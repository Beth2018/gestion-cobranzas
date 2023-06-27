package com.cibertec.edu.pe.categories.service.impl;

import com.cibertec.edu.pe.categories.dao.entity.Category;
import com.cibertec.edu.pe.categories.dao.repository.ICategoryRepository;
import com.cibertec.edu.pe.categories.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryRepository repository;

    @Override
    public List<Category> listAll() {
        log.debug("Listando categorias");
        return repository.findAll();
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        Optional<Category> optionalCategory = repository.findById(id);
        if (optionalCategory.isEmpty()) {
            return null;
        }
        Category categoryUpd = optionalCategory.get();
        try {
            BeanUtils.copyProperties(categoryUpd, category);
            categoryUpd.setId(id);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return repository.save(categoryUpd);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
