<%@page import="com.HelthCare.Model.Item"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Items Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/items.js"></script>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-6">
<h1>User Management - User Details</h1>
<form id="formItem" name="formItem">
 User ID:
 <input id="u_id" name="u_id" type="text"
 class="form-control form-control-sm">
 <br> User first name:
 <input id="u_fname" name="u_fname" type="text"
 class="form-control form-control-sm">
 <br> User last name:
 <input id="u_lname" name="u_lname" type="text"
 class="form-control form-control-sm">
 <br> Age:
 <input id="u_age" name="u_age" type="text"
 class="form-control form-control-sm">
 <br>
  Address:
 <input id="u_address" name="u_address" type="text"
 class="form-control form-control-sm">
 <br> Sex:
 <input id="u_sex" name="u_sex" type="text"
 class="form-control form-control-sm">
 <br> Email:
 <input id="u_email" name="u_email" type="text"
 class="form-control form-control-sm">
 <br> Username:
 <input id="u_username" name="u_username" type="text"
 class="form-control form-control-sm">
 <br>
  <br> Password:
 <input id="u_password" name="u_password" type="text"
 class="form-control form-control-sm">
 <br> Type:
 <input id="u_type" name="u_type" type="text"
 class="form-control form-control-sm">
 <br> Contact:
 <input id="u_contact" name="u_contact" type="text"
 class="form-control form-control-sm">
 <br>
 <input id="btnSave" name="btnSave" type="button" value="Save"
 class="btn btn-primary">
 <input type="hidden" id="hidItemIDSave"
 name="hidItemIDSave" value="">
</form>
<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br>
<div id="divItemsGrid">
 <%
 Item itemObj = new Item();
 out.print(itemObj.readItems());
 %>
</div>
</div>
 </div>
</div>

</body>
</html>
