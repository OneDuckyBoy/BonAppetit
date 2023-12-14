package com.bonappetit.init;

import com.bonappetit.model.entity.Category;
import com.bonappetit.model.enums.CategoryName;
import com.bonappetit.repo.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryInit implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    public CategoryInit(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args)  {

        int categoryCount= (int) categoryRepository.count();

        if (categoryCount==0){
            List<Category> categories = new ArrayList<>();
            Category mainDish = new Category();
            mainDish.setCategoryName(CategoryName.MAIN_DISH);
            mainDish.setDescription("Heart of the meal, substantial and satisfying; main dish delights taste buds.");

            categories.add(mainDish);
            Category dessert = new Category();
            dessert.setCategoryName(CategoryName.DESSERT);
            dessert.setDescription("Sweet finale, indulgent and delightful; dessert crowns the dining experience with joy.");

            categories.add(dessert);
            Category cocktail = new Category();
            cocktail.setCategoryName(CategoryName.COCKTAIL);
            cocktail.setDescription("Sip of sophistication, cocktails blend flavors, creating a spirited symphony in every glass.");

            categories.add(cocktail);
            categoryRepository.saveAll(categories);



        }

    }
}
