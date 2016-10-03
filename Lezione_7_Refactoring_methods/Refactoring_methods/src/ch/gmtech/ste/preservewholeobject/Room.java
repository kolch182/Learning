package ch.gmtech.ste.preservewholeobject;

public class Room {
	
	boolean withinPlan(HeatingPlan plan) {
		return plan.withinRange(daysTempRange());
	}
	
	private TempRange daysTempRange() {
		TempRange tempRange = new TempRange(7, 10);
		return tempRange;
	}

}
