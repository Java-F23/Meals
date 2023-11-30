import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ChefFrameController {
    // this class will handle the logic for the ChefFrame class
    private ChefFrame chefFrame;

    public ChefFrameController() {
        chefFrame = new ChefFrame();
        JPanel centerPanel = chefFrame.getCenterPanel();

        chefFrame.getSignOutButton().addActionListener(e -> {
            Utils.setLoggedInUser(null);
            new WelcomeFrameController();
            chefFrame.dispose();
        });

        chefFrame.getManageMeals().addActionListener(e -> {
            centerPanel.removeAll();
            ManageMealsView manageMealsView = new ManageMealsView(centerPanel);

            manageMealsView.getAddMealButton().addActionListener(e1 -> new AddMealFrameController());
            manageMealsView.getViewMealIngredientsButton().addActionListener(e1 -> {
                // get the selected row
                int selectedRow = manageMealsView.getMealTable().getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a meal to view its ingredients");
                } else {
                    // get the meal name
                    String mealName = (String) manageMealsView.getMealTable().getValueAt(selectedRow, 0);
                    // get the meal
                    Meal meal = Utils.getMealByName(mealName);
                    if (meal == null) {
                        JOptionPane.showMessageDialog(null, "Error fetching the Meal. Please try again later.");
                        return;
                    }

                    // get the items
                    ArrayList<MealItem> mealItems = meal.getMealItems();

                    // create a dialog to display the ingredients items
                    MealItemsDialog mealItemsDialog = new MealItemsDialog(mealItems);
                }
            });

            centerPanel.revalidate();
            centerPanel.repaint();
        });

        chefFrame.getManageIngredients().addActionListener(e -> {
            centerPanel.removeAll();
            centerPanel.add(new JLabel("Welcome, " + Utils.getLoggedInUser().getName()), BorderLayout.NORTH);
            centerPanel.add(new JLabel("This is the ingredients table"), BorderLayout.CENTER);
            centerPanel.add(ChefPanelContent.generateIngredientsTable());
            JPanel buttonPanel = ChefPanelContent.generateIngredientButtonPanel();
            // Add buttonPanel to the frame
            centerPanel.add(buttonPanel, BorderLayout.SOUTH);
            centerPanel.revalidate();
            centerPanel.repaint();
        });
    }
}
