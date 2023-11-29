import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.security.InvalidParameterException;
import java.security.SecureRandom;

// this is the controller for the sign up frame
public class SignUpFrameController {
    private SignUpFrame signUpFrame;

    public SignUpFrameController() {
        signUpFrame = new SignUpFrame();

        SignUpPanel signUpPanel = signUpFrame.getSignUpPanel();

        signUpPanel.getSignUpButton().addActionListener(e -> {
            try {
                String name = signUpPanel.getNameFieldText();
                String username = signUpPanel.getUsernameFieldText();
                String email = signUpPanel.getEmailFieldText();
                String mobile = signUpPanel.getMobileFieldText();
                String role = signUpPanel.getRole();
                String password = signUpPanel.getPasswordFieldText();

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

//                if (role.equalsIgnoreCase("Chef")) {
//                    new ChefFrameController();
//                } else if (role.equalsIgnoreCase("User")) {
//                    new MealPrepperFrameController();
//                }

                signUpFrame.dispose();

                // open the sign in window
                new SignInFrameController();
            } catch (InvalidParameterException ex) {
                JOptionPane.showMessageDialog(null, "Error during registration: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        signUpPanel.getGenerateRandomPasswordButton().addActionListener(e -> {
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

            // copy to clipboard button
            JButton copyToClipboardButton = new JButton("Copy to Clipboard");
            dialog.add(copyToClipboardButton);
            JLabel messageLabel = new JLabel();
            dialog.add(messageLabel);
            copyToClipboardButton.addActionListener(e1 -> {
                // copy the generated password to the clipboard
                StringSelection stringSelection = new StringSelection(new String(password));
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

                // show a message that the password has been copied to the clipboard on the dialog box
                messageLabel.setText("Password copied to clipboard");
            });
            dialog.setSize(300, 200);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);

            signUpPanel.setPasswordFieldText(new String(password));
        });

        signUpPanel.getSignInButton().addActionListener(e -> {
            new SignInFrameController();
            signUpFrame.dispose();
        });
    }
}
