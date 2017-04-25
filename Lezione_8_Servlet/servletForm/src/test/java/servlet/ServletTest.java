package servlet;

import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.Servlet;

public class ServletTest {
	
	@Test
	public void statusOK() throws Exception {
		FakeHttpServletRequest request = new FakeHttpServletRequest("/course");
		FakeHttpServletResponse response = new FakeHttpServletResponse();

		new Servlet().service(request, response);

		assertThat(response.statusCode(), is(HttpServletResponse.SC_OK));
	}

	@Test
	public void notFound() throws Exception {
		FakeHttpServletRequest request = new FakeHttpServletRequest("/course/whatever");
		FakeHttpServletResponse response = new FakeHttpServletResponse();

		new Servlet().service(request, response);

		assertThat(response.statusCode(), is(HttpServletResponse.SC_NOT_FOUND));
	}


}
