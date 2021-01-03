package pl.uncleglass.feeder.backend.app.meal.port.out;

import pl.uncleglass.feeder.backend.app.meal.domain.Meal;

import java.util.List;

public interface GetAllMealsPort {
    List<Meal> getAllMeals();
}
