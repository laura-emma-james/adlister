<%--
  Created by IntelliJ IDEA.
  User: lalepro
  Date: 4/11/18
  Time: 6:04 AM
  To change this template use File | Settings | File Templates.
--%>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <%--NAVBAR ADDED TO LOGOUT PAGE FOR ADSINDEX USE--%>
        <form action="/search-sellers-ads" method="get" class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input name="search" type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/logout">Logout</a> </li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
