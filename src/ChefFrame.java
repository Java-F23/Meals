import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ChefFrame extends JFrame {
    private DefaultTableModel ingredientModel;
    private JTable ingredientTable;
    public ChefFrame() {
        // this frame will include a navigation menu and a button to sign out
        // the navigation menu will include buttons to manage meals, manage ingredients, and generate reports
        // when the user clicks on the manage meals button, the large panel in the center will open with a table of all meals
        super("Chef");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the navigation menu
        JMenuBar menuBar = new JMenuBar();
        JMenu manageMenu = new JMenu("Manage");
        JMenuItem manageMeals = new JMenuItem("Meals");
        JMenuItem manageIngredients = new JMenuItem("Ingredients");
        manageMenu.add(manageMeals);
        manageMenu.add(manageIngredients);
        menuBar.add(manageMenu);
        setJMenuBar(menuBar);

        // generate reports menu
        JMenu generateReports = new JMenu("Generate Reports");
        JMenuItem generateMeals = new JMenuItem("Popularity of Meals");
        JMenuItem generateIngredients = new JMenuItem("User Feedback");
        generateReports.add(generateMeals);
        generateReports.add(generateIngredients);
        menuBar.add(generateReports);

        JButton signOutButton = new JButton("Sign Out");
        menuBar.add(signOutButton);

        // Create the large panel in the center
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.add(new JLabel("Welcome, " + Utils.getLoggedInUser().getName()), BorderLayout.NORTH);
        centerPanel.add(new JLabel("This is the center panel"), BorderLayout.CENTER);

        add(centerPanel, BorderLayout.CENTER);

        // Add action listeners to the navigation menu items
        signOutButton.addActionListener(e -> {
            Utils.setLoggedInUser(null);
            new WelcomeFrame();
            dispose();
        });

        manageMeals.addActionListener(e -> {
            centerPanel.removeAll();
            centerPanel.add(new JLabel("Welcome, " + Utils.getLoggedInUser().getName()), BorderLayout.NORTH);
            centerPanel.add(new JLabel("This is the meals table"), BorderLayout.CENTER);
            centerPanel.revalidate();
            centerPanel.repaint();
        });

        manageIngredients.addActionListener(e -> {
            centerPanel.removeAll();
            centerPanel.add(new JLabel("Welcome, " + Utils.getLoggedInUser().getName()), BorderLayout.NORTH);
            centerPanel.add(new JLabel("This is the ingredients table"), BorderLayout.CENTER);

            ingredientModel = new DefaultTableModel();
            ingredientModel.addColumn("Name");
            ingredientModel.addColumn("Calories");
            ingredientModel.addColumn("Unit");
            ingredientModel.addColumn("Description");
            ingredientModel.addColumn("Vegetarian");
            ingredientModel.addColumn("Vegan");
            ingredientModel.addColumn("Gluten Free");
            ingredientModel.addColumn("Dairy Free");
            ingredientModel.addColumn("Nut Free");
            ingredientModel.addColumn("Red Meat Free");

            ingredientTable = new JTable(ingredientModel);
            ingredientTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
            ingredientTable.setFillsViewportHeight(true);

            // add rows to the table
            for (Ingredient ingredient : Utils.getIngredients()) {
                ingredientModel.addRow(new Object[]{ingredient.getName(), ingredient.getCalories(), ingredient.getUnit(), ingredient.getDescription(), ingredient.isVegetarian(), ingredient.isVegan(), ingredient.isGlutenFree(), ingredient.isDairyFree(), ingredient.isNutFree(), ingredient.isRedMeatFree()});
            }
            JScrollPane scrollPane = new JScrollPane(ingredientTable);
            centerPanel.add(scrollPane, BorderLayout.CENTER);

            JButton addIngredientButton = new JButton("Add Ingredient");
            addIngredientButton.addActionListener(e1 -> showAddIngredientDialog());

            JButton deleteIngredientButton = new JButton("Delete Ingredient");
            deleteIngredientButton.addActionListener(e1 -> {
                int selectedRow = ingredientTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select an ingredient to delete.");
                    return;
                }
                String name = (String) ingredientModel.getValueAt(selectedRow, 0);
                for (Ingredient ingredient : Utils.getIngredients()) {
                    if (ingredient.getName().equals(name)) {
                        Utils.getIngredients().remove(ingredient);
                        break;
                    }
                }
                ingredientModel.removeRow(selectedRow);
            });

            JButton editIngredientButton = new JButton("Edit Ingredient");
            editIngredientButton.addActionListener(e1 -> {
                int selectedRow = ingredientTable.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select an ingredient to edit.");
                    return;
                }
                String name = (String) ingredientModel.getValueAt(selectedRow, 0);
                for (Ingredient ingredient : Utils.getIngredients()) {
                    if (ingredient.getName().equals(name)) {
                        JTextField nameField = new JTextField(ingredient.getName());
                        JTextField caloriesField = new JTextField(String.valueOf(ingredient.getCalories()));
                        JTextField unitField = new JTextField(ingredient.getUnit());
                        JTextField descriptionField = new JTextField(ingredient.getDescription());
                        JTextField isVegetarianField = new JTextField(String.valueOf(ingredient.isVegetarian()));
                        JTextField isVeganField = new JTextField(String.valueOf(ingredient.isVegan()));
                        JTextField isGlutenFreeField = new JTextField(String.valueOf(ingredient.isGlutenFree()));
                        JTextField isDairyFreeField = new JTextField(String.valueOf(ingredient.isDairyFree()));
                        JTextField isNutFreeField = new JTextField(String.valueOf(ingredient.isNutFree()));
                        JTextField isRedMeatFreeField = new JTextField(String.valueOf(ingredient.isRedMeatFree()));

                        JPanel panel = new JPanel(new GridLayout(0, 1));
                        panel.add(new JLabel("Name:"));
                        panel.add(nameField);
                        panel.add(new JLabel("Calories:"));
                        panel.add(caloriesField);
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

                        int result = JOptionPane.showConfirmDialog(null, panel, "Edit Ingredient",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        if (result == JOptionPane.OK_OPTION) {
                            // update the ingredient
                            try {
                                ingredient.setName(nameField.getText());
                                ingredient.setCalories(Float.parseFloat(caloriesField.getText()));
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
                            ingredientModel.setValueAt(ingredient.getUnit(), selectedRow, 2);
                            ingredientModel.setValueAt(ingredient.getDescription(), selectedRow, 3);
                            ingredientModel.setValueAt(ingredient.isVegetarian(), selectedRow, 4);
                            ingredientModel.setValueAt(ingredient.isVegan(), selectedRow, 5);
                            ingredientModel.setValueAt(ingredient.isGlutenFree(), selectedRow, 6);
                            ingredientModel.setValueAt(ingredient.isDairyFree(), selectedRow, 7);
                            ingredientModel.setValueAt(ingredient.isNutFree(), selectedRow, 8);
                            ingredientModel.setValueAt(ingredient.isRedMeatFree(), selectedRow, 9);
                        }
                    }
                }
            });


            // button panel to show all buttons next to each other
            JPanel buttonPanel = new JPanel();
//            buttonPanel.setLayout(new FlowLayout());
            buttonPanel.add(addIngredientButton);
            buttonPanel.add(deleteIngredientButton);
            buttonPanel.add(editIngredientButton);

            // Add buttonPanel to the frame
            add(buttonPanel, BorderLayout.SOUTH);
            
            centerPanel.revalidate();
            centerPanel.repaint();
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showAddIngredientDialog() {
        JTextField nameField = new JTextField();
        JTextField caloriesField = new JTextField();
        JTextField unitField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField isVegetarianField = new JTextField();
        JTextField isVeganField = new JTextField();
        JTextField isGlutenFreeField = new JTextField();
        JTextField isDairyFreeField = new JTextField();
        JTextField isNutFreeField = new JTextField();
        JTextField isRedMeatFreeField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Calories:"));
        panel.add(caloriesField);
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

        int result = JOptionPane.showConfirmDialog(null, panel, "Add New Ingredient",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                float calories = Float.parseFloat(caloriesField.getText());
                String unit = unitField.getText();
                String description = descriptionField.getText();
                boolean isVegetarian = Boolean.parseBoolean(isVegetarianField.getText());
                boolean isVegan = Boolean.parseBoolean(isVeganField.getText());
                boolean isGlutenFree = Boolean.parseBoolean(isGlutenFreeField.getText());
                boolean isDairyFree = Boolean.parseBoolean(isDairyFreeField.getText());
                boolean isNutFree = Boolean.parseBoolean(isNutFreeField.getText());
                boolean isRedMeatFree = Boolean.parseBoolean(isRedMeatFreeField.getText());

                // Create a new Ingredient object and add it to the list
                Ingredient newIngredient = new Ingredient(name, Utils.getLoggedInUser().getName(), calories, unit, description, isVegetarian, isVegan, isGlutenFree, isDairyFree, isNutFree, isRedMeatFree);
                ingredientModel.addRow(new Object[]{newIngredient.getName(), newIngredient.getCalories(), newIngredient.getUnit(),
                        newIngredient.getDescription(), newIngredient.getUnit(), newIngredient.isVegetarian(), newIngredient.isVegan(),
                        newIngredient.isGlutenFree(), newIngredient.isDairyFree(), newIngredient.isNutFree(), newIngredient.isRedMeatFree()
                });
                Utils.getIngredients().add(newIngredient);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
                return;
            }
        }
    }
}
