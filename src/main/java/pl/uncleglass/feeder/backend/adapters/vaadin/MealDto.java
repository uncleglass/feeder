package pl.uncleglass.feeder.backend.adapters.vaadin;

import lombok.Getter;
import lombok.Setter;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class MealDto {
    private UUID id;
    private String name;
    private String description;
    private String notes;
    private int calories;
    private Set<String> mealTypes;
}
