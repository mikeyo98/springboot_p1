package com.mz.tmall.dao;

import com.mz.tmall.pojo.Category;
import com.mz.tmall.pojo.Property;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyDAO extends JpaRepository<Property, Integer> {
    Page<Property> findByCategory(Category category, Pageable pageable);
}
