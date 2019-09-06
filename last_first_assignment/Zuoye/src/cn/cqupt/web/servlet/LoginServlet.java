package cn.cqupt.web.servlet;

import cn.cqupt.man.Teacher;
import cn.cqupt.service.UserService;
import cn.cqupt.service.imp.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //2.获取数据源
        HttpSession session = request.getSession();
        Map<String, String[]> map = request.getParameterMap();
        //3.封装teacher数据
        Teacher teacher = new Teacher();
        try {
            BeanUtils.populate(teacher,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //4.调用Service查询
        UserService service = new UserServiceImpl();
        Teacher loginTeacher = service.login(teacher);
        if (loginTeacher != null){
            //登陆成功
            //将用户存入session
            session.setAttribute("teacher",loginTeacher);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            request.setAttribute("login_msg","用户名或者密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
