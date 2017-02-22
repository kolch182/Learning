package ch.gmtech.ste.learning.html;
import static j2html.TagCreator.*;
import ch.gmtech.ste.learning.seminar.Seminar;

public class HtmlPage{
	
	public String header(){

		return html().with(
				head().with(
						title("Course Form"),
						meta().withCharset("UTF-8"),
						meta().withName("viewport"),
						meta().withContent("width=device-width, initial-scale=1"),
						link().withRel("stylesheet").withHref("/css/bootstrap.min.css")
						)
				).render();
	}

	public String renderBody(Seminar seminar){
		
		return body().with(
				div().withId("Seminars").with(
						ul().with(li(seminar.course().name()))
					)
				)
				.render();
	}

}
