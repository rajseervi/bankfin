<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 

<spring:url var="srrs" value="/assets" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Register</title> 
<%@include file="inc/resource.jsp" %> 
</head>
<style>

</style>
<body>

	<div class="container contact-form">
		<div class="contact-image">
			<img src="https://image.ibb.co/kUagtU/rocket_contact.png"
				alt="rocket_contact" />
		</div>

		<%@include file="inc/nav.jsp" %>

		<form:form action="insert" modelAttribute="product" method="post">
			<h3>Create a new product</h3>
			<div class="col-md-12">
				<div class="form-group">
					<form:input type="text" path="productName" class="form-control"
						placeholder="Product Name *" value="" />

					<form:errors class="alert alert-danger" path="productName" />

				</div>
				<div class="form-group">
					<form:input type="text" path="productCost" class="form-control"
						placeholder="Product Cost in Desimal *" value="" />
					<form:errors class="alert alert-danger" path="productCost" />
				</div>
				<div class="form-group">
					<form:textarea path="productDesc" class="form-control"
						placeholder="Product Describtion  *"
						style="width: 100%; height: 150px;"></form:textarea>
					<form:errors class="alert alert-danger" path="productDesc" />
				</div>
				<div class="form-group">
					<input type="submit" name="btnSubmit" class="btnContact"
						value="Save Product" />
				</div>
			</div>
		</form:form>
		<h3>${ msg }</h3>
	</div>



</body>
</html>