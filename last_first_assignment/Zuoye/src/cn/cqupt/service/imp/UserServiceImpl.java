package cn.cqupt.service.imp;

import cn.cqupt.dao.UserDao;
import cn.cqupt.dao.impl.UserDaoImpl;
import cn.cqupt.man.Student;
import cn.cqupt.man.Teacher;
import cn.cqupt.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();


    @Override
    public List<Student> findAll(String name) {
        return dao.findAll(name);
    }

    @Override
    public Teacher login(Teacher teacher) {
        return dao.load(teacher.getName(),teacher.getPwd());
    }

    @Override
    public void add(Student student) {
        dao.add(student);

    }

    @Override
    public void mod(Student student) {
        dao.mod(student);
    }

    @Override
    public void Del(int id) {
        dao.Del(id);
    }

    @Override
    public List<Student> find(int id) {
        return dao.find(id);
    }


}
