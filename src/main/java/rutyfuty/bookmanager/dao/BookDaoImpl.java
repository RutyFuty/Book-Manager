package rutyfuty.bookmanager.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import rutyfuty.bookmanager.model.Book;

import java.util.List;

//Класс выполняет роль репозитория, обеспечивает доступ к данным объекта
@Repository
public class BookDaoImpl implements BookDao {

    //Обеспечение логирования
    private static final Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    //Сущность, создающая Session для соединения с базой данных
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBook(Book book) {
        //Создание сессии, которая берет из фабрики сессий текущую сессию
        Session session = this.sessionFactory.getCurrentSession();
        //Сессия сохраняет объект, который ей передали
        session.persist(book);
        //Логирование
        logger.info("Book was added successfully. Book details: " + book);
    }

    @Override
    public void updateBook(Book book) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(book);
        logger.info("Book was updated successfully. Book details: " + book);
    }

    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        //Создаем proxy-объект (книгу), через который можно взаимодействовать с базой данных
        Book book = session.load(Book.class, id);

        if (book != null) {
            session.delete(book);
            logger.info("Book was successfully deleted. Book: " + book);
        } else {
            logger.info("Book does not exists");
        }

    }

    @Override
    public Book getBookById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book book = session.load(Book.class, id);
        logger.info("Book was successfully loaded. Book: " + book);
        return book;
    }

    @Override
    public List<Book> listBooks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Book> bookList = session.createQuery("from Book").list();

        for (Book book : bookList) {
            logger.info("Book list: " + book);
        }

        return bookList;
    }
}
