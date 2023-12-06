package helper;

public enum paths {
    // this enum will contain all the paths to the files
    // that will be used in the project
    LOGO("resources/cookease.png"),
    LOGO_SMALL("resources/cookeaseSmall.png"),
    CHEFS("resources/chefs.ser"),
    MEAL_PREPPERS("resources/mealPreppers.ser"),
    INGREDIENTS("resources/ingredients.ser"),
    MEALS("resources/meals.ser"),
    SHOPPING_LIST("resources/shoppingList.ser");

    private final String path;

    paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
