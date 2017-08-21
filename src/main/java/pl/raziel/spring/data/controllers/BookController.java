package pl.raziel.spring.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.raziel.spring.data.entities.Book;
import pl.raziel.spring.data.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    private ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookRepository.findAll();

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("{title}")
    private ResponseEntity<Book> getBook(@PathVariable("title") String title) {
        Book byTitle = bookRepository.findByTitle(title);
        System.out.println(byTitle);
        if (byTitle == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(byTitle, HttpStatus.OK);
    }

    @GetMapping("bookByTitleLike")
    private ResponseEntity<List<Book>> getBookByTitleLike(@PathVariable("title") String title) {

        return new ResponseEntity<>(bookRepository.findByTitleLike(title), HttpStatus.OK);
    }

    @GetMapping("bookByTitleContaining")
    private ResponseEntity<List<Book>> getBookByTitleContaining(@PathVariable("title") String title) {
        return new ResponseEntity<>(bookRepository.findByTitleContaining(title), HttpStatus.OK);
    }

    @GetMapping("bookByTitleStartingWith")
    private ResponseEntity<List<Book>> getBookByTitleStartingWith(@PathVariable("title") String title) {
        return new ResponseEntity<>(bookRepository.findByTitleStartingWith(title), HttpStatus.OK);
    }

    @GetMapping("bookByTitleEndingWith")
    private ResponseEntity<List<Book>> getBookByTitleEndingWith(@PathVariable("title") String title) {
        return new ResponseEntity<>(bookRepository.findByTitleEndingWith(title), HttpStatus.OK);
    }

    @GetMapping("bookByTitleIgnoreCase")
    private ResponseEntity<List<Book>> getBookByTitleIgnoreCase(@PathVariable("title") String title) {
        return new ResponseEntity<>(bookRepository.findByTitleIgnoreCase(title), HttpStatus.OK);
    }


    @GetMapping("pages")
    private ResponseEntity<List<Book>> findPages() {

        List<Book> books = new ArrayList<>();
        for (Book b : bookRepository.findAll(new PageRequest(0, 3))) {
            books.add(b);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("pagesGreaterThat")
    private ResponseEntity<List<Book>> pagesGreaterThat(int pageCount, int page, int result) {
        List<Book> books = new ArrayList<>();
        for (Book b : bookRepository.findByPageCountGreaterThan(pageCount, new PageRequest(page, result))) {
            books.add(b);
        }

        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
