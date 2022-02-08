package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entity.EProduct;
import com.util.HibernateUtil;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/add-product")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("add-product.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String productName = request.getParameter("name");
		String productPrice = request.getParameter("price");
		
	//1: Get session Factory
	SessionFactory sf = HibernateUtil.buildSessionFactory();
		
	//2: Get Session object
	Session session = sf.openSession();
		
	//3: Get object and begins transaction
	Transaction tx =  session.beginTransaction();
		
	//4: Create and populate entity object
	EProduct product = new EProduct();
	product.setName(productName);
	product.setPrice(Double.parseDouble(productPrice));
		
	session.save(product);
	tx.commit();
		
		out.print("<h3> Product is created successfully ! </h3>");
		out.print("<html><body>");
		out.print("<a href=index.jsp>home</a>" );
		out.print("</body></html>");
		
		session.close();
	}
}
