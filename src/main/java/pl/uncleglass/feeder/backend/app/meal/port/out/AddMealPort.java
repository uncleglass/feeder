package pl.uncleglass.feeder.backend.app.meal.port.out;

import pl.uncleglass.feeder.backend.app.meal.domain.Meal;

public interface AddMealPort {
    void addMeal(Meal meal);
}
