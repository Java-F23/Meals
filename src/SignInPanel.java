import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SignInPanel extends JPanel {
    private JTextField usernameField;
    private JPasswordField passwordField;
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
        JButton signInButton = getSignInButton();

        // sign up button
        JButton signUpButton = new JButton("Not registered yet? Sign up here.");
        signUpButton.addActionListener(e -> {
            new SignUpFrame();
            SwingUtilities.getWindowAncestor(this).dispose();
        });

        // Add components to the panel
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(signInButton);
        add(signUpButton);
    }

    private JButton getSignInButton() {
        JButton signInButton = new JButton("Sign In");
        signInButton.addActionListener(e -> {
            // check username and password against users arraylist
            String username = usernameField.getText();
            String password = new String (passwordField.getPassword());

            User user = SignIn(username, password);
            if (user != null) {
                // open the corresponding frame
                if (user instanceof Chef) {
                    new ChefFrame();
                } else if (user instanceof MealPrepper) {
                    new MealPrepperFrame();
                }
                // close the sign in frame
                SwingUtilities.getWindowAncestor(this).dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        });
        return signInButton;
    }

    private User SignIn(String username, String password) {
        ArrayList<User> users = new ArrayList<>();
        users.addAll(Utils.getChefs());
        users.addAll(Utils.getMealPreppers());

        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                Utils.setLoggedInUser(u);
                return u;
            }
        }
        return null;
    }
}
