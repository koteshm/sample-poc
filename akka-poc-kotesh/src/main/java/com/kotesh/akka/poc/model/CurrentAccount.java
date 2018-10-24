package com.kotesh.akka.poc.model;

public class CurrentAccount extends Account {	
	
	public CurrentAccount(String internalAccountId, String accountId, String accountType) {
		this.internalAccountId = internalAccountId;
		this.accountId = accountId;
		this.accountType = accountType;
	}
	
}
