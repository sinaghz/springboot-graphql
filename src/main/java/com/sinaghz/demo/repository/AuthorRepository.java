package com.sinaghz.demo.repository;

import com.sinaghz.demo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

    Iterable<Author> findALLByBookId(Integer bookId);
}