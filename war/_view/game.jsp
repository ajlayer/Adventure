<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
	
	<head>
		<title>Play Adventure</title>
		
		<style type="text/css">
			.error {
				color: red;
			}
		
			td.label {
				text-align: right;
			}
			.input {
  				position: fixed;
  				top: 5px;
  				left: 5px;
			}
			.success{
				color:green;
			}
			.response{
				color:black;
				position: fixed;
  				top: 50%;
  				left: 50%;
  				/* bring your own prefixes */
  				transform: translate(-50%, -50%);
			}			
		</style>
	</head>

	<body>
		<div class = "response">
			<c:if test="${! empty errorMessage}">
				<div class="error">${errorMessage}</div>
			</c:if>
			<c:if test="${! empty response}">
				<div class="response">${response}</div>
			</c:if>
		</div>
		<div class = "input">
			<form action="${pageContext.servletContext.contextPath}/game" method="post">
				<table>
					<td class="label">Enter Command: </td>
					<td><input type="text" name="userInput" size="12" value="${userInput}" /></td>
				</table>
	
				<input type="Submit" name="Submit" value="Submit">
		
			
		
			</form>
		</div>
	</body>
</html>