package cn.cqupt.dao.impl;

import cn.cqupt.dao.UserDao;
import cn.cqupt.man.Student;
import cn.cqupt.man.Teacher;
import cn.cqupt.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public List<Student> findAll(String name) {
        //使用jdbc擦欧总数据库
        //1.定义sql
        String sql = "select * from student where name=?";
        List<Student> students = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class),name);

        for (Student student: students
             ) {
            System.out.println(student);
        }
        return students;

    }

    @Override
    public Teacher load(String name, String pwd) {
        try {
            String sql = "select * from teacher where name=? and pwd=?";
            Teacher teacher = template.queryForObject(sql,new BeanPropertyRowMapper<Teacher>(Teacher.class),name,pwd);
            return teacher;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(Student student) {
        //1.定义sql
        String sql = "insert into student values(?,?,?,?,?)";
        //2.执行sql
        System.out.println("------------------");
        System.out.println(student);
        template.update(sql,student.getId(),student.getName(),student.getGender(),student.getAge(),student.getMajor());
    }

    @Override
    public void mod(Student student) {
        //1.定义sql
        String sql = "update student set id=?,name=?,gender=?,age=?,major=? where id = ?";
        //2.执行sql
        template.update(sql,student.getId(),student.getName(),student.getGender(),student.getAge(),student.getMajor(),student.getId());

    }

    @Override
    public void Del(int id) {
        //1.定义sql
        String sql = "delete from student where id = ?";
        //2.执行sql
        template.update(sql,id);
    }

    @Override
    public List<Student> find(int id) {
        String sql = "select * from student where id= ?";
        List<Student> students = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class), id);
        return students;
    }
}
