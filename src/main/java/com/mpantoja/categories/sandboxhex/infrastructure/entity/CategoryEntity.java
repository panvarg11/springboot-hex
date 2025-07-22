package com.mpantoja.categories.sandboxhex.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Entity
public class CategoryEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryName;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof CategoryEntity entity)) return false;

        return Objects.equals(categoryName.toLowerCase(), entity.categoryName.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(categoryName);
    }
}
