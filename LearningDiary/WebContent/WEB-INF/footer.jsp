<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<%-- <%@ include file="/WEB-INF/common-css-javascript.html"%> --%>

<style>

#footer {
	text-align:center;
	padding-bottom: 10px;
}

</style>
</head>
<body >
	<div id="footer">
		<br><br><br>
		<p>
		<i>LearningDiary designed by shindhu</i></p>
		
		<h6 id="demo" style="font-size: small;"></h6>
	
	</div>
	<script >
		document.getElementById("demo").innerHTML = Date();
	</script>
			 
</body>
</html>

