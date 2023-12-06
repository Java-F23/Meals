package controller;
import helper.Utils;
import model.Meal;
import model.MealPrepper;
import view.BrowseMealsPanel;
import view.MealDetailsDialog;
import view.ingredientsDialog;

import javax.swing.*;
import java.util.HashMap;

public class BrowseMealsController {
    private BrowseMealsPanel browseMealsPanel;

    public BrowseMealsController(BrowseMealsPanel browseMealsPanel) {
        this.browseMealsPanel = browseMealsPanel;

        // loop over the meals and add action listeners to the buttons and checkboxes
        for (HashMap.Entry<Meal, JComponent[]> entry : browseMealsPanel.getMealButtons().entrySet()) {
            Meal meal = entry.getKey();

            // view ingredients button action listener
            ((JButton) entry.getValue()[0]).addActionListener(e -> {
                // open ingredients dialog with the ingredients inside the meal corresponding to the button clicked
                new ingredientsDialog(meal.getIngredients());
            });

            // view details
            ((JButton) entry.getValue()[1]).addActionListener(e -> {
                // open a dialog with the details of the meal corresponding to the button clicked
                // details include the total calories and other nutrients in the meal, cook and prepare times, and instructions
                new MealDetailsDialog(meal);
            });

            // add to meal plan
            ((JButton) entry.getValue()[2]).addActionListener(e -> {
                System.out.println("Add to Meal Plan button clicked");
            });

            // add to shopping list
            ((JButton) entry.getValue()[3]).addActionListener(e -> {

            });

            // bookmark
            ((JCheckBox) entry.getValue()[4]).addActionListener(e -> {
                if (((JCheckBox) entry.getValue()[4]).isSelected()) {
                    ((MealPrepper) Utils.getLoggedInUser()).addBookmarkedMeal(meal);
                } else {
                    ((MealPrepper) Utils.getLoggedInUser()).removeBookmarkedMeal(meal);
                }
            });
        }
    }
}
