package org.psp.springbootgraphql.repository;

import org.psp.springbootgraphql.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    Iterable<Author> findALLByBookId(Integer bookId);
}