<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<head>
<title>UserBooks</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>

</head>
<body id="body_layout">
	<c:import url="/WEB-INF/navbar.jsp"></c:import>
	<div class="table-responsive" id="outerbody_table" >
	
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Image</th>
			<th>Name</th>
			<th>Book_Format</th>
			<th>Notes</th>
			<th>Delete</th>
		</tr>
		
		<%--<c:out value="${theBooksByCategory }"> </c:out> --%>
		  <c:forEach items="${userBooks }" var="theUserBook"> 
			<tr>	
				<td>${theUserBook.id }</td>
				<td><img src="${theUserBook.image }" height=100 width=100 /></td>
				<td>${theUserBook.name }</td>
				<td>${theUserBook.book_format }</td>
				<td style="text-align: justify;">${theUserBook.notes }</td>
				<td>
						<form action="deleteUserBook" method="post">
							<input type="hidden" name="id" value="${theUserBook.id }">
							<input class="btn btn-danger btn-sm" type="submit" value="Delete" id="submit">
						</form>
					</td>
				
			</tr>
		</c:forEach> 
			
	</table>
	</div>

	<div>
	<%@ include file="/WEB-INF/footer.jsp" %>
	</div>
	
</body>
</html>