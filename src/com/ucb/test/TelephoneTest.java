package com.ucb.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ucb.main.Telephone;

class TelephoneTest {
	private Telephone telephone;
	private PrintStream out;

	@BeforeEach
	public void setUp() throws Exception {
		out = mock(PrintStream.class);
		
		System.setOut(out);
	}

	@AfterEach
	public void tearDown() throws Exception {
		System.setOut(System.out);
	}

	@Test
	void test() {
		
	}

}
