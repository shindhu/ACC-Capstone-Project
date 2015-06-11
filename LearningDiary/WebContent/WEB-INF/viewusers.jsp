<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Users</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>

</head>
<body id="body_layout">
	
	<c:import url="/WEB-INF/navbar.jsp" />
	<%-- <c:out value="${ user}"> </c:out> --%>
	
	<div class="table-responsive" id="outerbody"  >
	<table class="table table-hover" style="width:40%">
		<tr>
			 <th style="width:15%">ID</th> 
			<th style="width:20%; text-align: left">Users</th>
			<th style="width:15%">Email</th>
			<!-- <th>Edit/Del</th> -->
		</tr>
		
		 <c:forEach items="${user }" var="theUser">
			<tr>	
				<td>${theUser.id }</td>
				<td style="text-align: left">${theUser.username}</td>
				<td style="text-align: left">${theUser.email }</td>
				<!-- <td>000</td> -->
			</tr>
		</c:forEach> 
	</table>
	</div>
	
	<div>
	<%@ include file="/WEB-INF/footer.jsp" %>
	</div>

</body>
</html>