package code;

import code.dao.AuthorDao;
import code.dao.BookDao;
import code.dao.GenreDao;
import code.dao.impl.AuthorDaoImpl;
import code.dao.impl.BookDaoImpl;
import code.dao.impl.GenreDaoImpl;
import code.model.Author;
import code.model.Book;
import code.model.Genre;

import java.util.Collections;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        AuthorDao authorDao = new AuthorDaoImpl();
        BookDao bookDao = new BookDaoImpl();
        GenreDao genreDao = new GenreDaoImpl();

        Author author1 = new Author();
        author1.setName("MISHA");

        Author author2 = new Author();
        author2.setName("ViTA");

        authorDao.create(author1);
        authorDao.create(author2);

        Genre genre1 = new Genre();
        genre1.setGenre("horor");

        Genre genre2 = new Genre();
        genre2.setGenre("fantasy");

        genreDao.create(genre1);
        genreDao.create(genre2);


        Book book1 = new Book();
        book1.setTitle("KingKong");
        book1.setAuthor(author1);
        book1.setGenre(List.of(genre1));

        Book book2 = new Book();
        book2.setTitle("Lords");
        book2.setAuthor(author2);
        book2.setGenre(List.of(genre2,genre1));

        bookDao.create(book1);
        bookDao.create(book2);


       // bookDao.getBooksByAuthor(author2).forEach(System.out::println);
       // bookDao.getBooksByGenre(genre1).forEach(System.out::println);


    }
}
