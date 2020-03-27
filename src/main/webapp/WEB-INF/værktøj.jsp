<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<c:choose>
    <c:when test="${sessionScope.role != '10'}">
        <c:redirect url="FrontController?target=redirect&page=index"></c:redirect>
    </c:when>
</c:choose>
<%@include file="../includes/header.html" %>
<c:choose>
    <c:when test="${sessionScope.email != null}">
        <%@include file="../includes/nav.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="../includes/loginNav.html" %>
    </c:otherwise>
</c:choose>
<!-- INDHOLDS DIV -->
<div class="jumbotron text-center" style="padding: 2px!important;">
    <br>
    <%--Overskrift sættes ind her--%>
    <h1>Employee page
        ${sessionScope.message}
    </h1>
    <br>
    <div class="container-fluid">
        <div class="row align-items-center">
            <div class="col">
                <h3>Mine ordrer</h3>
                <p>
                    <button type="button" class="btn btn-primary btn-block" value="Button"></button>
                    <br>
                    <button type="button" class="btn btn-primary btn-block" value="Button">Se udførte ordrer</button>
                    <br>
                </p>
                <h3>Administration</h3>
                <h5>Ordrer</h5>
                <p>
                    <button type="button" class="btn btn-primary btn-block" value="Button">Ordre-oversigt</button>
                    <br>
                    <button type="button" class="btn btn-primary btn-block" value="Button">Administrer ordrer</button>
                    <br>
                </p>
                <br>
                <h5>Produkter</h5>
                <p>
                    <button type="button" class="btn btn-primary btn-block" value="Button">Produkt-oversigt</button>
                    <br>
                    <button type="button" class="btn btn-primary btn-block" value="Button">Administrer produkter
                    </button>
                </p>
            </div>
        </div>
    </div>
<%@include file="../includes/footer.html" %>