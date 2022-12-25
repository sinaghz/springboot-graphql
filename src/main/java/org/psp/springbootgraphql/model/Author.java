package org.psp.springbootgraphql.model;


import javax.persistence.*;

@Entity
@Table(name = "Author", schema = "BOOK_API_DATA")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @Column(name = "firstname")
    String firstName;
    @Column(name = "lastname")
    String lastName;
    @Column(name = "starRating")
    Integer starRating;
    @Column(name = "bookid")
    Integer bookId;

    public Author() {
    }

    public Author(Integer id, String firstName, String lastName, Integer starRating, Integer bookId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.starRating = starRating;
        this.bookId = bookId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getStarRating() {
        return starRating;
    }

    public void setStarRating(Integer starRating) {
        this.starRating = starRating;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}