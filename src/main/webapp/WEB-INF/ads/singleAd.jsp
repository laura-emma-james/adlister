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
<div class="container paper-background">
<div class="col-md-6">
    <h2>${ad.title}</h2>
    <p>${ad.description}</p>
    <p>${ad.price}</p>
    <a href="/sellerprofile?id=${user.id}">${user.username}</a>
    <%--need emma's servlet for ads_user--%>
</div>



<div>
    <h2>FAQ</h2>
    <h3>Can you ship overseas?</h3>
    <h4>Yes! <em>For an addition $50.</em></h4>
</div>

</div>
<%--<c:forEach var="questions" items="${ads}">--%>
<%--<div class="col-md-6">--%>
<%--<h2>${ad.title}</h2>--%>
<%--<p>${ad.description}</p>--%>
<%--</div>--%>
<%--</c:forEach>--%>



</body>
</html>
