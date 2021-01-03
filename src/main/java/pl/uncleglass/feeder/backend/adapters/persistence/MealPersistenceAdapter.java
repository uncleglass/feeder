package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.port.out.AddMealPort;
import pl.uncleglass.feeder.backend.app.meal.port.out.DeleteMealPort;
import pl.uncleglass.feeder.backend.app.meal.port.out.GetAllMealsPort;

import java.util.List;

@Service
@RequiredArgsConstructor
class MealPersistenceAdapter implements AddMealPort, GetAllMealsPort, DeleteMealPort {
    private final MealRepository mealRepository;
    private final MealMapper mealMapper;

    @Override
    public void addMeal(Meal meal) {
        mealRepository.save(mealMapper.mapToJpaEntity(meal));
    }

    @Override
    public List<Meal> getAllMeals() {
        return mealMapper.mapToDomainEntityList(mealRepository.findAll());
    }

    @Override
    public void deleteMeal(Meal meal) {
        mealRepository.delete(mealMapper.mapToJpaEntity(meal));
    }
}
