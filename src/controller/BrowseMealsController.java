package controller;
import view.BrowseMealsPanel;

import javax.swing.*;

public class BrowseMealsController {
    private BrowseMealsPanel browseMealsPanel;

    public BrowseMealsController(BrowseMealsPanel browseMealsPanel) {
        this.browseMealsPanel = browseMealsPanel;

        // add action listeners to the buttons
        for (JButton[] buttons : browseMealsPanel.getMealButtons().values()) {
            buttons[0].addActionListener(e -> {
                System.out.println("View Ingredients button clicked");
            });

            buttons[1].addActionListener(e -> {
                System.out.println("View Details button clicked");
            });

            buttons[2].addActionListener(e -> {
                System.out.println("Add to Meal Plan button clicked");
            });
        }
    }
}
