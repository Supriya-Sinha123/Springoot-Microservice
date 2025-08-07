package com.practice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.ProfileEntity;

@Repository
public interface ProfileRepository extends CrudRepository<ProfileEntity, Long>{

}
