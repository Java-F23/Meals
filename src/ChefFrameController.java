import javax.swing.*;
import java.awt.*;

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
            centerPanel.revalidate();
            centerPanel.repaint();
        });

        chefFrame.getManageIngredients().addActionListener(e -> {
            centerPanel.removeAll();
            centerPanel.add(new JLabel("Welcome, " + Utils.getLoggedInUser().getName()), BorderLayout.NORTH);
            centerPanel.add(new JLabel("This is the ingredients table"), BorderLayout.CENTER);
            centerPanel.add(ChefPanelContent.generateIngredientsTable());
            JPanel buttonPanel = ChefPanelContent.generateButtonPanel();
            // Add buttonPanel to the frame
            chefFrame.add(buttonPanel, BorderLayout.SOUTH);
            centerPanel.revalidate();
            centerPanel.repaint();
        });
    }
}
