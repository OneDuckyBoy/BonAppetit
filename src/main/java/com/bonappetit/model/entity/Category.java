package com.bonappetit.model.entity;

import com.bonappetit.model.enums.CategoryName;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
    public CategoryName getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Recipe> getAddedRecipes() {
        return addedRecipes;
    }

    public void setAddedRecipes(List<Recipe> addedRecipes) {
        this.addedRecipes = addedRecipes;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "category_name",unique = true,nullable = false)
    private CategoryName categoryName;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "addedBy")
    private List<Recipe> addedRecipes;





}
