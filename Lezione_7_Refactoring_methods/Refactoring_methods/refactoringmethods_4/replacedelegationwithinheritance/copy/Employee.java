package replacedelegationwithinheritance.copy;

public class Employee extends Person{

	public String toString() {
		return "Emp: " + getLastName();
	}
}
