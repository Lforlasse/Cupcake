<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<c:choose>
    <c:when test="${sessionScope.role != '10'}">
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
    <h1>Kunde Kredit</h1>
    <br>
    <div class="context">
        <div class="col table-responsive" style="padding: 0;">
            <table id="scope" class="table table-bordered">
                <thead>
                <tr>
                    <th scope="col">Kunde ID</th>
                    <th scope="col">Kunde Email</th>
                    <th scope="col">Kredit</th>
                    <th scope="col">Rediger Kredit</th>
                </tr>
                </thead>
                <tbody>
                <!-- INDSÆT FOR EACH KODEN MED ELEMENTER -->
                <c:forEach var="userList" items="${sessionScope.userList}">
                    <tr>
                        <th scope="row">${userList.get("userId")}</th>
                        <td>${userList.get("userEmail")}</td>
                        <td>${userList.get("credit")}</td>
                        <td>
                            <form role="form" action="FrontController" name="target" method="POST">
                                <input type="number" id="editCredit" class="form-control" name="editCredit" placeholder="Beløb">
                                <input type="hidden" value="${userList.get("userId")}" name="userId">
                            <input type="hidden" name="target" value="editCredit">
                            <button type="submit" style="color: dodgerblue; background-color: #ffffff" value="submit">
                                Bekræft
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