package ch.gmtech.ste.learning.html;
import static j2html.TagCreator.*;

import java.util.ArrayList;

import com.Checker;

import ch.gmtech.ste.learning.seminar.Course;
import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

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

	public String renderBody(ArrayList<Course> courses){
		
		ArrayList<DomContent> children = new ArrayList<DomContent>();
		
		for(Course course : courses) {
			children.
				add(li(
					course.name() + " - " + course.location() + " - " + course.id() + " - seats left: " + course.seatsLeft()
					).withClass("list-group-item")
				);
		}

		
		return h2("Courses List").with(
				body().withClass("container").with(
					ul().withClass("list-group").with(
						children
					)
				))
				.render();
	}
	
	
	public String renderFormBody(){

		return header() + body().with(
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

	public String renderFormBody(Checker checker){
		
		return header() + body().with(
				div().withClass("container").with(
						div().withClass("row").with(
								div().withClass("col-md-6 col-md-offset-3").with(
										h1("Course Form").withClass("page-header text-center"),
										form().withId("courseForm").withClass("form-horizontal").withMethod("post").with(
												
												createValidatedInput("Name",checker.getCourseName(),"courseName","name","Course Name", checker.checkCourseName()),
												createValidatedInput("CourseId",checker.getCourseId(),"courseid","courseid","CourseId", checker.checkCourseId()),
												createValidatedInput("TotalSeats",checker.getTotalSeats(),"seats","seats","TotalSeats", checker.checkTotalSeats()),
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

	private ContainerTag createValidatedInput(String label, String value, String id, String name, String placeHolder, String message ) {
		return div().withClass(message.isEmpty() ? "form-group has-success has-feedback" : "form-group has-error has-feedback").with( 
				label(label).withClass("col-sm-2 control-label"),
				div().withClass("col-sm-10").with(
						input()
						.withType("text")
						.withClass("form-control")
						.withId(id)
						.withName(name)
						.withPlaceholder(placeHolder)
						.withValue(value),
						span().withClass(message.isEmpty() ? "glyphicon glyphicon-ok form-control-feedback" : "glyphicon glyphicon-remove form-control-feedback"),
						span(message.isEmpty() ? label + " is valid" : message).withClass("help-block").withId("idHelpname")
						
						)
				);
	}

}
