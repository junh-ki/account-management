package com.jun.restservice.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jun.restservice.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	@Query("from Account where holder_id=:holder_id")
	List<Account> findAccounts(@Param("holder_id") Long holderId);
	
}
