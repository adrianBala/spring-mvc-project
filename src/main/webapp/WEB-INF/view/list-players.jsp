<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
  <title>List Players</title>
  <link type="text/css"
        rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/style.css"

</head>

<body>
  <div id="wrapper">
    <div id="header">
      <h1>List of players</h1>
    </div>

  </div>

  <div id="container">

    <div id="content">

      <input type="button" value="Add player"
            onclick="window.location.href='showFormForAdd'; return false;"
            class="add-button"
      />

      <table>

        <tr>
          <th>First name</th>
          <th>Last name</th>
          <th>Discipline</th>
          <th>Action</th>
        </tr>

        <c:forEach var="tempPlayer" items="${players}">

          <c:url var="updateLink" value="/player/showFormForUpdate">
            <c:param name="playerId" value="${tempPlayer.id}" />
          </c:url>

          <c:url var="deleteLink" value="/player/delete">
            <c:param name="playerId" value="${tempPlayer.id}" />
          </c:url>
          <tr>
            <td>${tempPlayer.firstName}</td>
            <td>${tempPlayer.lastName}</td>
            <td>${tempPlayer.discipline}</td>
            <td>
              <a href="${updateLink}">Update</a>
              |
              <a href="${deleteLink}"
                onclick="if(!(confirm("Are you sure you want to delete this player?"))) return false">Delete</a>
            </td>
          </tr>

        </c:forEach>

      </table>

    </div>

  </div>
</body>

</html>
