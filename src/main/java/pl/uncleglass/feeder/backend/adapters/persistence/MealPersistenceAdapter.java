package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class MealPersistenceAdapter implements
        AddMealPort,
        DeleteMealPort,
        LoadAllMealsPort,
        LoadMealPort,
        LoadMealsByMealTypePort {

    private final MealDAO mealDAO;

    @Override
    public void addMeal(Meal meal) {
        MealEntity mealEntity = MealMapper.mapDomainObjectToEntity(meal);
        if (mealEntity.getId() == null) {
            mealDAO.saveNewMeal(mealEntity);
        } else {
            //mealDAO.updateMeal(mealEntity);
        }
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
