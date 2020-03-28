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
    <%--Overskrift sættes ind her--%>
    <h1>Værktøj
        ${sessionScope.message}
    </h1>
    <br>
    <div class="context">
        <div class="container-fluid text-center">
            <div class="row">
                <div class="col">
                    <a href="FrontController?target=redirect&page=orderTool" class="btn btn-primary btn-block" role="button" aria-pressed="true">
                        Ordre-oversigt
                    </a>
                </div>
                <div class="col">
                    <a href="FrontController?target=redirect&page=orderTool" class="btn btn-primary btn-block" role="button" aria-pressed="true">
                        Ordre-oversigt
                    </a>
                </div>
                <div class="col">
                    <a href="FrontController?target=redirect&page=orderTool" class="btn btn-primary btn-block" role="button" aria-pressed="true">
                        Ordre-oversigt
                    </a>
                </div>
            </div>
        </div>
    </div>
<%@include file="../includes/footer.html" %>