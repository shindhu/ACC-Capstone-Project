<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>LearningDiary Category</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>
</head>
<body>

	<c:import url="/WEB-INF/navbar.jsp"></c:import>
	
	<div class="table-responsive" id="outerbody_table"  >
	<a class="btn btn-lg" href="/LearningDiary/addCategory" style="color:blue">Add Category</a>
	<table class="table table-hover">
		<tr>
			 <th>ID</th> 
			<th>Category</th>
			<th>BookCounts</th>
			<th>Edit/Del</th>
		</tr>
		<%--<c:out value="${ categoryList}"> </c:out> --%>
		
		 <c:forEach items="${categoryList }" var="category">
			<tr>	
				<td>${category.id }</td>
				<td><a href="booksByCategory?id=${category.id}">${category.name }</a></td>
				<td><a href="booksByCategory?id=${category.id}">${category.bookcounts }</a></td>
				<td>
					<a class="btn btn-default btn-md" href="editCategory?id=${category.id }"> Edit </a>
						<form action="deleteCategory" method="post">
							<input type="hidden" name="id" value="${category.id }">
							<input class="btn btn-danger btn-md" type="submit" value="Delete" id="submit">
						</form>
				</td>
			</tr>
		</c:forEach> 
	</table>
	</div>
	
		
</body>
</html>