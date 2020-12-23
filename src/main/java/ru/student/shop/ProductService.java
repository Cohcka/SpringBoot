package ru.student.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductInMemoryRepository productInMemoryRepository;

    public Optional<Product> findById(Long id) {
        return productInMemoryRepository.findById(id);
    }

    public List<Product> findAll() {
        return productInMemoryRepository.findAll();
    }

    public List<Product> findAll(Integer minScore, Integer maxScore) {
        List<Product> out = findAll();
        if (minScore != null) {
            out = out.stream().filter(s -> s.getCost() >= minScore).collect(Collectors.toList());
        }
        if (maxScore != null) {
            out = out.stream().filter(s -> s.getCost() <= maxScore).collect(Collectors.toList());
        }
        return out;
    }

    public Product saveOrUpdate(Product s) {
        return productInMemoryRepository.saveOrUpdate(s);
    }

    public void deleteBydId(Long id) {
        productInMemoryRepository.deleteById(id);
    }
}
