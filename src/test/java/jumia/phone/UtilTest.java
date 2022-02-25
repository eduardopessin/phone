package jumia.phone;

import jumia.phone.entities.Customer;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class UtilTest {

    @Test
    void filteredCustomerList_Cameroon() {
        Customer customer  = new Customer(1, "MICHAEL MICHAEL", "(237) 677046616");
        assertThat(customer.getCountry(),equalTo("Cameroon"));
        assertThat(customer.getCountryCode(),equalTo("+237"));
        assertThat(customer.getState(),equalTo("Valid"));        
   
    }  
    @Test
    void filteredCustomerList_Ethiopia() {
        Customer customer  = new Customer(2, "Filimon Embaye", "(251) 914701723");
        assertThat(customer.getCountry(),equalTo("Ethiopia"));
        assertThat(customer.getCountryCode(),equalTo("+251"));
        assertThat(customer.getState(),equalTo("Valid"));        
    }
    @Test
    void filteredCustomerList_Morocco() {
        Customer customer  = new  Customer(3, "Yosaf Karrouch", "(212) 698054317");
        assertThat(customer.getCountry(),equalTo("Morocco"));
        assertThat(customer.getCountryCode(),equalTo("+212"));
        assertThat(customer.getState(),equalTo("Valid"));        
    }
    @Test
    void filteredCustomerList_Mozambique() {
        Customer customer  =   new Customer(4, "Edunildo Gomes Alberto", "(258) 847651504");
        assertThat(customer.getCountry(),equalTo("Mozambique"));
        assertThat(customer.getCountryCode(),equalTo("+258"));
        assertThat(customer.getState(),equalTo("Valid"));        
    }
    @Test
    void filteredCustomerList_Uganda() {
        Customer customer  = new Customer(5, "JACKSON NELLY", "(256) 775069443");
        assertThat(customer.getCountry(),equalTo("Uganda"));
        assertThat(customer.getCountryCode(),equalTo("+256"));
        assertThat(customer.getState(),equalTo("Valid"));        
    }
    void filteredCustomerList_Invalid() {
        Customer customer  = new Customer(6, "Walid Hammadi", "(212) 6007989253");
        assertThat(customer.getCountry(),equalTo("Uganda"));
        assertThat(customer.getCountryCode(),equalTo("+256"));
        assertThat(customer.getState(),equalTo("Valid"));        
    }
}
