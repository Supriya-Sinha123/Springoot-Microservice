package com.practice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.BookEntity;

@Repository
public interface BookRepository extends CrudRepository<BookEntity, Integer>{

}
