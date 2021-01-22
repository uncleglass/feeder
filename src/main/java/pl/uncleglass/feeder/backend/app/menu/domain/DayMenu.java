package pl.uncleglass.feeder.backend.app.menu.domain;

import lombok.Getter;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class DayMenu {
    private UUID id;
    private final LocalDate date;
    private Map<MealType, Meal> meals = new HashMap<>();

    public DayMenu(LocalDate date) {
        this.date = date;
    }

    public DayMenu(UUID id, LocalDate date, Map<MealType, Meal> meals) {
        this.id = id;
        this.date = date;
        this.meals = meals;
    }

    public void addMeal(MealType mealType, Meal meal) {
        meals.put(mealType, meal);
    }

    public Meal getMeal(MealType mealType) {
        return meals.get(mealType);
    }
}
