package ch.gmtech.ste.view;
import static j2html.TagCreator.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ch.gmtech.ste.checker.Checker;
import ch.gmtech.ste.seminar.Course;
import j2html.tags.ContainerTag;
import j2html.tags.DomContent;

public class HtmlPage{
	
	private String showView(DomContent domcontent){

		return html().with(
				head().with(
						meta().withContent("text/html; charset=UTF-8").attr("http-equiv", "content-type"),
						meta().withCharset("UTF-8"),
						title("Create courses"),
						meta().withName("viewport").withContent("width=device-width, initial-scale=1"),
						meta().withContent("IE=edge").attr("http-equiv", "X-UA-Compatible"),
						link().withRel("stylesheet").withHref("/css/bootstrap.min.css").attr("media", "screen"),
						link().withRel("stylesheet").withHref("/css/custom.css"),
						link().withRel("stylesheet").withHref("/css/app.css")
						),	
					body().with(
						div().withClass("navbar navbar-default navbar-fixed-top").with(
							div().withClass("container").with(
								div().withClass("navbar-header").with(
									a("Seminar").withHref("/").withClass("navbar-brand"),
									button().withClass("navbar-toggle").withType("button")
									.withData("data-toggle", "collapse").withData("data-target", "#navbar-main").with(
										span().withClass("icon-bar"),
										span().withClass("icon-bar"),
										span().withClass("icon-bar")
									)
								),
								div().withClass("navbar-collapse collapse").withId("navbar-main").with(
									ul().withClass("nav navbar-nav navbar-right").with(
										li().withClass("dropdown").with(
											a("Account").withClass("dropdown-toggle").attr("data-toggle", "dropdown")
											.withId("download").withHref("#").attr("aria-expanded", "false").with(span().withClass("caret")),
											ul().withClass("dropdown-menu").attr("aria-labelledby", "download").with(
												li().with(a("settings").withHref("/")),
												li().withClass("divider"),
												li().with(a("logout").withHref("/"))
											)
										)
									)
								)
							)
						),
						div().withClass("container").with(
							div().withClass("page-header").withId("banner").with(
								div().withClass("row").with(
									div().withClass("col-lg-8 col-md-7 col-sm-6").with(
										h1("Seminar"),
										p("Manage your courses!").withClass("lead")
									)
								),
								div().withClass("row").with(
									div().withClass("col-lg-2 col-md-2 col-sm-3").with(
										div().withClass("list-group table-of-contents").with(
											a("List").withClass("list-group-item").withHref("/course"),
											a("Create").withClass("list-group-item").withHref("/course/create")
										)
									),
									domcontent
								)
							),
							footer().with(
								div().withClass("row").with(
									div().withClass("col-lg-12").with(
										p().with(a("Cerulean theme").withHref("http://bootswatch.com/cerulean").withRel("nofollow")),
										p("Code released under the ").with(a("MIT License").withHref("https://github.com/thomaspark/bootswatch/blob/gh-pages/LICENSE")),
										p("GmTechnologies")
									)
								)
							)
						),
						script().withSrc("/js/jquery.min.js?v=1.0.0"),
						script().withSrc("/js/bootstrap.min.js?v=1.0.0"),
						script().withSrc("/js/custom.js?v=1.0.0")
					)
				)
				.render();
	}
	
	public String showForm(Checker checker){
		
		DomContent formElement = 
				div().withClass("col-lg-8 col-md-8 col-sm-9").with(
					form().withAction("/course/create").withClass("form-horizontal").withMethod("post").with(
						createInputFields(checker)
					)
				)
				;
		
		return showView(formElement);
	}

	public String showCourses(List<Course> courses){
		
		ArrayList<DomContent> courseData = new ArrayList<DomContent>();

		for(Course course : courses) {
			courseData.add(
					tr().with(
					td(course.id().toString()),
					th(course.name()).attr("scope", "row"),
					td(course.location()),
					td(course.seatsLeft().toString()),
					td(course.getStartDate())
				)
			);
		}
		
		DomContent courseElement = 
		div().withClass("col-lg-8 col-md-8 col-sm-9").with(
				table().withClass("table table-striped").with(
					thead().with(
						tr().with(
							th("id"),
							th("name"),
							th("location"),
							th("totalSeats"),
							th("start")
						)
					),
					tbody().with(courseData)
				)
			)
		;
		
		return showView(courseElement);
	}
	
	
	private ArrayList<DomContent> createInputFields(Checker checker) {
		ArrayList<DomContent> input = new ArrayList<DomContent>();

		if(checker != null){
			input.add(createValidatedInput("Name",checker.getCourseName(),"courseName","name","Course Name", checker.validate().get(Course.NAME)));
			input.add(createValidatedInput("CourseId",checker.getCourseId(),"courseid","courseid","CourseId", checker.validate().get(Course.ID)));
			input.add(createValidatedInput("TotalSeats",checker.getTotalSeats(),"seats","seats","TotalSeats", checker.validate().get(Course.TOTAL_SEATS)));
			input.add(createValidatedInput("Location",checker.getLocation(),"location","location","Location",checker.validate().get(Course.LOCATION)));
			input.add(createValidatedInput("Description",checker.getDescritpion(),"description","description","Description", checker.validate().get(Course.DESCRIPTION)));
			input.add(createValidatedInput("StartDate",checker.getStartDate(),"startdate","startdate","StartDate", checker.validate().get(Course.START)));
		}else{
			input.add(createEmptyInput("Name","courseName","name","Course Name"));
			input.add(createEmptyInput("CourseId","courseid","courseid","CourseId"));
			input.add(createEmptyInput("TotalSeats","seats","seats","TotalSeats"));
			input.add(createEmptyInput("Location","location","location","Location"));
			input.add(createEmptyInput("Description","description","description","Description"));
			input.add(createEmptyInput("StartDate","startdate","startdate","StartDate"));
		}
		input.add(createSubmit());
		input.add(script().withSrc("/js/jquery.min.js"));
		input.add(script().withSrc("/js/bootstrap.min.js"));
		return input;
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

	private ContainerTag createValidatedInput(String label, String value, String id, String name, String placeHolder, Collection<String> messages ) {
		
		ContainerTag input = div().withClass("col-sm-10").with(
			input()
			.withType("text")
			.withClass("form-control")
			.withId(id)
			.withName(name)
			.withPlaceholder(placeHolder)
			.withValue(value),
			span().withClass(messages.isEmpty() ? "glyphicon form-control-feedback glyphicon-ok" : "glyphicon form-control-feedback glyphicon-remove"),
			span(messages.isEmpty() ? "(success)"  : "(error)").withClass("sr-only")
			);
		
		for(String message : messages) {
			input.with(span(message.isEmpty() ? label + " is valid" : message).withClass("help-block").withId(id));
		}
		
		return div().withClass(messages.isEmpty() ? "form-group has-success has-feedback" : "form-group has-error has-feedback").with( 
				label(label).withClass("col-sm-2 control-label"),
				input
				);
	}

}
