package ch.gmtech.ste.substitutemethod;

import java.util.Arrays;
import java.util.List;

public class SubstituteMethod {

	String foundPerson(String[] people){
		for (int i = 0; i < people.length; i++) {
			if (people[i].equals ("Don")){
				return "Don";
			}
			if (people[i].equals ("John")){
				return "John";
			}
			if (people[i].equals ("Kent")){
				return "Kent";
			}
		}
		return "";
	}

	String foundPersonClearer(String[] people){
		List<String> candidates = Arrays.asList(new String[] {"Don", "John", "Kent"});
		for (int i=0; i<people.length; i++)
			if (candidates.contains(people[i]))
				return people[i];
		return "";
	}
}
