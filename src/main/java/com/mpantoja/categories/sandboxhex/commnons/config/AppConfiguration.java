package com.mpantoja.categories.sandboxhex.commnons.config;

import com.mpantoja.categories.sandboxhex.domain.ports.in.CategoryServicePort;
import com.mpantoja.categories.sandboxhex.domain.ports.out.CategoryPersistencePort;
import com.mpantoja.categories.sandboxhex.domain.usecase.CategoryUseCase;
import com.mpantoja.categories.sandboxhex.infrastructure.adapter.CategoryPersistenceAdapter;
import com.mpantoja.categories.sandboxhex.infrastructure.repository.CategoryEntityJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AppConfiguration {

   @Bean
    public ModelMapper modelMapper(){
       return new ModelMapper();
   }







}


