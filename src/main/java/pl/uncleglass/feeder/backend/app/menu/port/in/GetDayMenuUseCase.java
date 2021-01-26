package pl.uncleglass.feeder.backend.app.menu.port.in;

import pl.uncleglass.feeder.backend.app.menu.domain.DayMenu;

import java.time.LocalDate;
import java.util.UUID;

public interface GetDayMenuUseCase {
    DayMenu getDayMenu(LocalDate date);

    DayMenu getDayMenu(UUID dayMenuId);
}
