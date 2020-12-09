package guru.springframework.spring5webapp.controllers;

import guru.springframework.spring5webapp.domain.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookRepository bookRepository;

    // Injecting the dependency
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());

        // Templating library is spring manage Thymeleaf (yuck...)

      return "books/list";
    };

}
