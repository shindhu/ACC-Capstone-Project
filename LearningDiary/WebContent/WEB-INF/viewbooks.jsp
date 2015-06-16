<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>LearningDiary Books</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>

</head>
<body id="body_layout">
	<c:import url="/WEB-INF/navbar.jsp"></c:import>

	<div class="table-responsive" id="outerbody_table">
		<a href="/LearningDiary/category" style="color: blue; font-style: italic;">Back to Category</a>
		<a class="btn btn-lg" href="/LearningDiary/addBook" style="color:blue; font-weight: bold;">Add Book</a>
		
		<table class="table table-hover">
			<tr style="text-align: justify; ">
				
				<th style="width:5%"> <a href="/LearningDiary/books" style="color:red">ID<span class="glyphicon glyphicon-sort"></span></a></th>
				<th>Image</th>
				<th style="width:20%; text-align: left"> <a href="/LearningDiary/books?order=name" style="color:red">Name<span class="glyphicon glyphicon-sort-by-alphabet"></span></a></th>
				<th>Book_Format</th>
				<th style="width:50%">Notes</th>
				<th>Edit</th>
				<th>Delete</th>
				
			</tr>

			<c:forEach items="${booksList }" var="book">
				<tr>
					<td>${book.id }</td>
					<td><img src="${book.image }" height=100 width=100 /></td>
					<td  style="text-align: left;">${book.name }</td>
					<td>${book.book_format }</td>
					<td style="text-align: justify;">${book.notes }</td>
					<td style="width:100px">
						<a class="btn btn-warning btn-md" href="editBook?id=${book.id }"> Edit </a></td>
					<td>
						<form action="deleteBook" method="post">
							<input type="hidden" name="id" value="${book.id }">
							<input class="btn btn-danger btn-sm" type="submit" value="Delete" id="submit">
						</form>
					</td>
				
				</tr>
			</c:forEach>
		</table>
		<a href="/LearningDiary/category" style="color: blue; font-style: italic;">Back to Category</a>
		
	</div>
	
		
	<div>
	<%@ include file="/WEB-INF/footer.jsp" %>
	</div>
	</body>
</html>



<!-- its optional to have the select books by id and name
		<form action="/LearningDiary/books" method="get">
			<select name="order">
				<option value="id">Order By ID</option>
				<option value="name">Order By Name</option>
			</select>
			<input type="submit" value="submit ">
		</form> -->
		<!-- style="position: fixed; background-color: grey;" -->