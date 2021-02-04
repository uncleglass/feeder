package pl.uncleglass.feeder.backend.app.meal.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    private  Long id;
    private  String name;
    private  String description;
    private  String notes;
    private  Integer calories;
    private  Set<MealType> mealTypes;
}
