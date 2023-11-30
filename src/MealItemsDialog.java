import javax.swing.*;
import java.util.ArrayList;

public class MealItemsDialog extends JDialog {
    public MealItemsDialog(ArrayList<MealItem> mealItems) {
        // set the title
        setTitle("Meal Items");

        // set the layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // add the meal items
        for (MealItem mealItem : mealItems) {
            add(new JLabel(mealItem.getIngredient().getName() + " - " + mealItem.getQuantity() + " " + mealItem.getIngredient().getUnit()));
        }

        // set the size
        setSize(300, 300);

        // set the location
        setLocationRelativeTo(null);

        // set the visibility
        setVisible(true);
    }
}
