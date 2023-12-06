package controller;
import model.*;
import view.*;
import helper.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;

public class AddMealFrameController {
    // this class will handle the logic for the MealPanel class which is used to add a meal recipe by the chef
    private AddMealFrame addMealFrame;

    public AddMealFrameController(DefaultTableModel mealModel) {
        addMealFrame = new AddMealFrame();

        // list of ingredients to be added to the meal
        HashMap<Ingredient, Float> mealIngredients = new HashMap<>();

        addMealFrame.getAddMealButton().addActionListener(e -> {
            try {
                String name = addMealFrame.getNameFieldText();
                String cuisine = addMealFrame.getCuisineFieldText();
                int prepTime = Integer.parseInt(addMealFrame.getPrepTimeFieldText());
                int cookTime = Integer.parseInt(addMealFrame.getCookTimeFieldText());
                String instructions = addMealFrame.getInstructionsAreaText();

                Meal meal = new Meal(name, Utils.getLoggedInUser().getName(), mealIngredients, prepTime, cookTime, instructions, cuisine);
                Utils.saveToFile(meal, paths.MEALS.getPath());
                JOptionPane.showMessageDialog(null, "Meal added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                // close the frame
                addMealFrame.dispose();

                // refresh the meals table
                mealModel.addRow(new Object[]{meal.getName(), meal.getChefName(), meal.getPreparationTime(), meal.getCookingTime(), meal.getInstructions(), meal.getCuisine(), meal.getBookmarkCount()});
            } catch (DuplicateError ex) {
                JOptionPane.showMessageDialog(null, "Meal already exists", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        addMealFrame.getAddIngredientsButton().addActionListener(e -> {
            // pop up window that contains the ingredients table, an input field for the quantity and a button to add the ingredient to the meal
            AddMealIngredientsFrame ingredientsFrame = new AddMealIngredientsFrame();

            JTable ingredientsTable = ingredientsFrame.getIngredientsTable();
            ArrayList<Ingredient> ingredients = Utils.getIngredients();
            ingredientsFrame.getAddIngredientButton().addActionListener(e1 -> {
                try {
                    Float quantity = Float.parseFloat(ingredientsFrame.getQuantityField().getText());
                    int selectedRow = ingredientsTable.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Please select an ingredient", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Ingredient ingredient = ingredients.get(selectedRow);
                        mealIngredients.put(ingredient, quantity);

                        // update the chosenIngredients table
                        DefaultTableModel tableModel = (DefaultTableModel) addMealFrame.getChosenIngredientsTable().getModel();
                        tableModel.addRow(new Object[]{ingredient.getName(), quantity, ingredient.getUnit()});

                        JOptionPane.showMessageDialog(null, "Ingredient added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "No ingredients found", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    ingredientsFrame.getQuantityField().setText("");
                }
            });
        });
    }
}
