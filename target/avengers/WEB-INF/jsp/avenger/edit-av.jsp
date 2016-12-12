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
<title>Recrutement</title>
</head>
<body>
<div class="container">

		<div class="row">
			<div class="col-lg-offset-3 col-lg-6">
				<h2>Upload Photo :</h2>
				<form method="get" action="/avengers/app/avenger/">
						<td><button type="submit" class="btn btn-success test">List</button></td>
					</form><br>
				<div class="row">
					<form method="post" action="/a	vengers/app/avenger/${id}/add-pix" enctype="multipart/form-data">
						<input type="file" class="form-control" id="photo" name="file" placeholder="Choisir une photo">
						<input type="submit" value="Add Pix" class="btn btn-md btn-primary">
					</form>
				</div>
			</div>
		</div>
</div>

</body>
</html>