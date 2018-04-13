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
        <div class="container-fluid">
            <form action="/profile/update" method='POST' class="paper-background">
                <div class="row">
                    <div class="col-md-4 col-md-offset-4">
                        <h1>Update User Information</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6 col-md-offset-3">
                        <label for="first_name">First Name:</label>
                        <input class="form-control" type="text" name="first_name" id="first_name" placeholder="Enter First Name..." value="${user.first_name}">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6 col-md-offset-3">
                        <label for="last_name">Last Name:</label>
                        <input class="form-control" type="text" name="last_name" id="last_name" placeholder="Enter Last Name..." value="${user.last_name}">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6 col-md-offset-3">
                        <label for="email">Email:</label>
                        <input class="form-control" type="text" name="email" id="email" placeholder="Enter Email..." value="${user.email}">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6 col-md-offset-3">
                        <label for="bio">Bio:</label>
                        <textarea class="form-control" type="text" name="bio" id="bio" placeholder="Enter Bio..." value="${user.bio}"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6 col-md-offset-3">
                        <label for="username">Username:</label>
                        <input class="form-control" type="text" name="username" id="username" placeholder="Enter Username..." value="${user.username}">
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-md-6 col-md-offset-3">
                        <label for="last_name">Password:</label>
                        <input class="form-control" type="password" name="password" id="password" placeholder="Enter Password...">
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <input type="hidden" name="id" value="${user.id}">
                        <button class="btn btn-primary btn-block">Update!</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>