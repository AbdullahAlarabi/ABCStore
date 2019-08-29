package com.warba.abcstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.warba.abcstore.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
