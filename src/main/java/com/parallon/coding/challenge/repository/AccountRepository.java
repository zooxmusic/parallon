package com.parallon.coding.challenge.repository;

import com.parallon.coding.challenge.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}
