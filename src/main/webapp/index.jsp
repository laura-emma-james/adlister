<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
<div class="paper-background">
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <img id="indexpage" src="/images/DMLIST.jpg" alt="https://vignette.wikia.nocookie.net/fictionalcompanies/images/b/b3/DunderMifflinLogo.jpg/revision/latest?cb=20130917132424">
    <div class="container" id="home-title">
        <h1>Welcome <em>Team</em> to the Dunder-Mifflin Sale-List</h1>
        <blockquote><Strong><em>Bring your stuff and make a buck, good luck</em></Strong> -Michael Scott</blockquote>
    </div>
    <a href="/ads"><span id="sale-list" class="badge badge-secondary"><em>Powered by</em> Michael Scott</span></a>
</div>
</body>
</html>
