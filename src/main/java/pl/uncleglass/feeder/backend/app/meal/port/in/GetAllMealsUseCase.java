package pl.uncleglass.feeder.backend.app.meal.port.in;

import pl.uncleglass.feeder.backend.app.meal.domain.Meal;

import java.util.List;

public interface GetAllMealsUseCase {
    List<Meal> getAllMeals();
}
