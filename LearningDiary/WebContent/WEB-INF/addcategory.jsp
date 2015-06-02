<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Add Category</title>
<%@ include file="/common-css-javascript.html"%>

</head>
<body>
	<c:import url="/navbar.jsp"></c:import>
	
	<div id="outerbody"> <!-- class="col-md-offset-1 col-md-8" -->
	<h2 style="text-align: left;color:blue;">Add Category</h2>
	
		<form  action="addCategory" method = "post">
			<input type="hidden" name="action" value="add-book">
			
			<div class="form-group">
				<label>Category Name</label>
				<input class="form-control" style="width:500px" type="text" name="name" value="${category.name }" required placeholder="Enter the Category name"><br>
			</div>
			
			<label>&nbsp; </label>
			<input class="btn btn-primary active" type="submit" value="Save Category" id="submit">		
			
		</form>
	</div>


</body>
</html>