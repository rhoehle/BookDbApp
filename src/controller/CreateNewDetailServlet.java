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

import model.BookDetails;
import model.ListBook;
import model.Reader;

/**
 * Servlet implementation class CreateNewDetailServlet
 */
@WebServlet("/CreateNewDetailServlet")
public class CreateNewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateNewDetailServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ListBookHelper lbh = new ListBookHelper();
		String rating = request.getParameter("rating");
		System.out.println("List Name: " + rating);

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
		
		String[] selectedBooks = request.getParameterValues("allDetailsToAdd");
		List<ListBook> selectedBooksInList = new ArrayList<ListBook>();
		if (selectedBooks != null && selectedBooks.length > 0) {
			for (int i = 0; i < selectedBooks.length; i++) {
				System.out.println(selectedBooks[i]);

				ListBook c = lbh.searchForBookById(Integer.parseInt(selectedBooks[i]));
				selectedBooksInList.add(c);
			}

		}

		Reader reader = new Reader(readerName);
		BookDetails bd = new BookDetails(reader, ld, rating);
		bd.setDetailsOfBooks(selectedBooksInList);
		BookDetailsHelper bdh2 = new BookDetailsHelper();
		bdh2.insertNewBookDetails(bd);
		
		System.out.println("Success!");
		System.out.println(bd.toString());
		
		getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
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
