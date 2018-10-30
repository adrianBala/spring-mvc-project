<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

    <title>Add player</title>

    <link type="text/css" rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/style.css"
    />

    <link type="text/css" rel="stylesheet"
      href="${pageContext.request.contextPath}/resources/css/add-player-style.css"
    />

</head>
<body>
  <div id="wrapper">
    <div id="header">
      <h2>Add player form</h2>
    </div>

    <div id="container">
      <h3>Add player</h3>

      <form:form action="addPlayer" modelAttribute="player" method="POST">
        <table>
          <tbody>
            <tr>
              <td><label>First name:</label></td>
              <td><form:input path="firstName"/></td>
            </tr>
            <tr>
              <td><label>Last name:</label></td>
              <td><form:input path="lastName"/></td>
            </tr>
            <tr>
              <td><label>Discipline:</label></td>
              <td><form:input path="discipline"/></td>
            </tr>
            <tr>
              <td><label></label></td>
              <td><input type="submit" value="Add" class="add"/></td>
            </tr>
          </tbody>
        </table>
      </form:form>

      <div style="clear; both;"></div>
      <p>
        <a href="${pageContext.request.contextPath}/player/list">Back to list</a>
      </p>
    </div>

  </div>
</body>




</html>
