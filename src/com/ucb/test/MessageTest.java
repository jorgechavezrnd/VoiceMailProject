package com.ucb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ucb.main.Message;

class MessageTest {
	private Message message;

	@BeforeEach
	void setUp() throws Exception {
		message = new Message("Message Text");
	}

	@Test
	void shouldReturnTheMessageText() {
		String expected = "Message Text";
		String actual = message.getText();
		
		assertEquals(expected, actual);
	}

}
