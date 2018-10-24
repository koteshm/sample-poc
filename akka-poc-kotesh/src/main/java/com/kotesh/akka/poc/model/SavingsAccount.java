package com.kotesh.akka.poc.model;

public class SavingsAccount extends Account {
	
	
	public SavingsAccount(String internalAccountId, String accountId, String accountType) {
		this.internalAccountId = internalAccountId;
		this.accountId = accountId;
		this.accountType = accountType;
	}
	
}
