package view;
import helper.Utils;

import javax.swing.*;
import java.awt.*;

public class MealPrepperFrame extends JFrame {
    // The MealPrepperFrame class is the main frame for the MealPrepper user type. It will contain a header, side menu, and a main panel that displays corresponding information.
    // The header will contain the logo of the application, the user's name, a logout button, and a settings button. The settings button will allow the user to set their dietary preferences.
    // The side menu will contain buttons for viewing the browse meals, shopping list, bookmarked meals, current meal plan, and meal plan history.
    // The main panel will have the current meal plan panel displayed by default. The user can click on the buttons in the side menu to change the main panel to display the corresponding information.

    private HeaderPanel headerPanel;
    private MainPanel mainPanel;
    private SideMenuPanel sideMenuPanel;
    private CurrentMealPlanPanel currentMealPlanPanel;
    private BrowseMealsPanel browseMealsPanel;
    private ShoppingListPanel shoppingListPanel;
    private BookmarkedMealsPanel bookmarkedMealsPanel;
    private MealPlanHistoryPanel mealPlanHistoryPanel;
    private CardLayout cardLayout;

    private JButton browseMealsButton;
    private JButton shoppingListButton;
    private JButton bookmarkedMealsButton;
    private JButton currentMealPlanButton;
    private JButton mealPlanHistoryButton;

    private final int width = 1000;
    private final int height = 600;
    private final int navBarHeight = 50;
    private final int sideBarWidth = 200;

    public class HeaderPanel extends JPanel {
        public HeaderPanel() {
            setLayout(new BorderLayout());
            setPreferredSize(new Dimension(width, navBarHeight));
            setBackground(Color.GRAY);

            JLabel titleLabel = new JLabel("Home");
            titleLabel.setFont(titleLabel.getFont().deriveFont(20f));
            titleLabel.setHorizontalAlignment(JLabel.CENTER);

            add(titleLabel, BorderLayout.CENTER);

            JPanel logoPanel = new JPanel();
            logoPanel.setLayout(new BorderLayout());
            logoPanel.setPreferredSize(new Dimension(sideBarWidth, navBarHeight));
            Utils.addLogo(logoPanel, "../cookeaseSmall.png", navBarHeight);
            logoPanel.setBackground(Color.GRAY);

            add(logoPanel, BorderLayout.WEST);

            JPanel userPanel = new JPanel();
            userPanel.setLayout(new BorderLayout());
            userPanel.setPreferredSize(new Dimension(sideBarWidth, navBarHeight));
            userPanel.setBackground(Color.GRAY);

            JLabel usernameLabel = new JLabel(Utils.getLoggedInUser().getUsername());
            usernameLabel.setFont(usernameLabel.getFont().deriveFont(16f));
            usernameLabel.setHorizontalAlignment(JLabel.CENTER);

            userPanel.add(usernameLabel, BorderLayout.CENTER);

            JButton logoutButton = new JButton("Logout");

            userPanel.add(logoutButton, BorderLayout.EAST);

            add(userPanel, BorderLayout.EAST);
        }
    }

    public class SideMenuPanel extends JPanel {
        // the side menu panel will have a list of buttons that will be used to navigate the application. buttons will include: browse meals, shopping list, bookmarked meals, current meal plan, and meal plan history.

        public SideMenuPanel() {
            // the side menu panel constructor will initialize the panel and its components.
            setLayout(new GridLayout(5, 1, 10, 10));
            setPreferredSize(new Dimension(sideBarWidth, height));
            setBackground(Color.LIGHT_GRAY);


            browseMealsButton = new JButton("Browse Meals");
            shoppingListButton = new JButton("Shopping List");
            bookmarkedMealsButton = new JButton("Bookmarked Meals");
            currentMealPlanButton = new JButton("Current Meal Plan");
            mealPlanHistoryButton = new JButton("Meal Plan History");

            add(browseMealsButton);
            add(shoppingListButton);
            add(bookmarkedMealsButton);
            add(currentMealPlanButton);
            add(mealPlanHistoryButton);
        }

        public JButton getBrowseMealsButton() {
            return browseMealsButton;
        }

        public JButton getShoppingListButton() {
            return shoppingListButton;
        }

        public JButton getBookmarkedMealsButton() {
            return bookmarkedMealsButton;
        }

        public JButton getCurrentMealPlanButton() {
            return currentMealPlanButton;
        }

        public JButton getMealPlanHistoryButton() {
            return mealPlanHistoryButton;
        }
    }

    public class MainPanel extends JPanel {
        // The MealPrepperPanel class will be the main panel that will display the corresponding information based on the button clicked in the side menu.
        // It will use the card layout to switch between the different panels.
        private String currentMealPlanPanelName = "currentMealPlanPanel";
        private String browseMealsPanelName = "browseMealsPanel";
        private String shoppingListPanelName = "shoppingListPanel";
        private String bookmarkedMealsPanelName = "bookmarkedMealsPanel";
        private String mealPlanHistoryPanelName = "mealPlanHistoryPanel";

        public MainPanel() {
            cardLayout = new CardLayout();
            setLayout(cardLayout);

            currentMealPlanPanel = new CurrentMealPlanPanel();
            browseMealsPanel = new BrowseMealsPanel();
            shoppingListPanel = new ShoppingListPanel();
            bookmarkedMealsPanel = new BookmarkedMealsPanel();
            mealPlanHistoryPanel = new MealPlanHistoryPanel();

            add(currentMealPlanPanel, currentMealPlanPanelName);
            add(browseMealsPanel, browseMealsPanelName);
            add(shoppingListPanel, shoppingListPanelName);
            add(bookmarkedMealsPanel, bookmarkedMealsPanelName);
            add(mealPlanHistoryPanel, mealPlanHistoryPanelName);
        }

        public String getCurrentMealPlanPanelName() {
            return currentMealPlanPanelName;
        }

        public String getBrowseMealsPanelName() {
            return browseMealsPanelName;
        }

        public String getShoppingListPanelName() {
            return shoppingListPanelName;
        }

        public String getBookmarkedMealsPanelName() {
            return bookmarkedMealsPanelName;
        }

        public String getMealPlanHistoryPanelName() {
            return mealPlanHistoryPanelName;
        }
    }

    public MealPrepperFrame() {
        super("Meals");
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        headerPanel = new HeaderPanel();
        sideMenuPanel = new SideMenuPanel();
        mainPanel = new MainPanel();

        add(headerPanel, BorderLayout.NORTH);
        add(sideMenuPanel, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    // getters
    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }

    public SideMenuPanel getSideMenuPanel() {
        return sideMenuPanel;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public CurrentMealPlanPanel getCurrentMealPlanPanel() {
        return currentMealPlanPanel;
    }

    public BrowseMealsPanel getBrowseMealsPanel() {
        return browseMealsPanel;
    }

    public ShoppingListPanel getShoppingListPanel() {
        return shoppingListPanel;
    }

    public BookmarkedMealsPanel getBookmarkedMealsPanel() {
        return bookmarkedMealsPanel;
    }

    public MealPlanHistoryPanel getMealPlanHistoryPanel() {
        return mealPlanHistoryPanel;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }
}
