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
    <h1>Sortiment page
    </h1>
    <br>
    <div class="context">
        <div class="context-item">
            <form class="form" role="form" name="addCupcake" action="FrontController" method="POST" style="margin: auto; width: 300px;">
                <input type="hidden" name="target" value="addCupcake">
                <label for="topping"></label>
                <select id="topping" name="topping" class="form-control" style="margin-bottom: 10px;">
                    <c:forEach var="topping" items="${applicationScope.toppingList}">
                        <option name="" value="${topping.type}">${topping.type}</option>
                    </c:forEach>
                </select>
                <label for="bottom"></label>
                <select id="bottom" name="bottom" class="form-control" style="margin-bottom: 10px;">
                    <c:forEach var="bottom" items="${applicationScope.bottomList}">
                        <option value="${bottom.type}">${bottom.type}</option>
                    </c:forEach>
                </select>
                <div class="form-group">
                    <label for="quantity" class="sr-only">Antal</label>
                    <input id="quantity" name="quantity" type="text" class="form-control"  placeholder="Antal">
                </div>
                <button type="submit" class="btn btn-primary btn-block" value="submit">Tilføj</button>
            </form>
        </div>
    </div>
</div>
<%@include file="../includes/footer.html" %>