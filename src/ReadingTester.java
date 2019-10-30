import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import controller.BookDetailsHelper;
import controller.ReaderHelper;
import model.BookDetails;
import model.Reader;

public class ReadingTester {

	public static void main(String[] args) {

		Reader billy = new Reader("BillyBob Thornton");

		ReaderHelper rh = new ReaderHelper();

		rh.insertReader(billy);

		List<Reader> allReaders = rh.showAllReaders();
		for (Reader a : allReaders) {
			System.out.println(a.toString());

			Reader cameron = new Reader("Cameron");
			ReaderHelper rh2 = new ReaderHelper();
			rh2.insertReader(cameron);
			BookDetailsHelper bdh = new BookDetailsHelper();
			BookDetails cameronList = new BookDetails(cameron, LocalDate.now(), "99");
			bdh.insertNewBookDetails(cameronList);
			List<BookDetails> allDetails = bdh.getBookDetails();
			for (BookDetails z : allDetails) {
				System.out.println(z.toString());

			}
		}
	}
}
