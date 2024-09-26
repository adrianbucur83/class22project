package com.siit.class22project.service;

import com.siit.class22project.model.Product;
import com.siit.class22project.model.ProductCreateDto;
import com.siit.class22project.model.ProductReturnDto;
import com.siit.class22project.model.ProductUpdateDto;
import com.siit.class22project.repository.ProductJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Value("${minimum.profit}")
    private double minimumProfit;

    private final ProductJPARepository productJPARepository;

    public List<ProductReturnDto> getProducts() {
        return productJPARepository.findAll()
                .stream()
                .map(Product::toReturnDto)
                .toList();
    }

    public ProductReturnDto getProductByName(String name) {
        return productJPARepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Product not found by name: %s".formatted(name)))
                .toReturnDto();
    }

    public ProductReturnDto getProductById(Long id) {
        return productJPARepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found by id: %s".formatted(id)))
                .toReturnDto();
    }

    public ProductReturnDto createProduct(ProductCreateDto productCreateDto) {
        Product product = productCreateDto.toProduct();
        return productJPARepository.save(product)
                .toReturnDto();
    }

    public void deleteProductById(Long id) {
        Product product;
        if (id == null) {
            throw new RuntimeException("Product not found");
        }
        Optional<Product> productOptional = productJPARepository.findById(id);
        if (productOptional.isPresent()) {
            productJPARepository.deleteById(id);
        }

    }

    public void updateProduct(ProductUpdateDto productUpdateDto) {
        Product product = productJPARepository.findById(productUpdateDto.getId())
                .orElseThrow(() ->  new RuntimeException("Product not found for update with id " + productUpdateDto.getId()));
        product.setPrice(productUpdateDto.getPrice());
        product.setName(productUpdateDto.getName());
        productJPARepository.save(product);
    }
}
