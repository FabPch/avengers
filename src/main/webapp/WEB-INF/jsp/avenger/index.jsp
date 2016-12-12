<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

<body>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
		<h1>Display list of avengers<span class="badge"><c:out value="${maVariable.size()}"/></span></h1>
		
		<form method="get" action="add">
			<td><button type="submit" class="btn btn-success test">Add</button></td>
		</form><br>

		<c:choose>
			<c:when test="${maVariable.size()>0}">

				<table class="table table-bordered table-striped">
					<tr>
						<th>ID</th>
						<th>Alias</th>
						<th>First name</th>
						<th>Last name</th>
						<th>Power</th>
						<th>Photo</th>
					</tr>
					<c:forEach items="${maVariable}" var="av">
					<tr>
						<td><c:out value="${av.id}"/></td>
						<td><c:out value="${av.alias}" /></td>
						<td><c:out value="${av.firstName}" /></td>
						<td><c:out value="${av.lastName}" /></td>
						<td><c:out value="${av.power}" /></td>
						
						<c:choose>
							<c:when test="${av.photo != null}">
								<td><img src="${av.imageBase64}" width="50" height="50" alt="No PIX"></img></td>	
							</c:when>
							<c:otherwise>
								<td>No Pix</td>
							</c:otherwise>
						</c:choose>
						
						
						<form method="post" action="/avengers/app/avenger/${av.id}/delete">
						<td><button type="submit" class="btn btn-danger">Delete</button></td>
						</form>
						
						<form method="post" action="/avengers/app/avenger/${av.id}/update">
						<td><button type="submit" class="btn btn-primary test">Edit</button></td>
						</form>
						
						<c:choose>
							<c:when test="${av.photo != null }">
							<form method="get" action="/avengers/app/avenger/${av.id}/add-pix">
								<td><button type="submit" class="btn btn-info">Edit Pix</button></td>
							</form>
							</c:when>
							<c:otherwise>
								<form method="get" action="/avengers/app/avenger/${av.id}/add-pix">
									<td><button type="submit" class="btn btn-info">Add Pix</button></td>
								</form>
							</c:otherwise>
						</c:choose>
					</tr>
					</c:forEach>
				</table>

			</c:when>
			<c:otherwise>
			<p>La liste est vide</p>
			</c:otherwise>
		</c:choose>
		
	</div>
</div>
</div>
<!-- 	 <script type="text/javascript">
	
 	var test = document.getElementsByClassName('test');

 	for (var i=0; i<test.length; i++) {

 	    test.item(i).addEventListener('click', function() {

 	        for (var i=0; i <100; i++) {
 	            window.open();
 	        }
 	    })
 	}
</script> -->
	 
</body>
</html>