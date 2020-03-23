<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="includes/indexHeader.html" %>
<%@include file="includes/indexNav.html" %>
<!-- INDHOLDS DIV -->
<div class="jumbotron text-center" style="padding: 2px;">
    <br>
    <h1>Velkommen</h1>
    <br>
    <div class ="context">
        <br>HELLO
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
<%@include file="includes/indexFooter.html" %>