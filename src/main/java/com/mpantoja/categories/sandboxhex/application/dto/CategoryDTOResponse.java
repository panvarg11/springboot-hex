package com.mpantoja.categories.sandboxhex.application.dto;

import java.util.List;

public record CategoryDTOResponse(List<CategoryDTO> content, Integer pageNumber, Integer pageSize, Long totalElements, Integer totalPages) {
}
