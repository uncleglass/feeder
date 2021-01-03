package pl.uncleglass.feeder.backend.app.meal.port.in;

import pl.uncleglass.feeder.backend.app.meal.domain.Meal;

public interface DeleteMealUseCase {
    void deleteMeal(Meal meal);
}
