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
    <h1>Bruger opslag</h1>
    <br>
    <div class="context">
        <div class="context-item">
            <form action="FrontController" name="lookupUserId" method="POST">
                ${requestScope.error}
                <input required type="text" class="form-control" name="lookupUserId" placeholder="User ID">
                <input type="hidden" name="target" value="customerOrderLookup">
                <button id="button" type="submit" class="btn btn-primary mx-auto d-block"
                        style="width: 100%; margin-top: 10px;" value="submit">
                    Søg
                </button>
            </form>
        </div>
        <form role="form" action="FrontController" name="redirect" method="POST">
            <input type="hidden" name="target" value="redirect">
            <input type="hidden" name="page" value="employee">
            <button type="submit" class="btn btn-primary d-block mr-auto ml-0 grey-btn" value="submit">
                Tilbage
            </button>
        </form>
    </div>
</div>
<%@include file="../includes/footer.html" %>