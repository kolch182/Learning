package ch.gmtech.ste.learning.html;
import static j2html.TagCreator.body;
import static j2html.TagCreator.div;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static j2html.TagCreator.input;
import static j2html.TagCreator.label;
import static j2html.TagCreator.link;
import static j2html.TagCreator.meta;
import static j2html.TagCreator.title;

import java.util.ArrayList;

import ch.gmtech.ste.learning.seminar.Seminar;
import j2html.tags.ContainerTag;

public class HtmlPage{
	
	private ArrayList<Seminar> _seminars;
	private String render;

	public HtmlPage(ArrayList<Seminar> seminars){
		_seminars = seminars;
	}

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

		for(Seminar seminar : _seminars) {
				render = body().with(
					div().withId("Seminars").with(
						h1(seminar.location())
					)
				)
				.render();
		}
		;
				return render;
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
