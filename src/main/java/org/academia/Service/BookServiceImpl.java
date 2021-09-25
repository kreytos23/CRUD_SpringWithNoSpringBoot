package org.academia.Service;

import org.academia.Model.Books;
import org.academia.repository.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDAO bookDAO;

    @Override
    public List<Books> getBooksService() {
        return bookDAO.getBooks();
    }

    @Override
    public void saveService(Books books) {
        bookDAO.save(books);
    }

    @Override
    public void deleteService(Long bookId) {
        bookDAO.delete(bookId);
    }

    @Override
    public Integer getCountBookService() {
        return bookDAO.getCountBook();
    }

    @Override
    public Books searchService(Long bookId) {
        return bookDAO.search(bookId);
    }

    @Override
    public void updateService(int raiting, Long bookId) {
        bookDAO.update(raiting,bookId);
    }

}
