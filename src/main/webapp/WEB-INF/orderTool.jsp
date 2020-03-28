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
    <h1>Ordre-oversigt</h1>
    <br>
    <div class="context">
        <div class="col table-responsive" style="padding: 0;">
            <table id="scope" class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Ordre ID</th>
                    <th scope="col">User ID</th>
                    <th scope="col">Ordre Dato</th>
                    <th scope="col">Ordre Status</th>
                </tr>
                </thead>
                <tbody>
                <!-- INDSÆT FOR EACH KODEN MED ELEMENTER -->
                <c:forEach var="seeAllOrders" items="${OrderMapper.seeAllOrders}">
                    <tr>
                        <th scope="row">${OrderMapper.orderId}</th>
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
            <a href="FrontController?target=redirect&page=tools" class="btn btn-primary mr-auto" role="button"
               aria-pressed="true">
                Tilbage
            </a>
        </div>
    </div>
</div>
<%@include file="../includes/footer.html" %>