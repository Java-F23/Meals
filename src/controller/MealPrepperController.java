package controller;
import helper.Utils;
import view.MealPrepperFrame;
public class MealPrepperController {
    // This is the controller class for the MealPrepperFrame.
    // It is responsible for creating the frame and adding the panels to it.
    // It is also responsible for switching between the panels based on the button clicked in the side menu.

    private MealPrepperFrame mpf;

    public MealPrepperController() {
        mpf = new MealPrepperFrame();
        new BrowseMealsController(mpf.getBrowseMealsPanel());
//        new CurrentMealPlanController(mpf.getCurrentMealPlanPanel());
//        new ShoppingListController(mpf.getShoppingListPanel());
//        new BookmarkedMealsController(mpf.getBookmarkedMealsPanel());
//        new MealPlanHistoryController(mpf.getMealPlanHistoryPanel());

        // Add action listeners to the buttons in the side menu
        // each button will switch to the corresponding panel using cardlayout
        mpf.getSideMenuPanel().getCurrentMealPlanButton().addActionListener(e -> {
            mpf.getCardLayout().show(mpf.getMainPanel(), mpf.getMainPanel().getCurrentMealPlanPanelName());
        });
        mpf.getSideMenuPanel().getBrowseMealsButton().addActionListener(e -> {
            mpf.getCardLayout().show(mpf.getMainPanel(), mpf.getMainPanel().getBrowseMealsPanelName());
        });
        mpf.getSideMenuPanel().getShoppingListButton().addActionListener(e -> {
            mpf.getCardLayout().show(mpf.getMainPanel(), mpf.getMainPanel().getShoppingListPanelName());
        });
        mpf.getSideMenuPanel().getBookmarkedMealsButton().addActionListener(e -> {
            mpf.getCardLayout().show(mpf.getMainPanel(), mpf.getMainPanel().getBookmarkedMealsPanelName());
        });
        mpf.getSideMenuPanel().getMealPlanHistoryButton().addActionListener(e -> {
            mpf.getCardLayout().show(mpf.getMainPanel(), mpf.getMainPanel().getMealPlanHistoryPanelName());
        });

        mpf.getLogout().addActionListener(e -> {
            Utils.setLoggedInUser(null);
            new WelcomeFrameController();
            mpf.dispose();
        });

        // Add action listeners to the buttons in the current meal plan panel
        // each button will switch to the corresponding panel using cardlayout
//        mpf.getMainPanel().getCurrentMealPlanPanel().getEditMealPlanButton().addActionListener(e -> mpf.getCardLayout().show(mpf.getMainPanel(), mpf.getMainPanel().getBrowseMealsPanelName()));
//        mpf.getMainPanel().getCurrentMealPlanPanel().getGenerateMealPlanButton().addActionListener(e -> mpf.getCardLayout().show(mpf.getMainPanel(), mpf.getMainPanel().getBrowseMealsPanelName()));
//        mpf.getMainPanel().getCurrentMealPlanPanel().getPrintMealPlanButton().addActionListener(e -> mpf.getCardLayout().show(mpf.getMainPanel(), mpf.getMainPanel().getBrowseMealsPanelName()));
//        mpf.getMainPanel().getCurrentMealPlanPanel().getSaveMealPlanButton().addActionListener(e -> mpf.getCardLayout().show(mpf.getMainPanel(), mpf.getMainPanel().getBrowseMealsPanelName()));

    }
}
