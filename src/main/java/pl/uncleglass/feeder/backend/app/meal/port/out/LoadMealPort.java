package pl.uncleglass.feeder.backend.app.meal.port.out;

import pl.uncleglass.feeder.backend.app.meal.domain.Meal;

import java.util.UUID;

public interface LoadMealPort {
    Meal loadMeal(UUID mealId);
}
