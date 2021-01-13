package controllers;

import lombok.RequiredArgsConstructor;
import model.Product;
import org.springframework.web.bind.annotation.*;
import repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;

    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @GetMapping
    public List<Product> getAllProducts() {return productRepository.findAll();}

    @PostMapping
    public Product save(@RequestBody Product product){return productRepository.save(product);}

    @GetMapping("/delete/{id}")
    public void delete(@RequestBody Long id){productRepository.deleteById(id);}

    @GetMapping("/show")
    public List<Product> getProductsWhere(
            @RequestParam(defaultValue = "0", name = "min") int min,
            @RequestParam(defaultValue = "0", name = "max") int max) {
        return productRepository.findAllByPriceBetween(min, max);
    }
}
