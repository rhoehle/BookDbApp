package model;

import java.time.LocalDate;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "bookdb", name = "book_details")
public class BookDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DETAIL_ID")
	private int detailId;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "READER_ID")
	private Reader reader;
	@Column(name = "DATE_READ")
	private LocalDate dateRead;
	@Column(name = "RATING")
	private String rating;

	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	 (
			 name="ITEMS_IN_BOOK",
			 joinColumns={ @JoinColumn(name="DETAIL_ID", referencedColumnName="DETAIL_ID") },
			 inverseJoinColumns= { @JoinColumn(name="ITEM_ID", referencedColumnName="ID", unique=true) }
	 )
	  

	private List<ListBook> detailsOfBooks;

	public BookDetails() {
		super();
	}

	public BookDetails(Reader reader, LocalDate dateRead, String rating) {
		super();
		this.reader = reader;
		this.dateRead = dateRead;
		this.rating = rating;
	}

	public BookDetails(int detailId, Reader reader, LocalDate dateRead, String rating, List<ListBook> detailsOfBooks) {
		super();
		this.detailId = detailId;
		this.reader = reader;
		this.dateRead = dateRead;
		this.rating = rating;
		this.detailsOfBooks = detailsOfBooks;
	}

	public BookDetails(Reader reader, LocalDate dateRead, String rating, List<ListBook> detailsOfBooks) {
		super();
		this.reader = reader;
		this.dateRead = dateRead;
		this.rating = rating;
		this.detailsOfBooks = detailsOfBooks;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public Reader getReader() {
		return reader;
	}

	public void setReader(Reader reader) {
		this.reader = reader;
	}

	public LocalDate getDateRead() {
		return dateRead;
	}

	public void setDateRead(LocalDate dateRead) {
		this.dateRead = dateRead;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public List<ListBook> getDetailsOfBooks() {
		return detailsOfBooks;
	}

	public void setDetailsOfBooks(List<ListBook> detailsOfBooks) {
		this.detailsOfBooks = detailsOfBooks;
	}

	@Override
	public String toString() {
		return "BookDetails [detailId=" + detailId + ", reader=" + reader + ", dateRead=" + dateRead + ", rating="
				+ rating + ", detailsOfBooks=" + detailsOfBooks + "]";
	}

}
