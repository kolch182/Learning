package ch.gmtech.ste.preservewholeobject;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {

	@Test
	public void test() {
		Room room = new Room();
		HeatingPlan heatingPlan = new HeatingPlan();
		boolean withinPlan = room.withinPlan(heatingPlan);
		
		assertTrue(withinPlan);
	}

}
