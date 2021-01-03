package pl.uncleglass.feeder.backend.adapters.vaadin;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
public class DayMenuDto {
    private UUID id;
    private LocalDate date;
    private Map<String, MealDto> meals;
}
