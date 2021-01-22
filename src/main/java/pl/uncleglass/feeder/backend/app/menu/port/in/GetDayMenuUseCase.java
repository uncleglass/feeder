package pl.uncleglass.feeder.backend.app.menu.port.in;

import pl.uncleglass.feeder.backend.app.menu.domain.DayMenu;

import java.time.LocalDate;

public interface GetDayMenuUseCase {
    DayMenu getDayMenu(LocalDate date);
}
