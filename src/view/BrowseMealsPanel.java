package view;
import model.*;
import helper.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BrowseMealsPanel extends JPanel {
    // The BrowseMealsPanel class is a panel that displays all the meals that are available to the user.
    // the list of meals will be displayed in a vertical scrollable list

    JButton viewIngredientsButton;
    JButton viewDetailsButton;
    JButton addToMealPlanButton;

    public BrowseMealsPanel() {
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

            viewIngredientsButton = new JButton("View Ingredients");
            mealPanel.add(viewIngredientsButton);

            viewDetailsButton = new JButton("View Details");
            mealPanel.add(viewDetailsButton);

            addToMealPlanButton = new JButton("Add to Meal Plan");
            mealPanel.add(addToMealPlanButton);

            mealListPanel.add(mealPanel);
        }

        add(new JScrollPane(mealListPanel), BorderLayout.CENTER);
    }
}
