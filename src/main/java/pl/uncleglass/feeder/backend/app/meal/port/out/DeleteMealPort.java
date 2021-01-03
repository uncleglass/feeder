package pl.uncleglass.feeder.backend.app.meal.port.out;

import pl.uncleglass.feeder.backend.app.meal.domain.Meal;

public interface DeleteMealPort {
    void deleteMeal(Meal meal);
}
