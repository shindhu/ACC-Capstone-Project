<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<head>
<title>BookByCategory</title>
<%@ include file="/common-css-javascript.html"%>

</head>
<body>
	<c:import url="navbar.jsp"></c:import>
	<div class="table-responsive" id="outerbody" style="height: 700px; overflow: auto">
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Category</th>
			<th>Image</th>
			<th>Name</th>
			<th>Book_Format</th>
			<th>Notes</th>
		</tr>
		
		<%--<c:out value="${theBooksByCategory }"> </c:out> --%>
		  <c:forEach items="${theBooksByCategory }" var="book"> 
			<tr>	
				<td>${book.id }</td>
				<td><a href="category?id=${book.category_id}">${book.category_name }</a></td>
				<td><img src="${book.image }" height=100 width=100 /></td>
				<td>${book.name }</td>
				<td>${book.book_format }</td>
				<td>${book.notes }</td>
			</tr>
		</c:forEach> 
			
	</table>
	</div>

</body>
</html>