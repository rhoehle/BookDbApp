package model;

import javax.persistence.*;

/**
 * @author Robert Hoehle
 */

@Entity
@Table(name="items", schema = "bookdb")
public class ListItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;
    @Column(name="TITLE")
    private String title;
    @Column(name="AUTHOR")
    private String author;

    public ListItem() {
        super();

    }

    public ListItem(String title, String author) {
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
    public String returnItemDetails( ) {
        return title + " by " + author;
    }

}
