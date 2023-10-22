import java.util.ArrayList;

public class User {
    private final String name;
    private final String email;
    private final String username;
    private final String password;
    private final String phone;
    private final char role;
    private ArrayList<Meal> bookmarkedMeals;
    private ArrayList<Ingredient> shoppingList;
    private ArrayList<Float> shoppingListQuantities;
    private ArrayList<MealWeek> mealPlanHistory;

    public User(String name, String email,  String username,String password, String phone, char role) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.role = role;
        if (role == 'u') {
            this.bookmarkedMeals = new ArrayList<>();
            this.shoppingList = new ArrayList<>();
            this.shoppingListQuantities = new ArrayList<>();
            this.mealPlanHistory = new ArrayList<>();
        }
    }

    public void addMealToBookmarks(Meal meal) {
        this.bookmarkedMeals.add(meal);
    }

    public void removeMealFromBookmarks(Meal meal) {
        this.bookmarkedMeals.remove(meal);
    }

    public ArrayList<Meal> getBookmarkedMeals() {
        return this.bookmarkedMeals;
    }

    public void addIngredientsToShoppingList(ArrayList<Ingredient> ingredient, ArrayList<Float> quantity) {
        this.shoppingList.addAll(ingredient);
        this.shoppingListQuantities.addAll(quantity);
    }

    public void setCurrentWeekMealPlan(MealWeek mealPlan) {
        this.mealPlanHistory.add(mealPlan);
    }

    public MealWeek getCurrentWeekMealPlan() {
        return this.mealPlanHistory.get(this.mealPlanHistory.size() - 1);
    }

    public ArrayList<MealWeek> getMealPlanHistory() {
        return this.mealPlanHistory;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public char getRole() {
        return role;
    }

    public void printShoppingList() {
        // combine repeating ingredients in meals and add their quantities
        ArrayList<Ingredient> combinedIngredients = new ArrayList<>();
        ArrayList<Float> combinedQuantities = new ArrayList<>();
        for (int i = 0; i < this.shoppingList.size(); i++) {
            if (combinedIngredients.contains(this.shoppingList.get(i))) {
                int index = combinedIngredients.indexOf(this.shoppingList.get(i));
                combinedQuantities.set(index, combinedQuantities.get(index) + this.shoppingListQuantities.get(i));
            } else {
                combinedIngredients.add(this.shoppingList.get(i));
                combinedQuantities.add(this.shoppingListQuantities.get(i));
            }
        }

        // print the shopping list
        System.out.println("Shopping List:");
        for (int i = 0; i < combinedIngredients.size(); i++) {
            System.out.println(combinedIngredients.get(i).getName() + " - " + combinedQuantities.get(i) + " " + combinedIngredients.get(i).getUnit());
        }
    }
}
