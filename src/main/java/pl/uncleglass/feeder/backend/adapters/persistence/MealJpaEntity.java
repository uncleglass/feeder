package pl.uncleglass.feeder.backend.adapters.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.uncleglass.feeder.backend.app.meal.domain.MealType;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "meals")
@Data
@AllArgsConstructor
@NoArgsConstructor
class MealJpaEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    private String notes;
    private int calories;

    @ElementCollection(
            targetClass = MealType.class,
            fetch = FetchType.EAGER)
    @CollectionTable(
            name = "meal_type",
            joinColumns = @JoinColumn(name = "meal_id")
    )
    @Column(name = "meal_type_id")
    private Set<MealType> mealTypes = new HashSet<>();
}
