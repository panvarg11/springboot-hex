package com.mpantoja.categories.sandboxhex.domain.ports.in;

import com.mpantoja.categories.sandboxhex.domain.model.category.Category;
import com.mpantoja.categories.sandboxhex.domain.model.category.CategoryResponse;

public interface CategoryServicePort {

    Category saveCategory(Category category);
    //Integer page, Integer size, Boolean orderA
    CategoryResponse getCategories(Integer pageNumber, Integer pageSize, Boolean orderAsc);
    Category findByName(String categoryName);
    Category deleteCategoryById(Long categoryId);
}
