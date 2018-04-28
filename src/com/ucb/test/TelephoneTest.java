package com.ucb.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.PrintStream;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ucb.main.Telephone;

class TelephoneTest {
	private Telephone telephone;
	private PrintStream mockOut;

	@BeforeEach
	public void setUp() throws Exception {
		mockOut = mock(PrintStream.class);
		
		System.setOut(mockOut);
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.setOut(System.out);
	}

	@Test
	void shouldPrintTestRunningWithSpeak() {
		telephone = new Telephone(new Scanner(System.in));
		String output = "Test running";
		
		telephone.speak(output);
		
		verify(mockOut).println(output);
	}

}
