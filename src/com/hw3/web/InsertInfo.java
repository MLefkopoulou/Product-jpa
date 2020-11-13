/* Programmer : Lefkopoulou Eleni Maria 
 * AEM : 2557 
 * class : InsertInfo
 * role : server class for product insertion to the database ....if a product with the same barcode already exists send the user to an error page else send him to the product's page
 */
package com.hw3.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hw3.dao.ProductDao;
import com.hw3.model.ProductInfo;

@WebServlet("/InsertInfo")
public class InsertInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;

    public InsertInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void init() {
		productDao = new ProductDao();
	}

 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		String Name = request.getParameter("name");
		String Color = request.getParameter("color");
		String Description = request.getParameter("description");
		String Barcode = request.getParameter("barcode");
		ProductInfo newProduct = new ProductInfo(Name, Color,Description,Barcode);
		int check  =0;
		check = productDao.saveUser(newProduct);
		if(check == 1) {
			String url = "/error.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else {
			String url = "/DisplayInfo.jsp";
			ProductInfo prod = new ProductInfo(Name,Color,Description,Barcode);
			request.setAttribute("prod", prod);
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
	}
	
}