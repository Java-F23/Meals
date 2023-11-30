import java.io.Serializable;

public class Nutrients implements Serializable {
    private float calories;
    private float fat;
    private float carbohydrates;
    private float protein;

    public Nutrients(float calories, float fat, float carbohydrates, float protein) {
        this.calories = calories;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
    }

    public float getCalories() {
        return calories;
    }

    public float getFat() {
        return fat;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public float getProtein() {
        return protein;
    }

    public void setCalories(float calories) {
        this.calories = calories;
    }

    public void setFat(float fat) {
        this.fat = fat;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setProtein(float protein) {
        this.protein = protein;
    }

    public Nutrients add(Nutrients nutrients) {
        this.calories += nutrients.getCalories();
        this.fat += nutrients.getFat();
        this.carbohydrates += nutrients.getCarbohydrates();
        this.protein += nutrients.getProtein();
        return this;
    }

    public Nutrients multiply(float multiplier) {
        this.calories *= multiplier;
        this.fat *= multiplier;
        this.carbohydrates *= multiplier;
        this.protein *= multiplier;
        return this;
    }

    @Override
    public String toString() {
        return "Nutrients{" +
                "calories=" + calories +
                ", fat=" + fat +
                ", carbohydrates=" + carbohydrates +
                ", protein=" + protein +
                '}';
    }
}
