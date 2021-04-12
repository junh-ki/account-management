package com.jun.restservice.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jun.restservice.entities.Deposit;

public interface DepositRepository extends JpaRepository<Deposit, Long> {

}
