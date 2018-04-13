<%--
  Created by IntelliJ IDEA.
  User: lalepro
  Date: 4/12/18
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar-logout.jsp" />
<div class="container">
    <h1>Update Ad</h1>
    <form action="/ad/update" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="${ad.title}">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text" value="${ad.description}"></textarea>
        </div>
        <div class="form-group">
            <label for="description">Price</label>
            <textarea id="price" name="price" class="form-control" type="text" value="${ad.price}"></textarea>
        </div>
        <input type="hidden" name="id" value="${ad.id}">
        <button class="btn btn-outline-primary btn-block">Update!</button>
    </form>
</div>
</body>
</html>
<%----%>