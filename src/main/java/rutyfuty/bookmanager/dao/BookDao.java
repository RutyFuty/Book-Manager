package rutyfuty.bookmanager.dao;

import rutyfuty.bookmanager.model.Book;

import java.util.List;

//Укажем, что же можно сделать с объектом (книгой)
public interface BookDao {
    //Метод, который добавляет книгу
    void addBook(Book book);

    //Метод, который обновляет книгу
    void updateBook(Book book);

    //Метод, который удаляет книгу
    void removeBook(int id);

    //Метод, который получает книгу по id
    Book getBookById(int id);

    //Метод, который возвращает список книг в таблице
    List<Book> listBooks();
}
