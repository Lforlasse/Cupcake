<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- NAVBAR, start, knap ved collapse -->
<nav class="navbar navbar-expand-lg navbar-light bg-light" role="navigation">
    <div class="container">
        <button class="navbar-toggler border-0" type="button" data-toggle="collapse"
                data-target="#exCollapsingNavbar">
            &#9776;
        </button>
        <!-- NAVBAR, Forside, Sortiment, Kontakt -->
        <div class="collapse navbar-collapse" id="exCollapsingNavbar">
            <ul class="nav navbar-nav">
                <li class="nav-item active"><a href="FrontController?target=redirect&page=index" class="nav-link">Forside</a>
                </li>
                <li class="nav-item"><a href="FrontController?target=redirect&page=assortment"
                                        class="nav-link">Sortiment</a></li>
                <li class="nav-item"><a href="FrontController?target=redirect&page=contact" class="nav-link">Kontakt</a>
                </li>
            </ul>
            <!-- Dropdown Menu, Login -->
            <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                <li class="dropdown order-1" style="margin-right:10px">
                    <button type="button" id="dropdownMenu1" data-toggle="dropdown"
                            class="btn btn-outline-primary dropdown-toggle">${sessionScope.email}<span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right mt-2" style="width: 0;">
                        <li class="px-3 py-2">
                            <a class="dropdown-item text-center" href="FrontController?target=redirect&page=customer">Min side</a>
                            <a class="dropdown-item text-center" href="FrontController?target=logout">Log ud</a>
                        </li>
                    </ul>
                </li>
                <!-- CART knap -->
                <li class="nav-item order-2 order-md-1">
                    <a href="FrontController?target=redirect&page=cart">
                        <button type="submit" class="btn btn-primary btn-block">
                            <i class="fa fa-shopping-cart text-center" aria-hidden="true"></i>
                        </button>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>