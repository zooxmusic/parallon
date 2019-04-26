package com.parallon.coding.challenge.service;

import com.google.common.collect.Lists;
import com.parallon.coding.challenge.exception.CustomerNotFoundException;
import com.parallon.coding.challenge.model.Account;
import com.parallon.coding.challenge.model.Customer;
import com.parallon.coding.challenge.repository.AccountRepository;
import com.parallon.coding.challenge.repository.CustomerRepository;
import com.parallon.coding.challenge.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(final CustomerRepository customerRepository, final AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    @Secured("ROLE_USER")
    public List<Customer> getAllCustomers() {
        Iterable<Customer> customers = this.customerRepository.findAll();
        if(Util.isEmpty(customers)) throw new CustomerNotFoundException();
        return Lists.newArrayList(customers);
    }

    @Override
    public Customer getCustomer(Long id) {
        return null;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return null;
    }

    @Override
    public void deleteCustomer(Long id) {

    }

    @Override
    public List<Account> getAllAccounts(Customer customer) {
        return null;
    }

    @Override
    public Account getAccount(Customer customer, Long accountId) {
        return null;
    }

    @Override
    public Account addAccount(Customer customer, Account account) {
        return null;
    }

    @Override
    public Account addAccounts(Customer customer, Set<Account> accounts) {
        return null;
    }

    @Override
    public void deposit(Customer customer, Long accountId, double amount) {

    }

    @Override
    public void deposit(Customer customer, Account account, double amount) {

    }

    @Override
    public void withdraw(Customer customer, Long accountId, double amount) {

    }

    @Override
    public void withdraw(Customer customer, Account account, double amount) {

    }

    @Override
    public void transfer(Customer customer, Long fromAccountId, Long toAccountId, double amount) {

    }

    @Override
    public void transfer(Customer customer, Account fromAccountId, Account toAccountId, double amount) {

    }
}
