package com.mpantoja.categories.sandboxhex.application.service.intf;

import com.mpantoja.categories.sandboxhex.application.dto.CategoryDTO;
import com.mpantoja.categories.sandboxhex.application.dto.CategoryDTOResponse;
import com.mpantoja.categories.sandboxhex.domain.model.category.Category;

public interface ICategoryService {

    CategoryDTOResponse getAllCategories(Integer pageNumber, Integer pageSize, Boolean orderAsc);

    CategoryDTO saveCategory(CategoryDTO categoryDTO);

    CategoryDTO findByName(String categoryName);

    CategoryDTO deleteCategoryById(Long categoryId);

}
