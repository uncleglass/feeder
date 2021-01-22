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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "day_menus")
@Data
@AllArgsConstructor
@NoArgsConstructor
class DayMenuJpaEntity {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDate date;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(
            name = "day_menus_meals",
            joinColumns = @JoinColumn(name = "day_menu_id", referencedColumnName = "id")
    )
    @MapKeyEnumerated
    private Map<MealType, MealJpaEntity> meals = new HashMap<>();
}
