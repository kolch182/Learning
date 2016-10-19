package ch.gmtech.ste.preservewholeobject;

public class Room {
	
	TempRange _tempRange;
	
	public Room(TempRange roomRange){
		_tempRange = roomRange;
	}
	
	boolean withinPlan(HeatingPlan plan) {
		return plan.withinRange(daysTempRange());
	}
	
	private TempRange daysTempRange() {
		return _tempRange;
	}

}
