package ch.gmtech.ste.replaceparameterwithexplicitmethods;

public class Employee {

	static Employee createEngineer() {
		return new Engineer();
	}
	
	static Employee createSalesman() {
		return new Salesman();
	}

	static Employee createManager() {
		return new Manager();
	}
}