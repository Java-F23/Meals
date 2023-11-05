import javax.swing.*;

public class SignInFrame extends JFrame {


    public SignInFrame() {
        setTitle("Sign In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);

        SignInPanel panel = new SignInPanel();
        add(panel);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignInFrame();
    }
}
