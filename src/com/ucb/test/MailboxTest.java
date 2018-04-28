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
	public void setUp() throws Exception {
		passcode = "myPasscode";
		greeting = "myGreeting";
		mailbox = new Mailbox(passcode, greeting);
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void shouldCheckPasscode() {
		boolean condition = mailbox.checkPasscode(passcode);
		
		assertTrue(condition);
	}
	
	@Test
	public void shouldReturnGreeting() {
		String expected = greeting;
		String actual = mailbox.getGreeting();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldSetNewPasscode() {
		String newPasscode = "myNewPasscode";
		mailbox.setPasscode(newPasscode);
		boolean condition = mailbox.checkPasscode(newPasscode);
		
		assertTrue(condition);
	}
	
	@Test
	public void shouldSetNewGreeting() {
		String newGreeting = "myNewGreeting";
		mailbox.setGreeting(newGreeting);
		String actual = mailbox.getGreeting();
		
		assertEquals(newGreeting, actual);
	}
	
}
