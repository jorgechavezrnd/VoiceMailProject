package com.ucb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ucb.main.MailSystem;
import com.ucb.main.Mailbox;

class MailSystemTest {
	private MailSystem mailSystem;
	Mailbox mailbox2;

	@BeforeEach
	void setUp() throws Exception {
		mailSystem = new MailSystem(5);
		String passcode = "" + 2;
        String greeting = "You have reached mailbox " + 2
              + ". \nPlease leave a message now.";
        mailbox2 = new Mailbox(passcode, greeting);
	}

	@Test
	void shouldReturnTheMailboxThatIAsk() {
		Mailbox actual = mailSystem.findMailbox("2");
		
		assertEquals(mailbox2.getGreeting(), actual.getGreeting());
	}
	
	@Test
	public void shouldReturnNullWithNonExistentMailbox() {
		assertNull(mailSystem.findMailbox("6"));
	}
	
	@Test
	public void shouldReturnNullWithNegativeNumber() {
		assertNull(mailSystem.findMailbox("-1"));
	}

}
