package code.dao;

import code.model.Author;
import code.model.Book;
import code.model.Genre;

import java.util.List;

public interface BookDao {
    void create(Book book);

    Book getBookByTitle(String title);

    List<Book> getBooksByAuthor(Author author);

    List<Book> getBooksByGenre(Genre genre);
}
