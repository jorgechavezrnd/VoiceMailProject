package com.ucb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ucb.main.Mailbox;

class MailboxTest {
	private Mailbox mailbox;
	private String passcode;
	private String greeting;

	@BeforeEach
	void setUp() throws Exception {
		passcode = "myPasscode";
		greeting = "myGreeting";
		mailbox = new Mailbox(passcode, greeting);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void shouldCheckPasscode() {
		boolean condition = mailbox.checkPasscode(passcode);
		
		assertTrue(condition);
	}

}
