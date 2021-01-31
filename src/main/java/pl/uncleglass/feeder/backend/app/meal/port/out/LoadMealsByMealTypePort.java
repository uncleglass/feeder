package pl.uncleglass.feeder.backend.app.meal.port.out;

import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;

import java.util.List;

public interface LoadMealsByMealTypePort {
    List<Meal> leadMealsByMealType(MealType mealType);
}
