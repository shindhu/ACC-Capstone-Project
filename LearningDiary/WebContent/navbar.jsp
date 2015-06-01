<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar  navbar-default navbar-fixed-top">
	<div class="container-fluid">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-9">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="images/book-tree.jpg"
				style="font-size: large; font-style: italic; color: green;">
				Learning Diary</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-9">
			<font style="color: green">

				<ul class="nav navbar-nav navbar-left" style="font-size: small;">
					<li ><a href="home.jsp" style="color: green;"><span class="glyphicon glyphicon-home"></span></a></li>
				</ul>	
					
					<c:if test="${(isLoggedIn == false) or (empty isLoggedIn) }">
						<ul class="nav navbar-nav navbar-right" style="font-size: small;">
							<li><a href="/LearningDiary/signup" style="color: green;"><span class="glyphicon glyphicon-user"></span>
							Sign Up </a></li>
							<li><a href="/LearningDiary/login" style="color: green;"><span class="glyphicon glyphicon-log-in"></span>
							Login</a></li>
							
						</ul>
					</c:if>
					
					<c:if test="${isLoggedIn == true }">
					<ul class="nav navbar-nav navbar-left" style="font-size: small;">
						<li><a href="/LearningDiary/category" style="color: green;">Category</a></li>
						<li><a href="/LearningDiary/books" style="color: green;">Books</a></li>
						<li><a href="/LearningDiary/users" style="color:green; ">Users</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right" style="font-size: small;">
						<li class="nav navbar-nav navbar-right"><a href="/LearningDiary/logout" style="color: green;"><span class="glyphicon glyphicon-log-out"></span>
						Log Out  </a></li>
					</ul>
					</c:if>	
			</font>
		</div>

	</div>
</nav>

	<div class="form-horizontal">
		<br><br>
		<form action="" method="get">
			<input type="text" name="search"  placeholder="book u are looking for ?" style="width:500px">
			<input type="submit" name="submit" value="Search">
		</form>
	</div>

