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
				style="font-size: large;font-stretch:extra-expanded; color: blue; font-weight: bolder;">
				Learning Diary</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-9">
			<font style="color: grey">

				<ul class="nav navbar-nav navbar-left" style="font-size: small;">
					<li><a href="/LearningDiary/index" style="color: black;"><span
							class="glyphicon glyphicon-home"></span></a></li>
					<li><a href="/LearningDiary/about" style="color: black;">About</a></li>
					<li><a href="/LearningDiary/contact" style="color: black;" >Contact
							Us</a></li>

				</ul> 
				<c:if test="${(isLoggedIn == false) or (empty isLoggedIn) }">
					<ul class="nav navbar-nav navbar-right" style="font-size: small;">
						<li><a href="/LearningDiary/signup" style="color: black;"><span
								class="glyphicon glyphicon-user"></span> Sign Up </a></li>
						<li><a href="/LearningDiary/login" style="color: black;"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>

					</ul>
				</c:if> 
				<c:if test="${isLoggedIn == true }">
					<ul class="nav navbar-nav navbar-left" style="font-size: small;">
						
						<li><a href="/LearningDiary/category" style="color: black;">Category</a></li>
						<li><a href="/LearningDiary/books" style="color: black;">Books</a></li>
						<li><a href="/LearningDiary/users" style="color: black;">Users</a></li>
						<li><a href="/LearningDiary/userBooks" style="color: black">UserBooks</a></li>

					</ul>
					<form action = "/LearningDiary/booksByKeyword" class="navbar-form navbar-left" name="search" action="get">
						<div class="form-group">
							<input type="text" style="width: 500px"class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default">search</button>
					</form>
					
					<ul class="nav navbar-nav navbar-right" style="font-size: small;">
						<li> <a>Logged in as ${capName }, id: ${user_id }</a></li>
						<li><a href="/LearningDiary/logout" style="color: red;">
						<span class="glyphicon glyphicon-log-out"></span> Log Out </a></li>
					</ul>
				</c:if>
			</font>
		</div>

	</div>
</nav>

<!-- <div class="form-horizontal">
		<br><br>
		<form action="" method="get">
			<input type="text" name="search"  placeholder="book u are looking for ?" style="width:500px">
			<input type="submit" name="submit" value="Search">
		</form>
	</div> -->

