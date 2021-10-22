package com.divya.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.divya.dao.DB;
import com.divya.model.User;


@WebServlet({ "/LoginController", "/Login" })
public class LoginController extends HttpServlet {


	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("[LoginController] - init EXECUTED");
		
	}

	
 	public void destroy() {
		System.out.println("[LoginController] - destroy EXECUTED");
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[LoginController] - service EXECUTED");
		User user = new User();
		user.email= request.getParameter("txtEmail");
		user.password = request.getParameter("txtPassword");
		System.out.println("[LOGIN CONTROLLER] User Data:"+user);
		System.out.println(user);
		// 2. Perform some Logical Operation

				DB db = new DB();
				boolean result = db.loginUser(user);



				// 3. Send RESPOSNE to client ->  Either Text or HTML
				response.setContentType("text/html");

				PrintWriter writer = response.getWriter();

				//String message = "Thank You "+user.name;
				String html = "";

				if(result) {
					

					HttpSession session = request.getSession();
					session.setAttribute("keyUser", user);
								
					html = "<html> <body style=\"background-color:Moccasin ;\"> <center>THANK YOU "+user.name+"<br>Login Success"
							+ "<a href='home.jsp'> Enter Home </a>"
							+ "</center></body></html>";
				}else {
					html = "<html><body style=\"background-color:Moccasin ;\"><center>Invalid Credentials"+user.email+"<br>Please try Again</center></body></html>";
				}

				//writer.println(message);
				writer.println(html);



			}

		}