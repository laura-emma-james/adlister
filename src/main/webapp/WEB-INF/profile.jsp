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
        <div class="container paper-background">
            <div>
                <h1>Welcome, ${sessionScope.user.first_name}!</h1>
                <h3><em>That's what she said.</em></h3>
            </div>

            <div class="btn-group">
                <form action="/profile/update" method="GET">
                    <input type="hidden" name = "id" value="${user.id}">
                    <span><h3>Click here to update your profile:</h3></span><button class="btn btn-primary btn-lg">Update</button>
                </form>
                <form action="/profile/delete" method="POST">
                    <input type="hidden" name = "id" value="${user.id}">
                    <span><h3>Deleting your profile is permanent:</h3></span><button class="btn btn-danger btn-lg">Delete</button>
                </form>
            </div>

            <div>
                <h3>Your ads...</h3>
                <ul class="list-group">
                    <c:forEach var="ad" items="${ads}">
                        <li class="list-group-item">
                            <p>${ad.title}</p>
                            <p>${ad.description}</p>
                            <p>${ad.price}</p>

                            <%--<a href="/ads/update?id=${ad.id}">Edit Ad</a>--%>

                            <form action="/ad/update" method="get">
                                <input type="hidden" name="id" value="${ad.id}">
                                <button class="btn btn-primary btn-sm">Update Ad</button>
                            </form>

                            <form action="/delete/ad" method="POST">
                                <input type="hidden" name="id" value="${ad.id}">
                                <button class="btn btn-danger btn-sm">Delete Ad</button>
                            </form>
                    </c:forEach>
                </ul>
            </div>

        <div class="btn-group message">
            <button type="button" class="btn btn-secondary dropdown-toggle text-block" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Message From World's Best Boss
            </button>
            <div class="dropdown-menu dropdown-menu-right">
                <button class="dropdown-item" type="button"></button>
                <li><a class="navbar-brand mscott" href="/ads"><img src="/images/Mscotface.png" alt=""></a></li>
                <button class="dropdown-item boss-not" type="button">Do Not Sell My Stuff!</button>
            </div>
        </div>
        </div>
    </body>
</html>

<%----%>