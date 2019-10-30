package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBook;

/**
 * Servlet implementation class editBookServlet
 */
@WebServlet("/EditBookServlet")
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ListBookHelper dao = new ListBookHelper();
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		ListBook itemToUpdate = dao.searchForBookById(tempId);
		itemToUpdate.setTitle(title);
		itemToUpdate.setAuthor(author);
		dao.updateBook(itemToUpdate);
		getServletContext().getRequestDispatcher("/ViewAllItemsServlet").forward(request, response);
	}

}
