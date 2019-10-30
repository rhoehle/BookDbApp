package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBook;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/NavigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
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
		
		ListBookHelper bh = new ListBookHelper();
		String act = request.getParameter("doThisToBook");
		
		if (act == null) {
		getServletContext().getRequestDispatcher("/ViewAllBooksServlet").forward(request, response);
		
		} else if (act.equals("delete")) 
			try {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListBook bookToDelete = bh.searchForBookById(tempId);
			bh.deleteBook(bookToDelete);
			
			} catch (NumberFormatException e) {
			System.out.println("Forgot to select an entry.");
			
			} finally {
				getServletContext().getRequestDispatcher("/ViewAllBooksServlet").forward(request, response);
				
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListBook bookToEdit = bh.searchForBookById(tempId);
			request.setAttribute("bookToEdit", bookToEdit);
			getServletContext().getRequestDispatcher("/edit-item.jsp").forward(request, response);
				
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/ViewAllBooksServlet").
				forward(request, response);
			}	
			
		} else if (act.equals("add")) {
			
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);		
	}

}
}