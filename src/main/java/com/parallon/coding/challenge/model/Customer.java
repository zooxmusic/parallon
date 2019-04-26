package com.parallon.coding.challenge.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany
    private Set<Account> accounts = new HashSet();

    protected Customer() {}

    /**
     * Create a valid customer. There should be at least one account for the customer to be valid
     * @param name
     * @param account
     */
    public Customer(final String name, final Account account) {
        this.name = name;
        addAccount(account);
    }

    public void addAccount(final Account account) {
        this.accounts.add(account);
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s']",
                id, name);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Account> getAccounts() {
        return this.accounts;
    }
}
