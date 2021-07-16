package rutyfuty.bookmanager.model;

import javax.persistence.*;

//Класс является сущностью и связан с таблицей BOOKS
//!!!Так как используется PostgreSQL, то необходимо расставить кавычки!!!
@Entity
@Table(name = "\"BOOKS\"")
public class Book {

    //Указываем, что это id, связываем его с колонкой id, это генерируемое значение, опирающееся на auto-increment колонку в таблице
    @Id
    @Column(name = "\"id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //Связываем с BOOK_TITLE в таблице
    @Column(name = "\"BOOK_TITLE\"")
    private String bookTitle;

    //Связываем с BOOK_AUTHOR в таблице
    @Column(name = "\"BOOK_AUTHOR\"")
    private String bookAuthor;

    //Связываем с BOOK_PRICE в таблице
    @Column(name = "\"BOOK_PRICE\"")
    private int bookPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookTitle='" + bookTitle + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                '}';
    }
}
