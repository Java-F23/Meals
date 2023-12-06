package helper;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

public class Utils {
    // logged in user
    private static User loggedInUser = null;

    public static void saveToFile(Serializable object, String fileName) {
        // use FileHandler class to save object to file
        FileHandler<Serializable> fileHandler = new FileHandler<>(fileName);
        if (fileHandler.AddNew(object)){
            System.out.println("Saved to file " + fileName);
        } else {
            System.out.println("Error saving to file " + fileName);
        }
    }

    public static<T extends Serializable> void loadFromFile(String fileName, ArrayList<T> list) {
        // use FileHandler class to load object from file
        FileHandler<T> fileHandler = new FileHandler<>(fileName);
        ArrayList<T> loadedList = fileHandler.readFile();
        if (loadedList != null) {
            list.addAll(loadedList);
        }
    }

    public static<T extends Serializable> void saveEditedToFile(ArrayList<T> list, String fileName) {
        // use FileHandler class to edit object in file by rewriting the whole file with a given list
        FileHandler<T> fileHandler = new FileHandler<>(fileName);
        if (fileHandler.SaveEdited(list)){
            System.out.println("Saved to file " + fileName);
        } else {
            System.out.println("Error saving to file " + fileName);
        }
    }

    public static void registerUser(String name, String username, String email, String phone, String role,  String password) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        // username must be unique (no duplicates) in users list
        ArrayList<User> users = new ArrayList<>();
        loadFromFile(paths.CHEFS.getPath(), users);
        loadFromFile(paths.MEAL_PREPPERS.getPath(), users);

        for (User u : users) {
            if (u.getUsername().equals(username)) {
                throw new IllegalArgumentException("Username already exists");
            }
        }

        if (password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }

        try{
            isValidPhoneNumber(phone);
        } catch (InvalidPhoneNumberException e) {
            throw new IllegalArgumentException("Invalid phone number format");
        }

        if (role.equalsIgnoreCase("Chef")) {
            Chef chef = new Chef(name, email, username, password, phone);
            saveToFile(chef, paths.CHEFS.getPath());
        } else if (role.equalsIgnoreCase("User")) {
            MealPrepper mealPrepper = new MealPrepper(name, email, username, password, phone);
            saveToFile(mealPrepper, paths.MEAL_PREPPERS.getPath());
        } else {
            throw new IllegalArgumentException("Invalid role");
        }
    }

    private static boolean isValidEmail(String email) throws ArrayIndexOutOfBoundsException{
        // email validation using regex
        // Email format: <username>@<domain>
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    private static void isValidPhoneNumber(String phone) throws InvalidPhoneNumberException {
        // phone number validation
        // Phone number format: <01><9-digit number>
        if (!phone.matches("^(01)[0-9]{9}$")) {
            throw new InvalidPhoneNumberException("Invalid phone number format");
        }
    }

    public static void setLoggedInUser(User loggedInUser) {
        Utils.loggedInUser = loggedInUser;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static ArrayList<Chef> getChefs() {
        // load chefs from file
        ArrayList<Chef> chefs = new ArrayList<>();
        loadFromFile(paths.CHEFS.getPath(), chefs);
        return chefs;
    }

    public static ArrayList<MealPrepper> getMealPreppers() {
        // load meal preppers from file
        ArrayList<MealPrepper> mealPreppers = new ArrayList<>();
        loadFromFile(paths.MEAL_PREPPERS.getPath(), mealPreppers);
        return mealPreppers;
    }

    public static ArrayList<Ingredient> getIngredients() {
        // load ingredients from file
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        loadFromFile(paths.INGREDIENTS.getPath(), ingredients);
        return ingredients;
    }

    public static void initializeData() throws DuplicateError {
        // users
        saveToFile(new Chef("Shady", "s@s.s", "shady", "shady", "01111111111"), paths.CHEFS.getPath());
        saveToFile(new Chef("Youssef", "y@y.y", "youssef", "youssef", "01211111111"), paths.CHEFS.getPath());
        saveToFile(new MealPrepper("Saleh", "ss@s.s", "saleh", "saleh", "01311111111"), paths.MEAL_PREPPERS.getPath());

        // Ingredients
        Ingredient salt = new Ingredient("Salt", "shady", 0, 0, 0, 0, "g", "Salt is a mineral composed primarily of sodium chloride, a chemical compound belonging to the larger class of salts; salt in its natural form as a crystalline mineral is known as rock salt or halite.", true, true, true, true, true, true);
        Ingredient cheese = new Ingredient("Cheese", "shady", 403f,25.4f, 33.82f, 1.28f, "g", "Cheese is a dairy product derived from milk that is produced in a wide range of flavors, textures, and forms by coagulation of the milk protein casein.", true, false, true, false, true, true);
        Ingredient lettuce = new Ingredient("Lettuce", "shady", 15f, 0.15f, 1.36f, 0.15f, "g", "Lettuce is an annual plant of the daisy family, Asteraceae. It is most often grown as a leaf vegetable, but sometimes for its stem and seeds.", true, true, true, true, true, true);
        Ingredient tomato = new Ingredient("Tomato", "shady", 18f, 0.88f, 3.89f, 0.2f, "g", "The tomato is the edible, often red, berry of the plant Solanum lycopersicum, commonly known as a tomato plant.", true, true, true, true, true, true);
        Ingredient flour = new Ingredient("Flour", "shady", 3.52f, 0.44f, 0.15f, 0.01f, "g", "Flour is a powder made by grinding raw grains, roots, beans, nuts, or seeds. Flours are used to make many different foods.", true, true, false, true, true, true);
        Ingredient tomatoSauce = new Ingredient("Tomato Sauce", "shady", 18f, 0.88f, 3.89f, 0.2f, "g", "Tomato sauce, refers to any of a very large number of sauces made primarily from tomatoes, usually to be served as part of a dish.", true, true, true, true, true, true);
        Ingredient mozzarella = new Ingredient("Mozzarella", "shady", 300f, 22.2f, 22.2f, 1.5f, "g", "Mozzarella is a traditionally southern Italian cheese made from Italian buffalo's milk by the pasta filata method.", true, false, true, false, true, true);
        Ingredient pepperoni = new Ingredient("Pepperoni", "shady", 500f,27.5f, 27.5f, 2.5f, "g", "Pepperoni, also known as pepperoni sausage, is an American variety of salami, usually made from cured pork and beef mixed together.", false, false, true, true, true, true);
        Ingredient chicken = new Ingredient("Chicken", "shady", 239f, 27.3f, 0f, 14.1f, "g", "The chicken is a type of domesticated fowl, a subspecies of the red junglefowl. It is one of the most common and widespread domestic animals, with a total population of more than 19 billion as of 2011.", false, false, true, true, true, true);
        Ingredient beef = new Ingredient("Beef", "shady", 250f, 26.1f, 0f, 15.2f, "g", "Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.", false, false, true, true, true, false);

        saveToFile(salt, paths.INGREDIENTS.getPath());
        saveToFile(cheese, paths.INGREDIENTS.getPath());
        saveToFile(lettuce, paths.INGREDIENTS.getPath());
        saveToFile(tomato, paths.INGREDIENTS.getPath());
        saveToFile(flour, paths.INGREDIENTS.getPath());
        saveToFile(tomatoSauce, paths.INGREDIENTS.getPath());
        saveToFile(mozzarella, paths.INGREDIENTS.getPath());
        saveToFile(pepperoni, paths.INGREDIENTS.getPath());
        saveToFile(chicken, paths.INGREDIENTS.getPath());
        saveToFile(beef, paths.INGREDIENTS.getPath());

        // Meals
        Meal salad = new Meal("Salad", "shady", new HashMap<>(), 10, 0, "Mix all ingredients together.", "American");
        salad.addIngredient(salt, 10f);
        salad.addIngredient(cheese, 10f);
        salad.addIngredient(lettuce, 10f);
        salad.addIngredient(tomato, 10f);

        Meal pizza = new Meal("Pizza", "shady", new HashMap<>(), 30, 30, "gently shape the dough into a pizza circle, spread the tomato sauce on the dough, add the mozzarella and pepperoni, bake for 30 minutes at 350 degrees Fahrenheit.", "Italian");
        pizza.addIngredient(flour, 10f);
        pizza.addIngredient(tomatoSauce, 10f);
        pizza.addIngredient(mozzarella, 10f);
        pizza.addIngredient(pepperoni, 10f);
        pizza.addIngredient(cheese, 10f);

        Meal pasta = new Meal("Pasta", "shady", new HashMap<>(), 30, 30, "Salt water. Add pasta to water. Boil for 10 minutes then serve with beef and shredded cheese.", "Italian");
        pasta.addIngredient(flour, 50f);
        pasta.addIngredient(beef, 10f);
        pasta.addIngredient(cheese, 25f);

        saveToFile(salad, paths.MEALS.getPath());
        saveToFile(pizza, paths.MEALS.getPath());
        saveToFile(pasta, paths.MEALS.getPath());
    }

    public static void addLogo(JPanel panel, String source, int dimension) {
        try {
            File file = new File(source);
            ImageIcon logo = new ImageIcon(Objects.requireNonNull(file.getAbsolutePath()));
            JLabel logoLabel = new JLabel(logo);
            logoLabel.setPreferredSize(new Dimension(dimension, dimension));
            panel.add(logoLabel, BorderLayout.CENTER);
        } catch (Exception e) {
            System.out.println("Error loading logo");
        }
    }

    public static Ingredient getIngredientByName(String ingredientName) {
        ArrayList<Ingredient> ingredients = getIngredients();
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equals(ingredientName)) {
                return ingredient;
            }
        }
        return null;
    }

    public static ArrayList<Meal> getMeals() {
        // load meals from file
        ArrayList<Meal> meals = new ArrayList<>();
        loadFromFile(paths.MEALS.getPath(), meals);
        return meals;
    }

    public static Meal getMealByName(String mealName) {
        ArrayList<Meal> meals = getMeals();
        for (Meal meal : meals) {
            if (meal.getName().equals(mealName)) {
                return meal;
            }
        }
        return null;
    }
}
