import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

// controller helper class for the chef frame
public class ChefPanelContent {
    private static DefaultTableModel ingredientModel;
    private static JTable ingredientTable;
    public static JScrollPane generateIngredientsTable() {
        ingredientModel = new DefaultTableModel();
        ingredientModel.addColumn("Name");
        ingredientModel.addColumn("Calories");
        ingredientModel.addColumn("Protein");
        ingredientModel.addColumn("Fat");
        ingredientModel.addColumn("Carbohydrates");
        ingredientModel.addColumn("Unit");
        ingredientModel.addColumn("Description");
        ingredientModel.addColumn("Vegetarian");
        ingredientModel.addColumn("Vegan");
        ingredientModel.addColumn("Gluten Free");
        ingredientModel.addColumn("Dairy Free");
        ingredientModel.addColumn("Nut Free");
        ingredientModel.addColumn("Red Meat Free");

        ingredientTable = new JTable(ingredientModel);
        // make cells not editable
        ingredientTable.setDefaultEditor(Object.class, null);

        ingredientTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        ingredientTable.setFillsViewportHeight(true);

        // add rows to the table
        for (Ingredient ingredient : Utils.getIngredients()) {
            ingredientModel.addRow(new Object[]{ingredient.getName(), ingredient.getCalories(), ingredient.getProtein(), ingredient.getFat(), ingredient.getCarbohydrates(), ingredient.getUnit(), ingredient.getDescription(), ingredient.isVegetarian(), ingredient.isVegan(), ingredient.isGlutenFree(), ingredient.isDairyFree(), ingredient.isNutFree(), ingredient.isRedMeatFree()});
        }
        return new JScrollPane(ingredientTable);
    }

    private static JPanel ingredientDialog(JTextField nameField, JTextField caloriesField, JTextField proteinField, JTextField fatField, JTextField carbohydratesField, JTextField unitField, JTextField descriptionField, JTextField isVegetarianField, JTextField isVeganField, JTextField isGlutenFreeField, JTextField isDairyFreeField, JTextField isNutFreeField, JTextField isRedMeatFreeField) {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Calories:"));
        panel.add(caloriesField);
        panel.add(new JLabel("Protein:"));
        panel.add(proteinField);
        panel.add(new JLabel("Fat:"));
        panel.add(fatField);
        panel.add(new JLabel("Carbohydrates:"));
        panel.add(carbohydratesField);
        panel.add(new JLabel("Unit:"));
        panel.add(unitField);
        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);
        panel.add(new JLabel("Vegetarian (True/False):"));
        panel.add(isVegetarianField);
        panel.add(new JLabel("Vegan (True/False):"));
        panel.add(isVeganField);
        panel.add(new JLabel("Gluten Free (True/False):"));
        panel.add(isGlutenFreeField);
        panel.add(new JLabel("Dairy Free (True/False):"));
        panel.add(isDairyFreeField);
        panel.add(new JLabel("Nut Free (True/False):"));
        panel.add(isNutFreeField);
        panel.add(new JLabel("Red Meat Free (True/False):"));
        panel.add(isRedMeatFreeField);

        return panel;
    }

    private static void showAddIngredientDialog() {
        JTextField nameField = new JTextField();
        JTextField caloriesField = new JTextField();
        JTextField proteinField = new JTextField();
        JTextField fatField = new JTextField();
        JTextField carbohydratesField = new JTextField();
        JTextField unitField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField isVegetarianField = new JTextField();
        JTextField isVeganField = new JTextField();
        JTextField isGlutenFreeField = new JTextField();
        JTextField isDairyFreeField = new JTextField();
        JTextField isNutFreeField = new JTextField();
        JTextField isRedMeatFreeField = new JTextField();

        JPanel panel = ingredientDialog(nameField, caloriesField, proteinField, fatField, carbohydratesField, unitField, descriptionField, isVegetarianField, isVeganField, isGlutenFreeField, isDairyFreeField, isNutFreeField, isRedMeatFreeField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Add New Ingredient",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                float calories = Float.parseFloat(caloriesField.getText());
                float protein = Float.parseFloat(proteinField.getText());
                float fat = Float.parseFloat(fatField.getText());
                float carbohydrates = Float.parseFloat(carbohydratesField.getText());
                String unit = unitField.getText();
                String description = descriptionField.getText();
                boolean isVegetarian = Boolean.parseBoolean(isVegetarianField.getText());
                boolean isVegan = Boolean.parseBoolean(isVeganField.getText());
                boolean isGlutenFree = Boolean.parseBoolean(isGlutenFreeField.getText());
                boolean isDairyFree = Boolean.parseBoolean(isDairyFreeField.getText());
                boolean isNutFree = Boolean.parseBoolean(isNutFreeField.getText());
                boolean isRedMeatFree = Boolean.parseBoolean(isRedMeatFreeField.getText());

                // Create a new Ingredient object and add it to the list
                Ingredient newIngredient = new Ingredient(name, Utils.getLoggedInUser().getName(), calories, fat, carbohydrates, protein,
                        unit, description, isVegetarian, isVegan, isGlutenFree, isDairyFree, isNutFree, isRedMeatFree);
                ingredientModel.addRow(new Object[]{newIngredient.getName(), newIngredient.getCalories(),
                        newIngredient.getProtein(), newIngredient.getFat(),
                        newIngredient.getCarbohydrates(), newIngredient.getUnit(), newIngredient.getDescription(),
                        newIngredient.getUnit(), newIngredient.isVegetarian(), newIngredient.isVegan(),
                        newIngredient.isGlutenFree(), newIngredient.isDairyFree(), newIngredient.isNutFree(),
                        newIngredient.isRedMeatFree()
                });

                // add the new ingredient to the file
                Utils.saveToFile(newIngredient, Utils.getIngredientsFile());
            } catch (DuplicateError e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                return;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
                return;
            }
        }
    }

    public static JPanel generateIngredientButtonPanel() {
        JButton addIngredientButton = new JButton("Add Ingredient");
        addIngredientButton.addActionListener(e -> showAddIngredientDialog());

        JButton deleteIngredientButton = getDeleteIngredientButton();

        JButton editIngredientButton = new JButton("Edit Ingredient");
        editIngredientButton.addActionListener(e -> {
            int selectedRow = ingredientTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select an ingredient to edit.");
                return;
            }
            String name = (String) ingredientModel.getValueAt(selectedRow, 0);
            ArrayList<Ingredient> ingredients = Utils.getIngredients();
            for (Ingredient ingredient : ingredients) {
                if (ingredient.getName().equals(name)) {
                    JTextField nameField = new JTextField(ingredient.getName());
                    JTextField caloriesField = new JTextField(String.valueOf(ingredient.getCalories()));
                    JTextField proteinField = new JTextField(String.valueOf(ingredient.getProtein()));
                    JTextField fatField = new JTextField(String.valueOf(ingredient.getFat()));
                    JTextField carbohydratesField = new JTextField(String.valueOf(ingredient.getCarbohydrates()));
                    JTextField unitField = new JTextField(ingredient.getUnit());
                    JTextField descriptionField = new JTextField(ingredient.getDescription());
                    JTextField isVegetarianField = new JTextField(String.valueOf(ingredient.isVegetarian()));
                    JTextField isVeganField = new JTextField(String.valueOf(ingredient.isVegan()));
                    JTextField isGlutenFreeField = new JTextField(String.valueOf(ingredient.isGlutenFree()));
                    JTextField isDairyFreeField = new JTextField(String.valueOf(ingredient.isDairyFree()));
                    JTextField isNutFreeField = new JTextField(String.valueOf(ingredient.isNutFree()));
                    JTextField isRedMeatFreeField = new JTextField(String.valueOf(ingredient.isRedMeatFree()));

                    JPanel panel = ingredientDialog(nameField, caloriesField, proteinField, fatField, carbohydratesField, unitField, descriptionField, isVegetarianField, isVeganField, isGlutenFreeField, isDairyFreeField, isNutFreeField, isRedMeatFreeField);

                    int result = JOptionPane.showConfirmDialog(null, panel, "Edit Ingredient",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        // update the ingredient
                        try {
                            ingredient.setName(nameField.getText());
                            ingredient.setCalories(Float.parseFloat(caloriesField.getText()));
                            ingredient.setProtein(Float.parseFloat(proteinField.getText()));
                            ingredient.setFat(Float.parseFloat(fatField.getText()));
                            ingredient.setCarbohydrates(Float.parseFloat(carbohydratesField.getText()));
                            ingredient.setUnit(unitField.getText());
                            ingredient.setDescription(descriptionField.getText());
                            ingredient.setVegetarian(Boolean.parseBoolean(isVegetarianField.getText()));
                            ingredient.setVegan(Boolean.parseBoolean(isVeganField.getText()));
                            ingredient.setGlutenFree(Boolean.parseBoolean(isGlutenFreeField.getText()));
                            ingredient.setDairyFree(Boolean.parseBoolean(isDairyFreeField.getText()));
                            ingredient.setNutFree(Boolean.parseBoolean(isNutFreeField.getText()));
                            ingredient.setRedMeatFree(Boolean.parseBoolean(isRedMeatFreeField.getText()));
                        } catch (Exception e2) {
                            JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
                            return;
                        }

                        // update the table
                        ingredientModel.setValueAt(ingredient.getName(), selectedRow, 0);
                        ingredientModel.setValueAt(ingredient.getCalories(), selectedRow, 1);
                        ingredientModel.setValueAt(ingredient.getProtein(), selectedRow, 2);
                        ingredientModel.setValueAt(ingredient.getFat(), selectedRow, 3);
                        ingredientModel.setValueAt(ingredient.getCarbohydrates(), selectedRow, 4);
                        ingredientModel.setValueAt(ingredient.getUnit(), selectedRow, 5);
                        ingredientModel.setValueAt(ingredient.getDescription(), selectedRow, 6);
                        ingredientModel.setValueAt(ingredient.isVegetarian(), selectedRow, 7);
                        ingredientModel.setValueAt(ingredient.isVegan(), selectedRow, 8);
                        ingredientModel.setValueAt(ingredient.isGlutenFree(), selectedRow, 9);
                        ingredientModel.setValueAt(ingredient.isDairyFree(), selectedRow, 10);
                        ingredientModel.setValueAt(ingredient.isNutFree(), selectedRow, 11);
                        ingredientModel.setValueAt(ingredient.isRedMeatFree(), selectedRow, 12);

                        // save the changes to the file
                        Utils.saveEditedToFile(ingredients, Utils.getIngredientsFile());
                    }
                }
            }
        });

        // button panel to show all buttons next to each other
        JPanel buttonPanel = new JPanel();
        // buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(addIngredientButton);
        buttonPanel.add(deleteIngredientButton);
        buttonPanel.add(editIngredientButton);

        return buttonPanel;
    }

    private static JButton getDeleteIngredientButton() {
        JButton deleteIngredientButton = new JButton("Delete Ingredient");
        deleteIngredientButton.addActionListener(e -> {
            int selectedRow = ingredientTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please select an ingredient to delete.");
                return;
            }
            String name = (String) ingredientModel.getValueAt(selectedRow, 0);
            ArrayList<Ingredient> ingredients = Utils.getIngredients();
            for (Ingredient ingredient : ingredients) {
                if (ingredient.getName().equals(name)) {
                    ingredients.remove(ingredient);
                    break;
                }
            }
            ingredientModel.removeRow(selectedRow);
            Utils.saveEditedToFile(ingredients, Utils.getIngredientsFile());
        });
        return deleteIngredientButton;
    }
}
