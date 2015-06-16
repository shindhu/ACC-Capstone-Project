<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Learning Diary</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>
<style>
#heading {
	color:blue;
	text-align: center;
	
	font-family: cursive;
	font-size: 50px;
} 
#row2 {
	text-align: center;
	
}
</style>
</head>

<body id="body_layout">
	<%@ include file ="/WEB-INF/navbar.jsp" %>
<div class="outerbody">
	<div id="heading">
	<p><strong>LearningDiary</strong></p>
	</div>
	
	<div class="row">
		<div class="col-md-2">
			<img src="images/book-tree.jpg" width="250px" height="650px">
		</div>
		<div class="col-md-8" id="row2">
				<h3>Welcome to the LearningDiary!</h3><br>
			<p style="text-align: justify;">
				LearningDiary is handy-dandy for book lovers. This application dedicated to helping you keep track of your books 
				along book_location and notes for quick reference. 
				<br><br>
				SIGN UP FOR FREE and let the application help you organize your books through category.
				LearningDiary don't have limitations to have category and books. 
				<br><br>  
				Each Category track number of books you own as count. If you decide to delete category please make sure category is empty.
				<br><br>
				Each Book have 
				
			</p>
			
		</div>
		<div class="col-md-2">
			<img src="images/book-tree.jpg" width="250px" height="650px" >
		</div>
	</div> <!-- rows div --> 
	
	<div >
	<%@ include file="/WEB-INF/footer.jsp" %>
	</div>
</div> <!-- end of index_outerbody div -->
</body>
</html>