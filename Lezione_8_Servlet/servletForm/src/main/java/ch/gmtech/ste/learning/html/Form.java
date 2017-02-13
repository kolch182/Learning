package ch.gmtech.ste.learning.html;
import static j2html.TagCreator.*;

public class Form{

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

	public String renderBody(){

		return body().with(
					div().withClass("container").with(
						div().withClass("col-md-6 col-md-offset-3").with(
							h1("Course Form").withClass("page-header text-center").with(
								form().withId("courseForm")).withClass("form-horizontal").withMethod("post").withAction("/try/me").with(
									div().withClass("form-group").with( 
										label("Name").withClass("col-sm-2 control-label"),
										div().withClass("col-sm-10").with(
											input()
											.withType("text")
									        .withId("name")
									        .withName("name")
									        .withPlaceholder(placeholder)
										)
									)
								)
							)
						)
					)
				.render()
				;
	}
	
	

}
