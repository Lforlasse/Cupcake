<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
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
    <h1>Indkøbskurv</h1>
    <br>
    <div class="context">

        <div class="col table-responsive">
            <table id="example" class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Produkt nr.</th>
                    <th scope="col">Produkt</th>
                    <th scope="col">Pris</th>
                    <th scope="col">Antal</th>
                    <th scope="col">Total</th>
                </tr>
                </thead>
                <tbody>
                <!-- INDSÆT FOR EACH KODEN MED ELEMENTER -->
                <tr>
                    <th scope="row">Element.produktNR</th>
                    <td>Element.produkt</td>
                    <td>Element.pris</td>
                    <td>Element.antal</td>
                    <td>Element.</td>
                </tr>
                <!-- AFSLUT FOR EACH -->
                </tbody>
            </table>
            <br>
            <table id="example" class="table table-bordered">
                <tr>
                    <th scope="row">KREDIT</th>
                    <td>Element.userKredit</td>
                </tr>
            </table>
            <br><br>
            <table id="example" class="table table-bordered">
                <tr class="bg-light">
                    <th scope="row">SUM</th>
                    <td colspan="5">Element.cartSum (cartTotal-kredit)</td>
                </tr>
            </table>
        </div>


        <div class="col">
            <br>
            <button type="button" style="float: right;" class="btn btn-primary" value="Button">
                Bekræft ordre
            </button>
            <br>
            <br>
        </div>
    </div>
</div>
</div>
<%@include file="../includes/footer.html" %>

