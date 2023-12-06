package view;

import helper.ChefPanelContent;

import javax.swing.*;
import java.awt.*;

public class AddMealIngredientsFrame extends JFrame {
    private JTable ingredientsTable;
    private JButton addIngredientButton;
    private JTextField quantityField;
    public AddMealIngredientsFrame() {
        super("Add Meal Ingredients");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        // can't access other windows until this one is closed
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);

        JPanel ingredientsPanel = new JPanel();
        ingredientsPanel.setLayout(new BorderLayout());

        // add the ingredients table to the panel
        JScrollPane ingredientsTablePane = ChefPanelContent.generateIngredientsTable();
        ingredientsTable = null;
        try {
            ingredientsTable = (JTable) ingredientsTablePane.getViewport().getComponent(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No ingredients found", "Error", JOptionPane.ERROR_MESSAGE);
        }
        ingredientsPanel.add(ingredientsTablePane, BorderLayout.CENTER);

        // add the input field and the button to the panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel quantityLabel = new JLabel("Quantity");
        quantityField = new JTextField(10);
        addIngredientButton = new JButton("Add Ingredient");

        inputPanel.add(quantityLabel);
        inputPanel.add(quantityField);
        inputPanel.add(addIngredientButton);

        // add the input panel to the ingredients panel
        ingredientsPanel.add(inputPanel, BorderLayout.SOUTH);

        add(ingredientsPanel);
    }

    public JTable getIngredientsTable() {
        return ingredientsTable;
    }

    public JButton getAddIngredientButton() {
        return addIngredientButton;
    }

    public JTextField getQuantityField() {
        return quantityField;
    }
}
