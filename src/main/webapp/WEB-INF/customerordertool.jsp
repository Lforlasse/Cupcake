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
    <h1>Bruger: #${sessionScope.lookupUserId}</h1>
    <br>
    <div class="context">
        <div class="context-item">
            <form action="FrontController" name="lookupUserId" method="POST">
                <input required type="text" class="form-control" name="lookupUserId" placeholder="User ID">
                <input type="hidden" name="target" value="customerOrderLookup">
                <button id="button" type="submit" class="btn btn-primary mx-auto d-block"
                        style="width: 100%; margin-top: 10px;" value="submit">
                    Søg
                </button>
            </form>
        </div>

        <div class="col table-responsive" style="padding: 0; margin-top: 10px;">
            <table id="scope" class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Ordre ID</th>
                    <th scope="col">Ordre Dato</th>
                    <th scope="col">Ordre Status</th>
                </tr>
                </thead>
                <tbody>

                <!-- INDSÆT FOR EACH KODEN MED ELEMENTER -->
                <c:forEach var="userOrderList" items="${sessionScope.userOrderList}">
                    <tr>
                        <th scope="row">${userOrderList.get("orderId")}</th>
                        <td>${userOrderList.get("orderDate")}</td>
                        <td>
                            <form class="" action="FrontController" name="customerOrderUpdate" method="POST">
                                <select name="orderStatus" class="form-control">
                                    <c:forEach var="statusList" items="${sessionScope.statusList}">
                                        <option
                                                <c:choose>
                                                    <c:when test="${userOrderList.get('orderStatus').equals(statusList.get('orderStatus'))}">
                                                        selected
                                                    </c:when>
                                                </c:choose>
                                        >${statusList.get("orderStatus")}</option>
                                    </c:forEach>
                                </select>
                                <input type="hidden" name="orderId" value="${userOrderList.get("orderId")}">
                                <input type="hidden" name="userId" value="${sessionScope.lookupUserId}">
                                <input type="hidden" name="target" value="customerOrderUpdate">
                                <button type="submit" class="btn btn-primary w-100 grey-btn" value="submit"
                                        style="margin-top: 10px;">Opdater
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <!-- AFSLUT FOR EACH -->
                </tbody>
            </table>
            <form role="form" action="FrontController" name="redirect" method="POST">
                <input type="hidden" name="target" value="redirect">
                <input type="hidden" name="page" value="employee">
                <button type="submit" class="btn btn-primary d-block mr-auto ml-0 grey-btn" value="submit">
                    Tilbage
                </button>
            </form>
        </div>
    </div>
</div>
<%@include file="../includes/footer.html" %>