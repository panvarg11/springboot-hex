package com.mpantoja.categories.sandboxhex.application.service.impl;

import com.mpantoja.categories.sandboxhex.application.dto.CategoryDTO;
import com.mpantoja.categories.sandboxhex.application.dto.CategoryDTOResponse;
import com.mpantoja.categories.sandboxhex.application.service.intf.ICategoryService;
import com.mpantoja.categories.sandboxhex.domain.model.category.Category;
import com.mpantoja.categories.sandboxhex.domain.model.category.CategoryResponse;
import com.mpantoja.categories.sandboxhex.domain.ports.in.CategoryServicePort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ICategoryServiceImpl implements ICategoryService {

    private final CategoryServicePort categoryServicePort;
    private final ModelMapper modelMapper;

    @Override
    public CategoryDTO saveCategory(CategoryDTO categorydto) {
        Category saved= categoryServicePort.saveCategory(modelMapper.map(categorydto, Category.class));
        return modelMapper.map(saved, CategoryDTO.class);
    }

    @Override
    public CategoryDTOResponse getAllCategories(Integer pageNumber, Integer pageSize, Boolean orderAsc) {
        CategoryResponse categories = categoryServicePort.getCategories(pageNumber,pageSize,orderAsc);
        List<CategoryDTO> response = categories.content().stream().map(cat -> modelMapper.map(cat, CategoryDTO.class)).toList();
        return new CategoryDTOResponse(response, categories.pageNumber(),categories.pageSize(), categories.totalElements(), categories.totalPages());
    }



    @Override
    public CategoryDTO findByName(String categoryName) {
        return modelMapper.map(categoryServicePort.findByName(categoryName), CategoryDTO.class);
    }


    @Override
    public CategoryDTO deleteCategoryById(Long categoryId) {
        return modelMapper.map(categoryServicePort.deleteCategoryById(categoryId), CategoryDTO.class);
    }
}
