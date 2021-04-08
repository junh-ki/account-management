package com.jun.cashdeposit.services;

import com.jun.cashdeposit.dto.DepositRequest;
import com.jun.cashdeposit.entities.Deposit;

public interface DepositService {
	
	public Deposit depositCash(DepositRequest request);
	
}
