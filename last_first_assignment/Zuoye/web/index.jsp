<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/4 0004
  Time: 14:34
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<!-- head标签中包含的信息无需改动 -->

<head>
  <meta charset="UTF-8">
  <title>服务器平台后台考核--学生信息管理</title>
  <style>
    * {
      margin: 0;
      padding: 0;
    }
    h1 {
      height: 59px;
      line-height: 59px;
      border-bottom: 1px solid #ccc;
      box-shadow: 0 0 5px 3px #eee;
      background-color: #eee;
      color: #999;
      text-indent: 1.5em;
    }
    nav {
      background-color: rgb(19,20,21);
      color: #999;
      position: fixed;
      top: 60px;
      left: 0;
      bottom: 0;
      padding-top: 25px;
    }
    nav li {
      list-style: none;
      padding: 15px 50px 15px 25px;
    }
    nav li:hover {
      cursor: pointer;
      background-color: rgba(50,51,52,0.5);
    }
    nav .active {
      background-color: rgba(90,91,92,0.5) !important;
    }
    .content {
      margin-left: 180px;
      padding-left: 2em;
    }
    .content h2 {
      padding: 20px 0;
    }
    #ee{
      border: 1px solid #ccc;
      padding: 10px 25px;
      min-width: 100px;
      text-align: center;
    }
    input, select {
      display: block;
      border-radius: 5px;
      background-color: white;
      border: 1px solid #ccc;
      margin-bottom: 30px;
      height: 35px;
      font-size: 18px;
      text-indent: 1em;
      width: 350px;
    }
    button {
      display: block;
      width: 150px;
      text-align: center;
      height: 40px;
      line-height: 40px;
      color: white;
      background-color: rgb(54,133,250);
      font-size: 18px;
      border: 0;
      border-radius: 5px;
    }
    .content section {
      display: none;
    }
    .content .active {
      display: block;
    }
    table {
      background-color: #eee;
      margin: 50px;
      border: 1px solid #999;
      border-collapse: collapse;
    }
    th,td {
      border: 1px solid #ccc;
      padding: 10px 25px;
      min-width: 100px;
      text-align: center;
    }
  </style>
</head>
<!-- 以上标签中包含的信息无需改动 -->

<body>

<!-- 顶部导航栏，无需改动 -->
<h1>服务器平台后台考核-学生信息管理</h1>

<!-- 左侧导航栏，需要在合适的li标签上添加上 class="active" 字段，四个中只能选一个添加 -->
<nav>
  <ul>

    <li data-id="search" class="active">查找学生信息</li>
    <li  data-id="add">添加学生</li>
    <li data-id="delete">删除学生</li>
    <li data-id="modify">修改学生信息</li>

  </ul>
</nav>

<div class="content">

  <!-- 右侧显示的内容，需要在核实的section标签上添加上 class="active" 字段，需要和左侧导航栏的内容相吻合；此外只有查询信息部分需要额外的修改 -->

  <!-- 添加学生 -->
  <section id="add">
    <h2>添加学生</h2>
    <form action="${pageContext.request.contextPath}/addServlet" method="post">
      <input type="text" placeholder="姓名" name="name" />
      <select name="gender">
        <option value="" disabled="disabled" selected="selected">请选择性别</option>
        <option value="男">男</option>
        <option value="女">女</option>
      </select>
      <input type="text" placeholder="年龄" name="age" />
      <input type="text" placeholder="学号" name="id" />
      <select name="major">
        <option value="" disabled="disabled" selected="selected">请选择所在专业</option>
        <option value="通信工程">通信工程</option>
        <option value="电子信息工程">电子信息工程</option>
        <option value="信息工程">信息工程</option>
        <option value="广播电视工程">广播电视工程</option>
      </select>
      <button type="submit">确认添加</button>
    </form>
  </section>


  <!-- 删除学生 -->
  <section id="delete">
    <h2>删除学生</h2>
    <form action="${pageContext.request.contextPath}/delServlet" method="post">
      <input type="text" placeholder="学号" name="id" />
      <button type="submit">确认删除</button>
    </form>
  </section>


  <!-- 修改学生信息 -->
  <section id="modify">
    <h2>修改学生信息（依学号修改）</h2>
    <form action="${pageContext.request.contextPath}/modServlet" method="post">
      <input type="text" placeholder="姓名" name="name" value="" />
      <select name="gender">
        <option value="" disabled="disabled" selected="selected">请选择性别</option>
        <option value="男">男</option>
        <option value="女">女</option>
      </select>
      <input type="text" placeholder="年龄" name="age" value="" />
      <input type="text" placeholder="学号" name="id" value="" />
      <select name="major">
        <option value="" disabled="disabled" selected="selected">请选择所在专业</option>
        <option value="通信工程">通信工程</option>
        <option value="电子信息工程">电子信息工程</option>
        <option value="信息工程">信息工程</option>
        <option value="广播电视工程">广播电视工程</option>
      </select>
      <button type="submit">确认修改</button>
    </form>
  </section>


  <!-- 查询学生信息 -->
  <section id="search" class="active">
    <h2>查找学生信息(姓名/学号可二选一)</h2>
    <form action="${pageContext.request.contextPath}/findServlet" method="post">
      <input type="text" placeholder="姓名" name="name" value="" />
      <input type="text" placeholder="学号" name="id" value="" />
      <button type="submit">确认查找</button>
    </form>
    <table>
      <thead>
      <caption>查询结果</caption>
      <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>学号</th>
        <th>专业</th>
        <th>操作</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>a</td>
        <td>a</td>
        <td>a</td>
        <td>a</td>
        <td>a</td>
        <td>
          <button style="background:red">删除</button>
        </td>

      </tr>
      <tr>
        不知道怎么搞，我只会用Input提交。disabled又不能提交过去。。 <br>
        每次查学生都回到了add,要再点进search才能看，我不知道怎么办，就换了下顺序...
        <form id="form" action="${pageContext.request.contextPath}/delServlet" method="post">
              <c:forEach items="${students}" var="student">
                <tr>
                  <td>${student.name}</td>
                  <td>${student.age}</td>
                  <td>${student.gender}</td>
                  <td><input type="text" id="ee" name="id" value="${student.id}"></td>
                  <td>${student.major}</td>
                  <td>
                    <button style="background:red" type="submit">删除</button>
                  </td>
                </tr>
              </c:forEach>
        </form>
      </tr>
      </tbody>
    </table>
    <!--
        以上信息只在点击查询时有效，其它时候可以忽略
        如果有查询结果就添加如下代码在此处：
        如果有多条记录，请为tbody标签添加多组tr标签
        如果没有记录，则添加如下代码在此处
        ：
    -->

  </section>
</div>


<!-- 以下为浏览器js脚本，无需改动 -->
<script>
    var lis = document.getElementsByTagName("li");
    var content =  document.getElementsByClassName("content")[0];
    for(var i=lis.length; i>0; i--){
        lis[i-1].onclick = function(){
            document.getElementsByTagName("nav")[0].getElementsByClassName("active")[0].className = "";
            this.className = "active";
            content.getElementsByClassName("active")[0].className = "";
            document.getElementById(this.getAttribute("data-id")).className = "active";
        }
    }
</script>


</body>
</html>
