package mk.ukim.finki.wpaud.service;

import mk.ukim.finki.wpaud.model.Product;
import mk.ukim.finki.wpaud.model.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService
{
    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    Optional<Product> save(ProductDTO productDTO);

    Optional<Product> edit(Long id, ProductDTO productDTO);

    void deleteById(Long id);

    //void refreshMaterializedView();
}
