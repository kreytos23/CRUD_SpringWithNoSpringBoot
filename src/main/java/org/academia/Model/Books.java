package org.academia.Model;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;


public class Books {
    private Long bookId;
    private String title;
    private Integer totalPages;
    private Integer rating;
    private String isbn;
    private LocalDate publishedDate;
//    private Publisher publisherId;


    public Books(Long bookId, String title, int totalPage, int rating, String ibsn, LocalDate publishedDate) {
        this.bookId = bookId;
        this.title = title;
        this.totalPages = totalPage;
        this.rating = rating;
        this.isbn = ibsn;
        this.publishedDate = publishedDate;
    }

    public Books() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    /*public Publisher getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Publisher publisherId) {
        this.publisherId = publisherId;
    }*/
}
