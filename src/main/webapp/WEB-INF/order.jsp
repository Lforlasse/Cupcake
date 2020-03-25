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
    <%--Overskrift sættes ind her--%>
    <h1>Order page
        ${sessionScope.message}
    </h1>
    <br>
    <div class="context">
        <%--Indhold sættes ind her--%>
        Indhold her
    </div>
</div>
<%@include file="../includes/footer.html" %>