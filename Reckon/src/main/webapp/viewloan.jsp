<%@page import="com.divya.model.Loan"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.divya.dao.DB"%>
<%@page import="com.divya.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>LOAN</title>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   
 

<meta charset="utf-8">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</head>
<body>

	<%
		User user = (User)session.getAttribute("keyUser");
		DB db = new DB();
	%>

	<%-- 	<center>
		<h3>All Fevers </h3>
		
		<%
			ArrayList<Fever> fevers = db.fetchFevers(user._id);
		
			for(Fever fever : fevers){
				
		%>
			
			Fever: <%= fever.fever %>
			<br/>
			
		<%			
				
			}
		%>
		
	</center> --%>
	
	
<div class="container">
  <h2>LOAN RECORD</h2>
        <p>
			Dear
			<%= user.name%>, your Borrowers records till date:
		</p>          
  <table class="table table-warning table-hover">
   	<thead>
	<tr>
					<th>BORROWER NAME</th>
					<th>PHONE NO.</th>
					<th>ADDRESS</th>
					<th>LOAN DATE</th>
					<th>DURATION</th>
					 <th>RATE OFINTEREST</th>
			        <th>PRINCIPAL AMOUNT</th>
			        <th>INTEREST EARNED</th>
					<th>TOTAL VALUE</th>
					<th>ACTION</th>
					
				</tr>
			</thead>
    <tbody>
       <%
			ArrayList<Loan> loans = db.fetchLoans(user._id);
		
			for(Loan loan : loans){
				
		%>
    
    
      <tr>
                    <td><%= loan.borrowername %></td>
					<td><%= loan.ph%></td>
					<td><%= loan.address %></td>
					<td><%= loan.dateTimeStamp %></td>
					<td><%= loan.duration%></td>
					<td><%= loan.rateofinterest%></td>
					<td><%= loan.loan %></td>
					<td><strong><p style="color:orange;"><%= loan.interestearned %> </p></strong></td>
					<td><strong><p style="color:orange;"><%= loan.totalvalue %></p></strong></td>
					<td><a href=''>UPDATE</a> <a href=''> <a href="#" class="btn btn-warning btn-lg"><span class="glyphicon glyphicon-trash"></span> 
           </a></a> </td>
				    	  
	      </tr>
      	
		<%			
				}
		%>
		
    </tbody>
  </table>
</div>
</body>
</html>