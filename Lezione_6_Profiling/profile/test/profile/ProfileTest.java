package profile;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ProfileTest {

	@Test
	public void sumTo() {
		assertThat(new Profile().sumTo(100), is(5050));
	}
	
}
