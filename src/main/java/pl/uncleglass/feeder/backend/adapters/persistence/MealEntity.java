package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class MealEntity {
    private final Long id;
    private final String name;
    private final String description;
    private final String notes;
    private final Integer calories;
    private final Set<Integer> mealTypes;

}
