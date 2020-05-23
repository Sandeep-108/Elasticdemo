package org.experiment.elasticdemo.dao;

import lombok.extern.log4j.Log4j2;
import org.experiment.elasticdemo.model.Customer;
import org.experiment.elasticdemo.dao.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class CustomerDao {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerDao(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public int save(List<Customer> customers){
        try{
           customerRepository.saveAll(customers);
           return customers.size();
        }catch (Exception e){
            log.error("Error during save data in elastic search {}",e);
            throw new RuntimeException("Elastic Search Down");
        }
    }

    public Optional<List<Customer>> findByFirstName(String firstName){
        try{
            return customerRepository.findByFirstName(firstName);
        }catch (Exception e){
            log.error("Error during save data in elastic search {}",e);
            throw new RuntimeException("Elastic Search Down");
        }
    }

    public Optional<Customer> findById(Long id){
        try{
            return customerRepository.findById(id);
        }catch (Exception e){
            log.error("Error during save data in elastic search {}",e);
            throw new RuntimeException("Elastic Search Down");
        }
    }
}
