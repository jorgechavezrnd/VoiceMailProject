package com.ucb.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ucb.main.Message;
import com.ucb.main.MessageQueue;

class MessageQueueTest {
	private MessageQueue messageQueueEmpty;
	private MessageQueue messageQueueNotEmpty;
	private Message message1;
	private Message message2;

	@BeforeEach
	public void setUp() throws Exception {
		messageQueueEmpty = new MessageQueue();
		messageQueueNotEmpty = new MessageQueue();
		message1 = new Message("message 1");
		message2 = new Message("message 2");
		
		messageQueueNotEmpty.add(message1);
		messageQueueNotEmpty.add(message2);
	}

	@Test
	public void shouldRemoveTheFirstMessageOfTheQueue() {
		Message expected = message1;
		Message actual = messageQueueNotEmpty.remove();
		
		assertEquals(expected, actual);
	}

	@Test
	public void shouldDecreaseTheSizeOfTheQueueByRemovingAMessage() {
		messageQueueNotEmpty.remove();
		
		int expected = 1;
		int actual = messageQueueNotEmpty.size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldAddAMessageToTheQueue() {
		Message message3 = new Message("message 3");
		messageQueueNotEmpty.add(message3);
		
		int expected = 3;
		int actual = messageQueueNotEmpty.size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnTheSizeOfTheMessageQueue() {
		int expected = 2;
		int actual = messageQueueNotEmpty.size();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnMessage1WithPeek() {
		Message expected = message1;
		Message actual = messageQueueNotEmpty.peek();
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnNullWithPeek() {		
		Message expected = null;
		Message actual = messageQueueEmpty.peek();
		
		assertEquals(expected, actual);
	}
}
