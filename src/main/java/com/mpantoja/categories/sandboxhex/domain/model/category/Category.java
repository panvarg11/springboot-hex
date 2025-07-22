package com.mpantoja.categories.sandboxhex.domain.model.category;

import com.mpantoja.categories.sandboxhex.domain.exceptions.TextLengthViolationException;

public class Category {

    private Long categoryId;
    private String categoryName;

    public Category(Long categoryId, String categoryName) {
        if(categoryName.length()<3 || categoryName.length()>70)throw new TextLengthViolationException("Category Name",3,70);
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(){

    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        if(categoryName.length()<3 || categoryName.length()>70)throw new TextLengthViolationException("Category Name",3,70);
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
