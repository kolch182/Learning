package ch.gmtech.ste.replacearraywithobject;

import static org.junit.Assert.*;

import org.junit.Test;

public class FootballTest {

	@Test
	public void arraySetup() {
		Football football = new Football();
		
		assertEquals("Liverpool wins 15 games",football.arraySetup());
	}

}
