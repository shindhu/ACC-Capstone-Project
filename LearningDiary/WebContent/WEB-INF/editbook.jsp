<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<title>LearningDiary: Edit Book</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>

</head>
<body >
	<c:import url="/WEB-INF/navbar.jsp"></c:import>
	
	<div id="outerbody"> 
	<h2 style="text-align: left; color:blue">Edit Book</h2>
	
		<form action="editBook" method = "post">
			<input type="hidden" name="action" value="edit-book">
			
			<div class="form-group">
				<label>ID</label>
				<input class="form-control" style="width:500px" type="text" name="id" value="${book.id }" readonly><br>
				
			</div>
			
			<div class="form-group">
				<label>Category ID</label>
				<input class="form-control" style="width:500px" type="text" name="category_id" value="${book.category_id }" readonly><br>
				
			</div>
			
			<div class="from-group">	
				<label>Category Name</label>
				<input class="form-control" style="width:500px" type="text" name="category_name" value="${book.category_name }" required ><br>
			</div>
			
			<div class="from-group">	
				<label>Image</label>
				<input class="form-control" style="width:500px" type="text" name="image" value="${book.image }" ><br>
			</div>
			
			<div class="from-group">	
				<label>Name</label>
				<input class="form-control" style="width:500px" type="text" name="name" value="${book.name }" required ><br>
			</div>
			
			<div class="from-group">	
				<label>Book Format</label>
				<input class="form-control" style="width:500px" type="text" name="book_format" value="${book.book_format }" ><br>
			</div>
			
			<div class="from-group">	
				<label>Notes</label>
				<textarea class="form-control" rows="8"  name="notes" > ${book.notes }</textarea><br>
			</div>
			
			<label>&nbsp; </label>
			<input class="btn btn-primary active" type="submit" value="Save Edits To Book" id="submit">		
		</form>
		
	</div>
	
</body>
</html>