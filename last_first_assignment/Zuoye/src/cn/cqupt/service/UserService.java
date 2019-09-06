package cn.cqupt.service;

import cn.cqupt.man.Student;
import cn.cqupt.man.Teacher;

import java.util.List;

/**
 * 管理的业务接口
 */
public interface UserService {
    List<Student> findAll(String name);
    Teacher login(Teacher teacher);

    void add(Student student);

    void mod(Student student);

    void Del(int id);
    List<Student> find(int id);
}
