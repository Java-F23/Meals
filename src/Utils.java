import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

public class Utils {
    // logged in user
    private static User loggedInUser = null;

    private static final String CHEFS_FILE = "chefs.ser";
    private static final String MEAL_PREPPERS_FILE = "mealPreppers.ser";
    private static final String INGREDIENTS_FILE = "ingredients.ser";
    private static final String MEALS_FILE = "meals.ser";

    public static String getChefsFile() {
        return CHEFS_FILE;
    }

    public static String getMealPreppersFile() {
        return MEAL_PREPPERS_FILE;
    }

    public static String getIngredientsFile() {
        return INGREDIENTS_FILE;
    }

    public static String getMealsFile() {
        return MEALS_FILE;
    }

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
        loadFromFile(CHEFS_FILE, users);
        loadFromFile(MEAL_PREPPERS_FILE, users);

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
            saveToFile(chef, CHEFS_FILE);
        } else if (role.equalsIgnoreCase("User")) {
            MealPrepper mealPrepper = new MealPrepper(name, email, username, password, phone);
            saveToFile(mealPrepper, MEAL_PREPPERS_FILE);
        } else {
            throw new IllegalArgumentException("Invalid role");
        }
    }

    private static boolean isValidEmail(String email) throws ArrayIndexOutOfBoundsException{
        // email validation
        // Email format: <username>@<domain>

        // check if email contains @
        if (!email.contains("@")) {
            return false;
        }

        // split email into username and domain
        String[] emailParts = email.split("@");

        String username = emailParts[0];
        String domain = emailParts[1];

        // check if username is empty
        if (username.isEmpty()) {
            return false;
        }

        // check if domain contains .
        if (!domain.contains(".")) {
            return false;
        }

        // check if domain is empty
        return !domain.startsWith(".") && !domain.endsWith(".");
    }

    private static void isValidPhoneNumber(String phone) throws InvalidPhoneNumberException {
        // phone number validation
        // Phone number format: <01><9-digit number>

        // check if phone number contains 11 digits
        if (phone.length() != 11) {
            throw new InvalidPhoneNumberException("Phone number must have 11 digits");
        }

        // check if phone number starts with 01
        if (!phone.startsWith("01")) {
            throw new InvalidPhoneNumberException("Phone number must start with '01'");
        }

        // check if phone number contains only digits
        for (int i = 2; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                throw new InvalidPhoneNumberException("Phone number must contain only digits");
            }
        }

    }

    public static void setLoggedInUser(User loggedInUser) {
        Utils.loggedInUser = loggedInUser;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void logout() {
        loggedInUser = null;
    }

    public static ArrayList<Chef> getChefs() {
        // load chefs from file
        ArrayList<Chef> chefs = new ArrayList<>();
        loadFromFile(CHEFS_FILE, chefs);
        return chefs;
    }

    public static ArrayList<MealPrepper> getMealPreppers() {
        // load meal preppers from file
        ArrayList<MealPrepper> mealPreppers = new ArrayList<>();
        loadFromFile(MEAL_PREPPERS_FILE, mealPreppers);
        return mealPreppers;
    }

    public static ArrayList<Ingredient> getIngredients() {
        // load ingredients from file
        ArrayList<Ingredient> ingredients = new ArrayList<>();
        loadFromFile(INGREDIENTS_FILE, ingredients);
        return ingredients;
    }

    public static void initializeData() throws DuplicateError {
        // users
        saveToFile(new Chef("Shady", "s@s.s", "shady", "shady", "01111111111"), CHEFS_FILE);
        saveToFile(new Chef("Youssef", "y@y.y", "youssef", "youssef", "01211111111"), CHEFS_FILE);
        saveToFile(new MealPrepper("Saleh", "ss@s.s", "saleh", "saleh", "01311111111"), MEAL_PREPPERS_FILE);

        // Ingredients
        Ingredient salt = new Ingredient("Salt", "shady", 0, "g", "Salt is a mineral composed primarily of sodium chloride, a chemical compound belonging to the larger class of salts; salt in its natural form as a crystalline mineral is known as rock salt or halite.", true, true, true, true, true, true);
        Ingredient cheese = new Ingredient("Cheese", "shady", 4.02f, "g", "Cheese is a dairy product derived from milk that is produced in a wide range of flavors, textures, and forms by coagulation of the milk protein casein.", true, false, true, false, true, true);
        Ingredient lettuce = new Ingredient("Lettuce", "shady", 0.05f, "g", "Lettuce is an annual plant of the daisy family, Asteraceae. It is most often grown as a leaf vegetable, but sometimes for its stem and seeds.", true, true, true, true, true, true);
        Ingredient tomato = new Ingredient("Tomato", "shady", 0.22f, "g", "The tomato is the edible, often red, berry of the plant Solanum lycopersicum, commonly known as a tomato plant.", true, true, true, true, true, true);
        Ingredient flour = new Ingredient("Flour", "shady", 4.55f, "g", "Flour is a powder made by grinding raw grains, roots, beans, nuts, or seeds. Flours are used to make many different foods.", true, true, false, true, true, true);
        Ingredient tomatoSauce = new Ingredient("Tomato Sauce", "shady", 0.80f, "g", "Tomato sauce, refers to any of a very large number of sauces made primarily from tomatoes, usually to be served as part of a dish.", true, true, true, true, true, true);
        Ingredient mozzarella = new Ingredient("Mozzarella", "shady", 3.00f, "g", "Mozzarella is a traditionally southern Italian cheese made from Italian buffalo's milk by the pasta filata method.", true, false, true, false, true, true);
        Ingredient pepperoni = new Ingredient("Pepperoni", "shady", 1.42f, "g", "Pepperoni, also known as pepperoni sausage, is an American variety of salami, usually made from cured pork and beef mixed together.", false, false, true, true, true, true);
        Ingredient chicken = new Ingredient("Chicken", "shady", 2.39f, "g", "The chicken is a type of domesticated fowl, a subspecies of the red junglefowl. It is one of the most common and widespread domestic animals, with a total population of more than 19 billion as of 2011.", false, false, true, true, true, true);
        Ingredient beef = new Ingredient("Beef", "shady", 2.50f, "g", "Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.", false, false, true, true, true, false);

        saveToFile(salt, INGREDIENTS_FILE);
        saveToFile(cheese, INGREDIENTS_FILE);
        saveToFile(lettuce, INGREDIENTS_FILE);
        saveToFile(tomato, INGREDIENTS_FILE);
        saveToFile(flour, INGREDIENTS_FILE);
        saveToFile(tomatoSauce, INGREDIENTS_FILE);
        saveToFile(mozzarella, INGREDIENTS_FILE);
        saveToFile(pepperoni, INGREDIENTS_FILE);
        saveToFile(chicken, INGREDIENTS_FILE);
        saveToFile(beef, INGREDIENTS_FILE);

        // Meals
//        Meal salad = new Meal("Salad", "shady", new ArrayList<>(), 10, 0, "Mix all ingredients together.", "American");
//        salad.addIngredient(salt, 10f);
//        salad.addIngredient(cheese, 10f);
//        salad.addIngredient(lettuce, 10f);
//        salad.addIngredient(tomato, 10f);
//        meals.add(salad);
//
//        Meal pizza = new Meal("Pizza", "shady", new ArrayList<>(), 30, 30, "gently shape the dough into a pizza circle, spread the tomato sauce on the dough, add the mozzarella and pepperoni, bake for 30 minutes at 350 degrees Fahrenheit.", "Italian");
//        pizza.addIngredient(flour, 10f);
//        pizza.addIngredient(tomatoSauce, 10f);
//        pizza.addIngredient(mozzarella, 10f);
//        pizza.addIngredient(cheese, 5f);
//        pizza.addIngredient(pepperoni, 10f);
//        meals.add(pizza);
    }

    public static void addLogo(JPanel panel, int dimension) {
        try {
            ImageIcon logo = new ImageIcon(Objects.requireNonNull(Utils.class.getResource("cookease.png")));
            JLabel logoLabel = new JLabel(logo);
            logoLabel.setPreferredSize(new Dimension(dimension, dimension));
            panel.add(logoLabel, BorderLayout.CENTER);
        } catch (Exception e) {
            System.out.println("Error loading logo");
        }
    }
}
