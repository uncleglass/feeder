package pl.uncleglass.feeder.backend.adapters.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface DayMenuRepository extends JpaRepository<DayMenuJpaEntity, UUID> {
}
