<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="includes/indexHeader.html" %>
<c:choose>
    <c:when test="${sessionScope.role != null}">
        <%@include file="includes/nav.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="includes/loginNav.html" %>
    </c:otherwise>
</c:choose>
<!-- INDHOLDS DIV -->
<div class="jumbotron text-center" style="padding: 2px;">
    <br>
    <h1>Velkommen</h1>
    <br>
    <div class="container-fluid text-center">
        <button type="button" class="btn btn-primary" value="Button" href="...">Skab din egen cupcake!</button>
    </div>
    <br>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
        </ol>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="img-fluid" src="./img/1.png" alt="First slide">
            </div>
            <div class="carousel-item">
                <img class="img-fluid" src="./img/2.png" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="img-fluid" src="./img/3.png" alt="Third slide">
            </div>
            <div class="carousel-item">
                <img class="img-fluid" src="./img/4.png" alt="Forth slide">
            </div>
            <div class="carousel-item">
                <img class="img-fluid" src="./img/5.png" alt="Fifth slide">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <br>
    <c:if test="${requestScope.error!= null}">

        <h2>Error ! </h2>
        ${requestScope.error}

    </c:if>
    <br><br>
</div>
<%@include file="includes/indexFooter.html" %>