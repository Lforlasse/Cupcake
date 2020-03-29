<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="ISO-8859-8" %>
<%@include file="../includes/headerNewUser.html" %>

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

<div class="new user form" >
  <%-- new user form--%>

      <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
      <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
      <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <!------ Include the above in your HEAD tag ---------->

      <div class="wrapper fadeInDown">
          <div id="formContent">
              <!-- Tabs Titles -->



              <!-- Login Form -->
              <form class="form" role="form" name="register" action="FrontController" method="POST">
                  <input type="hidden" name="target" value="register">
                  <input required type="text" id="email" class="fadeIn second" name="email" placeholder="din e-mail">
                  <input required type="text" id="password1" class="fadeIn third" name="password1" placeholder="din adgangskode">
                  <input required type="text" id="password2" class="fadeIn third" name="password2" placeholder="din adgangskode igen">
                  <input required type="text" id="fullName" class="fadeIn third" name="fullName" placeholder="dit navn">
                  <input required type="text" id="address" class="fadeIn third" name="address" placeholder="din adresse">
                  <input required type="text" id="phone" class="fadeIn third" name="phone" placeholder="tlf. nummer">

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

