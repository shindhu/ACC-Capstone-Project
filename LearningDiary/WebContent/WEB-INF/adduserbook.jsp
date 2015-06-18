<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>LaerningDiary:AddUserBook</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>

</head>
<body id="body_layout">
	<c:import url="/WEB-INF/navbar.jsp"></c:import>
	
	<div id="outerbody"> 
	<h2 style="text-align: left; color:blue">Add Book</h2>
	
		<form action="addUserBook" method = "post">
			<input type="hidden" name="action" value="add-book">
			
			<!-- <div class="form-group">
				<label></label>
			</div> -->
			
			<div class="form-group">	
				<label>Image</label>
				<input class="form-control" style="width:500px" type="text" name="image" value="${theUserBook.image }" placeholder="Paste the book image link from your browser"><br>
			</div>
			
			<div class="form-group">	
				<label>Name</label>
				<input class="form-control" style="width:500px" type="text" name="name" value="${theUserBook.name }" required placeholder="Book Title "><br>
			</div>
			
			<div class="form-group">	
				<label>Book Format</label>
				<input class="form-control" style="width:500px" type="text" name="book_format" value="${theUserBook.book_format }" placeholder="Book Format"><br>
			</div>
			
			<div class="form-group">	
				<label>Notes</label>
				<textarea class="form-control" style="width:1000px" rows="10"  name="notes" value="${theUserBook.notes }" placeholder="Your Notes"></textarea><br>
			</div>
			
			<label>&nbsp; </label>
			<input class="btn btn-primary active" type="submit" value="Save Book" id="submit">		
		</form>
		
	</div>
	
	<div>
	<%@ include file="/WEB-INF/footer.jsp" %>
	</div>
	
</body>
</html>
