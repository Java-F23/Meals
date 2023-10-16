public class Ingredient {
    // fields
    private final String name;
    private final float calories;
    private final String unit;
    private final String description;
    private final boolean isVegetarian;
    private final boolean isVegan;
    private final boolean isGlutenFree;
    private final boolean isDairyFree;
    private final boolean isNutFree;
    private final boolean isRedMeatFree;
    private boolean unspecifiedDietaryRestrictions;

    // constructor
    public Ingredient(String name, float calories, String unit, String description, boolean isVegetarian, boolean isVegan, boolean isGlutenFree, boolean isDairyFree, boolean isNutFree, boolean isRedMeatFree) {
        this.name = name;
        this.calories = calories;
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

    // constructor for ingredients without dietary restrictions
    public Ingredient(String name, int calories, String unit, String description) {
        this(name, calories, unit, description, false, false, false, false, false, false);
        this.unspecifiedDietaryRestrictions = true;
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

    public float getCalories() {
        return calories;
    }

    public String getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }

    public boolean hasUnspecifiedRestrictions() {
        return unspecifiedDietaryRestrictions;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getDetails() {
        String details = "";
        details += "Name: " + name + "\n";
        details += "Calories: " + calories + " calories per " + unit + "\n";
        details += "Unit: " + unit + "\n";
        details += "Description: " + description + "\n";
        if (isVegetarian) {
            details += "Vegetarian: Yes\n";
        } else {
            details += "Vegetarian: No\n";
        }
        if (isVegan) {
            details += "Vegan: Yes\n";
        } else {
            details += "Vegan: No\n";
        }
        if (isGlutenFree) {
            details += "Gluten Free: Yes\n";
        } else {
            details += "Gluten Free: No\n";
        }
        if (isDairyFree) {
            details += "Dairy Free: Yes\n";
        } else {
            details += "Dairy Free: No\n";
        }
        if (isNutFree) {
            details += "Nut Free: Yes\n";
        } else {
            details += "Nut Free: No\n";
        }
        if (isRedMeatFree) {
            details += "Red Meat Free: Yes\n";
        } else {
            details += "Red Meat Free: No\n";
        }
        return details;
    }
}