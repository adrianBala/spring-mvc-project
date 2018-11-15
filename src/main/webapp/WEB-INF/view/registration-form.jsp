<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Register New User Form</title>

</head>

<body>

	<div>
		
		<div >
			
			<div >

				<div >
					<div >Register New User</div>
				</div>

				<div >

					<form:form action="${pageContext.request.contextPath}/register/processRegistrationForm" 
						  	   modelAttribute="myUser" >

					    <div >
					        <div >
					            <div>

									<c:if test="${registrationError != null}">
								
										<div >
											${registrationError}
										</div>
		
									</c:if>
																			
					            </div>
					        </div>
					    </div>

						<div >
							<form:input path="userName" placeholder="username" />
						</div>

						<div >
							<form:password path="password" placeholder="password" />
						</div>

						<div >
							<div >
								<button type="submit">Register</button>
							</div>
						</div>
						
					</form:form>

				</div>

			</div>

		</div>

	</div>

</body>
</html>