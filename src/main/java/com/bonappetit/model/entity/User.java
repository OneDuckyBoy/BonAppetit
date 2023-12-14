package com.bonappetit.model.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(name = "username",unique = true,nullable = false)
//    @Length(min = 2,max = 20,message = "Username must be between 3 and 20 characters")
    private String username;

    @Column(nullable = false)
    private String password;
    @Column
    @Email
    private String email;

    @OneToMany(mappedBy = "category")
    private List<Recipe> recipes;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(

            name = "users_liked_recipes",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "recipe_id")

    )
    private List<Recipe> likedRecipes;

}
