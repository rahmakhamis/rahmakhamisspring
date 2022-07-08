package com.tour.toursys.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tour.toursys.models.Customer;
import com.tour.toursys.repositories.CustomerRepository;

@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository repository;
    
    @GetMapping("/customer")
    public List<Customer> getAll(){
        return repository.findAll();
    }
    @PostMapping("/customer")
    public Customer newCustomer(@RequestBody Customer  customer){
        return repository.save(customer);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable int id){
    repository.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestBody Customer customer)
    {
        Customer customerId = customerRepository.findById(id)
        .orElseThrow(()-> new IllegalStateException("Staff with Id "+ id+ " does not exists"));
        customerId.setName(customer.getName());
        customerId.setEmail(customer.getEmail());
        
        
        Customer updateCustomer = customerRepository.save(customerId);

        return ResponseEntity.ok(updateCustomer);
    }


    
}


