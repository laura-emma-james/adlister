<%--
  Created by IntelliJ IDEA.
  User: emmadejong
  Date: 4/11/18
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="Your Profile" />
        </jsp:include>
    </head>
    <body>
    <jsp:include page="/WEB-INF/partials/navbar-logout.jsp" />
    <c:if test="${! sessionScope.errors.isEmpty()}">
        <c:forEach var="error" items="${sessionScope.errors}">
            <p class="alert alert-danger">${error}</p>
        </c:forEach>

        <c:remove var="errors" scope="session" />
    </c:if>
        <form action="/profile/update" method='POST'>
            <div class="form-group">
                <label for="first_name">First Name:</label>
                <input class="form-control" type="text" name="first_name" id="first_name" placeholder="Enter First Name..." value="${user.first_name}">
            </div>
            <div class="form-group">
                <label for="last_name">Last Name:</label>
                <input class="form-control" type="text" name="last_name" id="last_name" placeholder="Enter Last Name..." value="${user.last_name}">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input class="form-control" type="text" name="email" id="email" placeholder="Enter Email..." value="${user.bio}">
            </div>
            <div class="form-group">
                <label for="bio">Bio:</label>
                <input class="form-control" type="text" name="bio" id="bio" placeholder="Enter Bio..." value="${user.bio}">
            </div>
            <div class="form-group">
                <label for="username">Username:</label>
                <input class="form-control" type="text" name="username" id="username" placeholder="Enter Username..." value="${user.username}">
            </div>
            <div class="form-group">
                <label for="last_name">Password:</label>
                <input class="form-control" type="password" name="password" id="password" placeholder="Enter Password...">
            </div>
            <input type="hidden" name="id" value="${user.id}">
            <button class="btn btn-outline-primary btn-block">Update!</button>
        </form>
    </body>
</html>
