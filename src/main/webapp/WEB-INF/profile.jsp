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
        <div class="container">
            <div>
                <h1>Welcome, ${sessionScope.user.first_name}!</h1>
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

            <div>
                <h3>Your ads...</h3>
                <ul class="list-group">
                    <c:forEach var="ad" items="${ads}">
                        <li class="list-group-item">
                            <a href="/ads/specificad?id=<c:out value="${ad.id}"/>"><c:out
                                    value="${ad.title}"/></a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </body>
</html>
