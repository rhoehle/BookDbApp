package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BookDetails;
import model.ListBook;

/**
 * Servlet implementation class ViewBookDetails
 */
@WebServlet("/ViewBookDetailsServlet")
public class ViewBookDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBookDetailsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookDetailsHelper bdh = new BookDetailsHelper();		
		List<BookDetails> z = bdh.getBookDetails();
		request.setAttribute("allBookDetails", z);
		
		if(z.isEmpty()) {
			request.setAttribute("allBookDetails", " ");
		}
		
		getServletContext().getRequestDispatcher("/book-details-by-reader.jsp").forward(request, response);
		
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
