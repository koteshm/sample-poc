package com.kotesh.akka.poc.actor;

import com.kotesh.akka.poc.model.CurrentAccount;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class CurrentAccountActor extends AbstractActor {
	private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
	
	public static Props props() {
		return Props.create(CurrentAccountActor.class, () -> new CurrentAccountActor());
	}

	@Override
	public Receive createReceive() {
	    return receiveBuilder()
	            .match(CurrentAccount.class, currentAccount -> {
	                log.info(currentAccount.getAccountType());
	            })
	            .build();
	}
}
