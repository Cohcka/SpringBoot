package ru.student.shop;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
public class ProductInMemoryRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Pineapple", 110),
                new Product(2L, "Apple", 1),
                new Product(3L, "Whisky", 499)
        ));
    }

    public Product saveOrUpdate(Product s) {
        if (s.getId() != null) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId().equals(s.getId())) {
                    products.set(i, s);
                    return s;
                }
            }
        }

        Long newId = products.stream().mapToLong(Product::getId).max().orElseGet(() -> 0L) + 1L;
        s.setId(newId);
        products.add(s);
        return s;
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public Optional<Product> findById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id) {
        products.removeIf(s -> s.getId().equals(id));
    }
}
