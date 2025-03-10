package com.hexagonaljava;

import java.util.List;
import java.util.Scanner;

import com.hexagonaljava.application.usecase.client.ClientUseCase;
import com.hexagonaljava.application.usecase.product.ProductUseCase;
import com.hexagonaljava.domain.entity.Client;
import com.hexagonaljava.domain.entity.Product;
import com.hexagonaljava.domain.repository.ClientRespository;
import com.hexagonaljava.domain.repository.ProductRepository;
import com.hexagonaljava.infrastructure.database.ConnectionFactory;
import com.hexagonaljava.infrastructure.persistence.client.ClientRepositoryImpl;
import com.hexagonaljava.infrastructure.persistence.product.ProductRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        ClientRespository clientRepository = new ClientRepositoryImpl(ConnectionFactory.crearConexion());
        ProductRepository productRepository = new ProductRepositoryImpl(ConnectionFactory.crearConexion());

        ClientUseCase clientUseCase = new ClientUseCase(clientRepository);
        ProductUseCase productUseCase = new ProductUseCase(productRepository);

        
        try(Scanner teclado = new Scanner(System.in)){
            int option;

           do {
            System.out.println("**GESTION DE CLIENTES**");
            System.out.println("Seleccione una opcion");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. listar cliente");
            System.out.println("3. Actualizar datos de cliente");
            System.out.println("**GESTION DE PRODUCTOS**");
            System.out.println("4. Gestionar productos");
            System.out.println("5. Listar productos");
            System.out.println("0. Salir");
            System.out.println("Ingrese opcion");

            option = teclado.nextInt();

            teclado.nextLine(); 
            switch (option) {
                case 1:
                 
                 System.out.println("Ingrese el ID del cliente: ");
                 int id = teclado.nextInt();
                 teclado.nextLine(); 

                 System.out.println("Ingrese su nombre: ");
                 String nombre = teclado.nextLine();

                 System.out.println("Ingrese su Email: ");
                 String email = teclado.nextLine();

                 clientUseCase.registrarCliente(id, nombre, email);
                 System.out.println("CLIENTE REGISTRADO CON EXITO");
                    
                    break;

                case 2:
            
                 List<Client> cliente = clientUseCase.listarClientes();
                 System.out.println("Lista de clientes: ");
                 for (Client client : cliente){
                    System.out.println(client);
                 }
                    break;

                    case 3:
                
                    System.out.println("Ingrese el id del cliente que desea actualizar ");
                    
                     teclado.nextLine(); 
                    case 4:
                     
                     System.out.println("Ingrese el ID del producto: ");
                     int productoid = teclado.nextInt();
                     teclado.nextLine(); 

                     System.out.println("Ingrese el nombre del producto: ");
                     String nombreProducto = teclado.nextLine();

                     System.out.println("Ingrese Stock del producto: ");
                     int stock = teclado.nextInt();

                     productUseCase.registrarproducto(productoid, nombreProducto, stock);
                     System.out.println("Producto registrado exitosamente.");
                

                    break;

                    case 5:
                      
                        List<Product> productos = productUseCase.listarProductos();
                        System.out.println("Lista de Productos:");
                        for (Product producto : productos) {
                            System.out.println(producto);
                        }

                    break;

                    case 0:
                    System.out.println("👋 Saliendo...");
                    break;

                default:
                System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
           } while (option != 0);

        }
    }
}
