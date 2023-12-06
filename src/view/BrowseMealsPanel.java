package view;
import model.*;
import helper.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class BrowseMealsPanel extends JPanel {
    // The BrowseMealsPanel class is a panel that displays all the meals that are available to the user.
    // the list of meals will be displayed in a vertical scrollable list

    // list of meals with their corresponding buttons
    private HashMap<Meal, JComponent[]> mealButtons;

    public BrowseMealsPanel() {
        mealButtons = new HashMap<>();

        setLayout(new BorderLayout());
        JLabel label = new JLabel("Browse Meals");
        add(label, BorderLayout.NORTH);

        JPanel mealListPanel = new JPanel(new GridLayout(0, 1));
        // list of meals
        List<Meal> meals = Utils.getMeals();
        // for each meal, add a label that says the meal name
        // for each meal, add a button that says "View Ingredients"
        // for each meal, add a button that says "View Details"
        // for each meal, add a button that says "Add to Meal Plan"
        for (Meal meal : meals) {
            JPanel mealPanel = new JPanel(new FlowLayout());

            JLabel mealNameLabel = new JLabel(meal.getName());
            mealPanel.add(mealNameLabel);

            JButton viewIngredientsButton = new JButton("View Ingredients");
            mealPanel.add(viewIngredientsButton);

            JButton viewDetailsButton = new JButton("View Details");
            mealPanel.add(viewDetailsButton);

            JButton addToMealPlanButton = new JButton("Add to Meal Plan");
            mealPanel.add(addToMealPlanButton);

            JButton addToShoppingListButton = new JButton("Add to Shopping List");
            addToShoppingListButton.setToolTipText("Add all ingredients to shopping list without affecting meal plan");
            mealPanel.add(addToShoppingListButton);

            // bookmark checkbutton
            JCheckBox bookmarkButton = new JCheckBox("Bookmark");
            mealPanel.add(bookmarkButton);

            JButton reviewButton = new JButton("Review");
            mealPanel.add(reviewButton);

            mealListPanel.add(mealPanel);

            // add the meal and its buttons to the hashmap
            mealButtons.put(meal, new JComponent[]{viewIngredientsButton, viewDetailsButton, addToMealPlanButton, addToShoppingListButton, bookmarkButton, reviewButton});
        }

        add(new JScrollPane(mealListPanel), BorderLayout.CENTER);
    }

    public HashMap<Meal, JComponent[]> getMealButtons() {
        return mealButtons;
    }
}
