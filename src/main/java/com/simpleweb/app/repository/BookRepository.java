package com.simpleweb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simpleweb.app.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
