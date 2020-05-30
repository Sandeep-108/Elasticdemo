package org.experiment.elasticdemo.controller;

import org.experiment.elasticdemo.dao.CustomerDao;
import org.experiment.elasticdemo.dao.repository.CustomerRepository;
import org.experiment.elasticdemo.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao){
        this.customerDao=customerDao;
    }

    @PostMapping("/save")
    public int addCustomer(@RequestBody List<Customer> customers){
         return customerDao.save(customers);
    }

    @GetMapping("/customers/{firstName}")
    public List<Customer> getUserByName(@PathVariable String firstName){
        return customerDao.findByFirstName(firstName).get();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerDao.findById(id).get();
    }


    @GetMapping("/ping")
    public String getPing(){
        return "Pong";
    }
}
