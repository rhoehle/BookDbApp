package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListBook;
import model.Reader;
import model.BookDetails;

/**
 * Servlet implementation class CreateNewBookDetail
 */
@WebServlet("/CreateNewBookDetail")
public class CreateNewBookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewBookDetailServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ListBookHelper lbh = new ListBookHelper();
		String rating = request.getParameter("rating");
		System.out.println("Rating = " + rating);
		
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String readerName = request.getParameter("readerName");
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
			
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
 		}
		
		String[] selectedDetails = request.getParameterValues("allDetailsToAdd");
		List<ListBook> selectedDetailsInBook = new ArrayList<ListBook>();	
		if (selectedDetails != null && selectedDetails.length > 0) {
			for(int i = 0; i < selectedDetails.length; i++) {
				System.out.println(selectedDetails[i]);
				ListBook c = lbh.searchForBookById(Integer.parseInt(selectedDetails[i]));
				selectedDetailsInBook.add(c);
			}		
		}
		
				Reader reader = new Reader(readerName);
				BookDetails bd = new BookDetails(reader, ld, rating);
				bd.setDetailsOfBooks(selectedDetailsInBook);
				BookDetailsHelper bdh = new BookDetailsHelper();
				bdh.insertNewBookDetails(bd);
				
				System.out.println("Success!");
				System.out.println(bd.toString());
				
				getServletContext().getRequestDispatcher("/ViewBookDetailsServlet").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
