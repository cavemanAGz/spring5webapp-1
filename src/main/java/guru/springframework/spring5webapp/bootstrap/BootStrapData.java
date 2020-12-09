package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.domain.repositories.AuthorRepository;
import guru.springframework.spring5webapp.domain.repositories.BookRepository;
import guru.springframework.spring5webapp.domain.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(
            AuthorRepository authorRepository,
            BookRepository bookRepository,
            PublisherRepository
                    publisherRepository
    ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evens");
        Book ddd = new Book("Domain Driven Design", "123123");
        Publisher pub = new Publisher(
                "Some Publisher",
                "123 Some Rd",
                "Suite 500",
                "Eugene",
                "OR",
                "97401"
        );

        authorRepository.save(eric);
        publisherRepository.save(pub);

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(pub);

        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "125421246503646546");
        Publisher pub2 = new Publisher(
                "Some Other Publisher",
                "123 Some Rd",
                "Suite 550",
                "Eugene",
                "OR",
                "97401"
        );

        authorRepository.save(rod);
        publisherRepository.save(pub2);


        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(pub2);

        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());

        // ASCII art form: https://patorjk.com/software/taag/#p=display&c=c%2B%2B&f=Small&t=!CavemanApps!
        System.out.println("\n" +
                "    _  ___                                _                _ \n" +
                "   | |/ __|__ ___ _____ _ __  __ _ _ _   /_\\  _ __ _ __ __| |\n" +
                "   |_| (__/ _` \\ V / -_) '  \\/ _` | ' \\ / _ \\| '_ \\ '_ (_-<_|\n" +
                "   (_)\\___\\__,_|\\_/\\___|_|_|_\\__,_|_||_/_/ \\_\\ .__/ .__/__(_)\n" +
                "                                             |_|  |_|        \n"
        );

    }
}
