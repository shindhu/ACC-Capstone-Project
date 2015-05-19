<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>LearningDiary Books</title>
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
		
		<c:forEach items="${booksList }" var="book">
			<tr>	
				<td>${book.id }</td>
				<td>${book.category_name }</td>
				<td><img src="${book.image }" height=100 width=100 /></td>
				<td>${book.name }</td>
				<td>${book.book_format }</td>
				<td>${book.notes }</td>
				
			</tr>
		</c:forEach>
			
	</table>

</body>
</html>