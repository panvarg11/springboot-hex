package com.mpantoja.categories.sandboxhex.domain.model.category;

import java.util.List;

public record CategoryResponse (List<Category> content, Integer pageNumber, Integer pageSize, Long totalElements, Integer totalPages){
}
