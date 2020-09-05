package pl.uncleglass.feeder.service.services;

import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.persistence.repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
