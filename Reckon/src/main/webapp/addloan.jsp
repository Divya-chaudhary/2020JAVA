<%@page import="com.divya.dao.DB"%>
<%@page import="com.divya.model.User"%>
<%@page import="com.divya.model.Loan"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adding details</title>
</head>
<body>

	<%
		User user = (User)session.getAttribute("keyUser");
	
				
	%>

	<center>
		<h4>Welcome to RECKON</h4> 
		<b><%= user.name %></b>
	

	<%
		
		Loan loan = new Loan();

	
	//DOUBT THIS ID IS AUTOMATICALLY CREATED ONE AND IS ASSIGNED TO uerId?
		
			
			loan.userId = user._id;  
		loan.loan = Double.parseDouble(request.getParameter("txtLoanamount"));
		//loan.type = request.getParameter("type");
		
		loan.duration = Double.parseDouble(request.getParameter("duration"));
		loan.borrowername =request.getParameter("borrowername");
		loan.address =request.getParameter("address");
		loan.ph =request.getParameter("ph");
		loan.rateofinterest =Double.parseDouble(request.getParameter("interest"));
		loan.interestearned =(loan.loan*loan.rateofinterest*loan.duration)/100;
		loan.totalvalue =loan.interestearned +loan.loan;
		
		/*
		
		if(loan.type.equals(months))
		{
		loan.interestearned =(loan.loan*loan.rateofinterest*loan.duration)/100;
		loan.totalvalue =loan.interestearned +loan.loan;
		}
		else{
			loan.duration = loan.duration*12;
			loan.interestearned =(loan.loan*loan.rateofinterest*loan.duration)/100;
			loan.totalvalue =loan.interestearned +loan.loan;
		}
		
		*/
		
		DB db = new DB();
		db.logLoanDetails(loan);
		
		    
		
	%>
	
	<p>Amount of <%= loan.loan %></p>
	<p>Given to <%= loan.borrowername %></p>
	<p>At interest of <%= loan.rateofinterest %>%</p>
    <p>For Duration of <%= loan.duration %></p>
		<a href="viewloan.jsp">VIEW NET LOAN DETAILS OF BORROWERS  </a>
	
	
	</center>
	