<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
    <h1>Indkøbskurv</h1>
    <br>
    <div class="context">

        <div class="col table-responsive">
            <table id="example" class="table table-striped table-bordered">
                <thead>
                <tr>
                    <th>Produkt nr.</th>
                    <th>Produkt</th>
                    <th>Pris</th>
                    <th>Antal</th>
                    <th>Total</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="element" items="${sessionScope.myList}">
                <tr>
                   <td>${element.toString()}</td>
                </tr>
                </c:forEach>
                </tbody>

            </table>

        </div>


        <div class="col">
            <br>

            <button type="button" style="float: right;" class="btn btn-primary" value="Button">Bekræft ordre</button>

            <button type="button" style="float: left;" class="btn btn-primary" value="Button">Sortiment</button>
            <br>
            <br>

        </div>

    </div>
</div>
</div>
<%@include file="../includes/footer.html" %>