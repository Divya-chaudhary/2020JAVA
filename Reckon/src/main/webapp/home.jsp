<%@ page import="com.divya.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reckon home page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<style>
</style>
</head>

<body style= "background-color:Moccasin ;"> 
    <%
		User user = (User)session.getAttribute("keyUser");
	%>
<div class="container">
 <p class="text-body">Welcome Home, Dear <%= user.name %></p>
  <p class="text-body"><%= user.email %></p>
    <p class="text-body"><%= user.phonenumber%></p>
</div>

<div class="container">
 <center>        
        
<div class="container">
   <div class="jumbotron">
   <p>Enter the details to be remembered </p>  
   <h3>Log Your Borrower Details Here</h3>
   
  <form action="addloan.jsp">
  
  
   <div class="form-group">
      <label for="txt">Borrower Name</label>
      <input type="text" class="form-control" id="email" placeholder="Enter Borrower name" name="borrowername">
      </div>
      
      
      
   <div class="form-group">
      <label for="txt">phone Number</label>
      <input type="text" class="form-control" id="email" placeholder="Enter Phone no." name="ph">
      </div>
      
      
      
   <div class="form-group">
      <label for="txt">Address</label>
      <input type="text" class="form-control" id="email" placeholder="Enter Address " name="address">
      </div>
      
    <div class="form-group">
      <label for="txt">Principal Amount</label>
      <input type="text" class="form-control" id="email" placeholder="Enter Principal Amount" name="txtLoanamount">
      </div>
      
         
   <div class="form-group">
      <label for="txt">Rate of Interest</label>
      <input type="text" class="form-control" id="email" placeholder="IN PERCENTAGE WITHOUT PERCENTAGE SYMBOL" name="interest">
      </div>
      
      
    <div class="form-group">
    <div class="form-check-inline">
      <label class="form-check-label" for="radio1">
        <input type="radio" class="form-check-input" id="radio1" name="type" value="months" checked>MONTHS
      </label>
    </div>
    <div class="form-check-inline">
      <label class="form-check-label" for="radio2">
        <input type="radio" class="form-check-input" id="radio2" name="type" value="years">YEARS
      </label>
    </div>

    <label for="txt">Enter Duration</label>
      <input type="text" class="form-control" id="pwd" placeholder="How many months or years ?" name="duration">
    </div>
    
    <button type="submit" class="btn btn-primary">submit</button>
  </form>
</div>
	 <p class="bg-light text-dark"><a href="viewloan.jsp">VIEW ALL LOAN RECORDS</a></p>
		<br><br>
	</center>
</body>
</html>