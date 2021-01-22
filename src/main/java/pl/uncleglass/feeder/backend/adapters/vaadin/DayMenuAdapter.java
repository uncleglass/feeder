package pl.uncleglass.feeder.backend.adapters.vaadin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.backend.app.menu.port.in.GetDayMenuUseCase;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DayMenuAdapter {
    private final GetDayMenuUseCase getDayMenuUseCase;

    public DayMenuDto getDayMenu(LocalDate date) {
        return DayMenuMapper.mapToDto(getDayMenuUseCase.getDayMenu(date));
    }
}
