<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>BookByCategory</title>
<%@ include file="/common-css-javascript.html"%>

</head>
<body>

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Category</th>
			<th>Image</th>
			<th>Name</th>
			<th>Book_Format</th>
			<th>Notes</th>
		</tr>
		
		<c:forEach items="${theBooksByCategory }" var="booksbycategory">
			<tr>	
				<td>${booksbycategory.id }</td>
				<td>${booksbycategory.category_name }</td>
				<td><img src="${booksbycategory.image }" height=100 width=100 /></td>
				<td>${booksbycategory.name }</td>
				<td>${booksbycategory.book_format }</td>
				<td>${booksbycategory.notes }</td>
			</tr>
		</c:forEach>
			
	</table>

</body>
</html>