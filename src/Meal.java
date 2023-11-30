import java.io.Serializable;
import java.util.ArrayList;

public class Meal implements Serializable {
    private String name;
    private String chefName;
    private ArrayList<MealItem> mealItems;
    private int preparationTime;
    private int cookingTime;
    private String instructions;
    private String cuisine;
    private int bookmarkCount;
//    private final ArrayList<Review> reviews;

    public Meal(String name, String chefName, ArrayList<MealItem> mealItems, int preparationTime, int cookingTime, String instructions, String cuisine) {
        this.name = name;
        this.chefName = chefName;
        this.mealItems = mealItems;
        this.preparationTime = preparationTime;
        this.cookingTime = cookingTime;
        this.instructions = instructions;
        this.cuisine = cuisine;
//            this.reviews = new ArrayList<>();
    }

    public void addMealItem(MealItem mealItem) {
        mealItems.add(mealItem);
    }

    public String getName() {
        return name;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public int getTotalTime() {
        return preparationTime + cookingTime;
    }

    public String getInstructions() {
        return instructions;
    }

    public String getCuisine() {
        return cuisine;
    }

    public ArrayList<MealItem> getMealItems() {
        return mealItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Meal Name: ").append(name).append("\n");
        sb.append("Meal Items: ").append("\n");
        for (MealItem mealItem : mealItems) {
            sb.append(mealItem.toString()).append("\n");
        }
        return sb.toString();
    }
}
