package org.psp.springbootgraphql.queryresolver;

import org.psp.springbootgraphql.enums.ListOrder;
import org.psp.springbootgraphql.model.Author;
import org.psp.springbootgraphql.model.Book;
import org.psp.springbootgraphql.repository.AuthorRepository;
import org.psp.springbootgraphql.repository.BookRepository;
import org.psp.springbootgraphql.types.BookFilter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.Comparator;
import java.util.List;


@Controller
public class BookQuery{

    BookRepository bookRepository;
    AuthorRepository authorRepository;

    public BookQuery(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @QueryMapping
    public Iterable<Book> allBook(){
        return bookRepository.findAll();
    }

    @QueryMapping
    public Book getBookByName(@Argument("filter") BookFilter bookFilter){
        return bookRepository.findBookByName(bookFilter.getName());
    }

    @QueryMapping
    public Iterable<Author> allAuthor(){
        return authorRepository.findAll();
    }

    @SchemaMapping(typeName="Book", field="author")
    public Iterable<Author> getAuthor(Book book, @Argument ListOrder order) {
        List<Author> allAuthors = (List<Author>) authorRepository.findALLByBookId(book.getId());
        if (order != null) {
            switch (order) {
                case ASC:
                    allAuthors.sort(Comparator.comparingInt(Author::getStarRating));
                case DESC:
                    allAuthors.sort(Comparator.comparingInt(Author::getStarRating).reversed());
            }
        }
        return allAuthors;
    }

}