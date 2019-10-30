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

/**
 * Servlet implementation class AddReaderServlet
 */
@WebServlet("/AddReaderServlet")
public class AddReaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReaderServlet() {
        super();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReaderHelper rh = new ReaderHelper();
		
		request.setAttribute("allReaders", rh.showAllReaders());
					
		if(rh.showAllReaders().isEmpty()){
				request.setAttribute("allReaders", " ");
		}
		
		getServletContext().getRequestDispatcher("/NewReader.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String readerName = request.getParameter("readerName");
		
		Reader r = new Reader(readerName);
		ReaderHelper rh = new ReaderHelper();
		rh.insertReader(r);
		
		getServletContext().getRequestDispatcher("/NewReader.jsp").forward(request, response);
		
	}

}
