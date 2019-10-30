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
 * Servlet implementation class bookDetailsNavigationServlet
 */
@WebServlet("/bookDetailsNavigationServlet")
public class bookDetailsNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public bookDetailsNavigationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookDetailsHelper bdh = new BookDetailsHelper();
		String act = request.getParameter("doThisToItem");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/ViewAllBookDetailsServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("detailId"));
				BookDetails detailToDelete = bdh.searchForBookDetailsByDetailId(tempId);
				bdh.deleteBookDetails(detailToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/ViewAllBookDetailsServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				BookDetails detailToEdit = bdh.searchForBookDetailsByDetailId(tempId);
				ListBookHelper lbh = new ListBookHelper();
				List<ListBook> allBooks = lbh.showAllBooks();
				List<ListBook> currentListBook = detailToEdit.getDetailsOfBooks();

				System.out.println("----After removing items-------");
				for (int i = 0; i < allBooks.size(); i++) {
					for (int j = 0; j < currentListBook.size(); j++) {
						if (allBooks.get(i).getId() == currentListBook.get(j).getId()) {
							allBooks.remove(i);
						}
					}
				}

				request.setAttribute("detailToEdit", detailToEdit);
				request.setAttribute("allItemsToAdd", allBooks);
				getServletContext().getRequestDispatcher("/edit-item.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/ViewAllBookDetailsServlet").forward(request, response);
			}

		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/addReaderServlet").forward(request, response);
		}

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