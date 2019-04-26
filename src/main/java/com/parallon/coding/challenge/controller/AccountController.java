package com.parallon.coding.challenge.controller;

import com.parallon.coding.challenge.model.Account;
import com.parallon.coding.challenge.repository.AccountRepository;
import com.parallon.coding.challenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Set;


@RestController
@Transactional
@RequestMapping(value = "/api/customer/{customerId}")
public class AccountController {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountController(final CustomerRepository customerRepository, final AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Secured("ROLE_USER")
    @GetMapping(value = "/accounts")
    public Set<Account> getAllAccounts(@PathVariable("customerId") Long customerId) {
        return this.customerRepository.findById(customerId).get().getAccounts();
    }

    @Secured("ROLE_USER")
    @GetMapping(value = "/account/{id}")
    public Account getAccount(@PathVariable("id") Long id) {
        return this.accountRepository.findById(id).get();
    }

    @Secured("ROLE_USER")
    @PostMapping("/account")
    public Account addAccount(@RequestBody Account account) {
        return this.accountRepository.save(account);
    }

    @Secured("ROLE_USER")
    @PutMapping("/account")
    public Account updateAccount(@RequestBody Account account) {
        return this.accountRepository.save(account);
    }

    @Secured("ROLE_USER")
    @DeleteMapping("/account")
    public void deleteAccount(@RequestBody Account deleteAccount) {
        this.accountRepository.delete(deleteAccount);
    }

    @Secured("ROLE_USER")
    @PutMapping("/account/{id}/deposit/{amount}")
    public Account deposit(@PathVariable("id") Long id,  @PathVariable("amount")  double amount) {
        Account account = this.accountRepository.findById(id).get();
        account.deposit(amount);
        return this.accountRepository.save(account);
    }

    @Secured("ROLE_USER")
    @PutMapping("/account/{id}/withdraw/{amount}")
    public Account withdraw(@PathVariable("id") Long id, @PathVariable("amount") double amount) {
        Account account = this.accountRepository.findById(id).get();
        account.withdraw(amount);
        return this.accountRepository.save(account);

    }

    @Secured("ROLE_USER")
    @PutMapping("/account/transfer/{fromAccountId}/{toAccountId}/{amount}")
    public void transfer(@PathVariable("fromAccountId") Long fromAccountId, @PathVariable("toAccountId") Long toAccountId, @PathVariable("amount") double amount) {
        Account fromAccount = this.accountRepository.findById(fromAccountId).get();
        Account toAccount = this.accountRepository.findById(toAccountId).get();
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        this.accountRepository.save(fromAccount);
        this.accountRepository.save(toAccount);

    }

}
