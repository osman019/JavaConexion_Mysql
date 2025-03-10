package com.hexagonaljava.application.usecase.product;

import java.util.List;

import com.hexagonaljava.domain.entity.Product;
import com.hexagonaljava.domain.repository.ProductRepository;

public class ProductUseCase {
    private final ProductRepository repository;

    public ProductUseCase(ProductRepository repository) {
        this.repository = repository;
    }

    public void registrarproducto(int productoid, String nombreProducto, int stock) {
        Product producto = new Product(productoid, nombreProducto, stock);
        repository.guardar(producto);
    }

    public Product obtenerproducto(int productoid) {
        return repository.buscarPorId(productoid);
    }

    public List<Product> listarproductos() {
        return repository.listarTodos();
    }

    public void actualizarproducto(int productoid, String nombreProducto, int stock) {
        Product producto = new Product(productoid, nombreProducto, stock);
        repository.actualizar(producto);
    }

    public void eliminarproducto(int productoid) {
        repository.eliminar(productoid);
    }

  

    public List<Product> listarProductos() {
        return repository.listarTodos();
    }
}

