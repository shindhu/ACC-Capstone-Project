<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>LearningDiary Books</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>

</head>
<body>
	<c:import url="/WEB-INF/navbar.jsp"></c:import>

	<div class="table-responsive" id="outerbody_table">
		<a class="btn btn-lg" href="/LearningDiary/addBook" style="color:blue">Add Book</a>
		<!-- its optional to have the select books by id and name
		<form action="/LearningDiary/books" method="get">
			<select name="order">
				<option value="id">Order By ID</option>
				<option value="name">Order By Name</option>
			</select>
			<input type="submit" value="submit ">
		</form> -->
		
		<table class="table table-hover">
			<tr>
				<th> <a href="/LearningDiary/books">ID<span class="glyphicon glyphicon-sort"></span></a></th>
				<th>Category</th>
				<th>Image</th>
				<th> <a href="/LearningDiary/books?order=name">Name<span class="glyphicon glyphicon-sort-by-alphabet"></span></a></th>
				<th>Book_Format</th>
				<th>Notes</th>
				<th>Edit/Del</th>
			</tr>

			<c:forEach items="${booksList }" var="book">
				<tr>
					<td>${book.id }</td>
					<td><a href="category?id=${book.category_id}">${book.category_name }</a></td>
					<td><img src="${book.image }" height=100 width=100 /></td>
					<td>${book.name }</td>
					<td>${book.book_format }</td>
					<td>${book.notes }</td>
					<td style="width:100px">
						<a class="btn btn-default btn-md" href="editBook?id=${book.id }"> Edit </a>
						<form action="deleteBook" method="post">
							<input type="hidden" name="id" value="${book.id }">
							<input class="btn btn-danger btn-md" type="submit" value="Delete" id="submit">
						</form>
					</td>

				</tr>
			</c:forEach>

		</table>
	</div>
	
	</body>
</html>