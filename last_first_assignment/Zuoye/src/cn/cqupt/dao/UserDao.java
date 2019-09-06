package cn.cqupt.dao;

import cn.cqupt.man.Student;
import cn.cqupt.man.Teacher;

import java.util.List;

public interface UserDao {
    List<Student> findAll(String name);
    Teacher load(String name, String pwd);

    void add(Student student);

    void mod(Student student);

    void Del(int id);

    List<Student> find(int id);
}
