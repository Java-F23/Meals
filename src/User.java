import java.lang.reflect.Array;
import java.util.ArrayList;

public class User {
    int id;
    static int nextId = 1;
    String name;
    String email;
    String username;
    String password;
    String phone;
    char role;
    private ArrayList<Meal> bookmarkedMeals;
    private ArrayList<Ingredient> shoppingList;
    private ArrayList<Float> shoppingListQuantities;
    private ArrayList<MealDay> currentWeekMealPlan;

    public User(String name, String email, String password, String username, String phone, char role) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.role = role;
        if (role == 'u') {
            this.bookmarkedMeals = new ArrayList<Meal>();
            this.shoppingList = new ArrayList<Ingredient>();
            this.currentWeekMealPlan = new ArrayList<MealDay>(7);
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

    public void setCurrentWeekMealPlan(ArrayList<MealDay> mealPlan) {
        this.currentWeekMealPlan = mealPlan;
    }

    public ArrayList<MealDay> getCurrentWeekMealPlan() {
        return this.currentWeekMealPlan;
    }
}
