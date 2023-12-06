package view;
import model.Ingredient;

import javax.swing.*;
import java.util.HashMap;

public class ingredientsDialog extends JDialog {
    public ingredientsDialog(HashMap<Ingredient, Float> ingredients) {
        // set the title
        setTitle("Meal Items");

        // set the layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // add the meal items
        for (Ingredient ingredient : ingredients.keySet()) {
            add(new JLabel(ingredient.getName() + " - " + ingredients.get(ingredient) + " " + ingredient.getUnit()));
        }

        // set the size
        setSize(300, 300);

        // set the location
        setLocationRelativeTo(null);

        // set the visibility
        setVisible(true);
    }
}
