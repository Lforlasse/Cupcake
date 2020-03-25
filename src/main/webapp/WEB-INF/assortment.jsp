<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="../includes/header.html" %>
<c:choose>
    <c:when test="${sessionScope.email != null}">
        <%@include file="../includes/loginNav.jsp" %>
    </c:when>
    <c:otherwise>
        <%@include file="../includes/nav.html" %>
    </c:otherwise>
</c:choose>
<!-- INDHOLDS DIV -->
<div class="jumbotron text-center" style="padding: 2px!important;">
    <br>
    <%--Overskrift sættes ind her--%>
    <h1>Sortiement page
    </h1>
    <br>
    <div class="context">
        <div class="context-item">
            <form class="text-center" style="margin: auto; width: 300px;">
                <select class="form-control" style="margin-bottom: 10px;">
                    <c:forEach var="topping" items="${applicationScope.toppingList}">
                        <option value="${topping.type}">${topping.type}</option>
                    </c:forEach>
                </select>
                <select class="form-control" style="margin-bottom: 10px;">
                    <c:forEach var="bottom" items="${applicationScope.bottomList}">
                        <option value="${bottom.type}">${bottom.type}</option>
                    </c:forEach>
                </select>
                <div class="form-group">
                    <label for="antal" class="sr-only">Antal</label>
                    <input type="text" class="form-control" id="antal" placeholder="Antal">
                </div>
                <button type="submit" class="btn btn-primary btn-block">Tilføj</button>
            </form>
        </div>
    </div>
</div>
<%@include file="../includes/footer.html" %>