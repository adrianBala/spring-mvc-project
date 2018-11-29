<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
      <h1>Player ${player.firstName} ${player.lastName}</h1>
    </div>

  </div>

 <div id="container">

    <div id="content">

      <table>

        <tr>
          <th>Author</th>
          <th>Content</th>
          <th>Date</th>
        </tr>

        <c:forEach var="tempNote" items="${player.notices}">

          <tr>
            <td>${tempNote.author}</td>
            <td>${tempNote.content}</td>
            <td>${tempNote.date}</td>

          </tr>

        </c:forEach>


      </table>
      <div style="clear; both;"></div>
        <p>
            <a href="${pageContext.request.contextPath}/player/list">Back to list</a>
        </p>
      </div>

      <form:form action="${pageContext.request.contextPath}/logout"
      			   method="POST">

      		<input type="submit" value="Logout" />

      </form:form>

    </div>

  </div>


</body>

</html>
