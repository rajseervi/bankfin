<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User Register</title>
<%@include file="inc/resource.jsp" %> 
<body>


	<div class="container contact-form">
		<div class="contact-image">
			<span class="glyphicon glyphicon-user"></span>
		</div>
		
		<%@include file="inc/nav.jsp" %>
		
		<form:form action="insert" modelAttribute="user" method="post">
			<h3>Add User</h3>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<form:input type="text" path="userFullName" class="form-control"
							placeholder="Product Name *" value="" />
					</div>
					<div class="form-group">
						<form:input type="text" path="userEmail" class="form-control"
							placeholder="Email *" value="" />
					</div>

					<div class="form-group">
						<form:input type="text" path="userPwd" class="form-control"
							placeholder="Password *" value="" />
					</div>
					<div class="form-group">
						<fieldset>
							<label>Select Gender</label>
							<form:radiobutton style="padding:10px" path="userGen"
								value="Male" id="1" />
							<label for="1">Male</label>
							<form:radiobutton style="padding:10px" path="userGen"
								value="Female" id="2" />
							<label for="2">Female</label>
						</fieldset>
					</div>

					<div class="form-group">
						<label>Provide role of user</label>
						<form:checkbox style="padding:10px" path="userRole" value="ADMIN"
							id="3" />
						<label for="3">ADMIN</label>
						<form:checkbox style="padding:10px" path="userRole" value="USER"
							id="4" />
						<label for="4">USER</label>
					</div>
					<div class="form-group">
						<input type="submit" name="btnSubmit" class="btnContact"
							value="Save Product" />
					</div>

				</div>

			</div>
		</form:form>
		<h3>${msg}</h3>
	</div>



</body>
</html>