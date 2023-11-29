import javax.swing.*;
import java.awt.*;
import java.security.InvalidParameterException;
import java.security.SecureRandom;

public class SignUpPanel extends JPanel {
    private final JTextField nameField;
    private final JTextField usernameField;
    private final JTextField emailField;
    private final JTextField mobileField;
    private final JComboBox<String> rolesComboBox;
    private final JPasswordField passwordField;

    // buttons
    private final JButton signUpButton;
    private final JButton generateRandomPasswordButton;
    private final JButton signInButton;

    public SignUpPanel() {
        setLayout(new GridLayout(8, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Name field
        addLabelAndField("Name:");
        nameField = new JTextField(20);
        add(nameField);

        // username field
        addLabelAndField("Username:");
        usernameField = new JTextField(20);
        add(usernameField);

        // Email field
        addLabelAndField("Email:");
        emailField = new JTextField(20);
        add(emailField);

        // Mobile field
        addLabelAndField("Mobile:");
        mobileField = new JTextField(20);
        add(mobileField);

        // User roles dropdown
        addLabelAndField("User Roles:");
        String[] roles = {"Chef", "User"};
        rolesComboBox = new JComboBox<>(roles);
        add(rolesComboBox);

        // Password field
        addLabelAndField("Password:");
        passwordField = new JPasswordField(20);
        add(passwordField);

        // Sign up button
        generateRandomPasswordButton = new JButton("Generate Random Password");
        signUpButton = new JButton("Sign Up");

        // Add components to the panel
        add(generateRandomPasswordButton);
        add(signUpButton);

        // add option to go back to sign in page
        JLabel signInLabel = new JLabel("Already have an account?");
        signInLabel.setHorizontalAlignment(JLabel.RIGHT);
        add(signInLabel);

        signInButton = new JButton("Sign In");
        add(signInButton);
    }

    // Utility method to add label and field to the panel
    private void addLabelAndField(String labelText) {
        JLabel label = new JLabel(labelText);
        label.setHorizontalAlignment(JLabel.LEFT);
        add(label);
    }

    // Methods to get field values
    public String getNameFieldText() {
        return nameField.getText();
    }

    public String getUsernameFieldText() {
        return usernameField.getText();
    }

    public String getEmailFieldText() {
        return emailField.getText();
    }

    public String getMobileFieldText() {
        return mobileField.getText();
    }

    public String getRole() {
        return (String) rolesComboBox.getSelectedItem();
    }

    public String getPasswordFieldText() {
        return new String(passwordField.getPassword());
    }
    public void setPasswordFieldText(String password) {
        passwordField.setText(password);
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JButton getSignInButton() {
        return signInButton;
    }

    public JButton getGenerateRandomPasswordButton() {
        return generateRandomPasswordButton;
    }
}
