package com.parallon.coding.challenge.controller;

import com.parallon.coding.challenge.model.Customer;
import com.parallon.coding.challenge.service.CustomerFacadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {

    private final CustomerFacadeService customerFacadeService;

    @Autowired
    public CustomerController(final CustomerFacadeService customerFacadeService) {
        this.customerFacadeService = customerFacadeService;
    }

    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> getAllCustomers() {
        List<Customer> productsList = new ArrayList<>();

        return productsList;
    }
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String getCustomer() {
        return "Product is saved successfully";
    }

}
