import java.io.Serializable;

public class Ingredient implements Serializable {
    public static class Nutrients implements Serializable {
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
    // fields
    private String name;
    private final String chefName;
    private Nutrients nutrients;
    private String unit;
    private String description;
    private boolean isVegetarian;
    private boolean isVegan;
    private boolean isGlutenFree;
    private boolean isDairyFree;
    private boolean isNutFree;
    private boolean isRedMeatFree;
    private boolean unspecifiedDietaryRestrictions;

    // constructor
    public Ingredient(String name, String chefName, Nutrients nutrients, String unit, String description, boolean isVegetarian, boolean isVegan, boolean isGlutenFree, boolean isDairyFree, boolean isNutFree, boolean isRedMeatFree) throws DuplicateError {
        // check unique name
        for (Ingredient ingredient : Utils.getIngredients()) {
            if (ingredient.getName().equals(name)) {
                throw new DuplicateError(name);
            }
        }

        this.name = name;
        this.chefName = chefName;
        this.nutrients = nutrients;
        this.unit = unit;
        this.description = description;
        this.isVegetarian = isVegetarian;
        this.isVegan = isVegan;
        this.isGlutenFree = isGlutenFree;
        this.isDairyFree = isDairyFree;
        this.isNutFree = isNutFree;
        this.isRedMeatFree = isRedMeatFree;
        this.unspecifiedDietaryRestrictions = false;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public boolean isDairyFree() {
        return isDairyFree;
    }

    public boolean isNutFree() {
        return isNutFree;
    }

    public boolean isRedMeatFree() {
        return isRedMeatFree;
    }

    public String getName() {
        return name;
    }

    public String getChefName() {
        return chefName;
    }

    public String getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }

    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }

    public void setDairyFree(boolean dairyFree) {
        isDairyFree = dairyFree;
    }

    public void setNutFree(boolean nutFree) {
        isNutFree = nutFree;
    }

    public void setRedMeatFree(boolean redMeatFree) {
        isRedMeatFree = redMeatFree;
    }

    @Override
    public String toString() {
        return name;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }
}
