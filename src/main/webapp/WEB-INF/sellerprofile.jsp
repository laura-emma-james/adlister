<%--
  Created by IntelliJ IDEA.
  User: lalepro
  Date: 4/11/18
  Time: 5:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar-sellers.jsp" />

<div class="container">
    <%--TODO:Welcome heading with Seller Username--%>
    <h1>Welcome to Seller ${user.username} Ads Page</h1>

<%--TODO: Wrap a bootstrap Table around this forEach ads loop for styling--%>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <p>${ad.price}</p>
            <a href="/specificad?id=${ad.id}">See More</a>
            <%--RATINGS OF SELLER--%>
        </div>
    </c:forEach>
</div>

</body>
</html>