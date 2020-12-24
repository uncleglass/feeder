package pl.uncleglass.feeder.adapters;

import org.springframework.beans.BeanUtils;
import pl.uncleglass.feeder.backend.meals.Meal;
import pl.uncleglass.feeder.backend.meals.MealType;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static pl.uncleglass.feeder.backend.meals.MealType.BRANCH;
import static pl.uncleglass.feeder.backend.meals.MealType.BREAKFAST;
import static pl.uncleglass.feeder.backend.meals.MealType.LUNCH;
import static pl.uncleglass.feeder.backend.meals.MealType.SNACK;
import static pl.uncleglass.feeder.backend.meals.MealType.SUPPER;

public class MealMapper {
    private MealMapper() {
    }

    public static List<MealDto> mapToMealDtoList(List<Meal> all) {
        return all.stream()
                .map(MealMapper::mapToMealDto)
                .collect(Collectors.toList());
    }

    private static MealDto mapToMealDto(Meal meal) {
        MealDto mealDto = new MealDto();
        BeanUtils.copyProperties(meal, mealDto, "mealTypes");
        Set<String> mealTypes = convertFromMealTypes(meal.getMealTypes());
        mealDto.setMealTypes(mealTypes);
        return mealDto;
    }

    private static Set<String> convertFromMealTypes(Set<MealType> mealTypes) {
        return mealTypes.stream()
                .map(MealMapper::convertMealType)
                .collect(Collectors.toSet());
    }

    public static String   convertMealType(MealType mealType) {
        switch (mealType) {
            case BREAKFAST:
                return "Śniadanie";
            case BRANCH:
                return "Drugie śniadanie";
            case LUNCH:
                return "Obiad";
            case SNACK:
                return "Przekąska";
            case SUPPER:
                return "Kolacja";
            default:
                throw new IllegalArgumentException("Unsupported meal type");
        }
    }

    private static MealType convertMealTypeStr(String mealType) {
        switch (mealType) {
            case "Śniadanie":
                return BREAKFAST;
            case "Drugie śniadanie":
                return BRANCH;
            case "Obiad":
                return LUNCH;
            case "Przekąska":
                return SNACK;
            case "Kolacja":
                return SUPPER;
            default:
                throw new IllegalArgumentException("Unsupported meal type");
        }
    }

    public static Meal mapToMeal(MealDto mealDto) {
        Meal meal = new Meal();
        BeanUtils.copyProperties(mealDto, meal, "mealTypes");
        Set<MealType> mealTypes = convertToMealTypes(mealDto.getMealTypes());
        meal.setMealTypes(mealTypes);
        return meal;
    }

    private static Set<MealType> convertToMealTypes(Set<String> mealTypes) {
        return mealTypes.stream()
                .map(MealMapper::convertMealTypeStr)
                .collect(Collectors.toSet());
    }
}
