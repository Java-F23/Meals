import javax.swing.*;
import java.awt.*;

public class WelcomeFrame extends JFrame {
    // this frame will include a welcome message and a button to sign up or sign in
    private JButton signUpButton;
    private JButton signInButton;

    public WelcomeFrame() {
        super("Welcome to Meals");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Box verticalBox = Box.createVerticalBox();

        JLabel welcomeLabel = new JLabel("Welcome to Meals");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox.add(Box.createVerticalGlue());
        verticalBox.add(welcomeLabel);
        verticalBox.add(Box.createRigidArea(new Dimension(0, 20)));

        signUpButton = new JButton("Sign Up");
        signUpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox.add(signUpButton);
        verticalBox.add(Box.createRigidArea(new Dimension(0, 10)));

        signInButton = new JButton("Sign In");
        signInButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        verticalBox.add(signInButton);
        verticalBox.add(Box.createVerticalGlue());

        setLayout(new BorderLayout());
        add(verticalBox, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JButton getSignInButton() {
        return signInButton;
    }
}
