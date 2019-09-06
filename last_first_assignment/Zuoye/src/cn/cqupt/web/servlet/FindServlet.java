package cn.cqupt.web.servlet;

import cn.cqupt.man.Student;
import cn.cqupt.service.UserService;
import cn.cqupt.service.imp.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/findServlet")
public class FindServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //因为学号唯一，当有学号的时候就只用学号查找
        UserService service = new UserServiceImpl();
        String name = request.getParameter("name");
        String id1 = request.getParameter("id");
        if (id1 != ""){
            //通过学号找，学号是主键，本来只有一个，但是我查找是通过foreach添加的，是数组，我为了方便就顺便统一为List了。。
           List<Student> students = service.find(Integer.parseInt(id1));
           request.setAttribute("students",students);
        }else {
            //通过名字找
           List<Student> students =  service.findAll(name);
           request.setAttribute("students",students);
        }

        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
