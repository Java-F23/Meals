package controller;
import model.*;
import view.*;
import helper.Utils;

import javax.swing.*;
import java.util.ArrayList;

public class SignInFrameController {
    // this class will handle the logic for the SignInFrame class
    private SignInFrame signInFrame;

    public SignInFrameController() {
        signInFrame = new SignInFrame();

        SignInPanel signInPanel = signInFrame.getSignInPanel();

        signInPanel.getSignInButton().addActionListener(e -> {
            String username = signInPanel.getUsernameFieldText();
            String password = signInPanel.getPasswordFieldText();

            User user = SignIn(username, password);
            if (user != null) {
                // open the corresponding frame
                if (user instanceof Chef) {
                    new ChefFrameController();
                } else if (user instanceof MealPrepper) {
                    new MealPrepperController();
                }
                // close the sign in frame
                signInFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        signInPanel.getSignUpButton().addActionListener(e -> {
            // open the sign up window
            new SignUpFrameController();
            // close the sign in window
            signInFrame.dispose();
        });
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
