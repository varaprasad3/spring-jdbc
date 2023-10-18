package springjdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Repository;

import springjdbc.dto.Student;
import springjdbc.rowmapper.StudentRowMapper;

@Repository("studentdao")
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveStudent(Student student) throws SQLException {
		String query = "insert into student(id,name,age) values(?,?,?)";

		Object[] args = { student.getId(), student.getName(), student.getAge() };

		jdbcTemplate.update(query, args);

		System.out.println("data saved successfully");
	}

	public List<Student> findAllStudents() {
		return jdbcTemplate.query("select * from student", new StudentRowMapper());
	}
	
	public void insert(List<Student> students) {
		String sql = "insert into student(id,name,age) values(?,?,?)" ;
		List<Object[]> data = new ArrayList() ;
		
		for(Student student : students) {
			Object[] info = {student.getId(),student.getName(),student.getAge()} ;
			data.add(info) ;
		}
		jdbcTemplate.batchUpdate(sql,data) ;
		
		System.out.println("data saved successfully");
	}

}
