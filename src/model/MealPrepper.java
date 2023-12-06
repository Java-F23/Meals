package model;

import helper.Utils;
import helper.paths;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static helper.Utils.getMealPreppers;

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
        // update the user in the file
        // store users in a hashset
        ArrayList<MealPrepper> mealPreppers = Utils.getMealPreppers();
        // remove logged in user using the username
        mealPreppers.removeIf(mealPrepper -> mealPrepper.getUsername().equals(this.getUsername()));
        // add the edited user
        bookmarkedMeals.add(meal);
        meal.incrementBookmarkCount();
        mealPreppers.add(this);
        Utils.saveEditedToFile(mealPreppers, paths.MEAL_PREPPERS.getPath());
    }

    public void removeBookmarkedMeal(Meal meal) {
        // update the user in the file
        // store users in a hashset
        ArrayList<MealPrepper> mealPreppers = Utils.getMealPreppers();
        // remove logged in user using the username
        mealPreppers.removeIf(mealPrepper -> mealPrepper.getUsername().equals(this.getUsername()));
        // add the edited user
        bookmarkedMeals.remove(meal);
        meal.decrementBookmarkCount();
        mealPreppers.add(this);
        Utils.saveEditedToFile(mealPreppers, paths.MEAL_PREPPERS.getPath());
    }

    public HashSet<Meal> getBookmarkedMeals() {
        return bookmarkedMeals;
    }
}
