package pl.uncleglass.feeder.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.uncleglass.feeder.domain.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
