package com.cibertec.edu.pe.categories.service;

import com.cibertec.edu.pe.categories.dao.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> listAll();

    Category save(Category category);

    Category update(Long id, Category category);

    void delete(Long id);
}
