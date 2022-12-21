package com.study.springboot202210h.web.controller;

import com.study.springboot202210h.service.OptionService;
import com.study.springboot202210h.web.dto.CategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/option")
public class OptionController {

    @Autowired
    private OptionService optionService;

    @PostMapping("/category")
    public ResponseEntity<?> addCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity
                .created(URI.create("/api/option/category" + optionService.addCategory(categoryDto)))
                .body(categoryDto);
    }

    @GetMapping("/categories")
//    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public ResponseEntity<?> getCategories() {
        return ResponseEntity.ok(optionService.getCategories());
    }

    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> modifyCategory(@PathVariable int categoryId, @RequestBody CategoryDto categoryDto) {
        optionService.modifyCategory(categoryId, categoryDto);
        return ResponseEntity.ok(true);
    }
}

