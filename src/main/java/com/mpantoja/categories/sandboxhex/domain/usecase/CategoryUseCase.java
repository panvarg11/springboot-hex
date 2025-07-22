package com.mpantoja.categories.sandboxhex.domain.usecase;

import com.mpantoja.categories.sandboxhex.domain.exceptions.DomainException;
import com.mpantoja.categories.sandboxhex.domain.exceptions.ResourceNotFoundException;
import com.mpantoja.categories.sandboxhex.domain.model.category.Category;
import com.mpantoja.categories.sandboxhex.domain.model.category.CategoryResponse;
import com.mpantoja.categories.sandboxhex.domain.ports.in.CategoryServicePort;
import com.mpantoja.categories.sandboxhex.domain.ports.out.CategoryPersistencePort;

//AKA CategoryServicePortImpl
public class CategoryUseCase implements CategoryServicePort {

    private final CategoryPersistencePort categoryPersistencePort;

    public CategoryUseCase(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public Category saveCategory(Category category) {
        Category foundCategory = categoryPersistencePort.getCategoryByCategoryName(category.getCategoryName());
        if(foundCategory!=null)throw new DomainException("Category Already exists with id: "+foundCategory);
        return categoryPersistencePort.save(category);
    }

    @Override
    public CategoryResponse getCategories(Integer pageNumber, Integer pageSize, Boolean orderAsc) {
        return categoryPersistencePort.getAllCategories(pageNumber, pageSize, orderAsc);
    }

    @Override
    public Category findByName(String categoryName) {
        Category category = categoryPersistencePort.getCategoryByCategoryName(categoryName);
        if(category==null) throw new ResourceNotFoundException("Category", "Category Name", categoryName );
        return categoryPersistencePort.getCategoryByCategoryName(categoryName);
    }

    @Override
    public Category deleteCategoryById(Long categoryId) {
        Category deleted = categoryPersistencePort.deleteCategoryById(categoryId);
        if(deleted==null) throw new ResourceNotFoundException("Category", "ID", String.valueOf(categoryId));
        return deleted;
    }


}
