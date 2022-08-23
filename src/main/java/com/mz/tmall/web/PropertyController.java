package com.mz.tmall.web;

import com.mz.tmall.pojo.Property;
import com.mz.tmall.service.PropertyService;
import com.mz.tmall.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@RestController
public class PropertyController {
    @Autowired PropertyService propertyService;

    @GetMapping("/categories/{cid}/properties")
    public Page4Navigator<Property> list(@PathVariable(value = "cid") int cid, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        start = start < 0 ? 0 : start;
        return propertyService.list(cid, start, size, 5);
    }

    @GetMapping("/properties/{id}")
    public Property get(@PathVariable("id") int id) throws Exception{
        return propertyService.get(id);
    }

    @PostMapping("/properties")
    public Object add(@RequestBody Property property) throws Exception{
        propertyService.add(property);
        return property;
    }

    @PutMapping("/properties")
    public Object edit(@RequestBody Property property) throws Exception{
        propertyService.update(property);
        return property;
    }

    @DeleteMapping("/properties/{id}")
    public String delete(@PathVariable("id") int id) throws Exception {
        propertyService.delete(id);
        return null;
    }
}
