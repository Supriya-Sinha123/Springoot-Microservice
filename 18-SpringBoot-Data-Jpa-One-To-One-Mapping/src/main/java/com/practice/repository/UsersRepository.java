package com.practice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.UsersEntity;

@Repository
public interface UsersRepository extends CrudRepository<UsersEntity, Long>{

}
