package pl.uncleglass.feeder.backend.adapters.persistence;

import org.springframework.stereotype.Component;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;
import pl.uncleglass.feeder.backend.app.meal.port.out.AddMealPort;
import pl.uncleglass.feeder.backend.app.meal.port.out.DeleteMealPort;
import pl.uncleglass.feeder.backend.app.meal.port.out.LoadAllMealsPort;
import pl.uncleglass.feeder.backend.app.meal.port.out.LoadMealPort;
import pl.uncleglass.feeder.backend.app.meal.port.out.LoadMealsByMealTypePort;

import java.util.ArrayList;
import java.util.List;

@Component
public class MealPersistenceAdapter implements
        AddMealPort,
        DeleteMealPort,
        LoadAllMealsPort,
        LoadMealPort,
        LoadMealsByMealTypePort {
    @Override
    public void addMeal(Meal meal) {

    }

    @Override
    public void deleteMeal(Meal meal) {

    }

    @Override
    public List<Meal> loadAllMeals() {
        return new ArrayList<>();
    }

    @Override
    public Meal loadMeal(long mealId) {
        return new Meal();
    }

    @Override
    public List<Meal> leadMealsByMealType(MealType mealType) {
        return new ArrayList<>();
    }
}
