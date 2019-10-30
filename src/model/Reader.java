package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "bookdb", name = "reader")
public class Reader {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="READER_ID")
	private int readerId;
	@Column(name="READER_NAME")
	private String readerName;
	
	public Reader() {
		super();
	}
	
	public Reader(int readerId, String readerName) {
		super();
		this.readerId = readerId;
		this.readerName = readerName;
		}
	
	public Reader(int readerId) {
		super();
		this.readerId = readerId;
	}

	public Reader(String readerName) {
		super();
		this.readerName = readerName;
		}

	public int getReaderId() {
		return readerId;
	}

	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	
	@Override
	public String toString() {
	return "Reader [id = " + readerId + ", readerName = " + readerName + "]";
	}	

}
