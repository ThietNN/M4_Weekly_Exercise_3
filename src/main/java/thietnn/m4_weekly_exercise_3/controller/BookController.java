package thietnn.m4_weekly_exercise_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import thietnn.m4_weekly_exercise_3.model.Book;
import thietnn.m4_weekly_exercise_3.service.book.BookService;
import thietnn.m4_weekly_exercise_3.service.book.IBookService;
import thietnn.m4_weekly_exercise_3.service.category.CategoryService;
import thietnn.m4_weekly_exercise_3.service.category.ICategoryService;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBookService bookService;

    @GetMapping("/home")
    public ModelAndView homePage(){
        return new ModelAndView("/home");
    }

    @GetMapping("/user")
    public ModelAndView userPage(){
        return new ModelAndView("/user/home");
    }

    @GetMapping("/admin")
    public ModelAndView adminPage(){
        ModelAndView modelAndView = new ModelAndView("/admin/home");
        modelAndView.addObject("categoryList",categoryService.findAll());
        modelAndView.addObject("bookList",bookService.findAll());
        return modelAndView;
    }

    @GetMapping("")
    public ResponseEntity<Iterable<Book>> bookList(){
        Iterable<Book> books = bookService.findAll();
        List<Book> bookList = (List<Book>) books;
        return new ResponseEntity<>(bookList,HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Book> save(@RequestBody Book book){
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }

    @DeleteMapping("")
    public ResponseEntity<Book> remove(@PathVariable Long id){
        Optional<Book> book = bookService.findById(id);
        if (!book.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        bookService.removeById(id);
        return new ResponseEntity<>(book.get(),HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody Book book){
        Optional<Book> optionalBook = bookService.findById(id);
        if (!optionalBook.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        long idFound = optionalBook.get().getId();
        book.setId(idFound);
        return new ResponseEntity<>(bookService.save(book),HttpStatus.NO_CONTENT);
    }




}
