package com.ironhack.semana4_dia2.model;

public class Product {
    // private long id;
    private Long id;
    private String name;
    private String category;
    private int price;

    public Product(int size, String name, String category, int price) {
        this.id = (long) size + 1;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Product(Long id, String name, String category, int price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
