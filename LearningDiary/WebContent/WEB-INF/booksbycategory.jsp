<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>

<html>
<head>
<title>BookByCategory</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>

</head>
<body id="body_layout">
	<c:import url="/WEB-INF/navbar.jsp"></c:import>
	<div class="table-responsive" id="outerbody_table" >
	<a href="/LearningDiary/category" style="color: blue; font-style: italic;">Back to Category</a>
	<table class="table table-bordered">
		<tr>
			<th>ID</th>
			<th>Image</th>
			<th>Name</th>
			<th>Book_Format</th>
			<th>Notes</th>
		</tr>
		
		<%--<c:out value="${theBooksByCategory }"> </c:out> --%>
		  <c:forEach items="${theBooksByCategory }" var="book"> 
			<tr>	
				<td>${book.id }</td>
				<td><img src="${book.image }" height=100 width=100 /></td>
				<td>${book.name }</td>
				<td>${book.book_format }</td>
				<td style="text-align: justify;">${book.notes }</td>
			</tr>
		</c:forEach> 
			
	</table>
	</div>

</body>
</html>