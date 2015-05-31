<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>LearningDiary Category</title>
<%@ include file="/common-css-javascript.html"%>
</head>
<body>

	<c:import url="/navbar.jsp"></c:import>

	<div>
		<a class="btn btn-lg" href="/LearningDiary/addCategory" style="color:blue">Add Category</a>
		
	</div>
	
	<div class="table-responsive" id="outerbody"  >
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
				<td>000</td>
			</tr>
		</c:forEach> 
	</table>
	</div>
	
		
</body>
</html>