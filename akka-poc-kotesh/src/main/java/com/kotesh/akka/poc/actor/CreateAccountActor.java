package com.kotesh.akka.poc.actor;

import com.kotesh.akka.poc.model.CurrentAccount;
import com.kotesh.akka.poc.model.SavingsAccount;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateAccountActor extends AbstractActor {
	private ActorRef savingsActorRef;
	private ActorRef currentActorRef;
	
	
	public static Props props(ActorRef savingsActorRef, ActorRef currentActorRef) {		
		return Props.create(CreateAccountActor.class, () -> new CreateAccountActor(savingsActorRef, currentActorRef));
	}

	@Override
	public Receive createReceive() {
	    return receiveBuilder()
	            .match(SavingsAccount.class, account -> {
	            	savingsActorRef.tell(account, getSelf());
	              })
	            .match(CurrentAccount.class, account -> {
	            	currentActorRef.tell(account, getSelf());
	              })
	            .build();
	}

}
