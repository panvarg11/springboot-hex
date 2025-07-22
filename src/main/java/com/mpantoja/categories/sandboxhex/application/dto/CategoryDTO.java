package com.mpantoja.categories.sandboxhex.application.dto;


public class CategoryDTO {

    Long CategoryId;
    String CategoryName;

    public CategoryDTO(Long categoryId, String categoryName) {
        CategoryId = categoryId;
        CategoryName = categoryName;
    }

    public CategoryDTO() {

    }

    public Long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Long categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
