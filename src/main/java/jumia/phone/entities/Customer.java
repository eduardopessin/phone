
package jumia.phone.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import jumia.phone.util.ConversorUtil;

@Entity
@Table(name = "customer")
public class Customer{

    private int	id;
	private String name;
	private String phone;
    
    private String country;
    private String contryCode;
    private String state;

    
    public Customer (){}
    public Customer (int id, String name, String phone){
        this.id = id;
        this.name = name;
        this.setPhone(phone);  
    }

    @Id
    @Column(name = "id")
	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone")
	public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
        String[] validatedValues = ConversorUtil.getConversorUtilFactory().validatePhoneNumber(phone);
        this.setCountry(validatedValues[0]);
        this.setCountryCode(validatedValues[1]);
        this.setState(validatedValues[2]);
    }

    
    @Transient
    public String getCountry(){
        return country;
    }

    @Transient
    private void setCountry(String country){
        this.country = country;
    }
    
    @Transient
    public String getCountryCode(){
        return contryCode;
    }

    @Transient
    private void setCountryCode(String contryCode){
        this.contryCode = contryCode;
    }

    @Transient
    public String getState(){
        return state;
    }

    @Transient
    private void setState(String state){
        this.state = state;
    }
}
