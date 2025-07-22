package com.mpantoja.categories.sandboxhex.infrastructure.adapter.out.persistence.category;

import com.mpantoja.categories.sandboxhex.domain.model.category.Category;
import com.mpantoja.categories.sandboxhex.domain.model.category.CategoryResponse;
import com.mpantoja.categories.sandboxhex.domain.ports.out.CategoryPersistencePort;
import com.mpantoja.categories.sandboxhex.infrastructure.adapter.out.persistence.category.entity.CategoryEntity;
import com.mpantoja.categories.sandboxhex.infrastructure.adapter.out.persistence.category.repository.CategoryEntityJpaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    private final CategoryEntityJpaRepository entityRepository;
    private final ModelMapper modelMapper;

    @Override
    public Category save(Category category) {
        CategoryEntity entity= entityRepository.save(modelMapper.map(category,CategoryEntity.class));
        return modelMapper.map(entity,Category.class);
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        Optional<CategoryEntity> entity= entityRepository.findByCategoryNameIgnoreCase(categoryName);
        return entity.map(categoryEntity -> modelMapper.map(categoryEntity, Category.class)).orElse(null);
    }

    @Override
    public CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, Boolean orderAsc) {
        Pageable  pageDetails = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.ASC, "categoryName"));
        Page<CategoryEntity> categoryPaged = entityRepository.findAll(pageDetails);
        List<Category> content = categoryPaged.getContent().stream().map(cat-> modelMapper.map(cat,Category.class)).toList();
        return new CategoryResponse(content,categoryPaged.getNumber(),categoryPaged.getSize(), categoryPaged.getTotalElements(), categoryPaged.getTotalPages());
    }

    @Override
    public Category deleteCategoryById(Long categoryId) {
        CategoryEntity todelete = entityRepository.findById(categoryId).orElse(null);
        if(todelete==null) return null;
        entityRepository.delete(todelete);
        return modelMapper.map(todelete,Category.class);
    }


}
