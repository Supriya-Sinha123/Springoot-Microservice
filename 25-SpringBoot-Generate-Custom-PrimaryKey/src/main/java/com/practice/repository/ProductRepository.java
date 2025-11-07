package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String>{



}
