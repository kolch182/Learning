package ch.gmtech.ste.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ch.gmtech.ste.seminar.Course;

public class CourseDatabase {

	private final Connection _connection;

	public CourseDatabase(Connection connection) {
		_connection = connection;
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
	
	public HashMap<String, String> findById(String courseId) {
		HashMap<String, String> row = new HashMap<String, String>();
		Statement statement;
		try {
			statement = _connection.createStatement();
			String query = "select * from Course where id = " + courseId;
			ResultSet rs = statement.executeQuery(query);
			ResultSetMetaData md = rs.getMetaData();
			int columns = md.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columns; i++) {
					row.put(md.getColumnName(i), rs.getString((i)));
				}
			}
			statement.close();
			rs.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return row;
	}

	public HashMap<String, String> insertOrUpdate(String courseId, String name, String seats, String location, String description, String startDate) {
		HashMap<String, String> row = new HashMap<String, String>();
		Statement statement;
		try {
			statement = _connection.createStatement();
			statement.executeUpdate("INSERT OR REPLACE INTO Course values(" + courseId + ", '" + name + "', '" + description + "', '" + location + 
					"', '" + Integer.valueOf(seats) + "', '" + startDate + "')");
			statement.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return row;
	}
}
