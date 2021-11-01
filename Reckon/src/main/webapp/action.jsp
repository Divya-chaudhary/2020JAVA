<%@page import="com.divya.dao.DB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action</title>
</head>
<body style= "background-color:Moccasin ;"> 
 
	<center>

	<%
		DB db = new DB();
	
		String action = request.getParameter("action");
		String loanId = request.getParameter("loanid");
		Double loan = Double.parseDouble(request.getParameter("loan"));
		String borrowername = request.getParameter("borrowername");
		String address = request.getParameter("address");
		Double duration = Double.parseDouble(request.getParameter("duration"));
     	Double rateofinterest = Double.parseDouble(request.getParameter("rateofinterest"));
		String ph= request.getParameter("ph");
		session.setAttribute("loanid", loanId);
	
	
		if(action.equals("delete")){
			// delete the fever record
			db.deleteDetails(loanId);
	%>
			<h3>Loan Record Deleted</h3>
	<%			
		}else{
			
	%>	
   <p>UPDATE BORROWER DETAILS </p>  
   <h3>Log New Details Here</h3>
   
 <form action='intermediateupdate.jsp'>
  <div class="form-group">
      <label for="txt">Update Borrower Name</label>
      <input type="text" class="form-control" id="email" value="<%=borrowername%>" name="borrowername">
      </div>
      	<br>
   <div class="form-group">
      <label for="txt">Update Phone no.</label>
      <input type="text" class="form-control" id="email" value="<%=ph%>" name="ph">
      </div>
      	<br>
    <div class="form-group">
      <label for="txt">Update Address</label>
      <input type="text" class="form-control" id="email" value="<%=address%>" name="address">
      </div>
      	<br>
      <div class="form-group">
      <label for="txt">Update Principal Amount</label>
      <input type="text" class="form-control" id="email" value="<%=loan%>" name="loan">
      </div>
      	<br>
      <div class="form-group">
      <label for="txt">Update Rate of interest</label>
      <input type="text" class="form-control" id="email" value="<%=rateofinterest%>" name="rateofinterest">
      </div>
      	<br>
      <div class="form-group">
      <label for="txt">Update Duration</label>
      <input type="text" class="form-control" id="email" value="<%=duration%>" name="duration">
      </div>
      	<br>
      	<input type="submit" value="UPDATE">
      
      
      </form>
  
 
	<%			// update the fever record
		}
	%>
	</center>

</body>
</html> 