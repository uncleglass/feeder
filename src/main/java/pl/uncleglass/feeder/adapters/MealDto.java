package pl.uncleglass.feeder.adapters;

import lombok.Getter;
import lombok.Setter;

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
