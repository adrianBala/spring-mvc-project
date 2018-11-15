<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Login Page</title>

</head>

<body>

	<div>
		
		<div >
			
			<div>

				<div >
					<div>Sign In</div>
				</div>

				<div>

					<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
						  method="POST">

					    <div>
					        <div>
					            <div>

									<c:if test="${param.error != null}">
										
										<div>
											Invalid username and password.
										</div>
		
									</c:if>

									<c:if test="${param.logout != null}">
										            
										<div>
											You have been logged out.
										</div>
								    
									</c:if>
									
					            </div>
					        </div>
					    </div>

						<!-- User name -->
						<div >
						    <input type="text" name="username" placeholder="username">
						</div>

						<div >
							<input type="password" name="password" placeholder="password">
						</div>

						<div >
							<div >
								<button type="submit">Login</button>
							</div>
						</div>
						
					</form:form>

				</div>
				
			</div>

			<div>
				<a href="${pageContext.request.contextPath}/register/showRegistrationForm" >Register New User</a>
			</div>

		</div>

	</div>

</body>
</html>