import java.util.*;
interface MealPlan {
    String getMealDetails();
}
class VegetarianMeal implements MealPlan {
    public String getMealDetails() {
        return "Vegetarian Meal: Salad, Paneer, Rice";
    }
}
class VeganMeal implements MealPlan {
    public String getMealDetails() {
        return "Vegan Meal: Tofu, Veggies, Brown Rice";
    }
}
class KetoMeal implements MealPlan {
    public String getMealDetails() {
        return "Keto Meal: Chicken, Eggs, Avocado";
    }
}
class HighProteinMeal implements MealPlan {
    public String getMealDetails() {
        return "High Protein Meal: Eggs, Chicken, Lentils";
    }
}
class Meal<T extends MealPlan> {
    private T meal;
    public Meal(T meal) {
        this.meal = meal;
    }
    public T getMeal() {
        return meal;
    }
}
class MealPlanGenerator {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Generated Meal Plan:");
        System.out.println(meal.getMeal().getMealDetails());
    }
}
public class MealPlanApp {
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal());
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal());
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal());
        Meal<HighProteinMeal> highProteinMeal = new Meal<>(new HighProteinMeal());
        MealPlanGenerator.generateMealPlan(vegMeal);
        MealPlanGenerator.generateMealPlan(veganMeal);
        MealPlanGenerator.generateMealPlan(ketoMeal);
        MealPlanGenerator.generateMealPlan(highProteinMeal);
    }
}
