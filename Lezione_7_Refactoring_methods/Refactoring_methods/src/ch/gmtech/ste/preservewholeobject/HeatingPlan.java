package ch.gmtech.ste.preservewholeobject;

public class HeatingPlan {
	
	boolean withinRange (TempRange roomRange) {
		return (_range.includes(roomRange));
	}
	
	private TempRange _range = new TempRange(5, 10);
}
