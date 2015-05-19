<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>LearningDiary Category</title>
<%@ include file="/common-css-javascript.html"%>

</head>
<body>

	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Category</th>
		</tr>
		
		<c:forEach items="${categoryList }" var="category">
			<tr>	
				<td>${category.id }</td>
				<td><a href="booksbycategory?id=${category.id}">${category.name }</a></td>
			</tr>
		</c:forEach>
			
	</table>

</body>
</html>