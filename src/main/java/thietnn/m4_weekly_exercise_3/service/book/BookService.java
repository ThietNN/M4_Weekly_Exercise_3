package thietnn.m4_weekly_exercise_3.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thietnn.m4_weekly_exercise_3.model.Book;
import thietnn.m4_weekly_exercise_3.repository.IBookRepository;

import java.util.Optional;

@Service
public class BookService implements IBookService{
    @Autowired
    IBookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void removeById(Long id) {
        bookRepository.deleteById(id);
    }
}
