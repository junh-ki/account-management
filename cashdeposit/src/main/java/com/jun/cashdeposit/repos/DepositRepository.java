package com.jun.cashdeposit.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.cashdeposit.entities.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

}
