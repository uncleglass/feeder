package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.Data;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "day_menus")
@Data
class DayMenuJpaEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate date;

    @ElementCollection
    @MapKeyColumn(name = "meal_type")
    private Map<MealType, MealJpaEntity> meals;
}
