package com.ucb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ucb.main.Message;
import com.ucb.main.MessageQueue;

class MessageQueueTest {
	private MessageQueue messageQueue;
	private Message message1;
	private Message message2;

	@BeforeEach
	public void setUp() throws Exception {
		messageQueue = new MessageQueue();
		message1 = new Message("message 1");
		message2 = new Message("message 2");
		
		messageQueue.add(message1);
		messageQueue.add(message2);
	}

	@Test
	public void shouldRemoveTheFirstMessageOfTheQueue() {
		Message expected = message1;
		Message actual = messageQueue.remove();
		
		assertEquals(expected, actual);
	}

	@Test
	public void shouldDecreaseTheSizeOfTheQueueByRemovingAMessage() {
		messageQueue.remove();
		
		assertEquals(1, messageQueue.size());
	}
}
