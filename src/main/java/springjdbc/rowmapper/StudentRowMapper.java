package springjdbc.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springjdbc.dto.Student;

public class StudentRowMapper implements RowMapper<Student>{

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		System.out.println("mapRow() called: " + rowNum);
		
		Student s = new Student() ;
		s.setId(rs.getInt("id"));
		s.setName(rs.getString("name"));
		s.setAge(rs.getInt("age"));
		return s;
	}

}
