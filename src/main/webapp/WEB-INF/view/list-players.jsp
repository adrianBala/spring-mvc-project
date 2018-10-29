<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
  <title>List Players</title>
</head>

<body>
  <div id="wrapper">
    <div id="header">
      <h1>List of players</h1>
    </div>

  </div>

  <div id="container">

    <div id="content">

      <table>

        <tr>
          <th>First name</th>
          <th>Last name</th>
          <th>Discipline</th>
        </tr>

        <c:forEach var="tempPlayer" items="${players}">
          <tr>
            <td>${tempPlayer.firstName}</td>
            <td>${tempPlayer.lastName}</td>
            <td>${tempPlayer.discipline}</td>
          </tr>

        </c:forEach>

      </table>

    </div>

  </div>
</body>

</html>