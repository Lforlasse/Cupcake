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
        <c:choose>
            <c:when test="${sessionScope.role != 10}">
                <%@include file="../includes/nav.jsp" %>
            </c:when>
            <c:otherwise>
                <%@include file="../includes/adminNav.html" %>
            </c:otherwise>
        </c:choose>
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
    <div class="context">
        <div class="container-fluid">
            <div class="row align-items-center">
                <div class="col">
                    <h3>Mine ordrer</h3>
                    <p>
                        <button type="button" class="btn btn-primary mx-auto d-block" value="Button">Se aktive ordrer
                        </button>
                        <br>
                        <button type="button" class="btn btn-primary mx-auto d-block" value="Button">Se udførte ordrer
                        </button>
                        <br>
                    </p>
                    <h3>Administration</h3>
                    <form role="form" action="FrontController" name="orderTool" method="POST" style="margin-top: 10px">
                        <input type="hidden" name="target" value="orderTool">
                        <button type="submit" style="" class="btn btn-primary mx-auto d-block" value="submit">
                            Ordre-oversigt
                        </button>
                    </form>
                    <form role="form" action="FrontController" name="customerOrderTool" method="POST" style="margin-top: 10px">
                        <input type="hidden" name="target" value="customerOrderTool">
                        <button type="submit" style="" class="btn btn-primary mx-auto d-block" value="submit">
                            Kunde ordrer-oversigt
                        </button>
                    </form>
                    <form role="form" action="FrontController" name="customerCreditTool" method="POST" style="margin-top: 10px">
                        <input type="hidden" name="target" value="customerCreditTool">
                        <button type="submit" style="" class="btn btn-primary mx-auto d-block w-100" value="submit">
                            Kunde Kredit
                        </button>
                    </form>
                    <br>
                </div>
                <div class="col">
                    <table id="example" class="table table-striped table-bordered" style="width:100%">
                        <thead>
                        <tr>
                            <th>Mine data</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>Kredit</td>
                            <td>${sessionScope.balance}</td>
                        </tr>
                        <tr>
                            <td>Navn</td>
                            <td>${sessionScope.name}</td>
                        </tr>
                        <tr>
                            <td>Kunde nr.</td>
                            <td>${sessionScope.userId}</td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td>${sessionScope.email}</td>
                        </tr>
                        <tr>
                            <td>Adgangskode</td>
                            <td>********</td>
                        </tr>
                        <tr>
                            <td>Telefon</td>
                            <td>${sessionScope.phone}</td>
                        </tr>
                        <tr>
                            <td>Adresse</td>
                            <td>${sessionScope.address}</td>
                        </tr>
                    </table>
                    <button type="button" class="btn btn-primary btn-block" value="Button">Skift adgangskode
                    </button>
                </div>
            </div>
        </div>
    </div>
<%@include file="../includes/footer.html" %>