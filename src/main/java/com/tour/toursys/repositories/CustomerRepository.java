package com.tour.toursys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tour.toursys.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    

}
