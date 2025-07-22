package com.mpantoja.categories.sandboxhex.domain.ports.out;

import com.mpantoja.categories.sandboxhex.domain.model.category.Category;
import com.mpantoja.categories.sandboxhex.domain.model.category.CategoryResponse;

public interface CategoryPersistencePort {
    Category save (Category category);
    Category getCategoryByCategoryName(String categoryName);
    //Integer page, Integer size, Boolean orderA
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, Boolean orderAsc);
    Category deleteCategoryById(Long categoryId);
}
