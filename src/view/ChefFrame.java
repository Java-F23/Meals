package view;
import helper.Utils;

import javax.swing.*;
import java.awt.*;

public class ChefFrame extends JFrame {
    JPanel centerPanel;
    JButton signOutButton;
    JMenuItem manageMeals;
    JMenuItem manageIngredients;

    public ChefFrame() {
        // this frame will include a navigation menu and a button to sign out
        // the navigation menu will include buttons to manage meals, manage ingredients, and generate reports
        // when the user clicks on the manage meals button, the large panel in the center will open with a table of all meals
        super("Chef");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the navigation menu
        JMenuBar menuBar = new JMenuBar();
        JMenu manageMenu = new JMenu("Manage");
        manageMeals = new JMenuItem("Meals");
        manageIngredients = new JMenuItem("Ingredients");
        manageMenu.add(manageMeals);
        manageMenu.add(manageIngredients);
        menuBar.add(manageMenu);
        setJMenuBar(menuBar);

        // generate reports menu
        JMenu generateReports = new JMenu("Generate Reports");
        JMenuItem generateMeals = new JMenuItem("Popularity of Meals");
        JMenuItem generateIngredients = new JMenuItem("User Feedback");
        generateReports.add(generateMeals);
        generateReports.add(generateIngredients);
        menuBar.add(generateReports);

        signOutButton = new JButton("Sign Out");
        menuBar.add(signOutButton);

        // Create the large panel in the center
        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        centerPanel.add(new JLabel("Welcome, " + Utils.getLoggedInUser().getName()), BorderLayout.NORTH);

        Utils.addLogo(centerPanel, "../cookease.png", 150);

        add(centerPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JButton getSignOutButton() {
        return signOutButton;
    }

    public JMenuItem getManageMeals() {
        return manageMeals;
    }

    public JMenuItem getManageIngredients() {
        return manageIngredients;
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }
}
