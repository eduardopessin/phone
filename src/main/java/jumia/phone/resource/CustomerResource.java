package jumia.phone.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jumia.phone.entities.Customer;
import jumia.phone.repository.CustomerRepository;


@RestController
public class CustomerResource {

	@Autowired
	CustomerRepository customerRepository ;
	
	@GetMapping("/customersFiltered/{contry}/{state}")
	public ResponseEntity<List<Customer>> retrieveAllCUstomers(@PathVariable String contry, @PathVariable String state) {
		
		List<Customer> filteredCustomerList = customerRepository.findAll();
				
		if (!contry.equals("*"))		{
			filteredCustomerList = filteredCustomerList.stream().filter(
				p -> p.getCountry().equals(contry)).collect(Collectors.toList());;
		}

		if (!state.equals("*"))		{
			filteredCustomerList = filteredCustomerList.stream().filter(
				p -> p.getState().equals(state)).collect(Collectors.toList());;			
		}
		
		ResponseEntity<List<Customer>> filteredResponse = new  ResponseEntity<List<Customer>>(filteredCustomerList, HttpStatus.OK);

		return filteredResponse;
	}

}
