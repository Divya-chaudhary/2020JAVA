<%@page import="com.divya.dao.DB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	DB db = new DB();
	
	String action = request.getParameter("action");
	String loanId = (String)session.getAttribute("loanid");
	Double loan = Double.parseDouble(request.getParameter("loan"));
	String borrowername = request.getParameter("borrowername");
	String address = request.getParameter("address");
	Double duration = Double.parseDouble(request.getParameter("duration"));
 	Double rateofinterest = Double.parseDouble(request.getParameter("rateofinterest"));
	String ph= request.getParameter("ph");
	System.out.println("#####3#loanId"+loanId);
    db.updateDetails(loanId,borrowername,ph,address,loan,rateofinterest,duration);
	%>
   <h3>UPDATE SUCCESSFUL</h3>
   
</body>
</html>