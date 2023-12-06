package controller;
import view.WelcomeFrame;

// controller for WelcomeFrame class
public class WelcomeFrameController {
    // this class will handle the logic for the WelcomeFrame class
    private WelcomeFrame welcomeFrame;

    public WelcomeFrameController() {
        welcomeFrame = new WelcomeFrame();

        welcomeFrame.getSignUpButton().addActionListener(e -> {
            new SignUpFrameController();
            welcomeFrame.dispose();
        });
        welcomeFrame.getSignInButton().addActionListener(e -> {
            new SignInFrameController();
            welcomeFrame.dispose();
        });
    }
}
