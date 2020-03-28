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
    <h1>Opret ny bruger</h1>
    <br>
    <div class="context">

<div class="new user form" link rel="stylesheet" href="../css/styleNewUser.css" >
  <%-- new user form--%>

      <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
      <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <!------ Include the above in your HEAD tag ---------->

      <div class="wrapper fadeInDown">
          <div id="formContent">
              <!-- Tabs Titles -->



              <!-- Login Form -->
              <form>
                  <input type="text" id="login" class="fadeIn second" name="login" placeholder="dit brugernavn">
                  <input type="text" id="password" class="fadeIn third" name="login" placeholder="din adgangskode">
                  <input type="text" id="password" class="fadeIn third" name="login" placeholder="din adgangskode igen">

               <%--   <button type="button" style="float: center;" class="btn btn-primary" value="Button">Opret bruger</button>--%>

                  <input type="submit" class="fadeIn fourth" value="Opret bruger">
              </form>

              <!-- Remind Passowrd -->
              <div id="formFooter">
                  <a class="underlineHover" href="#">Glemt Kodeord?</a>
              </div>

          </div>
      </div>




      <%-- new user form --%>
</div>


       <%-- <div class="col">
            <br>
            <button type="button" style="float: center;" class="btn btn-primary" value="Button">Opret bruger</button>
            <br>
            <br>
        </div>--%>
    </div>
</div>

<script>

</script>
<%@include file="../includes/footer.html" %>

