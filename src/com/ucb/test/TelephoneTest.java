package com.ucb.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ucb.main.Connection;
import com.ucb.main.Telephone;

class TelephoneTest {
	private Telephone telephone;
	private PrintStream mockOut;
	private Connection mockConnection;

	@BeforeEach
	public void setUp() throws Exception {
		mockOut = mock(PrintStream.class);
		mockConnection = mock(Connection.class);
		
		System.setOut(mockOut);
		
		doNothing().when(mockConnection).hangup();
		doNothing().when(mockConnection).dial(anyString());
		doNothing().when(mockConnection).record(anyString());
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.setOut(System.out);
	}

	@Test
	public void shouldPrintTestRunningWithSpeak() {
		telephone = new Telephone(new Scanner(System.in));
		String output = "Test running";
		
		telephone.speak(output);
		
		verify(mockOut).println(output);
	}
	
	@Test
	public void shouldRunConnectionHungup() {
		Scanner scanner = getScannerWithText("H");
		telephone = new Telephone(scanner);
		
		telephone.run(mockConnection);
		
		verify(mockConnection).hangup();
	}
	
	@Test
	public void shouldGiveTheValueOfNullToMore() {
		Scanner scanner = getScannerWithText("Q");
		telephone = new Telephone(scanner);
		
		telephone.run(mockConnection);
		
		verify(mockConnection, never()).hangup();
		verify(mockConnection, never()).dial(anyString());
		verify(mockConnection, never()).record(anyString());
	}
	
	@Test
	public void shouldRunConnectionDial() {
		Scanner scanner = getScannerWithText("1");
		telephone = new Telephone(scanner);
		
		telephone.run(mockConnection);
		
		verify(mockConnection).dial(anyString());
	}
	
	private Scanner getScannerWithText(String text) {
		text += "\nQ";
		
		InputStream inputStream = new ByteArrayInputStream(text.getBytes());
		System.setIn(inputStream);
		
		return new Scanner(System.in);
	}

}
