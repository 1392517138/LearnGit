
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>系统登录</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        form {
            width: 400px;
            height: 240px;
            border: 1px solid #ccc;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -120px;
            margin-left: -200px;
            text-align: center;
        }
        h2 {
            position: absolute;
            width: 120px;
            height: 40px;
            line-height: 40px;
            top: -20px;
            left: 30px;
            background-color: white;
        }
        input, select {
            display: block;
            border-radius: 5px;
            background-color: white;
            border: 1px solid #ccc;
            margin: 30px 25px;
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
            margin: 0 auto;
        }
    </style>
</head>
<body>
        我google浏览器打开界面很怪异，ie浏览器就正常，不知道为什么 <br>
        用户名     密码 <br>
        皮         123456 <br>
        asdf       123456 <br>
        cccc       123456 <br>
        cxczvc     123456
    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        <h2>欢迎登录</h2>
        <input type="text" name="name" placeholder="用户名" />
        <input type="password" name="pwd" placeholder="用户密码" />
        <button type="submit">确认登录</button>
    </form>

</body>
</html>