package com.practice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{

}
