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

    public SignUpPanel() {
        setLayout(new GridLayout(8, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        //

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
        JButton generateRandomPassword = getGenerateRandomPassword();

        JButton signUpButton = new JButton("Sign Up");

        // Add components to the panel
        add(generateRandomPassword);
        add(signUpButton);

        signUpButton.addActionListener(e -> {
            try {
                String name = nameField.getText();
                String username = usernameField.getText();
                String email = emailField.getText();
                String mobile = mobileField.getText();
                String role = (String) rolesComboBox.getSelectedItem();
                String password = new String(passwordField.getPassword());

                // Perform user registration logic here
                if (role == null) {
                    JOptionPane.showMessageDialog(null, "Please select a role", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Utils.registerUser(name, username, email, mobile, role, password);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error during registration: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                JOptionPane.showMessageDialog(null, "User registered successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

                // close the sign up window
                Window window = SwingUtilities.getWindowAncestor(this);
                window.dispose();

                // open the sign in window
                new SignInFrame();
            } catch (InvalidParameterException ex) {
                JOptionPane.showMessageDialog(null, "Error during registration: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // add option to go back to sign in page
        JButton signInButton = new JButton("Sign In");
        signInButton.addActionListener(e -> {
            // close the sign up window
            new SignInFrame();
            SwingUtilities.getWindowAncestor(this).dispose();
        });

        add(signInButton);
    }

    private JButton getGenerateRandomPassword() {
        JButton generateRandomPassword = new JButton("Generate Random Password");
        generateRandomPassword.addActionListener(e -> {
            // Add code to generate random password here
            // use securerandom class to generate random password

            String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lowerCase = "abcdefghijklmnopqrstuvwxyz";
            String numbers = "0123456789";
            String specialChars = "!@#$%^&*_=+-/.?<>)";

            String values = upperCase + lowerCase + numbers + specialChars;

            // Using securerandom method
            SecureRandom random = new SecureRandom();
            char[] password = new char[10];

            for(int i = 0; i < 10; i++) {
                password[i] = values.charAt(random.nextInt(values.length()));
            }

            // Display the generated password in the password field in a dialog box
            JDialog dialog = new JDialog();
            dialog.setLayout(new FlowLayout());
            dialog.add(new JLabel("Your password is: " + new String(password)));
            dialog.setSize(300, 200);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);

            passwordField.setText(new String(password));
        });
        return generateRandomPassword;
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

    public String getPassword() {
        return new String(passwordField.getPassword());
    }
}
