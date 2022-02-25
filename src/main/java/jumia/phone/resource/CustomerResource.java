package jumia.phone.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
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
	
	@GetMapping("/customersFiltered/{contry}/{state}/{page}/{size}")
	public ResponseEntity<PagedListHolder<Customer>> retrieveAllCUstomers(@PathVariable String contry, @PathVariable String state, @PathVariable int page, @PathVariable int size) {
		
		List<Customer> filteredCustomerList = customerRepository.findAll();
		
		if (!contry.equals("*"))		{
			filteredCustomerList = filteredCustomerList.stream().filter(
				p -> p.getCountry().equals(contry)).collect(Collectors.toList());;
		}

		if (!state.equals("*"))		{
			filteredCustomerList = filteredCustomerList.stream().filter(
				p -> p.getState().equals(state)).collect(Collectors.toList());;			
		}

		PagedListHolder<Customer> filteredCustomerPage = new PagedListHolder<Customer>(filteredCustomerList);
		filteredCustomerPage.setPageSize(size); 
		filteredCustomerPage.setPage(page);      

      
     	return new ResponseEntity<>(filteredCustomerPage, HttpStatus.OK);

	}

}
