package com.kotesh.akka.poc.actor;

import com.kotesh.akka.poc.model.SavingsAccount;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;


public class SavingsAccountActor extends AbstractActor {
	private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
	
	public static Props props() {
		return Props.create(SavingsAccountActor.class, () -> new SavingsAccountActor());
	}

	@Override
	public Receive createReceive() {

	    return receiveBuilder()
	            .match(SavingsAccount.class, savingsAccount -> {
	                log.info(savingsAccount.getAccountType());
	            })
	            .build();
	}
}
