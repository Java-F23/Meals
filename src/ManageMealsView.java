import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

public class ManageMealsView {
    private JButton addMeal, viewMealIngredients;
    private JTable mealTable;

    public ManageMealsView(JPanel panel) {
        panel.add(new JLabel("Welcome, " + Utils.getLoggedInUser().getName()), BorderLayout.NORTH);
        panel.add(new JLabel("This is the meals table"), BorderLayout.CENTER);

        // Add the meals table
        DefaultTableModel mealModel = new DefaultTableModel();
        mealModel.addColumn("Name");
        mealModel.addColumn("Chef");
        mealModel.addColumn("Prep Time");
        mealModel.addColumn("Cook Time");
        mealModel.addColumn("Instructions");
        mealModel.addColumn("Cuisine");
        mealModel.addColumn("# Bookmarks");

        mealTable = new JTable(mealModel);
        mealTable.setDefaultEditor(Object.class, null);

        mealTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        mealTable.setFillsViewportHeight(true);

        // add rows to the table
        for (Meal meal : Utils.getMeals()) {
            mealModel.addRow(new Object[]{meal.getName(), meal.getChefName(), meal.getPreparationTime(), meal.getCookingTime(), meal.getInstructions(), meal.getCuisine(), meal.getBookmarkCount()});
        }

        JScrollPane mealsTablePane = new JScrollPane(mealTable);
        panel.add(mealsTablePane, BorderLayout.CENTER);

        viewMealIngredients = new JButton("View Ingredients");
        addMeal = new JButton("Add Meal");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(addMeal);
        buttonPanel.add(viewMealIngredients);

        panel.add(buttonPanel, BorderLayout.SOUTH);
    }

    public JButton getAddMealButton() {
        return addMeal;
    }

    public JButton getViewMealIngredientsButton() {
        return viewMealIngredients;
    }

    public JTable getMealTable() {
        return mealTable;
    }

    public DefaultTableModel getMealModel() {
        return (DefaultTableModel) mealTable.getModel();
    }
}
