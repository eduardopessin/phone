package jumia.phone.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jumia.phone.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
