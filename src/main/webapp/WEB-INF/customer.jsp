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
    <h1>Velkommen
        ${sessionScope.name}
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

                <h3>Olsker Cupcakes</h3>
                <p>
                    <button type="button" class="btn btn-primary btn-block" value="Button">FAQ</button>
                    <br>
                    <button type="button" class="btn btn-primary btn-block" value="Button">Kundeservice</button>
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
        <c:if test="${requestScope.error!= null}">
            <h2>Error ! </h2>
            ${requestScope.error}
        </c:if>
        <br><br>
    </div>
</div>
<%@include file="../includes/footer.html" %>