package pl.uncleglass.feeder.service.services;

import org.springframework.stereotype.Service;
import pl.uncleglass.feeder.domain.entities.Product;
import pl.uncleglass.feeder.persistence.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
