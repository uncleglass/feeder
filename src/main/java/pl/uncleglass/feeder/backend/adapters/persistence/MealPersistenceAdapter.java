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

        if (mealEntity.getId() == 0) { //TODO change it! mapper should map long 0 to Long null
            mealDAO.saveNewMeal(mealEntity);
        } else {
            mealDAO.updateMeal(mealEntity);
        }
    }

    @Override
    public void deleteMeal(Meal meal) {
        mealDAO.deleteMeal(MealMapper.mapDomainObjectToEntity(meal));
    }

    @Override
    public List<Meal> loadAllMeals() {
        List<MealEntity> mealEntities = mealDAO.loadMeals();
        return MealMapper.mapEntityObjectToDomainList(mealEntities);
    }

    @Override
    public Meal loadMeal(long mealId) {
        return MealMapper.mapEntityObjectToDomain(mealDAO.leadMeal(mealId));
    }

    @Override
    public List<Meal> leadMealsByMealType(MealType mealType) {
        Integer typeId = MealMapper.convertMealType(mealType);
        return MealMapper.mapEntityObjectToDomainList(mealDAO.leadMealByType(typeId));
    }
}
