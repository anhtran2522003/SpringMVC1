package controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;






@Controller
public class LogoutController {
	@RequestMapping(value="/Logout")
	public  String doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		System.out.print("Logout Controller");
		response.setContentType("text/html;charser=UTF-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession(true);
		session.removeAttribute("acc");
		// delete cookie

		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();

		if (cookies == null) {
			return ("login");
		}

		for (int i = 0; i < cookies.length; i++) {
			cookie = cookies[i];

			if ((cookie.getName()).equals("user")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}

			if ((cookie.getName()).equals("password")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}

		}

		return ("login");
//		return null;
		

	}
}