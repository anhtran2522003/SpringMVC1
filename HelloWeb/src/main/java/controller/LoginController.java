package controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import dao.AccountDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import modal.Account;






@Controller
public class LoginController {
	@RequestMapping(value="/Login", method = RequestMethod.GET)
	public  String doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();

		if (cookies != null) {
			System.out.print("cookie khac null");
			String user = "";
			String password = "";
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if ((cookie.getName()).equals("user")) {
					user = cookie.getValue();
				}
				if ((cookie.getName()).equals("password")) {
					password = cookie.getValue();
				}
				System.out.print("dang doc cookie");
			}
			if (user == "" || password == "") {
				System.out.print("khong  luu cookie");
				return "login";
			} else {
				System.out.print("co  luu cookie");
				System.out.print(user + " " + password);
				AccountDAO a = new AccountDAO();
				Account acc = a.search(user);
				if (acc == null) {
					System.out.println("acc = null");
					return "login";
				} else if (password.equals(acc.getPwd())) {
					System.out.println("acc != null");
					System.out.println(acc.getUsr() + " " + acc.getAddress() + " " + acc.getAddress());
					if (acc.getRole() == 1) {
						response.sendRedirect("index.jsp");
					} else {
						return "login";					}

				} else {
					return "login";				}
			}
		} else {
			System.out.print("cookie = null");
			return "login";
		}
		return "login";
	}
	@RequestMapping( value="/Login", method = RequestMethod.POST) 
	public  String doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		response.setContentType("text/html;charset=UTF-8");
		try {

			request.getSession(true).invalidate();
			// make sure that email is valid
			String regexMail = "^[A-Z0-9_a-z]+@[A-Z0-9\\.a-z]+\\.[A-Za-z]{2,6}$";
			String regex = "[a-zA-Z0-9_!@#$%^&*]+";
			// collect data from a login form
			String user = request.getParameter("username");
			String password = request.getParameter("password");

			HttpSession session = request.getSession(true);
			if (!password.matches(regex) || !user.matches(regexMail)) {
				session.setAttribute("error", "Invalid syntax");
				return "login";
			} else {
				// read information of account gmail from db
				AccountDAO a = new AccountDAO();
				Account acc = a.search(user);

				// check account - use validate code in assignment 1 to valid user
				if (acc != null && acc.getPwd().equals(password) && acc.getUsr().equalsIgnoreCase(user)) {
					// set session

					session.setAttribute("acc", acc);

					String rememberMe = (String) request.getParameter("rememberMe");
					if (rememberMe != null) {
						Cookie cookieUser = new Cookie("user", acc.getUsr());
						Cookie cookiePass = new Cookie("password", acc.getPwd());
						cookieUser.setMaxAge(5000);
						cookiePass.setMaxAge(5000);
						response.addCookie(cookieUser);
						response.addCookie(cookiePass);

					}
					if (acc.getRole() == 1) {
						return "index";
					} else if (acc.getRole() == 0) {
						response.sendRedirect("Home");}
	

				} else {
					session.setAttribute("user", user);
					session.setAttribute("password", password);
					session.setAttribute("error", "Wrong username or password!");
					return "login";
				}
			}
		} catch (NullPointerException e) {
			response.getWriter().println(e);

			return "login";

		} catch (Exception ex) {
			response.getWriter().println(ex);
			return "login";
		}

		return null;

	}
}