package org.academia.repository;

import org.academia.Model.Books;

import java.util.List;

public interface BookDAO {
    List<Books> getBooks();
    void save(Books books);
    void delete(Long bookId);
    Integer getCountBook();
    Books search(Long bookId);
    void update(int raiting, Long bookId);
}
