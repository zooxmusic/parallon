package com.parallon.coding.challenge.service;

import com.parallon.coding.challenge.model.Customer;
import com.parallon.coding.challenge.repository.AccountRepository;
import com.parallon.coding.challenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerFacadeService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public CustomerFacadeService(final CustomerRepository customerRepository, final AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    public void addCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }
}
