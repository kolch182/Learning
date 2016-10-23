package ch.gmtech.ste.replacetypecodewithsubclass;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

//	@Test
//	public void preRefactoring() {
//		Employee engineer = new Employee(Employee.ENGINEER);
//		Employee salesman = new Employee(Employee.SALESMAN);
//		Employee manager = new Employee(Employee.MANAGER);
//		
//		assertEquals(0, engineer.ENGINEER);
//		assertEquals(1, salesman.SALESMAN);
//		assertEquals(2, manager.MANAGER);
//	}
	
	@Test
	public void postRefactoring() {
		Employee engineer = new Engineer();
		Employee salesman = new Salesman();
		Employee manager = new Manager();
		
		assertEquals(0, engineer.ENGINEER);
		assertEquals(1, salesman.SALESMAN);
		assertEquals(2, manager.MANAGER);
	}

}
