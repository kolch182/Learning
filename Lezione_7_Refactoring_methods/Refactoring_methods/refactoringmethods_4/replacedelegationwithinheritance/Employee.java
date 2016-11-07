package replacedelegationwithinheritance;

public class Employee extends Person{

	public String toString() {
		return "Emp: " + getLastName();
	}
}
