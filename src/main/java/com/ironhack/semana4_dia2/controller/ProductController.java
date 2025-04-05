package com.ironhack.semana4_dia2.controller;

import com.ironhack.semana4_dia2.model.Product;
import com.ironhack.semana4_dia2.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products") // Hace que todos mis endpoints empiezen con /products
public class ProductController {

    // Inyección de dependencias por constructor
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Inyección de dependcias por Autowired
//    @Autowired
//    private ProductService productService;


    // Traerme todos los productos
    // http://localhost:8080/products
    @GetMapping()
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Traerme el producto por id
    // http://localhost:8080/products/id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) { // @PathVariable --> extraer el valor/variable desde nuestra URL
        return productService.getProductById(id);
    }

    // Buscar productos por categoría, por precio mínimo y máximo
    // http://localhost:8080/products/search
    // http://localhost:8080/products/search?maxPrice=int
    // http://localhost:8080/products/search?minPrice=int&maxPrice=int
    // http://localhost:8080/products/search?minPrice=int&maxPrice=int&productCategory=String
    @GetMapping("/search")
    public List<Product> getProductsByParams(@RequestParam(required = false, name = "productCategory") List<String> categories, @RequestParam(defaultValue = "0") int minPrice, @RequestParam(defaultValue = "100") int maxPrice) { // @RequestParam --> extráe parámetros desde nuestra URL
        return productService.getProductsByParams(categories, minPrice, maxPrice);
    }

    // @RequestParam --> es obligatorio y el nombre tendrá que ser igual en la URL y el parámetro del método
    // @RequestParam(required = false) --> es OPCIONAL y el nombre tendrá que ser igual en la URL y el parámetro del método
    // @RequestParam(name = "newName") --> es obligatorio y el nombre de la URL será newName y el del parámetro el que esté en el método

    @GetMapping("/search/category")
    public List<Product> getProductsByCategory(@RequestParam(required = false, name = "productCategory") String category) {
        return productService.getProductsByCategory(category);
    }

    @GetMapping("/search/price-range")
    public List<Product> getProductsByPriceRange(@RequestParam(defaultValue = "0") int minPrice, @RequestParam(defaultValue = "100") int maxPrice) {
        return productService.getProductsByPriceRange(minPrice, maxPrice);
    }
}
