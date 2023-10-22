// TODO user stories:
// As a chef, I want to receive feedback and ratings from users on meal recipes.
// As a user, I want to add meals to my shopping list.
// As a user, I want to create meal plans for the week and generate a shopping list based on my plan.
// As a user, I want to view meal schedules, including upcoming meals and past meal history.
// As a user, I want to view historical meal schedules and the meals I've prepared in the past.
// As a chef, I want to generate reports on the popularity of meal recipes and user feedback.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final ArrayList<User> users = new ArrayList<>();
    private static final ArrayList<Ingredient> ingredients = new ArrayList<>();
    private static final ArrayList<Meal> meals = new ArrayList<>();

    public static void main(String[] args) {
        // users
        User shady = new User("Shady", "s@s.s", "shady", "shady", "01111111111", 'c');
        User youssef = new User("Youssef", "y@y.y", "youssef", "youssef", "01111111111", 'u');
        User Saleh = new User("Saleh", "ss@s.s", "saleh", "saleh", "01111111111", 'u');

        users.add(shady);
        users.add(youssef);
        users.add(Saleh);

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

        ingredients.add(salt);
        ingredients.add(cheese);
        ingredients.add(lettuce);
        ingredients.add(tomato);
        ingredients.add(flour);
        ingredients.add(tomatoSauce);
        ingredients.add(mozzarella);
        ingredients.add(pepperoni);
        ingredients.add(chicken);
        ingredients.add(beef);

        // Meals
        Meal salad = new Meal("Salad", "shady", new ArrayList<>(), new ArrayList<>(), 10, 0, "Mix all ingredients together.", "American");
        salad.addIngredient(salt, 10f);

        salad.addIngredient(cheese, 10f);
        salad.addIngredient(lettuce, 10f);
        salad.addIngredient(tomato, 10f);
        meals.add(salad);

        Meal pizza = new Meal("Pizza", "shady", new ArrayList<>(), new ArrayList<>(), 30, 30, "gently shape the dough into a pizza circle, spread the tomato sauce on the dough, add the mozzarella and pepperoni, bake for 30 minutes at 350 degrees Fahrenheit.", "Italian");
        pizza.addIngredient(flour, 10f);
        pizza.addIngredient(tomatoSauce, 10f);
        pizza.addIngredient(mozzarella, 10f);
        pizza.addIngredient(cheese, 5f);
        pizza.addIngredient(pepperoni, 10f);
        meals.add(pizza);

        // driver code
        boolean appRunning = true;
        while (appRunning) {
            // sign in or sign up
            System.out.println("Welcome to the Meal Planner App!");
            System.out.println("1. Sign in");
            System.out.println("2. Sign up");
            System.out.println("3. Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();

            // switch case for options
            if (choice == 1) {
                // sign in
                User user = signIn();
                if (user != null) {
                    // user is signed in
                    boolean userSignedIn = true;
                    if (user.getRole() == 'c') {
                        // user is a chef
                        while (userSignedIn) {
                            System.out.println("1. Log out");
                            System.out.println("2. View all meals");
                            System.out.println("3. View all ingredients");
                            System.out.println("4. Add new ingredient");
                            System.out.println("5. Add new meal");
                            System.out.println("6. Remove ingredient");
                            System.out.println("7. Remove meal");
                            System.out.println("8. Edit ingredient");
                            System.out.println("9. Edit meal");
                            System.out.println("10. Generate report on popularity of meal recipes and user feedback");

                            int option = scanner.nextInt();
                            scanner.nextLine();

                            if (option == 1) {
                                // log out
                                // user = null;
                                userSignedIn = false;
                            }
                            else if (option == 2) {
                                // view all meals
                                for (Meal m : meals) {
                                    System.out.println(m);
                                }
                            }
                            else if (option == 3) {
                                // view all ingredients
                                for (Ingredient i : ingredients) {
                                    System.out.println(i);
                                }
                            }
                            else if (option == 4) {
                                // add new ingredient
                                Ingredient ingredient = createIngredient(user.getUsername());
                                ingredients.add(ingredient);
                                System.out.println("You have successfully added a new ingredient!");
                            }
                            else if (option == 5) {
                                // add new meal
                                Meal meal = createMeal(user.getUsername());
                                meals.add(meal);
                                System.out.println("You have successfully added a new meal!");
                            }
                            else if (option == 6) {
                                // remove ingredient
                                if (removeIngredient()){
                                    System.out.println("You have successfully removed the ingredient!");
                                }
                                else {
                                    System.out.println("Ingredient not found.");
                                }
                            }
                            else if (option == 7) {
                                // remove meal
                                if (removeMeal()) {
                                    System.out.println("You have successfully removed the meal!");
                                }
                                else {
                                    System.out.println("Meal not found.");
                                }
                            }
                            else if (option == 8) {
                                // edit ingredient
                                // editing ingredient by removing it and adding it again with new user data
                                // removeIngredient returns true if it was found hence we can add it again
                                if (removeIngredient()){
                                    Ingredient ingredient = createIngredient(user.getUsername());
                                    ingredients.add(ingredient);
                                    System.out.println("You have successfully edited the ingredient!");
                                }
                            }
                            else if (option == 9) {
                                // edit meal
                                // edit meal by editing details or adding/removing ingredients
                                System.out.println("Do you want to edit the details or the ingredients of the meal?");
                                System.out.println("1. Edit all details");
                                System.out.println("2. Edit ingredients list only");

                                int editOption = scanner.nextInt();
                                scanner.nextLine();

                                if (editOption == 1){
                                    if (removeMeal()){
                                        Meal meal = createMeal(user.getUsername());
                                        meals.add(meal);
                                        System.out.println("You have successfully edited the meal!");
                                    }
                                }
                                else {
                                    System.out.println("Enter the name of the meal you want to edit:");
                                    String mealName = scanner.nextLine();
                                    while (mealName.isEmpty()) {
                                        System.out.println("Name cannot be empty. Enter the name of the meal you want to edit:");
                                        mealName = scanner.nextLine();
                                    }
                                    // find meal index in meals list
                                    int mealIndex = -1;
                                    for (int i = 0; i < meals.size(); i++) {
                                        if (meals.get(i).getName().equals(mealName)) {
                                            mealIndex = i;
                                            break;
                                        }
                                    }
                                    if (mealIndex == -1) {
                                        System.out.println("Meal not found.");
                                        continue;
                                    }

                                    System.out.println("Add or remove ingredients?");
                                    System.out.println("1. Add ingredients");
                                    System.out.println("2. Remove ingredients");

                                    int addOrRemove = scanner.nextInt();
                                    scanner.nextLine();

                                    if (addOrRemove == 1){
                                        ArrayList<Ingredient> mealIngredients = new ArrayList<>();
                                        ArrayList<Float> mealIngredientQuantities = new ArrayList<>();

                                        System.out.println("Enter the name of the ingredient (enter 0 to exit):");
                                        String ingredientName = scanner.nextLine();

                                        while (!ingredientName.equals("0")) {
                                            // find ingredient
                                            Ingredient ingredient = null;
                                            for (Ingredient i : ingredients) {
                                                if (i.getName().equals(ingredientName)) {
                                                    ingredient = i;
                                                    break;
                                                }
                                            }

                                            // if ingredient is found, add it to meal
                                            if (ingredient != null) {
                                                mealIngredients.add(ingredient);
                                                System.out.println("Enter the quantity of the ingredient:");
                                                float quantity = scanner.nextFloat();
                                                while (quantity < 0) {
                                                    System.out.println("Quantity cannot be negative. Enter the quantity of the ingredient:");
                                                    quantity = scanner.nextFloat();
                                                }
                                                mealIngredientQuantities.add(quantity);
                                            } else {
                                                System.out.println("Ingredient not found.");
                                            }

                                            System.out.println("Enter the name of the ingredient (enter 0 to exit):");
                                            ingredientName = scanner.nextLine();
                                        }

                                        // add ingredients to meal

                                        // add ingredients to meal
                                        for (Ingredient i : mealIngredients) {
                                            meals.get(mealIndex).addIngredient(i, mealIngredientQuantities.get(mealIngredients.indexOf(i)));
                                        }


                                    }
                                    else if (addOrRemove == 2){
                                        // remove existing ingredient from meal
                                        // print all ingredients
                                        for (Ingredient i : meals.get(mealIndex).getIngredients()) {
                                            System.out.println("- " + i);
                                        }

                                        // input ingredient name
                                        System.out.println("Enter the name of the ingredient you want to remove:");
                                        String ingredientName = scanner.nextLine();
                                        while (ingredientName.isEmpty()) {
                                            System.out.println("Name cannot be empty. Enter the name of the ingredient you want to remove:");
                                            ingredientName = scanner.nextLine();
                                        }

                                        // find ingredient
                                        Ingredient ingredient = null;
                                        for (Ingredient i : meals.get(mealIndex).getIngredients()) {
                                            if (i.getName().equals(ingredientName)) {
                                                ingredient = i;
                                                break;
                                            }
                                        }

                                        // remove ingredient and quantity from meal
                                        if (ingredient != null) {
                                            meals.get(mealIndex).removeIngredient(ingredient);
                                            System.out.println("You have successfully removed the ingredient!");
                                        } else {
                                            System.out.println("Ingredient not found.");
                                        }
                                    }
                                    else {
                                        System.out.println("Invalid option.");
                                    }
                                }
                            }
                            else if (option == 10) {
                                // generate report on popularity of meal recipes of signed in chef and user feedback
                                System.out.println("Report on popularity of meal recipes and user feedback:");
                                System.out.println("Meal name | Number of bookmarks | Average rating | Number of reviews");
                                for (Meal m : meals) {
                                    if (m.getChefName().equals(user.getUsername())) {
                                        System.out.printf("%s | %d | %.2f | %d\n", m.getName(), m.getBookmarkCount(), m.getAverageRating(), m.getReviews().size());
                                        System.out.println("Reviews:");
                                        System.out.println(m.getReviewsString());
                                    }
                                }
                            }
                            else {
                                // invalid option
                                System.out.println("Invalid option.");
                            }
                        }
                    } else {
                        // user is a user(meal preparer)
                        while (userSignedIn) {
                            System.out.println("1. Log out");
                            System.out.println("2. View all meals");
                            System.out.println("3. Search for meals based on specific criteria");
                            System.out.println("4. View detailed information about a specific meal");
                            System.out.println("5. Bookmark meals");
                            System.out.println("6. View bookmarked meals");
                            System.out.println("7. Add meals to shopping list");
                            System.out.println("8. Create meal plans for the week and generate a shopping list");
                            System.out.println("9. View meal schedules");
                            System.out.println("10. View nutritional information of meals");
                            System.out.println("11. Review meals");
                            System.out.println("12. View shopping list");
                            System.out.println("13. View historical meal schedules and the meals you've prepared in the past");

                            int option = scanner.nextInt();
                            scanner.nextLine();

                            if (option == 1) {
                                // log out
                                // user = null;
                                userSignedIn = false;
                            }
                            else if (option == 2) {
                                // view all meals
                                for (Meal m : meals) {
                                    System.out.println(m);
                                }
                            }
                            else if (option == 3) {
                                // search for meals based on specific criteria
                                // criteria: cuisine type or dietary preferences (vegetarian, vegan, gluten-free, dairy free, nut free, red meat free)

                                // cuisine type
                                System.out.println("Enter the cuisine type (enter 0 to exit):");

                                // print all cuisine types
                                ArrayList<String> cuisineTypes = new ArrayList<>();
                                for (Meal m : meals) {
                                    if (!cuisineTypes.contains(m.getCuisine())) {
                                        cuisineTypes.add(m.getCuisine());
                                    }
                                }
                                for (String cuisine : cuisineTypes) {
                                    System.out.printf("- %s\n", cuisine);
                                }

                                // input list of cuisine types. if cuisine type is not found, ask user to enter a new cuisine type. exit when user enters 0.
                                ArrayList<String> cuisineTypeChoices = new ArrayList<>();
                                String cuisineType = scanner.nextLine();
                                while (!cuisineType.equals("0")) {
                                    boolean cuisineTypeFound = false;
                                    for (String cuisine : cuisineTypes) {
                                        if (cuisine.equals(cuisineType)) {
                                            cuisineTypeFound = true;
                                            break;
                                        }
                                    }
                                    if (cuisineTypeFound) {
                                        if (!cuisineTypeChoices.contains(cuisineType)) {
                                            cuisineTypeChoices.add(cuisineType);
                                        }
                                        System.out.println("Enter the cuisine type (enter 0 to exit):");
                                    } else {
                                        System.out.println("Cuisine type not found. Enter the cuisine type:");
                                    }
                                    cuisineType = scanner.nextLine();
                                }

                                // dietary preferences
                                System.out.println("Enter the dietary preferences (enter 0 to exit):");
                                System.out.println("1. Vegetarian");
                                System.out.println("2. Vegan");
                                System.out.println("3. Gluten Free");
                                System.out.println("4. Dairy Free");
                                System.out.println("5. Nut Free");
                                System.out.println("6. Red Meat Free");
                                System.out.println("7. None");

                                // input list of dietary preferences. if dietary preference is not found, ask user to enter a new dietary preference. exit when user enters 0.
                                ArrayList<String> dietaryPreferenceChoices = new ArrayList<>();
                                int dietaryPreference = scanner.nextInt();
                                scanner.nextLine();

                                while (dietaryPreference != 0) {
                                    if (dietaryPreference == 1) {
                                        if (!dietaryPreferenceChoices.contains("vegetarian")) {
                                            dietaryPreferenceChoices.add("vegetarian");
                                        }
                                    } else if (dietaryPreference == 2) {
                                        if (!dietaryPreferenceChoices.contains("vegan")) {
                                            dietaryPreferenceChoices.add("vegan");
                                        }
                                    } else if (dietaryPreference == 3) {
                                        if (!dietaryPreferenceChoices.contains("gluten free")) {
                                            dietaryPreferenceChoices.add("gluten free");
                                        }
                                    } else if (dietaryPreference == 4) {
                                        if (!dietaryPreferenceChoices.contains("dairy free")) {
                                            dietaryPreferenceChoices.add("dairy free");
                                        }
                                    } else if (dietaryPreference == 5) {
                                        if (!dietaryPreferenceChoices.contains("nut free")) {
                                            dietaryPreferenceChoices.add("nut free");
                                        }
                                    } else if (dietaryPreference == 6) {
                                        if (!dietaryPreferenceChoices.contains("red meat free")) {
                                            dietaryPreferenceChoices.add("red meat free");
                                        }
                                    } else if (dietaryPreference == 7) {
                                        dietaryPreferenceChoices.clear();
                                    } else {
                                        System.out.println("Invalid option. Enter the dietary preference:");
                                    }
                                    dietaryPreference = scanner.nextInt();
                                    scanner.nextLine();
                                }
                                // filter based on cuisine type and dietary preferences
                                ArrayList<Meal> filteredMeals = new ArrayList<>();
                                for (Meal m : meals) {
                                    if (cuisineTypeChoices.contains(m.getCuisine())) {
                                        if (dietaryPreferenceChoices.isEmpty()) {
                                            filteredMeals.add(m);
                                            continue;
                                        }
                                        boolean mealHasDietaryRestrictions = false;
                                        for (Ingredient i : m.getIngredients()) {
                                            if (i.hasUnspecifiedRestrictions()) {
                                                mealHasDietaryRestrictions = true;
                                                break;
                                            }
                                            for (String dietaryPreferenceChoice : dietaryPreferenceChoices) {
                                                if (dietaryPreferenceChoice.equals("vegetarian") && !i.isVegetarian()) {
                                                    mealHasDietaryRestrictions = true;
                                                    break;
                                                }
                                                if (dietaryPreferenceChoice.equals("vegan") && !i.isVegan()) {
                                                    mealHasDietaryRestrictions = true;
                                                    break;
                                                }
                                                if (dietaryPreferenceChoice.equals("gluten free") && !i.isGlutenFree()) {
                                                    mealHasDietaryRestrictions = true;
                                                    break;
                                                }
                                                if (dietaryPreferenceChoice.equals("dairy free") && !i.isDairyFree()) {
                                                    mealHasDietaryRestrictions = true;
                                                    break;
                                                }
                                                if (dietaryPreferenceChoice.equals("nut free") && !i.isNutFree()) {
                                                    mealHasDietaryRestrictions = true;
                                                    break;
                                                }
                                                if (dietaryPreferenceChoice.equals("red meat free") && !i.isRedMeatFree()) {
                                                    mealHasDietaryRestrictions = true;
                                                    break;
                                                }
                                            }
                                            if (mealHasDietaryRestrictions) {
                                                break;
                                            }
                                        }
                                        if (!mealHasDietaryRestrictions) {
                                            filteredMeals.add(m);
                                        }
                                    }
                                }

                                // print filtered meals
                                System.out.println("Filters:");
                                System.out.println("- Cuisine type: " + cuisineTypeChoices);
                                System.out.println("- Dietary preferences: " + dietaryPreferenceChoices);
                                System.out.println("Filtered meals:");
                                for (Meal m : filteredMeals) {
                                    System.out.println("- " + m);
                                }
                            }
                            else if (option == 4) {
                                // view detailed information about a specific meal

                                // print all meals
                                for (Meal m : meals) {
                                    System.out.println("- " + m);
                                }

                                // input meal name
                                System.out.println("Enter the name of the meal:");
                                String mealName = scanner.nextLine();
                                while (mealName.isEmpty()) {
                                    System.out.println("Name cannot be empty. Enter the name of the meal:");
                                    mealName = scanner.nextLine();
                                }

                                // find meal
                                Meal meal = null;
                                for (Meal m : meals) {
                                    if (m.getName().equals(mealName)) {
                                        meal = m;
                                        break;
                                    }
                                }

                                // print meal info
                                if (meal != null) {
                                    System.out.println(meal.getMeal());
                                } else {
                                    System.out.println("Meal not found.");
                                }
                            }
                            else if (option == 5) {
                                // bookmark meals

                                // print all meals
                                for (Meal m : meals) {
                                    System.out.println("- " + m);
                                }

                                // input meal name
                                System.out.println("Enter the name of the meal you want to bookmark:");
                                String mealName = scanner.nextLine();
                                while (mealName.isEmpty()) {
                                    System.out.println("Name cannot be empty. Enter the name of the meal you want to bookmark:");
                                    mealName = scanner.nextLine();
                                }

                                // find meal
                                Meal meal = null;
                                for (Meal m : meals) {
                                    if (m.getName().equals(mealName)) {
                                        meal = m;
                                        break;
                                    }
                                }

                                // print meal info
                                if (meal != null) {
                                    System.out.println(meal.getMeal());
                                } else {
                                    System.out.println("Meal not found.");
                                    continue;
                                }

                                // give option to bookmark meal
                                System.out.println("Do you want to bookmark this meal? (y/n)");
                                String answer = scanner.nextLine();
                                while (answer.charAt(0) != 'y' && answer.charAt(0) != 'n') {
                                    System.out.println("Invalid input. Do you want to bookmark this meal? (y/n)");
                                    answer = scanner.nextLine();
                                }

                                // add meal to bookmarks
                                if (answer.equals("y")) {
                                    user.addMealToBookmarks(meal);
                                    meal.addBookmark();
                                    System.out.println("You have successfully bookmarked the meal!");
                                }
                            }
                            else if (option == 6) {
                                // view bookmarked meals
                                System.out.println("Bookmarked meals:");
                                for (Meal m : user.getBookmarkedMeals()) {
                                    System.out.println("- " + m);
                                }
                            }
                            else if (option == 7) {
                                // add meals to shopping list

                                // print all meals
                                for (Meal m : meals) {
                                    System.out.println("- " + m);
                                }

                                // input meal name
                                System.out.println("Enter the name of the meal you want to add to your shopping list:");
                                String mealName = scanner.nextLine();
                                while (mealName.isEmpty()) {
                                    System.out.println("Name cannot be empty. Enter the name of the meal you want to add to your shopping list:");
                                    mealName = scanner.nextLine();
                                }

                                // find meal
                                Meal meal = null;
                                for (Meal m : meals) {
                                    if (m.getName().equals(mealName)) {
                                        meal = m;
                                        break;
                                    }
                                }

                                // add meal ingredients to shopping list
                                if (meal != null) {
                                    user.addIngredientsToShoppingList(meal.getIngredients(), meal.getQuantities());
                                    System.out.println("You have successfully added the meal to your shopping list!");
                                } else {
                                    System.out.println("Meal not found.");
                                }
                            }
                            else if (option == 8) {
                                // create meal plans for the week and generate a shopping list

                                // choose meals for each day of the week. each day has 3 meals: breakfast, lunch, dinner
                                ArrayList<MealDay> mealPlan = new ArrayList<>();
                                for (int i = 0; i < 7; i++) {
                                    System.out.println("Choose a breakfast meal for day " + (i + 1) + ":");
                                    // print all meals
                                    for (Meal m : meals) {
                                        System.out.println("- " + m);
                                    }

                                    // input meal name
                                    System.out.println("Enter the name of the meal:");
                                    String mealName = scanner.nextLine();
                                    while (mealName.isEmpty()) {
                                        System.out.println("Name cannot be empty. Enter the name of the meal:");
                                        mealName = scanner.nextLine();
                                    }

                                    // find meal
                                    Meal meal = null;
                                    for (Meal m : meals) {
                                        if (m.getName().equals(mealName)) {
                                            meal = m;
                                            break;
                                        }
                                    }

                                    // add meal to meal plan
                                    if (meal != null) {
                                        MealDay mealDay = new MealDay(meal, null, null);
                                        mealPlan.add(mealDay);
                                    } else {
                                        System.out.println("Meal not found.");
                                        continue;
                                    }

                                    System.out.println("Choose a lunch meal for day " + (i + 1) + ":");
                                    // print all meals
                                    for (Meal m : meals) {
                                        System.out.println("- " + m);
                                    }

                                    // input meal name
                                    System.out.println("Enter the name of the meal:");
                                    mealName = scanner.nextLine();
                                    while (mealName.isEmpty()) {
                                        System.out.println("Name cannot be empty. Enter the name of the meal:");
                                        mealName = scanner.nextLine();
                                    }

                                    // find meal
                                    meal = null;
                                    for (Meal m : meals) {
                                        if (m.getName().equals(mealName)) {
                                            meal = m;
                                            break;
                                        }
                                    }

                                    // add meal to meal plan
                                    if (meal != null) {
                                        mealPlan.get(i).setLunch(meal);
                                    } else {
                                        System.out.println("Meal not found.");
                                        continue;
                                    }

                                    System.out.println("Choose a dinner meal for day " + (i + 1) + ":");
                                    // print all meals
                                    for (Meal m : meals) {
                                        System.out.println("- " + m);
                                    }

                                    // input meal name
                                    System.out.println("Enter the name of the meal:");
                                    mealName = scanner.nextLine();
                                    while (mealName.isEmpty()) {
                                        System.out.println("Name cannot be empty. Enter the name of the meal:");
                                        mealName = scanner.nextLine();
                                    }

                                    // find meal
                                    meal = null;
                                    for (Meal m : meals) {
                                        if (m.getName().equals(mealName)) {
                                            meal = m;
                                            break;
                                        }
                                    }

                                    // add meal to meal plan
                                    if (meal != null) {
                                        mealPlan.get(i).setDinner(meal);
                                    } else {
                                        System.out.println("Meal not found.");
                                        continue;
                                    }

                                    System.out.println("You have successfully added the meal plan for day " + (i + 1) + "!");
                                }

                                // save meal plan
                                user.setCurrentWeekMealPlan(new MealWeek(mealPlan));
                                // generate shopping list
                                ArrayList<Ingredient> shoppingList = new ArrayList<>();
                                ArrayList<Float> shoppingListQuantities = new ArrayList<>();

                                // get ingredients and total quantity from meal plan
                                for (MealDay mealDay : mealPlan) {
                                    for (Ingredient i : mealDay.getBreakfast().getIngredients()) {
                                        if (!shoppingList.contains(i)) {
                                            shoppingList.add(i);
                                            shoppingListQuantities.add(mealDay.getBreakfast().getQuantities().get(mealDay.getBreakfast().getIngredients().indexOf(i)));
                                        } else {
                                            shoppingListQuantities.set(shoppingList.indexOf(i), shoppingListQuantities.get(shoppingList.indexOf(i)) + mealDay.getBreakfast().getQuantities().get(mealDay.getBreakfast().getIngredients().indexOf(i)));
                                        }
                                    }
                                    for (Ingredient i : mealDay.getLunch().getIngredients()) {
                                        if (!shoppingList.contains(i)) {
                                            shoppingList.add(i);
                                            shoppingListQuantities.add(mealDay.getLunch().getQuantities().get(mealDay.getLunch().getIngredients().indexOf(i)));
                                        } else {
                                            shoppingListQuantities.set(shoppingList.indexOf(i), shoppingListQuantities.get(shoppingList.indexOf(i)) + mealDay.getLunch().getQuantities().get(mealDay.getLunch().getIngredients().indexOf(i)));
                                        }
                                    }
                                    for (Ingredient i : mealDay.getDinner().getIngredients()) {
                                        if (!shoppingList.contains(i)) {
                                            shoppingList.add(i);
                                            shoppingListQuantities.add(mealDay.getDinner().getQuantities().get(mealDay.getDinner().getIngredients().indexOf(i)));
                                        } else {
                                            shoppingListQuantities.set(shoppingList.indexOf(i), shoppingListQuantities.get(shoppingList.indexOf(i)) + mealDay.getDinner().getQuantities().get(mealDay.getDinner().getIngredients().indexOf(i)));
                                        }
                                    }
                                }

                                // add ingredients to shopping list
                                user.addIngredientsToShoppingList(shoppingList, shoppingListQuantities);
                                System.out.println("You have successfully generated the shopping list!");
                            }
                            else if (option == 9) {
                                // view meal schedules

                                // print all meal schedules
                                int scheduleSize = user.getCurrentWeekMealPlan().getMealDays().size();

                                if (scheduleSize == 0) {
                                    System.out.println("No meal schedules found.");
                                    continue;
                                }
                                for (int i = 0; i < scheduleSize; i++) {
                                    System.out.println("Day " + (i + 1) + ":");
                                    System.out.println(user.getCurrentWeekMealPlan().getMealDays().get(i));
                                }
                            }
                            else if (option == 10) {
                                // view nutritional information of meals

                                // print all meals
                                for (Meal m : meals) {
                                    System.out.println("- " + m);
                                }

                                // input meal name
                                System.out.println("Enter the name of the meal:");
                                String mealName = scanner.nextLine();
                                while (mealName.isEmpty()) {
                                    System.out.println("Name cannot be empty. Enter the name of the meal:");
                                    mealName = scanner.nextLine();
                                }

                                // find meal
                                Meal meal = null;
                                for (Meal m : meals) {
                                    if (m.getName().equals(mealName)) {
                                        meal = m;
                                        break;
                                    }
                                }

                                // print meal info
                                if (meal != null) {
                                    System.out.println(meal.getTotalCalories());
                                    System.out.println(meal.getDietaryRestrictionsString());
                                } else {
                                    System.out.println("Meal not found.");
                                }
                            }
                            else if (option == 11) {
                                // review meals
                                for (Meal m : meals) {
                                    System.out.println("- " + m);
                                }

                                // input meal name
                                System.out.println("Enter the name of the meal:");
                                String mealName = scanner.nextLine();
                                while (mealName.isEmpty()) {
                                    System.out.println("Name cannot be empty. Enter the name of the meal:");
                                    mealName = scanner.nextLine();
                                }

                                // find meal
                                Meal meal = null;
                                for (Meal m : meals) {
                                    if (m.getName().equals(mealName)) {
                                        meal = m;
                                        break;
                                    }
                                }

                                if (meal != null) {
                                    // user can't review meal more than once
                                    boolean reviewed = false;
                                    for (Review r : meal.getReviews()) {
                                        if (r.getReviewerUserName().equals(user.getUsername())) {
                                            System.out.println("You have already reviewed this meal.");
                                            reviewed = true;
                                            break;
                                        }
                                    }
                                    if (reviewed) {
                                        continue;
                                    }

                                    System.out.println("Enter your rating (1-5):");
                                    int rating = scanner.nextInt();
                                    scanner.nextLine();
                                    while (rating < 1 || rating > 5) {
                                        System.out.println("Invalid rating. Enter your rating (1-5):");
                                        rating = scanner.nextInt();
                                        scanner.nextLine();
                                    }
                                    System.out.println("Enter your review:");
                                    String review = scanner.nextLine();
                                    while (review.isEmpty()) {
                                        System.out.println("Review cannot be empty. Enter your review:");
                                        review = scanner.nextLine();
                                    }
                                    meal.addReview(new Review(user.getUsername(), rating, review));
                                    System.out.println("You have successfully reviewed the meal!");
                                } else {
                                    System.out.println("Meal not found.");
                                }
                            }
                            else if (option == 12) {
                                // view shopping list
                                user.printShoppingList();
                            }
                            else if (option == 13) {
                                // view historical meal schedules and the meals you've prepared in the past
                                System.out.println("Historical meal schedules and the meals you've prepared in the past:");
                                for (MealWeek mealWeek : user.getMealPlanHistory()) {
                                    System.out.println("Meal schedule:");
                                    System.out.println(mealWeek);
                                    System.out.println("----------------------------------------");
                                }
                            }
                            else {
                                // invalid option
                                System.out.println("Invalid option.");
                            }
                        }
                    }
                }
            }
            else if (choice == 2) {
                // sign up
                User user = createUser();
                users.add(user);
                System.out.println("You have successfully signed up!");
            }
            else {
                System.out.println("Do you want to print all data before exiting? (y/n)");
                String answer = scanner.nextLine();
                while (answer.charAt(0) != 'y' && answer.charAt(0) != 'n') {
                    System.out.println("Invalid input. Do you want to print all data? (y/n)");
                    answer = scanner.nextLine();
                }
                if (answer.equals("y")) {
                    // print all data
                    //users
                    for (User u : users) {
                        // print user info with labels
                        System.out.println("Name: " + u.getName());
                        System.out.println("Email: " + u.getEmail());
                        System.out.println("Password: " + u.getPassword());
                        System.out.println("Username: " + u.getUsername());
                        System.out.println("Phone: " + u.getPhone());
                        System.out.println("Role: " + u.getRole());
                        System.out.println();
                    }

                    // ingredients
                    for (Ingredient i : ingredients) {
                        System.out.println(i.getDetails());
                        System.out.println();
                    }

                    // meals
                    for (Meal m : meals) {
                        System.out.println(m.getMeal());
                        System.out.println();
                    }
                }

                appRunning = false;
            }
        }
    }

    private static User createUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty. Enter your name:");
            name = scanner.nextLine();
        }

        System.out.println("Enter your email:");
        String email = scanner.nextLine();
        while (!isValidEmail(email)) {
            System.out.println("Invalid email format. Enter your email:");
            email = scanner.nextLine();
        }

        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        while (username.isEmpty()) {
            System.out.println("Username cannot be empty. Enter your username:");
            username = scanner.nextLine();
        }

        // username must be unique (no duplicates) in users list
        boolean usernameExists = false;
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                usernameExists = true;
                break;
            }
        }
        while (usernameExists) {
            System.out.println("Username already exists. Enter your username:");
            username = scanner.nextLine();
            while (username.isEmpty()) {
                System.out.println("Username cannot be empty. Enter your username:");
                username = scanner.nextLine();
            }
            usernameExists = false;
            for (User u : users) {
                if (u.getUsername().equals(username)) {
                    usernameExists = true;
                    break;
                }
            }
        }

        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        while (password.isEmpty()) {
            System.out.println("Password cannot be empty. Enter your password:");
            password = scanner.nextLine();
        }

        System.out.println("Enter your phone number:");
        String phone = scanner.nextLine();
        while (!isValidPhoneNumber(phone)) {
            System.out.println("Invalid phone number format. Enter your phone number:");
            phone = scanner.nextLine();
        }

        System.out.println("Enter your role (chef(c) or user(u)):");
        String role = scanner.nextLine();
        while (role.isEmpty() || (role.charAt(0) != 'c' && role.charAt(0) != 'u')) {
            System.out.println("Invalid role. Enter your role (chef(c) or user(u)):");
            role = scanner.nextLine();
        }

        return new User(name, email, password, username, phone, role.charAt(0));
    }

    private static User signIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username:");
        String username = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                System.out.println("You have successfully signed in!");
                return u;
            }
        }
        System.out.println("Invalid username or password.");
        return null;
    }

    private static Ingredient createIngredient(String chefName){
        // create ingredient
        // ingredient name must be unique (no duplicates) in ingredients list
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the ingredient:");
        String name = scanner.nextLine();

        // if name is not unique or empty, ask user to enter a new name
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty. Enter the name of the ingredient:");
            name = scanner.nextLine();
        }
        boolean nameExists = false;
        for (Ingredient i : ingredients) {
            if (i.getName().equals(name)) {
                nameExists = true;
                break;
            }
        }
        while (nameExists) {
            System.out.println("Name already exists. Enter the name of the ingredient:");
            name = scanner.nextLine();
            while (name.isEmpty()) {
                System.out.println("Name cannot be empty. Enter the name of the ingredient:");
                name = scanner.nextLine();
            }
            nameExists = false;
            for (Ingredient i : ingredients) {
                if (i.getName().equals(name)) {
                    nameExists = true;
                    break;
                }
            }
        }

        System.out.println("Enter the number of calories in the ingredient:");
        int calories = scanner.nextInt();
        scanner.nextLine();
        while (calories < 0) {
            System.out.println("Calories cannot be negative. Enter the number of calories in the ingredient:");
            calories = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Enter the unit of measurement for the ingredient:");
        String unit = scanner.nextLine();
        while (unit.isEmpty()) {
            System.out.println("Unit cannot be empty. Enter the unit of measurement for the ingredient:");
            unit = scanner.nextLine();
        }

        System.out.println("Enter the description of the ingredient:");
        String description = scanner.nextLine();
        while (description.isEmpty()) {
            System.out.println("Description cannot be empty. Enter the description of the ingredient:");
            description = scanner.nextLine();
        }

        String answer;

        System.out.println("Is the ingredient vegetarian? (y/n)");
        answer = scanner.nextLine();

        while (answer.charAt(0) != 'y' && answer.charAt(0) != 'n') {
            System.out.println("Invalid input. Is the ingredient vegetarian? (y/n)");
            answer = scanner.nextLine();
        }
        boolean isVegetarian = answer.equals("y");

        // vegetarian food can be vegan. non vegetarian food can't be vegan.
        boolean isVegan;
        if (isVegetarian) {
            System.out.println("Is the ingredient vegan? (y/n)");
            answer = scanner.nextLine();
            while (answer.charAt(0) != 'y' && answer.charAt(0) != 'n') {
                System.out.println("Invalid input. Is the ingredient vegan? (y/n)");
                answer = scanner.nextLine();
            }
            isVegan = answer.equals("y");
        } else {
            isVegan = false;
        }

        System.out.println("Is the ingredient gluten free? (y/n)");
        answer = scanner.nextLine();
        while (answer.charAt(0) != 'y' && answer.charAt(0) != 'n') {
            System.out.println("Invalid input. Is the ingredient gluten free? (y/n)");
            answer = scanner.nextLine();
        }
        boolean isGlutenFree = answer.equals("y");

        System.out.println("Is the ingredient dairy free? (y/n)");
        answer = scanner.nextLine();
        while (answer.charAt(0) != 'y' && answer.charAt(0) != 'n') {
            System.out.println("Invalid input. Is the ingredient dairy free? (y/n)");
            answer = scanner.nextLine();
        }
        boolean isDairyFree = answer.equals("y");

        System.out.println("Is the ingredient nut free? (y/n)");
        answer = scanner.nextLine();
        while (answer.charAt(0) != 'y' && answer.charAt(0) != 'n') {
            System.out.println("Invalid input. Is the ingredient nut free? (y/n)");
            answer = scanner.nextLine();
        }
        boolean isNutFree = answer.equals("y");

        System.out.println("Is the ingredient red meat free? (y/n)");
        answer = scanner.nextLine();
        while (answer.charAt(0) != 'y' && answer.charAt(0) != 'n') {
            System.out.println("Invalid input. Is the ingredient red meat free? (y/n)");
            answer = scanner.nextLine();
        }
        boolean isRedMeatFree = answer.equals("y");

        return new Ingredient(name, chefName, calories, unit, description, isVegetarian, isVegan, isGlutenFree, isDairyFree, isNutFree, isRedMeatFree);
    }

    private static boolean removeIngredient(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the ingredient:");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty. Enter the name of the ingredient:");
            name = scanner.nextLine();
        }

        boolean found = false;
        for (Ingredient i : ingredients) {
            if (i.getName().equals(name)) {
                ingredients.remove(i);
                found = true;
                break;
            }
        }
        if (found) {
            return true;
        } else {
            System.out.println("Ingredient not found.");
            return false;
        }
    }

    private static Meal createMeal(String chefName){
        // meal name must be unique (no duplicates) in meals list
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the meal:");
        String name = scanner.nextLine();

        // if name is not unique or empty, ask user to enter a new name
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty. Enter the name of the meal:");
            name = scanner.nextLine();
        }
        boolean nameExists = false;
        for (Meal m : meals) {
            if (m.getName().equals(name)) {
                nameExists = true;
                break;
            }
        }
        while (nameExists) {
            System.out.println("Name already exists. Enter the name of the meal:");
            name = scanner.nextLine();
            while (name.isEmpty()) {
                System.out.println("Name cannot be empty. Enter the name of the meal:");
                name = scanner.nextLine();
            }
            nameExists = false;
            for (Meal m : meals) {
                if (m.getName().equals(name)) {
                    nameExists = true;
                    break;
                }
            }
        }

        System.out.println("Enter the cuisine of the meal:");
        String cuisine = scanner.nextLine();
        while (cuisine.isEmpty()) {
            System.out.println("Cuisine cannot be empty. Enter the cuisine of the meal:");
            cuisine = scanner.nextLine();
        }

        System.out.println("Enter the preparation time of the meal (in minutes):");
        int preparationTime = scanner.nextInt();
        scanner.nextLine();
        while (preparationTime < 0) {
            System.out.println("Preparation time cannot be negative. Enter the preparation time of the meal (in minutes):");
            preparationTime = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Enter the cooking time of the meal (in minutes):");
        int cookingTime = scanner.nextInt();
        scanner.nextLine();
        while (cookingTime < 0) {
            System.out.println("Cooking time cannot be negative. Enter the cooking time of the meal (in minutes):");
            cookingTime = scanner.nextInt();
            scanner.nextLine();
        }

        System.out.println("Enter the instructions for the meal:");
        String instructions = scanner.nextLine();
        while (instructions.isEmpty()) {
            System.out.println("Instructions cannot be empty. Enter the instructions for the meal:");
            instructions = scanner.nextLine();
        }

        // loop to add ingredients until users enters 0
        System.out.println("Ingredients for the meal:");

        ArrayList<Ingredient> mealIngredients = new ArrayList<>();
        ArrayList<Float> mealIngredientQuantities = new ArrayList<>();

        System.out.println("Enter the name of the ingredient (enter 0 to exit):");
        String ingredientName = scanner.nextLine();

        while (!ingredientName.equals("0")) {
            // find ingredient
            Ingredient ingredient = null;
            for (Ingredient i : ingredients) {
                if (i.getName().equals(ingredientName)) {
                    ingredient = i;
                    break;
                }
            }

            // if ingredient is found, add it to meal
            if (ingredient != null) {
                mealIngredients.add(ingredient);
                System.out.println("Enter the quantity of the ingredient:");
                float quantity = scanner.nextFloat();
                while (quantity < 0) {
                    System.out.println("Quantity cannot be negative. Enter the quantity of the ingredient:");
                    quantity = scanner.nextFloat();
                }
                mealIngredientQuantities.add(quantity);
            } else {
                System.out.println("Ingredient not found.");
            }

            System.out.println("Enter the name of the ingredient (enter 0 to exit):");
            ingredientName = scanner.nextLine();
        }

        return new Meal(name, chefName, mealIngredients, mealIngredientQuantities, preparationTime, cookingTime, instructions, cuisine);
    }

    private static boolean removeMeal(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the meal you want to remove:");
        String name = scanner.nextLine();
        while (name.isEmpty()) {
            System.out.println("Name cannot be empty. Enter the name of the meal you want to remove:");
            name = scanner.nextLine();
        }

        boolean found = false;
        for (Meal m : meals) {
            if (m.getName().equals(name)) {
                meals.remove(m);
                found = true;
                break;
            }
        }
        return found;
    }

    private static boolean isValidEmail(String email) {
        // email validation
        // Email format: <username>@<domain>

        // check if email contains @
        if (!email.contains("@")) {
            return false;
        }

        // split email into username and domain
        String[] emailParts = email.split("@");
        if (emailParts.length != 2) {
            return false;
        }
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
        if (domain.startsWith(".") || domain.endsWith(".")) {
            return false;
        }

        return true;
    }

    private static boolean isValidPhoneNumber(String phone) {
        // phone number validation
        // Phone number format: <01><9-digit number>

        // check if phone number contains 11 digits
        if (phone.length() != 11) {
            return false;
        }

        // check if phone number starts with 01
        if (!phone.startsWith("01")) {
            return false;
        }

        // check if phone number contains only digits
        for (int i = 2; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}