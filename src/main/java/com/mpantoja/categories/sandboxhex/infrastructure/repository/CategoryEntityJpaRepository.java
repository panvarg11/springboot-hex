package com.mpantoja.categories.sandboxhex.infrastructure.repository;

import com.mpantoja.categories.sandboxhex.infrastructure.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryEntityJpaRepository extends JpaRepository<CategoryEntity, Long> {

    Optional<CategoryEntity> findByCategoryNameIgnoreCase(String categoryName);
}
