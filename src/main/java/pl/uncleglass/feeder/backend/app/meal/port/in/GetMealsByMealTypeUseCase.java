package pl.uncleglass.feeder.backend.app.meal.port.in;

import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;

import java.util.List;

public interface GetMealsByMealTypeUseCase {
    List<Meal> getMealsByMealType(MealType mealType);
}
