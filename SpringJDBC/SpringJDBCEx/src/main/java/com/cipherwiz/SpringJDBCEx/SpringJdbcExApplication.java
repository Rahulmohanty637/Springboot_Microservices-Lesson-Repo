package com.cipherwiz.SpringJDBCEx;

import com.cipherwiz.SpringJDBCEx.model.Student;
import com.cipherwiz.SpringJDBCEx.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);

		Student std = context.getBean(Student.class);
		std.setRollNo(101);
		std.setName("Rahul");
		std.setMarks(78);

		StudentService service = context.getBean(StudentService.class);

		service.addStudent(std);

		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
