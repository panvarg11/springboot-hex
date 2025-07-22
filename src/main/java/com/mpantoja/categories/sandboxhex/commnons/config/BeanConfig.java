package com.mpantoja.categories.sandboxhex.commnons.config;

import com.mpantoja.categories.sandboxhex.domain.ports.in.CategoryServicePort;
import com.mpantoja.categories.sandboxhex.domain.ports.out.CategoryPersistencePort;
import com.mpantoja.categories.sandboxhex.domain.usecase.CategoryUseCase;
import com.mpantoja.categories.sandboxhex.infrastructure.adapter.out.persistence.category.CategoryPersistenceAdapter;
import com.mpantoja.categories.sandboxhex.infrastructure.adapter.out.persistence.category.repository.CategoryEntityJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

    private final ModelMapper modelMapper;
    private final CategoryEntityJpaRepository repository;

    @Bean
    public CategoryPersistencePort categoryPersistencePort(){
        return new CategoryPersistenceAdapter(repository, modelMapper);
    }

    @Bean
    CategoryServicePort categoryServicePort(CategoryPersistencePort categoryPersistencePort){
        return new CategoryUseCase(categoryPersistencePort);
    }
}
