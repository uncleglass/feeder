package pl.uncleglass.feeder.web.controllers;

import org.springframework.stereotype.Controller;
import pl.uncleglass.feeder.service.services.ProductService;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
}
