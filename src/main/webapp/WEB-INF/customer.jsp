<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.html" %>
<%@include file="../includes/nav.html" %>
<!-- INDHOLDS DIV -->
<div class="jumbotron text-center" style="padding: 2px!important;">
    <br>
    <h1>Velkommen
        ${sessionScope.message}
    </h1>
    <br>
    <div class="context">
        <br>
        <br>
        <br>
        <br>
        <br>
        <c:if test="${requestScope.error!= null}">
            <h2>Error ! </h2>
            ${requestScope.error}
        </c:if>
        <br><br>
    </div>
</div>
<%@include file="../includes/footer.html" %>