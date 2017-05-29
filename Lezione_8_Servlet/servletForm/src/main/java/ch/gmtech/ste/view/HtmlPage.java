package ch.gmtech.ste.view;
import static j2html.TagCreator.a;
import static j2html.TagCreator.body;
import static j2html.TagCreator.button;
import static j2html.TagCreator.div;
import static j2html.TagCreator.footer;
import static j2html.TagCreator.form;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static j2html.TagCreator.input;
import static j2html.TagCreator.label;
import static j2html.TagCreator.li;
import static j2html.TagCreator.link;
import static j2html.TagCreator.meta;
import static j2html.TagCreator.p;
import static j2html.TagCreator.script;
import static j2html.TagCreator.span;
import static j2html.TagCreator.table;
import static j2html.TagCreator.tbody;
import static j2html.TagCreator.td;
import static j2html.TagCreator.th;
import static j2html.TagCreator.thead;
import static j2html.TagCreator.title;
import static j2html.TagCreator.tr;
import static j2html.TagCreator.ul;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
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
						link().withRel("stylesheet").withHref("/css/app.css"),
						link().withRel("stylesheet").withHref("/css/main.css")
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
								createValidatedInput("Name",checker.getCourseName(),"courseName","name","Course Name", checker.validate().get(Course.NAME)),
								createValidatedInput("TotalSeats",checker.getTotalSeats(),"totalSeats","totalSeats","totalSeats", checker.validate().get(Course.TOTAL_SEATS)),
								createValidatedInput("Location",checker.getLocation(),"location","location","Location",checker.validate().get(Course.LOCATION)),
								createValidatedInput("Description",checker.getDescritpion(),"description","description","Description", checker.validate().get(Course.DESCRIPTION)),
								createValidatedInput("StartDate",checker.getStartDate(),"start","start","Start", checker.validate().get(Course.START)),
								createSubmit(),
								script().withSrc("/js/jquery.min.js"),
								script().withSrc("/js/bootstrap.min.js")
								)
						)
				;

		return showView(formElement);
	}

	public String showForm(){

		return showView(div().withClass("col-lg-8 col-md-8 col-sm-9").with(
				form().withAction("/course/create").withClass("form-horizontal").withMethod("post").with(
						createInput("Name","courseName","name","Course Name",""),
						createInput("TotalSeats","totalSeats","totalSeats","totalSeats",""),
						createInput("Location","location","location","Location",""),
						createInput("Description","description","description","Description",""),
						createInput("StartDate","start","start","Start",""),
						createSubmit(),
						script().withSrc("/js/jquery.min.js"),
						script().withSrc("/js/bootstrap.min.js")
						)
				));
	}

	public String showCourses(Iterable<Course> _courses){
		return showView(
					div().withClass("col-lg-8 col-md-8 col-sm-9").with(
						table().withClass("table table-striped").with(
							thead().with(
								showCoursesHeader()
							),
							tbody().with(
								showCoursesContent(_courses))
						)
//						, 
//						createTrashButton()
					)
				);
	}

	private ContainerTag showCoursesHeader() {
		return tr().with(
				th("action"),
				th("name"),
				th("location"),
				th("totalSeats"),
				th("start")
				);
	}

	private List<DomContent> showCoursesContent(Iterable<Course> _courses) {
		List<DomContent> courseData = new ArrayList<DomContent>();
		for(Course course : _courses) {
			courseData.add(
				showOneCourse(course)
				);
		}
		return courseData;
	}
	
	private ContainerTag showOneCourse(Course course) {
		return tr().with(
			td().with(
				a().withHref("/course/delete/" + course.getId()).with(
					button().withType("button").withClass("btn btn-default btn-sm").with(
						span().withClass("glyphicon glyphicon-trash")
					)
				)
			),
//			td().with(button().withType("button").withClass("glyphicon glyphicon-trash").attr("data-toggle", "modal").attr("data-target", "#confirm-delete")),
			th().attr("scope", "row").with(a(course.getName()).withHref("course/" + course.getId())),
			td(course.getLocation()),
			td(course.getSeatsLeft().toString()),
			td(course.getStartDate())
			);
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

	private ContainerTag createInput(String label, String id, String name, String placeHolder, String value ) {
		return div().withClass("form-group").with( 
				label(label).withClass("col-sm-2 control-label"),
				div().withClass("col-sm-10").with(
						input()
						.withType("text")
						.withClass("form-control")
						.withId(id)
						.withName(name)
						.withPlaceholder(placeHolder)
						.withValue(value)
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

	public String updateCourse(HashMap<String, String> row) {
		DomContent formElement = 
				div().withClass("col-lg-8 col-md-8 col-sm-9").with(
						form().withAction("/course/" + row.get("id")).withClass("form-horizontal").withMethod("post").with(
								createInput("Name","courseName","name","Course Name", row.get("name")),
								createInput("TotalSeats","totalSeats","totalSeats","TotalSeats",row.get("totalSeats")),
								createInput("Location","location","location","Location",row.get("location")),
								createInput("Description","description","description","Description",row.get("description")),
								createInput("StartDate","start","start","Start",row.get("start")),
								createSubmit(),
								script().withSrc("/js/jquery.min.js"),
								script().withSrc("/js/bootstrap.min.js")
								)
						)
				;

		return showView(formElement);
	}

//	public String deleteCourse(Course course) {
//		return showView(
//			div().withClass("col-lg-8 col-md-8 col-sm-9").with(
//					p("Are you sure you want to delete the following course?").withClass("lead"),
//					table().withClass("table table-striped").with(
//						thead().with(
//							tr().with(
//								th("name"),
//								th("location"),
//								th("totalSeats"),
//								th("start")
//							)
//						),
//						tbody().with(
//							tr().with(
//								th().attr("scope", "row").with(a(course.getName()).withHref("course/" + course.getId())),
//								td(course.getLocation()),
//								td(course.getSeatsLeft().toString()),
//								td(course.getStartDate())
//							)
//						)
//					),
//					a("Delete").withHref("/course/delete/" + course.getId() + "?confirm=true").withClass("btn btn-primary btn-sm").withMethod("post")
//				)
//		);
//	}

//	private ContainerTag createTrashButton() {
//	return div().withId("confirm-delete").withClass("modal fade").withRole("dialog").with(
//		div().withClass("modal-dialog").with(
//			div().withClass("modal-content").with(
//				div().withClass("modal-header").with(
//					button().withType("button").withClass("close").attr("data-dismiss", "modal"),
//					h1("Confirm Delete").withClass("modal-title")
//				),
//				div().withClass("modal-body").with(
//					p("You are about to delete one track, this procedure is irreversible."),
//					p("Do you want to proceed?")
//				),
//				div().withClass("modal-footer").with(
//					button("Cancel").withType("button").withClass("btn btn-default").attr("data-dismiss", "modal"),
//					a("Delete").withClass("btn btn-danger btn-ok").withHref("/course/delete/id")
//				)
//			)
//		)
//	);
//}

}
