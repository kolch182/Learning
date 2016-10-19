package ch.gmtech.ste.preservewholeobject;

public class HeatingPlan {
	private TempRange _range;
	
	public HeatingPlan(TempRange heatingPlanRange){
		_range = heatingPlanRange;
	}
	
	boolean withinRange (TempRange roomRange) {
		return (_range.includes(roomRange));
	}
	
}
