package com.kotesh.akka.poc;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.kotesh.akka.poc.actor.CreateAccountActor;
import com.kotesh.akka.poc.model.Account;
import com.kotesh.akka.poc.model.CurrentAccount;
import com.kotesh.akka.poc.model.SavingsAccount;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;

@RunWith(value = Parameterized.class)
public class CreateAccountActorTest {
    private ActorSystem system;    
    private Account account;
    private String expected;
    
    public CreateAccountActorTest(Account account, String expected) {
        this.account = account;
        this.expected = expected;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
    	return Arrays.asList(new Object[][]{
            {new SavingsAccount(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Savings"), "Savings"},
            {new CurrentAccount(UUID.randomUUID().toString(), UUID.randomUUID().toString(), "Current"), "Current"}    
            });
    }    


    @Before
    public void setup() {
        system = ActorSystem.create();
    }

    
    @Test
    public void testCreateAccountActor() {
        final TestKit testProbe = new TestKit(system);

        final ActorRef createAccountActor = 
        system.actorOf(CreateAccountActor.props(testProbe.getRef(), testProbe.getRef()), "createAccountActor");
        
        createAccountActor.tell(account, ActorRef.noSender());

        Account account = testProbe.expectMsgClass(Account.class);
        assertEquals(expected, account.getAccountType());
    }
    
    @After
    public void teardown() {
        TestKit.shutdownActorSystem(system);
        system = null;
    }
}
