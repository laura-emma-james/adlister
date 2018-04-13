<nav class="navbar navbar-dark navbar-default" style="background-color: #9CAFB7">

    <div  class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->

        <div class="navbar-header">
            <ul class="nav navbar-nav navbar-left">
                <li><a class="logo" href="/index.jsp"><img src="/images/dunder-mifflin.jpg" height="80" length=1000" hspace="5"></a></li>
            </ul>
        </div>

        <div class=" navbar-nav navbar-right dropdown-menu-right">
            <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li><a href="/register">Register</a> </li>
                <li><a href="/login">Sign In</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="/ads">See Avaiable Ads</a></li>
           </ul>
        </div>

    </div>
    <jsp:include page="../partials/foot.jsp" />
</nav>
