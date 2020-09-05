package pl.uncleglass.feeder.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.uncleglass.feeder.domain.entities.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
}
