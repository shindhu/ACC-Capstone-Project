<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LearningDiary Contact</title>
<%@ include file="/WEB-INF/common-css-javascript.html"%>


</head>
<body id="body_layout">

	<c:import url="/WEB-INF/navbar.jsp"></c:import>
	
	<div id="outerbody" class="container-fluid">
		<div class="row">
			<div class="col-sm-6">
				<h3 style="color:blue">About Me</h3>
				<p>
					Thank you for visiting my page. 
					My name is <font style="color:red; font-size: medium; font-style: italic; ">Shindhu Malathi Padmanaban.</font>
					Completed my <font style="color:red; font-size: small;">
										Bachelor of Engineering in Information Technology(IT)</font>
					in 2007 and <font style="color:red; font-size: small;">
										Java Development Series in Austin Community College(ACC).</font>
				</p>
				<p>
				
				</p>
			</div>
			<div class="col-sm-6">
				<h3 style="color: blue;">Contact us</h3>
				
				<p> Got a question ? Got a suggestion ? <br>
				Please submit your contact information and I will be in touch shortly.
				</p>
				
				
				 <form  action="mailto:mp.shindhu@gmail.com" method="POST" enctype="text/plain">
					<div class="form-group">
						<label for="name">Your name:</label><br /> 
						<input id="name" class="input" name="name" type="text" value="" size="30" /><br />
					</div>
					
					<div class="form-group">
						<label for="email">Your email:</label><br /> 
						<input id="email" class="input" name="email" type="text" value="" size="30" /><br />
					</div>
					
					<div class="form-group">
						<label for="message">Your message:</label><br />
						<textarea id="message" class="input" name="message" rows="4" cols="50"></textarea>
						<br />
					</div>
					<input id="submit_button" type="submit" value="send message" />
				</form> 
			</div>
		</div>			
	</div>
	
	<div>
	<%@ include file="/WEB-INF/footer.jsp" %>
	</div>
	
	
	
</body>
</html>