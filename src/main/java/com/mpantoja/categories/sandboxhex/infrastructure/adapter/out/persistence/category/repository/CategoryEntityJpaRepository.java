package com.mpantoja.categories.sandboxhex.infrastructure.adapter.out.persistence.category.repository;

import com.mpantoja.categories.sandboxhex.infrastructure.adapter.out.persistence.category.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryEntityJpaRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByCategoryNameIgnoreCase(String categoryName);
}
