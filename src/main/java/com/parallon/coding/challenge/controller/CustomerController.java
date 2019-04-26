package com.parallon.coding.challenge.controller;


import com.parallon.coding.challenge.model.Customer;
import com.parallon.coding.challenge.repository.CustomerRepository;
import com.parallon.coding.challenge.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api")
public class    CustomerController {

    private final CustomerRepository customerRepository;
    private final AccountService accountService;

    @Autowired
    public CustomerController(final AccountService accountService, final CustomerRepository customerRepository) {
        this.accountService = accountService;
        this.customerRepository = customerRepository;
    }

    @GetMapping(value = "/customers")
    public Iterable<Customer> getAllCustomers() {
        return accountService.getAllCustomers();
    }

    @Secured("ROLE_USER")
    @GetMapping(value = "/customer/{id}")
    public Customer getCustomer(@PathVariable("id") Long customerId) {
        return this.customerRepository.findById(customerId).get();
    }

    @Secured("ROLE_USER")
    @PostMapping("/customer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Secured("ROLE_USER")
    @PutMapping("/customer")
    public Customer updateCustomer(@RequestBody Customer updatedCustomer) {
        return this.customerRepository.save(updatedCustomer);
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/customer")
    public void deleteCustomer(@RequestBody Customer deleteCustomer) {
        this.customerRepository.delete(deleteCustomer);
    }


}
