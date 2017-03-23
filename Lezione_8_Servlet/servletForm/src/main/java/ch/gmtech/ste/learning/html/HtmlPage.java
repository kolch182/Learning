package ch.gmtech.ste.learning.html;
import static j2html.TagCreator.*;

import com.Checker;

import ch.gmtech.ste.learning.seminar.Seminar;
import j2html.tags.ContainerTag;

public class HtmlPage{
	
	public String header(){

		return html().with(
				head().with(
						title("Course Form"),
						meta().withCharset("UTF-8"),
						meta().withName("viewport"),
						meta().withContent("width=device-width, initial-scale=1"),
						link().withRel("stylesheet").withHref("https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css")
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
	
	public String renderFormBody(){

		return body().with(
				div().withClass("container").with(
					div().withClass("row").with(
						div().withClass("col-md-6 col-md-offset-3").with(
							h1("Course Form").withClass("page-header text-center"),
								form().withId("courseForm").withClass("form-horizontal").withMethod("post").with(
		
									createEmptyInput("Name","courseName","name","Course Name"),
									createEmptyInput("CourseId","courseid","courseid","CourseId"),
									createEmptyInput("TotalSeats","seats","seats","TotalSeats"),
									createEmptyInput("Location","location","location","Location"),
									createEmptyInput("Description","description","description","Description"),
									createEmptyInput("StartDate","startdate","startdate","StartDate"),
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

	public String renderValidatedFormBody(Checker checker){
		
		return body().with(
				div().withClass("container").with(
						div().withClass("row").with(
								div().withClass("col-md-6 col-md-offset-3").with(
										h1("Course Form").withClass("page-header text-center"),
										form().withId("courseForm").withClass("form-horizontal").withMethod("post").with(
												
												createValidatedInput("Name",checker.getCourseName(),"courseName","name","Course Name", checker.checkCourseName()),
												createValidatedInput("CourseId",checker.getCourseId().toString(),"courseid","courseid","CourseId", checker.checkCourseId()),
												createValidatedInput("TotalSeats",checker.getTotalSeats().toString(),"seats","seats","TotalSeats", checker.checkTotalSeats()),
												createValidatedInput("Location",checker.getLocation(),"location","location","Location",checker.checkLocation()),
												createValidatedInput("Description",checker.getDescritpion(),"description","description","Description", checker.checkDescription()),
												createValidatedInput("StartDate",checker.getStartDate(),"startdate","startdate","StartDate", checker.checkStartDate()),
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

	private ContainerTag createEmptyInput(String label, String id, String name, String placeHolder ) {
		return div().withClass("form-group").with( 
			label(label).withClass("col-sm-2 control-label"),
			div().withClass("col-sm-10").with(
				input()
				.withType("text")
				.withClass("form-control")
		        .withId(id)
		        .withName(name)
		        .withPlaceholder(placeHolder)
			)
		);
	}

	private ContainerTag createValidatedInput(String label, String value, String id, String name, String placeHolder, boolean isOk ) {
		return div().withClass(isOk? "form-group has-success has-feedback" : "form-group has-error has-feedback").with( 
				label(label).withClass("col-sm-2 control-label"),
				div().withClass("col-sm-10").with(
						input()
						.withType("text")
						.withClass("form-control")
						.withId(id)
						.withName(name)
						.withPlaceholder(placeHolder)
						.withValue(value),
						span().withClass(isOk? "glyphicon glyphicon-ok form-control-feedback" : "glyphicon glyphicon-remove form-control-feedback"),
						span(isOk? label + " is valid" : "Provide a valid " + label + "!").withClass("help-block").withId("idHelpname")
						
						)
				);
	}

}