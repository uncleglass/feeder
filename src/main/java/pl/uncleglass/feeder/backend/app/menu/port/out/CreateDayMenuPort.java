package pl.uncleglass.feeder.backend.app.menu.port.out;

import pl.uncleglass.feeder.backend.app.menu.domain.DayMenu;

public interface CreateDayMenuPort {
    DayMenu createDayMenu(DayMenu date);
}
