<nav class="navbar navbar-dark navbar-default" style="background-color: #9CAFB7">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <%--NAVBAR ADDED TO LOGOUT PAGE FOR ADSINDEX USE--%>
        <form action="/search-ads" method="get" class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" name="search" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/logout">Logout</a> </li>
            <li><a href="/ads/create">Create Ad</a></li>
        </ul>
        <div class="dropdown-menu-right">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li><a href="/ads">Products</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="/profile">Profile</a></li>
                <li><a href="/sellerprofile">Public Profile</a></li>
                <li><a href="/">Categories</a></li>
            </ul>
        </div>
    </div><!-- /.navbar-collapse -->
    <jsp:include page="../partials/foot.jsp" />
</nav>
