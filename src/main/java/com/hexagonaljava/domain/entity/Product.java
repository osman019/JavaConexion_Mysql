package com.hexagonaljava.domain.entity;

public class Product {
    private int id;
    private String nombreProducto;
    private int stock;
    public Product(int id, String nombreProducto, int id2) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.stock = id2;
    }

    public  int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return  nombreProducto;
    }
    public void setName(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public int getstock() {
        return stock;
    }
    public void setstock(int stock) {
        this.stock = stock;
    }
    
    public String toString() {
        return String.format("ID: %d | NOMBRE: %s | STOCK: %s", id, nombreProducto, stock);
    }
}
