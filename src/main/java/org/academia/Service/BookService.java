package org.academia.Service;

import org.academia.Model.Books;

import java.util.List;

public interface BookService {
    List<Books> getBooksService();
    void saveService(Books books);
    void deleteService(Long bookId);
    Integer getCountBookService();
    Books searchService(Long bookId);
    void updateService(int raiting, Long bookId);
}
