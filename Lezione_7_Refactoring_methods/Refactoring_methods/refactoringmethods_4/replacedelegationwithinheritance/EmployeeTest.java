package replacedelegationwithinheritance;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void test() {
		Employee employee = new Employee();
		
		employee.setName("Stefano Coluccia Kolch");
		
		assertEquals("Emp: Coluccia Kolch", employee.toString());
	}

}
