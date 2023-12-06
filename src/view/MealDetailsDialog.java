package view;
import model.Meal;

import javax.swing.*;
import java.util.HashMap;

public class MealDetailsDialog extends JDialog {
    public MealDetailsDialog(Meal meal) {
        // set the title
        setTitle("Meal details");

        // set the layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // add the meal details
        add(new JLabel("Meal name: " + meal.getName()));
        add(new JLabel("Total calories: " + meal.getTotalCalories()));
        add(new JLabel("Total fat: " + meal.getTotalFat()));
        add(new JLabel("Total carbohydrates: " + meal.getTotalCarbohydrates()));
        add(new JLabel("Total protein: " + meal.getTotalProtein()));
        add(new JLabel("Cook time: " + meal.getCookingTime()));
        add(new JLabel("Prep time: " + meal.getPreparationTime()));
        add(new JLabel("Instructions: " + meal.getInstructions()));
        add(new JLabel("Cuisine: " + meal.getCuisine()));

        // set the size
        setSize(300, 300);

        // set the location
        setLocationRelativeTo(null);

        // set the visibility
        setVisible(true);
    }
}
