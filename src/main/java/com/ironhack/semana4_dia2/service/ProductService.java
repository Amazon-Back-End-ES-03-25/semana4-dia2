package com.ironhack.semana4_dia2.service;

import com.ironhack.semana4_dia2.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    // OPCIÓN 1
    private final ArrayList<Product> productArrayList = new ArrayList<>();

    public ProductService() {
        productArrayList.add(new Product(productArrayList.size(), "Laptop", "electronics", 80));
        productArrayList.add(new Product(productArrayList.size(), "Headphones", "electronics", 20));
        productArrayList.add(new Product(productArrayList.size(), "Notebook", "stationary", 5));
        productArrayList.add(new Product(productArrayList.size(), "Pen", "stationary", 2));
        productArrayList.add(new Product(productArrayList.size(), "Phone", "electronics", 60));
        productArrayList.add(new Product(productArrayList.size(), "Backpack", "accessories", 30));
    }

    // OPCIÓN 2 - lo mismo pero en una línea pero no podemos acceder al size
    private final List<Product> products = List.of(
            new Product(1L, "Laptop", "electronics", 80),
            new Product(2L, "Headphones", "electronics", 20),
            new Product(3L, "Notebook", "stationary", 5),
            new Product(4L, "Pen", "stationary", 2),
            new Product(5L, "Phone", "electronics", 60),
            new Product(6L, "Backpack", "accessories", 30));

    // OPCIÓN 3 - solo si no voy a añadir más productos y no necesito acceder al size
    private final Product[] productArray = {
            new Product(1L, "Laptop", "electronics", 80),
            new Product(2L, "Headphones", "electronics", 20),
            new Product(3L, "Notebook", "stationary", 5),
            new Product(4L, "Pen", "stationary", 2),
            new Product(5L, "Phone", "electronics", 60),
            new Product(6L, "Backpack", "accessories", 30)
    };

    // Método para traerme todos los productos
    public List<Product> getAllProducts() {
        return productArrayList;
    }


    // Método para traerme el producto por id
    public Product getProductById(Long id) {
        for (Product product : productArrayList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        // throw new NoSuchElementException("Product not found with id: " + id); --> tiro una excepción si no encuentro nada
        return null;
    }

    // Buscar productos por categoría, por precio mínimo y máximo
    public List<Product> getProductsByParams(List<String> categories, int minPrice, int maxPrice) {
        List<Product> result = new ArrayList<>();

        for (Product product : productArrayList) {
            // Checkear si es la misma categoria
            boolean equalsCategory = categories == null || categories.isEmpty() || categories.contains(product.getCategory());
            // Checkear si el precio está en el rango
            boolean isInMinPriceRange = product.getPrice() >= minPrice;
            boolean isInMaxPriceRange = product.getPrice() <= maxPrice;
            boolean matchesPriceRange = isInMinPriceRange && isInMaxPriceRange;

            if (equalsCategory && matchesPriceRange) {
                result.add(product);
            }
        }

        return result;
    }

    public List<Product> getProductsByCategory(String category) {
        List<Product> result = new ArrayList<>();

        for (Product product : productArrayList) {
            boolean equalsCategory = category == null || product.getCategory().equalsIgnoreCase(category); //--> cuando era solo una String, no una lista
            if (equalsCategory) {
                result.add(product);
            }
        }

        return result;
    }

    public List<Product> getProductsByPriceRange(int minPrice, int maxPrice) {
        List<Product> result = new ArrayList<>();

        for (Product product : productArrayList) {
            // Checkear si el precio está en el rango
            boolean isInMinPriceRange = product.getPrice() >= minPrice;
            boolean isInMaxPriceRange = product.getPrice() <= maxPrice;
            boolean matchesPriceRange = isInMinPriceRange && isInMaxPriceRange;

            if (matchesPriceRange) {
                result.add(product);
            }
        }

        return result;
    }
}
