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
            System.out.println("---------------------------------");
            System.out.println("-     GESTION DE CLIENTES       -");
            System.out.println("---------------------------------");
            System.out.println("Seleccione una opcion");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. listar cliente");
            System.out.println("3. Actualizar datos de cliente");
            System.out.println("4. Eliminar cliente");
            System.out.println("                                 ");
            System.out.println("---------------------------------");
            System.out.println("-     GESTION DE PRODUCTOS      -");
            System.out.println("---------------------------------");
            System.out.println("5. Gestionar productos");
            System.out.println("6. Listar productos");
            System.out.println("7. Eliminar producto");
            System.out.println("8. Actualizar producto");
            System.out.println("0. Salir");
            System.out.println("----------------------------------");
            System.out.println("Ingrese  opcion: ");
            while (!teclado.hasNextInt()) { 
                System.out.println("¡Entrada inválida. Ingrese solo numeros validos!.");
                teclado.next();
            }
            option = teclado.nextInt();

            teclado.nextLine(); 
            switch (option) {
                case 1:
                 
                 System.out.println("Ingrese el ID del cliente: ");
                 while (!teclado.hasNextInt()) { 
                    System.out.println("¡Entrada no valida. Ingrese solo ID validos!.");
                    teclado.next();
                }
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
                    while (!teclado.hasNextInt()) { 
                        System.out.println("¡Entrada no valida. Ingrese solo ID validos!.");
                        teclado.next();
                    }
                       id = teclado.nextInt();
                      teclado.nextLine();
                      System.out.println("Ingrese su nuevo nombre: ");
                       nombre = teclado.nextLine();
     
                      System.out.println("Ingrese su nuevo email: ");
                       email = teclado.nextLine();
     
                      clientUseCase.actualizarCliente(id, nombre, email);
                      System.out.println("CLIENTE ACUALIZADO CON EXITO");
                      break;


                       case 4:
                      System.out.println("Ingrese el id del cliente que desea eliminar");
                      while (!teclado.hasNextInt()) { 
                        System.out.println("¡Entrada no valida. Ingrese solo ID validos!.");
                        teclado.next();
                    }
                      id = teclado.nextInt();
                      teclado.nextLine();
                      clientUseCase.eliminarCliente(id);
                      System.out.println("CLIENTE ELIMINADO CON EXITO");
                      break;
                    case 5:
                    System.out.println("Ingrese el ID del producto: ");
                    while (!teclado.hasNextInt()) { 
                        System.out.println("¡Entrada no valida. Ingrese solo ID validos!.");
                        teclado.next();
                    }
                    int productoid = teclado.nextInt();
                    teclado.nextLine(); 

                    System.out.println("Ingrese el nombre del producto: ");
                    String nombreProducto = teclado.nextLine();

                    System.out.println("Ingrese Stock del producto: ");
                    int stock = teclado.nextInt();

                    productUseCase.registrarproducto(productoid, nombreProducto, stock);
                    System.out.println("Producto registrado exitosamente.");
                    

                    break;
                    case 6:
                     
                    
                    List<Product> productos = productUseCase.listarProductos();
                    System.out.println("Lista de Productos:");
                    for (Product producto : productos) {
                        System.out.println(producto);
                    }

                   break;
                   case 7:
                     
                    
                   System.out.println("Ingrese el id del producto que desea eliminar");
                   while (!teclado.hasNextInt()) { 
                    System.out.println("¡Entrada no valida. Ingrese solo ID validos!.");
                    teclado.next();
                }
                   productoid = teclado.nextInt();
                   productUseCase.eliminarproducto(productoid);
                   System.out.println("Producto Eliminado Correctamente");
                  break;

                 
                 case 8:
                     
                    
                  System.out.println("Ingrese el id del producto que desea actualizar");
                  productoid = teclado.nextInt();
                  teclado.nextLine(); 

                  System.out.println("Ingrese el nuevo nombre del producto");
                  nombreProducto  = teclado.nextLine();

                  System.out.println("Ingrese el nuevo sctok del producto");
                  stock = teclado.nextInt();

                  productUseCase.actualizarproducto(productoid, nombreProducto, stock);
                  System.out.println("Producto Actualizado Correctamente");
                 break;
                    case 0:
                    System.out.println(" Vuelve pronto ");
                    break;

                default:
                System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
           } while (option != 0);

        }
    }
}
