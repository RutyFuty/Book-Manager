package rutyfuty.bookmanager.service;

import rutyfuty.bookmanager.model.Book;

import java.util.List;

//Все методы сервиса повторяются с BookDao
public interface BookService {
    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(int id);

    Book getBookById(int id);

    List<Book> listBooks();
}
