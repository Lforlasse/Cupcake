<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.html" %>
<c:choose>
    <c:when test="${sessionScope.email != null}">
        <%@include file="../includes/loginNav.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="../includes/nav.html" %>
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
                    <button type="button" class="btn btn-primary btn-block" value="Button">Se aktive ordrer</button>
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
                    <button type="button" class="btn btn-primary btn-block" value="Button">Administrer produkter</button>
                </p>
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
                        <td>Credit</td>
                        <td>INDSÆT KODE TIL credit balance</td>
                    </tr>
                    <tr>
                        <td>Navn</td>
                        <td>INDSÆT KODE TIL NAVN</td>
                    </tr>
                    <tr>
                        <td>Kunde nr.</td>
                        <td>LAV ATTRIBUT TIL KUNDENR</td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>${sessionScope.name}</td>
                    </tr>
                    <tr>
                        <td>Adgangskode</td>
                        <td>LAV ATTRIBUT TIL adgangskode (husk secretpassformat)</td>
                    </tr>
                    <tr>
                        <td>Telefon</td>
                        <td>LAV ATTRIBUT TIL TELEFON</td>
                    </tr>
                    <tr>
                        <td>Adresse</td>
                        <td>LAV ATTRIBUT TIL Adresse</td>
                    </tr>
                </table>
                <button type="button" class="btn btn-primary btn-block" value="Button">Skift adgangskode</button>
            </div>
        </div>
</div>
<%@include file="../includes/footer.html" %>