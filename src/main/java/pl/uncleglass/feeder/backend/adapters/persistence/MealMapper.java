package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import pl.uncleglass.feeder.backend.app.meal.domain.Meal;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;

import java.util.Set;
import java.util.stream.Collectors;

import static pl.uncleglass.feeder.backend.app.meal.domain.MealType.BRANCH;
import static pl.uncleglass.feeder.backend.app.meal.domain.MealType.BREAKFAST;
import static pl.uncleglass.feeder.backend.app.meal.domain.MealType.LUNCH;
import static pl.uncleglass.feeder.backend.app.meal.domain.MealType.SNACK;
import static pl.uncleglass.feeder.backend.app.meal.domain.MealType.SUPPER;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MealMapper {

    static MealEntity mapDomainObjectToEntity(Meal meal) {
        MealEntity mealEntity = new MealEntity();
        BeanUtils.copyProperties(meal, mealEntity, "mealTypes");
        mealEntity.setMealTypes(convertFromMealTypes(meal.getMealTypes()));
        return mealEntity;
    }

    private static Set<Integer> convertFromMealTypes(Set<MealType> mealTypes) {
        return mealTypes.stream()
                .map(MealMapper::convertMealType)
                .collect(Collectors.toSet());
    }

    private static Integer convertMealType(MealType mealType) {
        switch (mealType) {
            case BREAKFAST:
                return 0;
            case BRANCH:
                return 1;
            case LUNCH:
                return 2;
            case SNACK:
                return 3;
            case SUPPER:
                return 4;
            default:
                throw new IllegalArgumentException("Unsupported meal type");
        }
    }

    static Meal mapEntityObjectToDomain(MealEntity mealEntity) {
        Meal meal = new Meal();
        BeanUtils.copyProperties(mealEntity, meal, "mealTypes");
        meal.setMealTypes(convertToMealTypes(mealEntity.getMealTypes()));
        return meal;
    }

    private static Set<MealType> convertToMealTypes(Set<Integer> mealTypes) {
        return mealTypes.stream()
                .map(MealMapper::convertMealType)
                .collect(Collectors.toSet());

    }

    private static MealType convertMealType(Integer mealType) {
        switch (mealType) {
            case 0:
                return BREAKFAST;
            case 1:
                return BRANCH;
            case 2:
                return LUNCH;
            case 3:
                return SNACK;
            case 4:
                return SUPPER;
            default:
                throw new IllegalArgumentException("Unsupported meal type");
        }
    }
}
