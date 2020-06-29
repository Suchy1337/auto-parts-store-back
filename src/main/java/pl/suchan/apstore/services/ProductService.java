package pl.suchan.apstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.suchan.apstore.DTOs.ProductDTO;
import pl.suchan.apstore.models.Product;
import pl.suchan.apstore.repositories.ProductRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(ProductDTO productDTO){
        Product product = convertToProduct(productDTO);
        productRepository.save(product);
        return product;
    }

    private Product convertToProduct(ProductDTO productDTO){
        Product product = new Product();
        return product;
    }


}
