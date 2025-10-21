package miniproject01.repository.book;

import miniproject01.common.DBUtil;
import miniproject01.dto.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCBookRepository implements BookRepository {

    @Override
    public void save(Book book) {
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("도서 등록 오류 발생!");
        }
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM books";
        List<Book> books = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                long bookId = rs.getLong("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                boolean isRented = rs.getBoolean("is_rented");

                books.add(new Book(bookId, title, author, isRented));
            }
        } catch (SQLException e) {
            throw new RuntimeException("도서 목록 조회 오류 발생!");
        }
        return books;
    }

    @Override
    public List<Book> findByTitle(String title) {
        String sql = "SELECT * FROM books WHERE title LIKE '%?%'";
        List<Book> booksByTitle = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Long bookId = rs.getLong("book_id");
                String bookTitle = rs.getString("title");
                String bookAuthor = rs.getString("author");
                boolean isRented = rs.getBoolean("is_rented");

                booksByTitle.add(new Book(bookId, bookTitle, bookAuthor, isRented));
            }
        } catch (SQLException e) {
            throw new RuntimeException("도서 검색 오류 발생!");
        }
        return booksByTitle;
    }

    @Override
    public Book findById(Long bookId) {
        String sql = "SELECT * FROM books WHERE book_id = ?";
        Book book = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            ps.setLong(1, bookId);

        } catch (SQLException e) {
            throw new RuntimeException("대여를 위한 도서 검색 중 오류 발생!");
        }
        return book;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
