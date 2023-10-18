package springjdbc.controller;

import java.io.ObjectInputFilter.Config;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import springjdbc.dao.StudentDao;
import springjdbc.dto.Student;

public class StudentController {
	
	
    public static void main(String[] args) throws SQLException {
		
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(springjdbc.configuration.Config.class) ;
		Student s1 =new Student() ;
		s1.setId(1);
		s1.setName("varaprasad");
        s1.setAge(23);
        
        Student s2 =new Student() ;
		s2.setId(2);
		s2.setName("Karthik");
        s2.setAge(24);
        
        Student s3 =new Student() ;
		s3.setId(3);
		s3.setName("durgesh");
        s3.setAge(25);
        
        Student s4 =new Student() ;
		s4.setId(4);
		s4.setName("becoder");
        s4.setAge(26);
        
        ArrayList<Student> students = new ArrayList() ;
        students.add(s1) ;
        students.add(s2) ;
        students.add(s3) ;
        students.add(s4) ;
        
        ac.getBean("studentdao", StudentDao.class).insert(students);
    }
	
}
