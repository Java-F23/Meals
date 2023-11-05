// TODO: refactor meal class to use the new RecipeItem instead of ingredient class
// TODO: the RecipeItem class should have a reference to the ingredient and the quantity
// TODO: refactor any code that used the old way of storing ingredients in a meal
// TODO: use enum for cuisines

public class Main {
    public static void main(String[] args) {
        Utils.initializeData();
        new WelcomeFrame();
    }
}