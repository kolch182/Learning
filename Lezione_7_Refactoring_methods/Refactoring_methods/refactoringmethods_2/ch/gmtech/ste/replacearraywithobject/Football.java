package ch.gmtech.ste.replacearraywithobject;

public class Football {

	public String arraySetup(){	
		Performance row = new Performance();
		
		row.setName("Liverpool");
		row.setWins("15");
		
		return row.getName() + " wins " + row.getWins() + " games";
	}
}
