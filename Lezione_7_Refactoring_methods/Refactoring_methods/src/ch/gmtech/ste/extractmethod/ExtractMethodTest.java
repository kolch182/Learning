package ch.gmtech.ste.extractmethod;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class ExtractMethodTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void printOwing() {
		ExtractMethod method = new ExtractMethod();
		String expected = 
				"**************************\n" +
				"***** Customer Owes ******\n" +
				"**************************\n" +
				"name:Stefano\n" +
				"amount15.0\n";
		
		method.printOwing();
		
		assertEquals(expected,outContent.toString());
	}

}
