<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<title>Add Book</title>
<%@ include file="/common-css-javascript.html"%>

</head>
<body >
	<c:import url="/navbar.jsp"></c:import>
	
	<div id="outerbody"> <!-- class="col-md-offset-1 col-md-8" -->
	<h2 style="text-align: left; color:blue">Add Book</h2>
	
		<form action="addBook" method = "post">
			<input type="hidden" name="action" value="add-book">
			
			<div class="form-group">
				<label>Category ID</label>
				<input class="form-control" style="width:1000px" type="text" name="category_id" value="${book.category_id }" required placeholder="Category ID"><br>
			</div>
			
			<div class="from-group">	
				<label>Category Name</label>
				<input class="form-control" style="width:1000px" type="text" name="category_name" value="${book.category_name }" required placeholder="Category Name"><br>
			</div>
			
			<div class="from-group">	
				<label>Image</label>
				<input class="form-control" style="width:1000px" type="text" name="image" value="${book.image }" placeholder="Paste the book image link from your browser"><br>
			</div>
			
			<div class="from-group">	
				<label>Name</label>
				<input class="form-control" style="width:1000px" type="text" name="name" value="${book.name }" required placeholder="Book Title "><br>
			</div>
			
			<div class="from-group">	
				<label>Book Format</label>
				<input class="form-control" style="width:1000px" type="text" name="book_format" value="${book.book_format }" placeholder="Book Format"><br>
			</div>
			
			<div class="from-group">	
				<label>Notes</label>
				<textarea class="form-control" rows="8"  name="notes" value="${book.notes }" placeholder="Your Notes"></textarea><br>
			</div>
			
			<label>&nbsp; </label>
			<input class="btn btn-primary active" type="submit" value="Save Book" id="submit">		
		</form>
		
	</div>
	
</body>
</html>