package model;
import helper.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Meal implements Serializable {
    private String name;
    private String chefName;
    // hash map of ingredient to quantity
    private HashMap<Ingredient, Float> ingredients;
    private int preparationTime;
    private int cookingTime;
    private String instructions;
    private String cuisine;
    private int bookmarkCount;
//    private final ArrayList<Review> reviews;

    public Meal(String name, String chefName, HashMap<Ingredient, Float> ingredients, int preparationTime, int cookingTime, String instructions, String cuisine) throws DuplicateError {
        // check unique name
        for (Meal meal : Utils.getMeals()) {
            if (meal.getName().equals(name)) {
                throw new DuplicateError(name);
            }
        }

        this.name = name;
        this.chefName = chefName;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.instructions = instructions;
        this.cuisine = cuisine;
        this.bookmarkCount = 0;
//            this.reviews = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public int getTotalTime() {
        return preparationTime + cookingTime;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getChefName() {
        return chefName;
    }

    public HashMap<Ingredient, Float> getIngredients() {
        return ingredients;
    }

    public void setIngredients(HashMap<Ingredient, Float> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient, float quantity) {
        if (ingredients.containsKey(ingredient)) {
            ingredients.put(ingredient, ingredients.get(ingredient) + quantity);
            return;
        }
        ingredients.put(ingredient, quantity);
    }

    public int getBookmarkCount() {
        return bookmarkCount;
    }

    public void incrementBookmarkCount() {
        bookmarkCount++;
    }

    public void decrementBookmarkCount() {
        bookmarkCount--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Meal Name: ").append(name).append("\n");
        sb.append("Meal Items: ").append("\n");
        for (Ingredient ingredient : ingredients.keySet()) {
            // add ingredient name, quantity, and unit using hash map key and value
            sb.append(ingredient.getName()).append(": ").append(ingredients.get(ingredient)).append(" ").append(ingredient.getUnit()).append("\n");
        }
        return sb.toString();
    }

    public Float getTotalCalories() {
        // calculate total calories using stream
        return ingredients.keySet().stream()
                .map(ingredient -> ingredient.getCalories() * ingredients.get(ingredient))
                .reduce(0f, Float::sum);
    }

    public Float getTotalFat() {
        return ingredients.keySet().stream()
                .map(ingredient -> ingredient.getFat() * ingredients.get(ingredient))
                .reduce(0f, Float::sum);
    }

    public Float getTotalCarbohydrates() {
        return ingredients.keySet().stream()
                .map(ingredient -> ingredient.getCarbohydrates() * ingredients.get(ingredient))
                .reduce(0f, Float::sum);
    }

    public Float getTotalProtein() {
        return ingredients.keySet().stream()
                .map(ingredient -> ingredient.getProtein() * ingredients.get(ingredient))
                .reduce(0f, Float::sum);
    }
}
