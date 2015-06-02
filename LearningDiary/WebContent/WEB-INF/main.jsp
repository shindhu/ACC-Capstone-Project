<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>User LoggedIn Main Page</title>
<%@ include file="/common-css-javascript.html"%>

</head>
<body>

	<c:import url="/navbar.jsp">
	</c:import>
	<div id="outerbody">
		<br>
		<p style="text-align: left; color: blue;">&nbsp;Welcome to
			LearningDiary ${capName }.</p>

		<%-- <c:param name= "isLoggedIn" value="${isLoggedIn }"></c:param>
				
			<c:if test="${sessionScope.isLoggedIn == true }">
				<p class="alert alert-success" role="alert">Logged In! </p>
			</c:if>	
			 --%>
		<p>
			&nbsp;Your id: ${id }<br> &nbsp;Your email: ${email }
		</p>
	</div>

</body>
</html>