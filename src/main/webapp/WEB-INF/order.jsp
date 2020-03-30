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
    <h1>Ordre: #${sessionScope.orderId}</h1>
    <br>
    <div class="context">

        <div class="col table-responsive">
            <table id="example" class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Produkt nr.</th>
                    <th scope="col">Topping</th>
                    <th scope="col">Bund</th>
                    <th scope="col">Pris</th>
                    <th scope="col">Antal</th>
                    <th scope="col">Total</th>
                </tr>
                </thead>
                <tbody>
                <!-- INDSÆT FOR EACH KODEN MED ELEMENTER -->
                <c:forEach var="orderLine" items="${sessionScope.order}">
                    <tr>
                        <th scope="row">${orderLine.get("productId")}</th>
                        <td>${orderLine.get("topping")}</td>
                        <td>${orderLine.get("bottom")}</td>
                        <td>${orderLine.get("priceSingle")}</td>
                        <td>${orderLine.get("quantity")}</td>
                        <td>${orderLine.get("priceTotal")}</td>
                    </tr>
                </c:forEach>
                <!-- AFSLUT FOR EACH -->
                </tbody>
            </table>
            <table id="sum" class="table table-bordered" style="margin-top: 10px">
                <tr class="bg-light">
                    <th scope="row">SUM</th>
                    <c:set var="order" value="${sessionScope.order}"/>

                    <c:choose>
                        <c:when test="${order.size() == 0}">
                            <td colspan="5"></td>
                        </c:when>
                        <c:otherwise>
                            <c:set var="lastLine" value="${order.get(order.size()-1)}"/>
                            <td colspan="5">${lastLine.get("priceSum")}</td>
                        </c:otherwise>
                    </c:choose>

                </tr>
            </table>
            <table id="kredit" class="table table-bordered" style="margin-top: 10px">
                <tr>
                    <th scope="row">KREDIT</th>
                    <td>${sessionScope.balance}</td>
                </tr>
            </table>
        </div>
        <form role="form" action="FrontController" name="redirect" method="POST">
            <input type="hidden" name="target" value="redirect">
            <input type="hidden" name="page" value="customer">
            <button type="submit" class="btn btn-primary d-block mr-auto ml-0 grey-btn" value="submit">
                Tilbage
            </button>
        </form>
    </div>
</div>
<%@include file="../includes/footer.html" %>

