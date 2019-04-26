package com.parallon.coding.challenge.controller;


import com.parallon.coding.challenge.model.Customer;
import com.parallon.coding.challenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api")
public class    CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Secured("ROLE_USER")
    @GetMapping(value = "/customers")
    public Iterable<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
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
