package ch.gmtech.ste.learning.html;
import static j2html.TagCreator.*;
import j2html.tags.ContainerTag;

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
					div().withClass("row").with(
						div().withClass("col-md-6 col-md-offset-3").with(
							h1("Course Form").withClass("page-header text-center"),
								form().withId("courseForm").withClass("form-horizontal").withMethod("post").withAction("/try/me").with(
		
									createInput("Name","text","form-control","courseName","name","Course Name"),
									createInput("Number","number","form-control","number","number","Number"),
									createInput("Location","text","form-control","location","location","Location"),
									createInput("#Seats","number","form-control","seats","seats","#Seats"),
									createInput("StartDate","date","form-control","startdate","startdate","StartDate"),
									createSubmit(),
									script().withSrc("/js/jquery.min.js"),
									script().withSrc("/js/bootstrap.min.js")
								)
							)
						)
					)
				)
				.render()
				;
	}

	private ContainerTag createSubmit() {
		return div().withClass("form-group").with( 
			div().withClass("col-sm-10 col-sm-offset-2").with(
					input()
					.withType("submit")
					.withClass("btn btn-primary")
			        .withId("submit")
			        .withValue("Send")
			)
		);
	}

	private ContainerTag createInput(String value, String type, String inputClass, String id, String name, String placeHolder ) {
		return div().withClass("form-group").with( 
			label(value).withClass("col-sm-2 control-label"),
			div().withClass("col-sm-10").with(
				input()
				.withType(type)
				.withClass(inputClass)
		        .withId(id)
		        .withName(name)
		        .withPlaceholder(placeHolder)
		        .withValue(value)
			)
		);
	}
	
	

}
