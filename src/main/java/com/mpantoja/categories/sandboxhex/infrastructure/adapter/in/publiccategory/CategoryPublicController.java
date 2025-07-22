package com.mpantoja.categories.sandboxhex.infrastructure.adapter.in.publiccategory;

import com.mpantoja.categories.sandboxhex.application.dto.CategoryDTO;
import com.mpantoja.categories.sandboxhex.application.dto.CategoryDTOResponse;
import com.mpantoja.categories.sandboxhex.application.service.intf.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/public/category")
@RestController
@RequiredArgsConstructor
public class CategoryPublicController {

    private final ICategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<CategoryDTOResponse> getAllCategories(
            @RequestParam(name = "page", required = false,defaultValue = "0") Integer page,
            @RequestParam(name = "size", required = false,defaultValue = "10")Integer size,
            @RequestParam(name = "orderAsc", required = false,defaultValue = "true") Boolean orderAsc){

        return ResponseEntity.ok(categoryService.getAllCategories(page,size,orderAsc));
    }

    @GetMapping("/find")
    public ResponseEntity<CategoryDTO> findByName(@RequestBody CategoryDTO categoryDTO ){
       return ResponseEntity.ok(categoryService.findByName(categoryDTO.getCategoryName()));
    }




}
