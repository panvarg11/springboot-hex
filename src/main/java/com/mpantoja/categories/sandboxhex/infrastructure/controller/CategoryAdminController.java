package com.mpantoja.categories.sandboxhex.infrastructure.controller;

import com.mpantoja.categories.sandboxhex.application.dto.CategoryDTO;
import com.mpantoja.categories.sandboxhex.application.service.intf.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/admin/category")
@RestController
@RequiredArgsConstructor
public class CategoryAdminController {

    private final ICategoryService categoryService;


    @PostMapping("/")
    public ResponseEntity<CategoryDTO> saveCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok( categoryService.saveCategory(categoryDTO));
    }


    @DeleteMapping("/id")
    public ResponseEntity<CategoryDTO> deleteCategoryById(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.deleteCategoryById(categoryDTO.getCategoryId()), HttpStatus.OK);
    }



}
