<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Login</title>
<%@ include file="/common-css-javascript.html"%>

</head>
<body>
	<c:import url="/navbar.jsp" />
	
	<div id="outerbody">
		<h3 style="text-align: left;color:blue;">Login</h3>

		<form  action="LoginServlet" method="post">
			<input type="hidden" name="action" value="login">
			<div class="form-group">
				<label>Username:</label> <input class="form-control"
					style="width: 300px" type="text" name="username" required placeholder="username">
			</div>
			<div class="form-group">
				<label>Password:</label> <input class="form-control"
					style="width: 300px" type="password" name="password" required placeholder="password">
			</div>
			<div class="form-group">
				<label>&nbsp;</label> <input class="btn btn-primary active"
					type="submit" value="login" id="submit">
			</div>
		
		</form>
		If You haven't register before <a href="/LearningDiary/signup">click here</a>
		
	</div>
	
</body>
</html>