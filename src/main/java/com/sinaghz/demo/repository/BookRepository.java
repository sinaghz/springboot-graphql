package com.sinaghz.demo.repository;

import com.sinaghz.demo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

    Book findBookByName(String name);

}
