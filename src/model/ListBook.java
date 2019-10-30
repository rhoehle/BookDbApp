package model;

import java.util.List;

import javax.persistence.*;

/**
 * @author Robert Hoehle
 */

@Entity
@Table(schema = "bookdb", name = "books")
public class ListBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "AUTHOR")
	private String author;

	public ListBook() {
		super();

	}

	public ListBook(int id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
	}

	public ListBook(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String item) {
		this.author = item;
	}

	public String returnBookDetails() {
		return "Book [Title=" + title + " by " + author + "Id= " + id + "]";
	}

}
