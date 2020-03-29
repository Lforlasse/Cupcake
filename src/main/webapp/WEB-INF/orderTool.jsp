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
                <c:forEach var="orderList" items="${sessionScope.orderList}">
                    <tr>
                        <th scope="row">${orderList.get("orderId")}</th>
                        <td>${orderList.get("userId")}</td>
                        <td>${orderList.get("orderDate")}</td>
                        <td>${orderList.get("orderStatus")}</td>
                        <td>
                            <form role="form" action="FrontController" name="removeOrder" method="POST">
                                <input type="hidden" name="orderId" value="${orderList.get("orderId")}">
                                <input type="hidden" name="target" value="removeOrder">

                                <button type="submit" style="color: dodgerblue; background-color: #ffffff"
                                        value="submit">Fjern
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <!-- AFSLUT FOR EACH -->
                </tbody>
            </table>
            <br>
            <form role="form" action="FrontController" name="redirect" method="POST">
                <input type="hidden" name="target" value="redirect">
                <input type="hidden" name="page" value="tools">
                <button type="submit" style="" class="btn btn-primary mx-auto d-block" value="submit">
                    Værktøj
                </button>
            </form>
        </div>
    </div>
</div>
<%@include file="../includes/footer.html" %>