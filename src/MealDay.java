public class MealDay {
    // this class is used to store the meals for a day in the meal plan. each day has a breakfast, lunch, and dinner.
    private Meal breakfast;
    private Meal lunch;
    private Meal dinner;

    public MealDay(Meal breakfast, Meal lunch, Meal dinner) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public Meal getBreakfast() {
        return breakfast;
    }

    public Meal getLunch() {
        return lunch;
    }

    public Meal getDinner() {
        return dinner;
    }

    public void setBreakfast(Meal breakfast) {
        this.breakfast = breakfast;
    }

    public void setLunch(Meal lunch) {
        this.lunch = lunch;
    }

    public void setDinner(Meal dinner) {
        this.dinner = dinner;
    }

    @Override
    public String toString() {
        return "Breakfast: " + breakfast + "\nLunch: " + lunch + "\nDinner: " + dinner;
    }
}
