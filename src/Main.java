import java.io.File;
import java.util.ArrayList;

// This project uses the MVC design pattern
public class Main {
    public static void main(String[] args) {
        // run first time setup
        try {
            // if files don't exist, call initializeData()
            if (!new File("chefs.ser").exists()) {
                Utils.initializeData();
            }
        } catch (DuplicateError e) {
            System.out.println(e.getMessage());
        }

        // run the welcome frame
        new WelcomeFrameController();

        // testing files
        System.out.println("Chefs:");
        for (Chef user : Utils.getChefs()) {
            System.out.println(user);
        }

        System.out.println("Meal Preppers:");
        for (MealPrepper user : Utils.getMealPreppers()) {
            System.out.println(user);
        }

        System.out.println("Ingredients:");
        for (Ingredient ingredient : Utils.getIngredients()) {
            System.out.println(ingredient);
        }

        System.out.println("Meals:");
        for (Meal meal : Utils.getMeals()) {
            System.out.println(meal);
        }

//        // Testing Edit
//        ArrayList<Ingredient> ingredients = Utils.getIngredients();
//        System.out.println("changed " + ingredients.get(0).getName() + " to New Name" );
//        ingredients.get(0).setName("New Name");
//
//        Utils.saveEditedToFile(ingredients, Utils.getIngredientsFile());
//
//        // print all data for testing
//        System.out.println("Ingredients:");
//        for (Ingredient ingredient : Utils.getIngredients()) {
//            System.out.println(ingredient);
//        }

    }
}


// TODO: refactor meal class to use the new RecipeItem instead of ingredient class
// TODO: the RecipeItem class should have a reference to the ingredient and the quantity
// TODO: refactor any code that used the old way of storing ingredients in a meal
// TODO: use enum for cuisines
