package com.divya.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.divya.dao.DB;
import com.divya.model.User;

@WebServlet({ "/RegisterController", "/Register" })
public class RegisterController extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. Fetch data from Request
				User user = new User();
				//user.name = request.getParameter("txtName");
				user.name= request.getParameter("txtName");
				user.email = request.getParameter("txtEmail");
				user.password = request.getParameter("txtPassword");
				
				user.phonenumber = request.getParameter("Ph");
			
				//user.makePasswordSecure();

				System.out.println(user);

				// 2. Logical Processing
				//    Dump the data in Mongo DB/ MySQL / FirebaseFirestore
				DB db = new DB();

				// 3. Send Back some Response
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				boolean result = db.registerUser(user);


				String html = "";

				HttpSession session = request.getSession();
				session.setAttribute("keyUser", user);
				
				if(result) {
			        
					html = "<html> <body style=\"background-color:Moccasin ;\"> <center>THANK YOU "+user.name+"<br>Login Success"
							+ "<a href='home.jsp'> Enter Home</a>"
							+ "</center></body></html>";
				}else {
					out.println("OOPS. Something Went Wrong");
					html = "<html><body><center>Somthing Went Wrong"+user.email+"<br>Please try Again</center></body></html>";

				}


				out.println(html);


			}
		}