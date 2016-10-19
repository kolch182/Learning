package ch.gmtech.ste.preservewholeobject;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomTest {

	@Test
	public void rangeOK() {
		Room room = new Room(new TempRange(7, 10));
		HeatingPlan heatingPlan = new HeatingPlan(new TempRange(5, 10));
		boolean withinPlan = room.withinPlan(heatingPlan);
		
		assertTrue(withinPlan);
	}

	@Test
	public void rangeKO() {
		Room room = new Room(new TempRange(4, 10));
		HeatingPlan heatingPlan = new HeatingPlan(new TempRange(5, 10));
		boolean withinPlan = room.withinPlan(heatingPlan);
		
		assertFalse(withinPlan);
	}

}
