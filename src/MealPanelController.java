import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class MealPanelController {
    // this class will handle the logic for the MealPanel class which is used to add a meal recipe by the chef
    private MealPanel mealPanel;

    public MealPanelController(JPanel centerPanel) {
        mealPanel = new MealPanel();

        // list of ingredients to be added to the meal
        ArrayList<MealItem> mealItems = new ArrayList<>();

        mealPanel.getAddMealButton().addActionListener(e -> {
            try {
                String name = mealPanel.getNameFieldText();
                String cuisine = mealPanel.getCuisineFieldText();
                int prepTime = Integer.parseInt(mealPanel.getPrepTimeFieldText());
                int cookTime = Integer.parseInt(mealPanel.getCookTimeFieldText());
                String instructions = mealPanel.getInstructionsAreaText();

                Meal meal = new Meal(name, Utils.getLoggedInUser().getName(), mealItems, prepTime, cookTime, instructions, cuisine);
                Utils.saveToFile(meal, Utils.getMealsFile());
                JOptionPane.showMessageDialog(null, "Meal added successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        mealPanel.getAddIngredientsButton().addActionListener(e -> {
            // pop up window that contains the ingredients table, an input field for the quantity and a button to add the ingredient to the meal
            AddMealIngredientsFrame ingredientsFrame = new AddMealIngredientsFrame();

            JTable ingredientsTable = ingredientsFrame.getIngredientsTable();
            ArrayList<Ingredient> ingredients = Utils.getIngredients();
            ingredientsFrame.getAddIngredientButton().addActionListener(e1 -> {
                try {
                    int quantity = Integer.parseInt(ingredientsFrame.getQuantityField().getText());
                    int selectedRow = ingredientsTable.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Please select an ingredient", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Ingredient ingredient = ingredients.get(selectedRow);
                        MealItem mealItem = new MealItem(ingredient, quantity);
                        mealItems.add(mealItem);

                        // update the chosenIngredients table
                        DefaultTableModel tableModel = (DefaultTableModel) mealPanel.getChosenIngredientsTable().getModel();
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

        centerPanel.add(mealPanel, BorderLayout.CENTER);
    }
}
