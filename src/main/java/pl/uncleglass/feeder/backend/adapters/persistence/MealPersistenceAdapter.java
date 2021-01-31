package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;
import pl.uncleglass.feeder.backend.app.meal.port.out.AddMealPort;
import pl.uncleglass.feeder.backend.app.meal.port.out.DeleteMealPort;
import pl.uncleglass.feeder.backend.app.meal.port.out.GetAllMealsPort;
import pl.uncleglass.feeder.backend.app.meal.port.out.LoadMealPort;
import pl.uncleglass.feeder.backend.app.meal.port.out.LoadMealsByMealTypePort;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
class MealPersistenceAdapter implements
        AddMealPort,
        GetAllMealsPort,
        DeleteMealPort,
        LoadMealPort,
        LoadMealsByMealTypePort {
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

    @Override
    public Meal loadMeal(UUID mealId) {
        MealJpaEntity mealJpaEntity = mealRepository.findById(mealId)
                .orElseThrow(EntityNotFoundException::new);
        return mealMapper.mapToDomainEntity(mealJpaEntity);
    }

    @Override
    public List<Meal> leadMealsByMealType(MealType mealType) {
        List<MealJpaEntity> mealJpaEntities = mealRepository.findAllByMealTypes(mealType);
        return mealMapper.mapToDomainEntityList(mealJpaEntities);
    }
}
