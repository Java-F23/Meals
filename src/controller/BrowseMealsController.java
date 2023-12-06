package controller;
import helper.Utils;
import helper.paths;
import model.Ingredient;
import model.Meal;
import model.MealPrepper;
import view.BrowseMealsPanel;
import view.ingredientsDialog;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BrowseMealsController {
    MealPrepper user;
    public BrowseMealsController(BrowseMealsPanel browseMealsPanel, BrowseMealsPanel bookmarkedMealsPanel) {
        String username = Utils.getLoggedInUser().getUsername();
        ArrayList<MealPrepper> mealPreppers = Utils.getMealPreppers();
        for (MealPrepper mealPrepper : mealPreppers) {
            if (mealPrepper.getUsername().equals(username)) {
                user = mealPrepper;
                break;
            }
        }
        if (user == null) {
            JOptionPane.showMessageDialog(null, "Error fetching the User. Please try again later.");
            return;
        }

        browseMealsPanel.getAddMealToBookmarkedMealsButton().addActionListener(e -> {
            // get the selected row
            int selectedRow = browseMealsPanel.getMealTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a meal to add to your bookmarked meals");
            } else {
                // get the meal name
                String mealName = (String) browseMealsPanel.getMealTable().getValueAt(selectedRow, 0);
                // get the meal
                Meal meal = Utils.getMealByName(mealName);
                if (meal == null) {
                    JOptionPane.showMessageDialog(null, "Error fetching the Meal. Please try again later.");
                    return;
                }

                // check if the meal is already bookmarked
                HashSet<Meal> bookmarkedMeals = user.getBookmarkedMeals();
                for (Meal m : bookmarkedMeals) {
                    if (m.getName().equals(mealName)) {
                        JOptionPane.showMessageDialog(null, "Meal already bookmarked");
                        return;
                    }
                }

                // add the meal to the user's bookmarked meals
                user.addBookmarkedMeal(meal);

                // update the meal table
                bookmarkedMealsPanel.getMealModel().addRow(new Object[]{meal.getName(), meal.getChefName(), meal.getPreparationTime(), meal.getCookingTime(), meal.getInstructions(), meal.getCuisine(), meal.getBookmarkCount()});
                // increment the bookmark count in the meals table
                int bookmarkCount = (int) browseMealsPanel.getMealTable().getValueAt(selectedRow, 6);
                browseMealsPanel.getMealTable().setValueAt(bookmarkCount + 1, selectedRow, 6);
                JOptionPane.showMessageDialog(null, "Meal added to your bookmarked meals");
            }
        });

        browseMealsPanel.getRemoveMealFromBookmarkedMealsButton().addActionListener(e -> {
            // get the selected row
            int selectedRow = browseMealsPanel.getMealTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a meal to remove from your bookmarked meals");
            } else {
                // get the meal name
                String mealName = (String) browseMealsPanel.getMealTable().getValueAt(selectedRow, 0);
                // get the meal
                Meal meal = Utils.getMealByName(mealName);
                if (meal == null) {
                    JOptionPane.showMessageDialog(null, "Error fetching the Meal. Please try again later.");
                    return;
                }

                // check if the meal is not bookmarked
                HashSet<Meal> bookmarkedMeals = user.getBookmarkedMeals();
                boolean found = false;
                for (Meal m : bookmarkedMeals) {
                    if (m.getName().equals(mealName)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Meal not bookmarked");
                    return;
                }

                // remove the meal from the user's bookmarked meals
                user.removeBookmarkedMeal(meal);

                // update the bookmark table
                int bookmarkedMealsRowCount = bookmarkedMealsPanel.getMealModel().getRowCount();
                for (int i = 0; i < bookmarkedMealsRowCount; i++) {
                    if (bookmarkedMealsPanel.getMealModel().getValueAt(i, 0).equals(mealName)) {
                        bookmarkedMealsPanel.getMealModel().removeRow(i);
                        break;
                    }
                }
                // decrement the bookmark count in the meals table
                int bookmarkCount = (int) browseMealsPanel.getMealTable().getValueAt(selectedRow, 6);
                bookmarkCount = bookmarkCount == 0 ? 0 : bookmarkCount + 1;
                browseMealsPanel.getMealTable().setValueAt(bookmarkCount - 1, selectedRow, 6);
                JOptionPane.showMessageDialog(null, "Meal removed from your bookmarked meals");
            }
        });

        browseMealsPanel.getAddMealToCurrentMealPlanButton().addActionListener(e -> {
            // get the selected row
//            int selectedRow = browseMealsPanel.getMealTable().getSelectedRow();
//            if (selectedRow == -1) {
//                JOptionPane.showMessageDialog(null, "Please select a meal to add to your current meal plan");
//            } else {
//                // get the meal name
//                String mealName = (String) browseMealsPanel.getMealTable().getValueAt(selectedRow, 0);
//                // get the meal
//                Meal meal = Utils.getMealByName(mealName);
//                if (meal == null) {
//                    JOptionPane.showMessageDialog(null, "Error fetching the Meal. Please try again later.");
//                    return;
//                }
//
//                // get the current user
//                User user = Utils.getLoggedInUser();
//                if (user == null) {
//                    JOptionPane.showMessageDialog(null, "Error fetching the User. Please try again later.");
//                    return;
//                }
//
//                // add the meal to the user's current meal plan
//                ((MealPrepper) user).addMealToCurrentMealPlan(meal);
//                JOptionPane.showMessageDialog(null, "Meal added to your current meal plan");
//            }
            System.out.println("Add to current meal plan button clicked");
        });

        browseMealsPanel.getViewMealIngredientsButton().addActionListener(e -> {
            // get the selected row
            int selectedRow = browseMealsPanel.getMealTable().getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select a meal to view its ingredients");
            } else {
                // get the meal name
                String mealName = (String) browseMealsPanel.getMealTable().getValueAt(selectedRow, 0);
                // get the meal
                Meal meal = Utils.getMealByName(mealName);
                if (meal == null) {
                    JOptionPane.showMessageDialog(null, "Error fetching the Meal. Please try again later.");
                    return;
                }

                // get the items
                HashMap<Ingredient, Float> ingredients = meal.getIngredients();

                // create a dialog to display the ingredients items
                new ingredientsDialog(ingredients);
            }
        });


    }
}
