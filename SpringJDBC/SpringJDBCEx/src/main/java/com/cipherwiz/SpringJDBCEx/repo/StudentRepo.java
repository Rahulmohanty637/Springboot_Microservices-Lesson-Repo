package com.cipherwiz.SpringJDBCEx.repo;

import com.cipherwiz.SpringJDBCEx.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student std) {
        String sql = "insert into student (rollno, name, marks) values (?, ?, ?)";
        int rows = jdbc.update(sql, std.getRollNo(), std.getName(), std.getMarks());
        System.out.println(rows + " effected");
    }

    public List<Student> findAll() {
        String sql = "select * from student";

//        RowMapper<Student> mapper = new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//                Student s = new Student();
//                s.setRollNo(rs.getInt("rollno"));
//                s.setName(rs.getString("name"));
//                s.setMarks(rs.getInt("marks"));
//
//                return s;
//            }
//        };

        return jdbc.query(sql, (rs, rowNum) -> {
            Student s = new Student();
            s.setRollNo(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));

            return s;
        });
    }
}
