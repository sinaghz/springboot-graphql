package org.psp.springbootgraphql.queryresolver;

import org.psp.springbootgraphql.model.Book;
import org.psp.springbootgraphql.repository.BookRepository;
import org.psp.springbootgraphql.types.BookInput;
import org.psp.springbootgraphql.types.DeleteBookInput;
import org.psp.springbootgraphql.types.DeletedBook;
import org.psp.springbootgraphql.types.NewBook;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;

@Controller
public class BookMutation {

    BookRepository bookRepository;

    public BookMutation(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @MutationMapping
    public NewBook newBook(@Argument("input") BookInput bookInput){
        Book book =  new Book();
        book.setName(bookInput.getName());
        book.setPageCount(bookInput.getPageCount());
        Book book1 = bookRepository.save(book);
        return new NewBook(book1.getId(),book1.getName(),book1.getPageCount());
    }

    @MutationMapping
    public DeletedBook deleteBook(@Argument("input") DeleteBookInput deleteBookInput){
        Book deleteBook = new Book();
        Optional<Book> findBook =  bookRepository.findById(deleteBookInput.getId());
        if(findBook.isPresent()){
            bookRepository.delete(findBook.get());
            deleteBook = findBook.get();
        }
        return new DeletedBook(deleteBook.getId(), deleteBook.getName(), deleteBook.getPageCount());
    }
}