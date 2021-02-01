package pl.uncleglass.feeder.backend.adapters.vaadin;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class MealDto {
    private Long id;
    private String name;
    private String description;
    private String notes;
    private Integer calories;
    private Set<String> mealTypes;
}
