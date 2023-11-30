import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AddMealFrame extends JFrame {
    private JLabel nameLabel, descriptionLabel, CuisineLabel, prepTimeLabel, cookTimeLabel,
            instructionsLabel, chosenIngredientsLabel;
    private JTextField nameField, descriptionField, CuisineField, prepTimeField, cookTimeField;
    private JTextArea instructionsArea;
    private JTable chosenIngredientsTable;
    private JScrollPane chosenIngredientsTablePane;
    private JButton addIngredientsButton, addMealButton;

    public AddMealFrame() {
        // set the frame's properties
        setTitle("Add Meal");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 4, 5, 5)); // 8 rows, 2 columns, horizontal and vertical gap of 5 pixels

        // initialize the components
        nameLabel = new JLabel("Name");
        nameField = new JTextField(20);
        descriptionLabel = new JLabel("Description");
        descriptionField = new JTextField(20);
        CuisineLabel = new JLabel("Cuisine");
        CuisineField = new JTextField(20);
        prepTimeLabel = new JLabel("Prep Time");
        prepTimeField = new JTextField(20);
        cookTimeLabel = new JLabel("Cook Time");
        cookTimeField = new JTextField(20);
        instructionsLabel = new JLabel("Instructions");
        instructionsArea = new JTextArea(5, 20);
        chosenIngredientsLabel = new JLabel("Chosen Ingredients");
        chosenIngredientsTablePane = new JScrollPane();
        chosenIngredientsTable = new JTable();
        addIngredientsButton = new JButton("Add Ingredients");
        addMealButton = new JButton("Add Meal");

        // set the components' properties
        instructionsArea.setLineWrap(true);
        instructionsArea.setWrapStyleWord(true);
        chosenIngredientsTablePane.setPreferredSize(new Dimension(200, 100));
        chosenIngredientsTablePane.setMinimumSize(new Dimension(200, 100));
        chosenIngredientsTablePane.setMaximumSize(new Dimension(200, 100));
        chosenIngredientsTablePane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        chosenIngredientsTablePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // set up the table
        DefaultTableModel tableModel = new DefaultTableModel();
        chosenIngredientsTable.setModel(tableModel);
        chosenIngredientsTable.setDefaultEditor(Object.class, null);
        tableModel.addColumn("Name");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Unit");

        chosenIngredientsTablePane.setViewportView(chosenIngredientsTable);

        // add the components to the panel
        add(nameLabel);
        add(nameField);
        add(descriptionLabel);
        add(descriptionField);
        add(CuisineLabel);
        add(CuisineField);
        add(prepTimeLabel);
        add(prepTimeField);
        add(cookTimeLabel);
        add(cookTimeField);
        add(instructionsLabel);
        add(instructionsArea);
        add(chosenIngredientsLabel);
        add(chosenIngredientsTablePane);
        add(addIngredientsButton);
        add(addMealButton);

        // set the frame's visibility
        setVisible(true);
    }

    public String getNameFieldText() {
        return nameField.getText();
    }

    public String getCuisineFieldText() {
        return CuisineField.getText();
    }

    public String getPrepTimeFieldText() {
        return prepTimeField.getText();
    }

    public String getCookTimeFieldText() {
        return cookTimeField.getText();
    }

    public String getInstructionsAreaText() {
        return instructionsArea.getText();
    }

    public JTable getChosenIngredientsTable() {
        return chosenIngredientsTable;
    }

    public JButton getAddIngredientsButton() {
        return addIngredientsButton;
    }

    public JButton getAddMealButton() {
        return addMealButton;
    }

}
