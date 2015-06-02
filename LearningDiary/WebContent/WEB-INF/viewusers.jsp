<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Users</title>
<%@ include file="/common-css-javascript.html"%>

</head>
<body>
	
	<c:import url="/navbar.jsp" />
	<%-- <c:out value="${ user}"> </c:out> --%>
	
	<div class="table-responsive" id="outerbody"  >
	<table class="table table-hover">
		<tr>
			 <th>ID</th> 
			<th>Users</th>
			<th>Email</th>
			<th>Edit/Del</th>
		</tr>
		
		 <c:forEach items="${user }" var="theUser">
			<tr>	
				<td>${theUser.id }</td>
				<td>${theUser.username}</td>
				<td>${theUser.email }</td>
				<td>000</td>
			</tr>
		</c:forEach> 
	</table>
	</div>
	

</body>
</html>