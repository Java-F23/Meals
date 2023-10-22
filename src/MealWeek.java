import java.util.ArrayList;
public class MealWeek {
    private ArrayList<MealDay> mealDays;

    public MealWeek(ArrayList<MealDay> mealDays) {
        this.mealDays = mealDays;
    }

    public void setMealDays(ArrayList<MealDay> mealDays) {
        this.mealDays = mealDays;
    }

    public ArrayList<MealDay> getMealDays() {
        return mealDays;
    }

    public void setMealDay(MealDay mealDay, int day) {
        mealDays.set(day, mealDay);
    }

    public MealDay getMealDay(int day) {
        return mealDays.get(day);
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < mealDays.size(); i++) {
            output += "Day " + (i + 1) + "\n" + mealDays.get(i) + "\n";
        }
        return output;
    }
}
