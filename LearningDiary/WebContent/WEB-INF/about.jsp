<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LearningDiary About</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>


</head>
<body id="body_layout">
	<c:import url="/WEB-INF/navbar.jsp"></c:import>

	<div id="outerbody">
		<div>
		<h3 style="color:blue;">About LearningDiary</h3>
		<h4><i>LearningDiary is dedicated to my 2015 ACC Java Development Capstone Project.</i></h4><br>
		</div>
		
		<div  style="text-align: justify; width:700px">
			<b>Task 1: Create the initial project.</b><br>
			The LearningDiary is a simple CRUD (Create Read Update Delete)
			ArrayList Management application created as a Dynamic Web Project with 
			Eclipse IDE, Apache Tomcat and Derby database using Java Servlets
			and JSPs to return and display Prepared Statements.
			<br><br>
			<b>Task 2: Create the home page and site structure.</b><br>
			
		
		</div>
		
	</div>
	
	<div >
	<%@ include file="/WEB-INF/footer.jsp" %>
	</div>
</body>
</html>