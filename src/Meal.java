import java.util.ArrayList;

public class Meal {
    private final String name;
    private final ArrayList<Ingredient> ingredients;
    private final ArrayList<Float> quantity;
    private final int preparationTime;
    private final int cookingTime;
    private final String instructions;
    private final String cuisine;
    private ArrayList<String> reviews;
    private int bookmarkCount;

    public Meal(String name, ArrayList<Ingredient> ingredients, ArrayList<Float> quantity, int preparationTime, int cookingTime, String instructions, String cuisine) {
        this.name = name;
        this.ingredients = ingredients;
        this.quantity = quantity;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.instructions = instructions;
        this.cuisine = cuisine;
        this.reviews = new ArrayList<String>();
        this.bookmarkCount = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
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

    public void addIngredient(Ingredient ingredient, Float quantity) {
        this.ingredients.add(ingredient);
        this.quantity.add(quantity);
    }

    public void removeIngredient(Ingredient ingredient) {
        ingredients.remove(ingredient);
        quantity.remove(ingredients.indexOf(ingredient));
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public String getIngredientsString() {
        String ingredientsString = "";
        for (Ingredient ingredient : ingredients) {
            ingredientsString += ingredient.getName() + ", ";
        }
        return ingredientsString.substring(0, ingredientsString.length() - 2);
    }

    public String getDietaryRestrictionsString() {
        ArrayList<String> dietaryRestrictions = new ArrayList<String>();
        dietaryRestrictions.add("Vegetarian");
        dietaryRestrictions.add("Vegan");
        dietaryRestrictions.add("Gluten Free");
        dietaryRestrictions.add("Dairy Free");
        dietaryRestrictions.add("Nut Free");
        dietaryRestrictions.add("Red Meat Free");

        for (Ingredient ingredient : ingredients) {
            if (!ingredient.isVegetarian()) {
                dietaryRestrictions.remove("Vegetarian");
            }
            if (!ingredient.isVegan()) {
                dietaryRestrictions.remove("Vegan");
            }
            if (!ingredient.isGlutenFree()) {
                dietaryRestrictions.remove("Gluten Free");
            }
            if (!ingredient.isDairyFree()) {
                dietaryRestrictions.remove("Dairy Free");
            }
            if (!ingredient.isNutFree()) {
                dietaryRestrictions.remove("Nut Free");
            }
            if (!ingredient.isRedMeatFree()) {
                dietaryRestrictions.remove("Red Meat Free");
            }
        }
        String dietaryRestrictionsString = "";
        for (String dietaryRestriction : dietaryRestrictions) {
            dietaryRestrictionsString += dietaryRestriction + ", ";
        }
        return dietaryRestrictionsString.substring(0, dietaryRestrictionsString.length() - 2);
    }

    public float getTotalCalories() {
        float calories = 0;
        for (Ingredient ingredient : ingredients) {
            calories += ingredient.getCalories() * quantity.get(ingredients.indexOf(ingredient));
        }
        return calories;
    }

    public String getMeal() {
        String meal = "";
        meal += "Name: " + name + "\n";
        meal += "Cuisine: " + cuisine + "\n";
        meal += "Preparation Time: " + preparationTime + " minutes\n";
        meal += "Cooking Time: " + cookingTime + " minutes\n";
        meal += "Total Time: " + getTotalTime() + " minutes\n";
        meal += "Ingredients: " + getIngredientsString() + "\n";
        for (Ingredient i: ingredients) {
            meal += "Quantity: " + quantity.get(ingredients.indexOf(i)) + " " + i.getUnit() + "\n";
            meal += i.getDetails() + "\n";
        }
        meal += "Dietary Restrictions: " + getDietaryRestrictionsString() + "\n";
        meal += "Total Calories: " + getTotalCalories() + "\n";
        meal += "Instructions: " + instructions + "\n";
        return meal;
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void addBookmark() {
        bookmarkCount++;
    }

    public ArrayList<Float> getQuantities() {
        return quantity;
    }
}
