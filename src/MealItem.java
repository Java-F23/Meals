import java.io.Serializable;

public class MealItem implements Serializable {
    private Ingredient ingredient;
    private float quantity;

    public MealItem(Ingredient ingredient, float quantity) {
        this.ingredient = ingredient;
        this.quantity = quantity;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return ingredient.getName() + " " + quantity + " " + ingredient.getUnit();
    }

    // get nutrients method that returns the nutrients for the ingredient multiplied by the quantity
    // this is used to calculate the total nutrients for a meal
    public Ingredient.Nutrients getNutrients() {
        return ingredient.getNutrients().multiply(quantity);
    }
}
