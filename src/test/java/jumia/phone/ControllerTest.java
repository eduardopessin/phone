package jumia.phone;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import jumia.phone.controllers.CustomerController;
import jumia.phone.entities.Customer;
import jumia.phone.resource.CustomerResource;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({CustomerController.class})
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    CustomerResource customerResource;

    @Test
    public void retrieveAllCUstomers() throws Exception {
        
        List<Customer> customerList = Arrays.asList(
                new Customer(1, "MICHAEL MICHAEL", "(237) 677046616"),
                new Customer(2, "Filimon Embaye", "(251) 914701723"),
                new Customer(3, "Yosaf Karrouch", "(212) 698054317"),
                new Customer(4, "Edunildo Gomes Alberto", "(258) 847651504"),
                new Customer(5, "JACKSON NELLY", "(256) 775069443"),
                new Customer(6, "Walid Hammadi", "(212) 6007989253") 
                
        );
        ResponseEntity<PagedListHolder<Customer>> customerResponse = new  ResponseEntity<PagedListHolder<Customer>>(new PagedListHolder<Customer>(customerList), HttpStatus.OK);

        when(customerResource.retrieveAllCUstomers("*", "*",0,5)).thenReturn(customerResponse);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/customersFiltered/*/*"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{},{},{},{},{},{}]"));
    }
   
}
