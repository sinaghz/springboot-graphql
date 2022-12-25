package org.psp.springbootgraphql.repository;

import org.psp.springbootgraphql.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findBookByName(String name);

}
