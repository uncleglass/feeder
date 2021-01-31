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
    private  long id;
    private  String name;
    private  String description;
    private  String notes;
    private  int calories;
    private  Set<MealType> mealTypes;
}
