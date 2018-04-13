<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	<head>
		<title>Adventure - Create Account</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		.centered {
  			position: fixed;
  			top: 50%;
  			left: 50%;
  			/* bring your own prefixes */
  			transform: translate(-50%, -50%);
		}
		.success{
			color:green;
			}
		</style>
	</head>

	<body>
		<div class = "centered">
		<h1>Adventure Create Account</h1>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
		<c:if test="${! empty successMessage}">
			<div class="success">${successMessage}</div>
		</c:if>
		<!-- TODO: ACCOUNT SERVLET -->
		
		<form action="${pageContext.servletContext.contextPath}/createAccount" method="post">
			
			<table>
				<tr>
					<td class="label">USERNAME: </td>
					<td><input type="text" name="username" size="12" value="${username}" /></td>
				</tr>
				<tr>
					<td class="label">PASSWORD: </td>
					<td><input type="password" name="password" size="12" value="${password}" /></td>
				</tr>
				
				
			</table>
			<input type="Submit" name="createAccount" value="Create Account">
			
			</div>
		</form>
	</body>
</html>