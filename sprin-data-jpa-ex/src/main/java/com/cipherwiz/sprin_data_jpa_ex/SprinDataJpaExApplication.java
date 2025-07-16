package com.cipherwiz.sprin_data_jpa_ex;

import com.cipherwiz.sprin_data_jpa_ex.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SprinDataJpaExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SprinDataJpaExApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);

		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);

		s1.setRollno(101);
		s1.setName("Navin");
		s1.setMarks(75);

		s2.setRollno(102);
		s2.setName("Viren");
		s2.setMarks(52);

		s3.setRollno(103);
		s3.setName("Kapil");
		s3.setMarks(67);

		repo.save(s1);
	}

}
