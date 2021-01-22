package pl.uncleglass.feeder.backend.app.menu.port.out;

import pl.uncleglass.feeder.backend.app.menu.domain.DayMenu;

import java.time.LocalDate;

public interface LoadDayMenuPort {
    DayMenu loadDayMenu(LocalDate date);
}
