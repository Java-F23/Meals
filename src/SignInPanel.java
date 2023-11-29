import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SignInPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
    JButton signInButton;
    JButton signUpButton;
    SignInPanel() {
        setLayout(new GridLayout(6, 1, 10, 5));
        setBorder(BorderFactory.createEmptyBorder(30, 10, 40, 10));

        // Email field
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        // Password field
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        // Sign in button
        signInButton = new JButton("Sign In");

        // sign up button
        signUpButton = new JButton("Not registered yet? Sign up here.");

        // Add components to the panel
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(signInButton);
        add(signUpButton);
    }

    public String getUsernameFieldText() {
        return usernameField.getText();
    }

    public String getPasswordFieldText() {
        return new String(passwordField.getPassword());
    }

    public JButton getSignInButton() {
        return signInButton;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }
}
