import javax.swing.*;
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
            centerPanel.add(new JLabel("Welcome, " + Utils.getLoggedInUser().getName()), BorderLayout.NORTH);
            centerPanel.add(new JLabel("This is the meals table"), BorderLayout.CENTER);

            // Add the meals table
            JScrollPane mealsTablePane = ChefPanelContent.generateMealsTable();
            centerPanel.add(mealsTablePane, BorderLayout.CENTER);

            // Add view ingredient button actionlistener for each meal
            ArrayList<JButton> viewIngredientButtons = new ArrayList<>();

            JButton addMeal = new JButton("Add Meal");
            addMeal.addActionListener(e1 -> new AddMealFrameController());

            centerPanel.add(addMeal, BorderLayout.SOUTH);

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
