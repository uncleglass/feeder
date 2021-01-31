package pl.uncleglass.feeder.backend.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
interface DayMenuRepository extends JpaRepository<DayMenuJpaEntity, UUID> {
    DayMenuJpaEntity findDayMenuJpaEntitiesByDate(LocalDate date);
}
