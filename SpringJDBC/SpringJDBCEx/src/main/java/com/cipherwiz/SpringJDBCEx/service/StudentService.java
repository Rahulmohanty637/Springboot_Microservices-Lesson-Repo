package com.cipherwiz.SpringJDBCEx.service;

import com.cipherwiz.SpringJDBCEx.model.Student;
import com.cipherwiz.SpringJDBCEx.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private com.cipherwiz.SpringJDBCEx.repo.StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student std) {
        repo.save(std);
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }
}
