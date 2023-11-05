import javax.swing.*;

public class SignUpFrame extends JFrame {
    public SignUpFrame() {
        setTitle("Sign Up");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);

        // Create an instance of SignUpPanel
        SignUpPanel signUpPanel = new SignUpPanel();

        // Add the SignUpPanel to the frame
        add(signUpPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
