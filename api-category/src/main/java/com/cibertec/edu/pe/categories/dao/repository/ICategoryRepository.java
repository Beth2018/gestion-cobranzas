package com.cibertec.edu.pe.categories.dao.repository;

import com.cibertec.edu.pe.categories.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
