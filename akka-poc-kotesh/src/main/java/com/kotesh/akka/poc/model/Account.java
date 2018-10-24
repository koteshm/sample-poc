package com.kotesh.akka.poc.model;

import lombok.Getter;

@Getter
public abstract class Account {
	protected String internalAccountId;
	protected String accountId;
	protected String accountType;

}
