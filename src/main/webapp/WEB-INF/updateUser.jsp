<%--
  Created by IntelliJ IDEA.
  User: emmadejong
  Date: 4/11/18
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="Your Profile" />
        </jsp:include>
    </head>
    <body>
        <form action="/profile/update/" method="post">
            <div class="form-group">
                <label for="first_name">First Name:</label>
                <input class="form-control" type="text" name="first_name" id="first_name" placeholder="Enter First Name..." value="${user.first_name}">
            </div>
            <div class="form-group">
                <label for="last_name">Last Name:</label>
                <input class="form-control" type="text" name="last_name" id="last_name" placeholder="Enter Last Name..." value="${user.last_name}">
            </div>
            <div class="form-group">
                <label for="bio">Bio:</label>
                <input class="form-control" type="text" name="bio" id="bio" placeholder="Enter Last Name..." value="${user.bio}">
            </div>
            <div class="form-group">
                <label for="username">Username:</label>
                <input class="form-control" type="text" name="username" id="username" placeholder="Enter Last Name..." value="${user.username}">
            </div>
            <div class="form-group">
                <label for="last_name">Password:</label>
                <input class="form-control" type="password" name="password" id="password" placeholder="Enter Last Name..." value="${user.password}">
            </div>
            <input type="hidden" name="id" value="${user.id}">
            <button class="btn btn-outline-primary btn-block">Update!</button>
        </form>
    </body>
</html>
