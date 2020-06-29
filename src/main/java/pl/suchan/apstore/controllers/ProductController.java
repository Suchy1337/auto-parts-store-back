package pl.suchan.apstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.suchan.apstore.DTOs.ProductDTO;
import pl.suchan.apstore.DTOs.UserDTO;
import pl.suchan.apstore.models.Product;
import pl.suchan.apstore.models.User;
import pl.suchan.apstore.services.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ResponseBody
    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }
}
