<%--
  Created by IntelliJ IDEA.
  User: lalepro
  Date: 4/10/18
  Time: 9:15 AM
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
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
var="ad" items="${ad}"
<div class="col-md-6">
    <h2>${ad.title}</h2>
    <p>${ad.description}</p>
    <p>${ad.price}</p>
    <a href="/profile/ad.user_id"></a>>${ad.user_id}</a>
    <%--need emma's servlet for ads_user--%>
</div>

<div>
    <h2>Product Questions and Answers</h2>
    <p>Under Construction</p>
</div>
<%--<c:forEach var="questions" items="${ads}">--%>
<%--<div class="col-md-6">--%>
<%--<h2>${ad.title}</h2>--%>
<%--<p>${ad.description}</p>--%>
<%--</div>--%>
<%--</c:forEach>--%>



</body>
</html>
