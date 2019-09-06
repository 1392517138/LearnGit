<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/4 0004
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>查询信息</h4>
    <div>
        <talbe border="1">
            <c:forEach items="${students}" var="student">
                <td>${student.name}</td>
                <td>${student.id}</td>
                <td>${student.major}</td>
            </c:forEach>
        </talbe>
    </div>
</body>
</html>
