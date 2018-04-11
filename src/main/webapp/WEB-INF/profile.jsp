<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="Your Profile" />
        </jsp:include>
    </head>
    <body>
        <jsp:include page="/WEB-INF/partials/navbar-logout.jsp" />
        <div class="container">
            <div>
                <h1>Welcome, ${sessionScope.user.username}!</h1>
            </div>

            <div class="btn-group">
                <form action="/profile/update" method="GET">
                    <input type="hidden" name = "id" value="${user.id}">
                    <button class="btn btn-primary btn-lg">Update</button>
                </form>
                <form action="/profile/delete" method="POST">
                    <input type="hidden" name = "id" value="${user.id}">
                    <button class="btn btn-danger btn-lg">Delete</button>
                </form>
            </div>
        </div>
    </body>
</html>
