<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New User Register</title>
<%@include file="inc/resource.jsp"%>
<body>


	<div class="container contact-form">
		<div class="contact-image">
			<img src="https://image.ibb.co/kUagtU/rocket_contact.png"
				alt="rocket_contact" />
		</div>

		<%@include file="inc/nav.jsp"%>
		<div class="first">
			<h3>All Product</h3>
			
			<h5>${msg}</h5>

			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">SR No</th>
						<th scope="col">Name</th>
						<th scope="col">Cost</th>
						<th scope="col">Desc</th>
						<th scope="col" colspan="2">Action</th>
					</tr>
				</thead>
				<tbody>
					<% int sr = 1; %>
				
					 <c:forEach items="${prod}" var="i">
						<tr>
							<th scope="row"><%= sr %></th>
							<th><c:out value="${i.productName}" /></th>
							<th><c:out value="${i.productCost}" /></th>
							<th><c:out value="${i.productDesc}" /></th>
							<th> <a href="" class="btn btn-info">Edit</a> </th>
							<th> <a href="/product/deleteProduct/${i.prodID}/" class="btn btn-danger">Delete</a> </th>
						</tr>
						<%= sr++ %> 
					</c:forEach> 

				</tbody> 
			</table>
		</div>

	</div>

</body>
</html>