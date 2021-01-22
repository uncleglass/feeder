package pl.uncleglass.feeder.backend.app.menu.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.menu.domain.DayMenu;
import pl.uncleglass.feeder.backend.app.menu.port.in.GetDayMenuUseCase;
import pl.uncleglass.feeder.backend.app.menu.port.out.CreateDayMenuPort;
import pl.uncleglass.feeder.backend.app.menu.port.out.LoadDayMenuPort;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class GetDayMenuService implements GetDayMenuUseCase {
    private final LoadDayMenuPort loadDayMenuPort;
    private final CreateDayMenuPort createDayMenuPort;

    @Override
    public DayMenu getDayMenu(LocalDate date) {
        DayMenu dayMenu = loadDayMenuPort.loadDayMenu(date);

        if (dayMenu == null) {
            return createDayMenuPort.createDayMenu(new DayMenu(date));
        } else {
            return dayMenu;
        }
    }
}
