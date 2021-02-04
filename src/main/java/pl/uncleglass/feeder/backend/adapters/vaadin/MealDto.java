package pl.uncleglass.feeder.backend.adapters.vaadin;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class MealDto {
    private long id;
    private String name;
    private String description;
    private String notes;
    private int calories;
    private Set<String> mealTypes;
}
