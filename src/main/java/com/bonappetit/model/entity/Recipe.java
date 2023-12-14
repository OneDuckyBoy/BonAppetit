package com.bonappetit.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "recipe")
public class Recipe extends BaseEntity{

    @Column(name = "name",nullable = false)
    @Length(min = 1, max = 40, message = "Name should be between 2 and 40 characters!")
    private String name;

    @Length(min = 1,max = 150,message = "The ingredients list should be between 2 and 150 characters")
    @Column(nullable = false)
    private String ingredients;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "added_by")
    private User addedBy;

}
