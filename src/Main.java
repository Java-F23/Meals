import controller.WelcomeFrameController;
import helper.DuplicateError;
import helper.Utils;
import helper.paths;
import model.*;

import java.io.File;

// This project uses the MVC design pattern
public class Main {
    public static void main(String[] args) {
        // run first time setup
        try {
            // if files don't exist, call initializeData()
            if (!new File(paths.CHEFS.getPath()).exists()) {
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
            System.out.println("Bookmarks: " + meal.getBookmarkCount());
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


// TODO: use enum for cuisines