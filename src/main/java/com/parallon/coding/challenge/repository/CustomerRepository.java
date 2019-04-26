package com.parallon.coding.challenge.repository;

import com.parallon.coding.challenge.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
