package mk.ukim.finki.wpaud.service.impl;

import mk.ukim.finki.wpaud.model.Category;
import mk.ukim.finki.wpaud.model.Manufacturer;
import mk.ukim.finki.wpaud.model.Product;
import mk.ukim.finki.wpaud.model.dto.ProductDTO;
import mk.ukim.finki.wpaud.model.events.ProductCreatedEvent;
import mk.ukim.finki.wpaud.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.wpaud.model.exceptions.ManufacturerNotFoundException;
import mk.ukim.finki.wpaud.model.exceptions.ProductNotFoundException;
import mk.ukim.finki.wpaud.repository.CategoryRepository;
import mk.ukim.finki.wpaud.repository.ManufacturerRepository;
import mk.ukim.finki.wpaud.repository.ProductRepository;
import mk.ukim.finki.wpaud.service.ProductService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService
{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    //private final ProductsPerManufacturerViewRepository manufacturerViewRepository;


    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ManufacturerRepository manufacturerRepository, ApplicationEventPublisher applicationEventPublisher)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Product> findAll()
    {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id)
    {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name)
    {
        return productRepository.findByName(name);
    }

    @Override
    @Transactional
    public Optional<Product> save(ProductDTO productDTO)
    {
        Category category = categoryRepository.findById(productDTO.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException(productDTO.getCategory()));
        Manufacturer manufacturer = manufacturerRepository.findById(productDTO.getManufacturer())
                .orElseThrow(() -> new ManufacturerNotFoundException(productDTO.getManufacturer()));

        this.productRepository.deleteByName(productDTO.getName());
        Product product = new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getQuantity(), category, manufacturer);
        this.productRepository.save(product);

        this.applicationEventPublisher.publishEvent(new ProductCreatedEvent(product));
        return Optional.of(product);
    }

    @Override
    public Optional<Product> edit(Long id, ProductDTO productDto) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        Category category = this.categoryRepository.findById(productDto.getCategory())
                .orElseThrow(() -> new CategoryNotFoundException(productDto.getCategory()));
        product.setCategory(category);

        Manufacturer manufacturer = this.manufacturerRepository.findById(productDto.getManufacturer())
                .orElseThrow(() -> new ManufacturerNotFoundException(productDto.getManufacturer()));
        product.setManufacturer(manufacturer);

        this.productRepository.save(product);
        return Optional.of(product);
    }


    @Override
    public void deleteById(Long id)
    {
        productRepository.deleteById(id);
    }

//    @Override
//    public void refreshMaterializedView()
//    {
//        this.manufacturerViewRepository.refreshMaterializedView();
//    }
}
