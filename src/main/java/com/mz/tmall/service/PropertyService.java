package com.mz.tmall.service;

import com.mz.tmall.dao.PropertyDAO;
import com.mz.tmall.pojo.Category;
import com.mz.tmall.pojo.Property;
import com.mz.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
    @Autowired PropertyDAO propertyDAO;
    @Autowired CategoryService categoryService;


    public Page4Navigator<Property> list(int cid, int start, int size, int navigatePages){
        Category category = categoryService.get(cid);
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page page = propertyDAO.findByCategory(category, pageable);
        return new Page4Navigator<>(page, navigatePages);
    }

    public void add(Property property){
        propertyDAO.save(property);
    }

    public void update(Property property){
        propertyDAO.save(property);
    }

    public Property get(int id){
        return propertyDAO.findOne(id);
    }

    public void delete(int id){
        propertyDAO.delete(id);
    }
}
