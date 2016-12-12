<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
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
<title>Recrutement</title>
</head>
<body>
<div class="container">

		<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<c:choose>
				<c:when test="${av != null}">
					<h2>Editer un avenger :</h2>
					<form method="get" action="/avengers/app/avenger/">
						<td><button type="submit" class="btn btn-success test">List</button></td>
					</form><br>
					<div class="row">
					<form method="post" action="/avengers/app/avenger/${av.id}/updateAv">
				</c:when>
				<c:otherwise>
					<h2>Recruter un avenger :</h2>
					<form method="get" action="/avengers/app/avenger/">
						<td><button type="submit" class="btn btn-success test">List</button></td>
					</form><br>
					<div class="row">
					<form method="post" action="add">
				</c:otherwise>
				</c:choose>
				
<!-- 				<div class="row"> -->
<%-- 					<form method="post" action="add"> --%>
						<label for="firstName" class="sr-only"> First Name </label> 
						<input type="text" id="firstName" class="form-control"
							placeholder="First Name" name="firstName" value="${av.firstName}"
							required> 
						<label for="lastName" class="sr-only"> Last Name </label> 
						<input type="text" id="lastName" class="form-control"
							placeholder="Last Name" name="lastName" value="${av.lastName}"
							required> 
						<label for="alias" class="sr-only"> Alias </label> 
						<input type="text" id="alias" class="form-control"
							placeholder="Alias" name="alias" value="${av.alias}"> 
						<label for="power" class="sr-only" required> Power </label> 
						<input type="number" id="power" class="form-control" placeholder="Power"
							name="power" value="${av.power}" required><br>
						<input type="file" id ="photoInput"/>
						<input type="hidden" id="imgValue" name="photo">
						<img id="img" src="${av.imageBase64}"></img>


						<c:choose>
							<c:when test="${av != null}">
								<input type="submit" value="Editer"
							class="btn btn-lg btn-primary">
							</c:when>
							<c:otherwise>
								<input type="submit" value="Recruter"
							class="btn btn-lg btn-primary">
							</c:otherwise>
						</c:choose>
					</form>
				</div>
			</div>
		</div>
</div>


<script>

$(document).ready(function() {
$('#photoInput').change(function() {
var formData = new FormData();
formData.append('file', $('#photoInput')[0].files[0]);
console.log("data : "+formData);
 
$.ajax({
    url: 'http://localhost:8080/avengers/app/avenger/uploadPhoto',
    data: formData,
    cache: false,
    contentType: false,
    processData: false,
    type: 'POST',
    success: function(data){
    console.log(data);
    $("#img").attr("src", "data:image/png;base64,"+data);
    $("#imgValue").val(data);
    }
});
 
});
});
</script>


</body>
</html>