<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>password</td>
        <td>score</td>
        <td>修改</td>
        <td>删除</td>
    </tr>
    <c:forEach items="${cs}" var="c" varStatus="st">
        <tr>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.password}</td>
            <td>${c.score}</td>
            <td><a href="change.jsp?id=${c.id}">修改</a></td>
            <td><a href="delete.jsp?id=${c.id}">删除</a></td>
        </tr>
    </c:forEach>
     <a href="/showCategory?page=${page.nextPage}">下一页</a>
    <a href="/showCategory?page=${page.prePage}">上一页</a>
</table>