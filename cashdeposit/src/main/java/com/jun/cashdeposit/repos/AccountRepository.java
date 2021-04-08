package com.jun.cashdeposit.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.cashdeposit.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
