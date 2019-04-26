package com.parallon.coding.challenge.service;

import com.parallon.coding.challenge.model.Account;
import com.parallon.coding.challenge.model.Customer;

import java.util.List;
import java.util.Set;

public interface AccountService {

    public List<Customer> getAllCustomers();
    public Customer getCustomer(Long id);

    public Customer saveCustomer(final Customer customer);
    public void deleteCustomer(final Long id);

    public List<Account> getAllAccounts(final Customer customer);
    public Account getAccount(final Customer customer, final Long accountId);

    public Account addAccount(final Customer customer, final Account account);
    public Account addAccounts(final Customer customer, final Set<Account> accounts);

    public void deposit(final Customer customer, final Long accountId, double amount);
    public void deposit(final Customer customer, final Account account, double amount);

    public void withdraw(final Customer customer, final Long accountId, double amount);
    public void withdraw(final Customer customer, final Account account, double amount);

    public void transfer(final Customer customer, final Long fromAccountId, final Long toAccountId, double amount);
    public void transfer(final Customer customer, final Account fromAccountId, final Account toAccountId, double amount);


}
