<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<c:choose>
    <c:when test="${sessionScope.role == null}">
        <c:redirect url="FrontController?target=redirect&page=index"/>
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
    <h1>Indkøbskurv</h1>
    <br>
    <div class="context">

        <div class="col table-responsive" style="padding: 0;">
            <table id="scope" class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Produkt ID</th>
                    <th scope="col">Topping</th>
                    <th scope="col">Bottom</th>
                    <th scope="col">Antal</th>
                    <th scope="col">Total</th>
                </tr>
                </thead>
                <tbody>
                <!-- INDSÆT FOR EACH KODEN MED ELEMENTER -->
                <c:forEach var="cartItem" items="${sessionScope.cartItemList}">
                    <tr>
                        <th scope="row">${cartItem.itemId}</th>
                        <td>${cartItem.topping}</td>
                        <td>${cartItem.bottom}</td>
                        <td>
                            <form role="form" action="FrontController" name="removeCupcake" method="POST">
                                <input type="hidden" name="target" value="removeCupcake">
                                    ${cartItem.quantity}
                                <input type="hidden" name="itemId" value="${cartItem.itemId}">
                                <button type="submit" style="color: dodgerblue; float: right; background-color: #ffffff"
                                        value="submit">Fjern
                                </button>
                            </form>
                        </td>
                        <td>${cartItem.price}</td>
                    </tr>
                </c:forEach>
                <!-- AFSLUT FOR EACH -->
                </tbody>
            </table>
            <br>
            <table id="sum" class="table table-bordered">
                <tr class="bg-light">
                    <th scope="row">SUM</th>
                    <td colspan="5">${sessionScope.cart.cartPrice}</td>
                </tr>
            </table>
        </div>
        <form role="form" action="FrontController" name="createOrder" method="POST">
            <input type="hidden" name="target" value="createOrder">
            <button type="submit" style="" class="btn btn-primary mr-0 ml-auto d-block" value="submit">
                Bekræft ordre
            </button>
        </form>
    </div>
</div>
<%@include file="../includes/footer.html" %>