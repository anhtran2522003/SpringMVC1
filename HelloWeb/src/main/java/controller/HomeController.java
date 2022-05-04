package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.ListProductDAO;
import modal.Product;






@Controller
public class HomeController {
	@RequestMapping(value="/Home")
	public  String login(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");

		
//		 get data from dao
		response.setContentType("text/html;charset=UTF-8");
		//
		// get data from dao
		ListProductDAO dao = new ListProductDAO();
		List<Product> listHotDealSection = dao.getListHotDealSection();
		// set data to jsp
		request.setAttribute("listHotDealSection", listHotDealSection);
         
		//
		// get data from dao
		List<Product> listNewProduct = dao.getListNewProduct();
		// set data to jsp
		request.setAttribute("listNewProduct", listNewProduct);

		//
		// get data from dao
		List<Product> listTopSelling = dao.getListTopSelling();
		// set data to jsp
		request.setAttribute("listTopSelling", listTopSelling);

		//
		// get data from dao
		List<Product> listTop_3_Selling = dao.getListTop_3_Selling();
		// set data to jsp
		request.setAttribute("listTop_3_Selling", listTop_3_Selling);

	    Product p1 = new Product();
	    p1.setId(1);
	    p1.setName("anh");

	    Product p2 = new Product();
	    p2.setId(2);
	    p2.setName("anhs");
	    List<Product> lp = new ArrayList<Product> ();
	    lp.add(p1);
	    lp.add(p2);
		request.setAttribute("Product", p1);

		return "home";
	}


}