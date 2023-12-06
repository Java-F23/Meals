package view;
import model.*;
import helper.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BrowseMealsPanel extends JPanel {
    // The BrowseMealsPanel class is a panel that displays all the meals that are available to the user.
    // the panel will have a table of meals. there will be a panel of buttons at the bottom of the table that will allow the user to add the meal to their bookmarked meals, add the meal to their current meal plan, or view the ingredients of the meal

    private JButton addMealToBookmarkedMealsButton;
    private JButton removeMealFromBookmarkedMealsButton;
    private JButton addMealToCurrentMealPlanButton;
    private JButton viewMealIngredientsButton;
    private JButton viewMealDetailsButton;
    private JTable mealTable;
    private HashMap<Integer, Meal> mealMap;
    private HashSet<Meal> meals;
    public BrowseMealsPanel(HashSet<Meal> meals) {
        this.meals = meals;
        mealMap = new HashMap<>();
        setLayout(new BorderLayout());
        setBackground(Color.GRAY);

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
        int i = 0;
        for (Meal meal : meals) {
            mealModel.addRow(new Object[]{meal.getName(), meal.getChefName(), meal.getPreparationTime(), meal.getCookingTime(), meal.getInstructions(), meal.getCuisine(), meal.getBookmarkCount()});
            mealMap.put(i, meal);
            i++;
        }

        JScrollPane mealsTablePane = new JScrollPane(mealTable);
        add(mealsTablePane, BorderLayout.CENTER);

        // Add the buttons panel
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        addMealToBookmarkedMealsButton = new JButton("Add to Bookmarked Meals");
        removeMealFromBookmarkedMealsButton = new JButton("Remove from Bookmarked Meals");
        addMealToCurrentMealPlanButton = new JButton("Add to Current Meal Plan");
        viewMealIngredientsButton = new JButton("View Ingredients");
        viewMealDetailsButton = new JButton("View Details");

        buttonsPanel.add(viewMealDetailsButton);
        buttonsPanel.add(addMealToBookmarkedMealsButton);
        buttonsPanel.add(removeMealFromBookmarkedMealsButton);
        buttonsPanel.add(addMealToCurrentMealPlanButton);
        buttonsPanel.add(viewMealIngredientsButton);

        add(buttonsPanel, BorderLayout.SOUTH);
    }

    public JButton getAddMealToBookmarkedMealsButton() {
        return addMealToBookmarkedMealsButton;
    }

    public JButton getRemoveMealFromBookmarkedMealsButton() {
        return removeMealFromBookmarkedMealsButton;
    }

    public JButton getAddMealToCurrentMealPlanButton() {
        return addMealToCurrentMealPlanButton;
    }

    public JButton getViewMealIngredientsButton() {
        return viewMealIngredientsButton;
    }

    public JTable getMealTable() {
        return mealTable;
    }

    public DefaultTableModel getMealModel() {
        return (DefaultTableModel) mealTable.getModel();
    }

    public HashMap<Integer, Meal> getMealMap() {
        return mealMap;
    }

    public HashSet<Meal> getMeals() {
        return meals;
    }
}
