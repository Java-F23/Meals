import javax.swing.*;

public class SignInFrame extends JFrame {

    private SignInPanel signInPanel;
    public SignInFrame() {
        setTitle("Sign In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);

        signInPanel = new SignInPanel();
        add(signInPanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public SignInPanel getSignInPanel() {
        return signInPanel;
    }
}
