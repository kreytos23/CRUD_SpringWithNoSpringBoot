package org.academia.Implement;

import org.academia.Model.Books;
import org.academia.repository.BookDAO;
import org.academia.repository.JDBCConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class BookImpl extends JDBCConfig implements BookDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Books> getBooks() {

        String query = "SELECT * FROM Books";

        return this.jdbcTemplate.query(query, (rs, i) -> {
            Books book = new Books();
            book.setBookId(rs.getLong("bookId"));
            book.setTitle(rs.getString("title"));
            book.setTotalPages(rs.getInt("totalPages"));
            book.setRating(rs.getInt("rating"));
            book.setIsbn(rs.getString("isbn"));
            book.setPublishedDate((rs.getDate("publishedDate").toLocalDate()));
            return book;
        });
    }

    @Override
    public void save(Books book) {
        String query = "INSERT INTO Books (title, totalPages, rating, isbn, publishedDate) VALUES (?, ?, ?, ?, ?)";
        this.jdbcTemplate.update(query, book.getTitle(),
                book.getTotalPages(), book.getRating(), book.getIsbn(), book.getPublishedDate());
    }

    @Override
    public void delete(Long bookId) {
        String query = "DELETE FROM Books WHERE bookId = ? ";
        this.jdbcTemplate.update(query, bookId);
    }

    @Override
    public Integer getCountBook() {
        String query = "SELECT COUNT(*) FROM Books";
        return this.jdbcTemplate.queryForObject(query, Integer.class);
    }

    @Override
    public Books search(Long bookId) {
        String query = "SELECT * FROM Books WHERE bookId = ?";
        return this.jdbcTemplate.queryForObject(query, new BookRowMapper(), bookId);
    }

    public void update(int raiting, Long bookId) {
        String query = "UPDATE Books SET rating = ? where bookId = ?";
        this.jdbcTemplate.update(query, raiting, bookId);
    }

    class BookRowMapper implements RowMapper<Books> {
        public Books mapRow(ResultSet rs, int i) throws SQLException {
            Books book = new Books();
            book.setBookId(rs.getLong("bookId"));
            book.setTitle(rs.getString("title"));
            book.setTotalPages(rs.getInt("totalPages"));
            book.setRating(rs.getInt("rating"));
            book.setIsbn(rs.getString("isbn"));
            book.setPublishedDate(rs.getDate("publishedDate").toLocalDate());
            return book;
        }
    }
}
