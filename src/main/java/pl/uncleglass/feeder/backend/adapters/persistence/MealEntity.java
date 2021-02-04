package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class MealEntity {
    private  Long id;
    private  String name;
    private  String description;
    private  String notes;
    private  Integer calories;
    private Set<Integer> mealTypes = new HashSet<>();

    public void addMealType(Integer mealTypeId) {
        mealTypes.add(mealTypeId);
    }
}
