<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
    <head>
        <jsp:include page="partials/head.jsp">
            <jsp:param name="title" value="Register For Our Site!"/>
        </jsp:include>
    </head>
    <body>
        <jsp:include page="partials/navbar.jsp"/>
        <%
            String first_name = request.getParameter("first_name");
            if(first_name == null) first_name = "";
            String last_name = request.getParameter("last_name");
            if(last_name == null) last_name = "";
            String email = request.getParameter("email");
            if(email ==  null) email = "";
            String username = request.getParameter("username");
            if(username == null) username = "";
        %>
        <c:if test="${! sessionScope.errors.isEmpty()}">
            <c:forEach var="error" items="${sessionScope.errors}">
                <p class="alert alert-danger">${error}</p>
            </c:forEach>
            <c:remove var="errors" scope="session"/>
        </c:if>
        <div class="container">
            <div class="paper-background">
                <h1>Please fill in your information.</h1>
                <form action="/register" method="post">
                    <div class="form-group">
                        <label for="first_name">First Name:</label>
                        <input id="first_name" name="first_name" class="form-control" type="text" value=<%=first_name%>>
                    </div>
                    <div class="form-group">
                        <label for="last_name">Last Name:</label>
                        <input id="last_name" name="last_name" class="form-control" type="text" value=<%=last_name%>>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input id="email" name="email" class="form-control" type="text" value=<%=email%>>
                    </div>
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input id="username" name="username" class="form-control" type="text" value=<%=username%>>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <input id="password" name="password" class="form-control" type="password">
                    </div>
                    <div class="form-group">
                        <label for="confirm_password">Confirm Password</label>
                        <input id="confirm_password" name="confirm_password" class="form-control" type="password">
                    </div>
                    <input type="submit" class="btn btn-primary btn-block">
                </form>
            </div>
        </div>
    </body>
</html>
