package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookSearchDAO;
import model.Books;

/**
 * Servlet implementation class SearchBook
 */
@WebServlet("/SearchBook")
public class SearchBook extends HttpServlet {
	Connection connect;
	Books book;
	HttpSession session;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		connect = (Connection) request.getServletContext().getAttribute("Connection");
		
		try {
			book = new BookSearchDAO(connect, request.getParameter("searchBar")).searchName();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		if(book!=null){
		request.setAttribute("book", book);	
		request.getRequestDispatcher("./userHomePage.jsp").forward(request, response);
		}else{
			response.sendRedirect("./userHomePage.jsp");
		}
	}

}
