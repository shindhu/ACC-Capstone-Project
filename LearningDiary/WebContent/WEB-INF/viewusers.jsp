<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Users</title>
<%@ include file="/common-css-javascript.html"%>

</head>
<body>
	
	<c:import url="/navbar.jsp" />
	
	<div id="outerbody">
	<c:out value="${ user}"> </c:out>
		<%-- ${user.username}<br> 
		${user.id }<br>
		${user.email }		 --%>
	</div>

</body>
</html>