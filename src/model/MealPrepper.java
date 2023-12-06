package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

public class MealPrepper extends User implements Serializable {
    private HashSet<Meal> bookmarkedMeals;
    private HashMap<Ingredient, Float> shoppingList;
//    private ArrayList<MealWeek> mealPlanHistory;

    public MealPrepper(String name, String email, String username, String password, String phone) {
        super(name, email, username, password, phone);
        this.bookmarkedMeals = new HashSet<>();
        this.shoppingList = new HashMap<>();
//        this.mealPlanHistory = new ArrayList<>();
    }

    public void addBookmarkedMeal(Meal meal) {
        bookmarkedMeals.add(meal);
        meal.incrementBookmarkCount();
    }

    public void removeBookmarkedMeal(Meal meal) {
        bookmarkedMeals.remove(meal);
        meal.decrementBookmarkCount();
    }
}
