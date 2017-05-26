package ch.gmtech.ste.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ch.gmtech.ste.seminar.Course;

public class CourseDatabase {

	private final Connection _connection;

	public CourseDatabase(Connection connection) {
		_connection = connection;
	}
	
	public void insert(Course course){
		try {
			PreparedStatement ps = _connection.prepareStatement("insert into Course (name, description, location, totalSeats, start) values (?,?,?,?,?)");
			ps.setObject(1, course.getName());
			ps.setObject(2, course.getDescription());
			ps.setObject(3, course.getLocation());
			ps.setObject(4, course.getSeatsLeft());
			ps.setObject(5, course.getStartDate());
			
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Iterable<Course> findAll() {
		List<Course> courses = null;
		try {
			PreparedStatement preparedStatement = _connection.prepareStatement("select * from Course");
			ResultSet rs = preparedStatement.executeQuery();
			courses = new ArrayList<Course>();
			while(rs.next()){
				courses.add(
						new Course(
								rs.getInt(1),
								rs.getString(2),
								rs.getString(3),  
								new SimpleDateFormat("dd.mm.yyyy").parse(rs.getString(6)),
								rs.getString(4),
								rs.getInt(5)
						)
					);
			}
			preparedStatement.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return courses;
	}
}
