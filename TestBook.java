package Ejercicio2;

import java.util.List;
import java.util.Scanner;

public class TestBook{
	public static void main(String[] args) {
	    BookSystem bookSystem = new BookSystem();
	    Scanner scanner = new Scanner(System.in);
	
	    int choice = -1;
	    System.out.println("Hi");
	    while (choice != 0) {
	        System.out.println("1. Agregar Libro");
	        System.out.println("2. Modificar Libro");
	        System.out.println("3. Compra Segura");
	        System.out.println("4. Listado de Libros");
	        System.out.println("0. Salir");
	        System.out.print("Ingrese una opción: ");
	        choice = scanner.nextInt();
	        scanner.nextLine();
	
	        switch (choice) {
	            case 1:
	                System.out.print("Titulo: ");
	                String title = scanner.nextLine();
	                System.out.print("Autor: ");
	                String author = scanner.nextLine();
	                System.out.print(" Venta: ");
	                int sales = scanner.nextInt();
	                System.out.print("Rating: ");
	                int rating = scanner.nextInt();
	                scanner.nextLine();
	                System.out.print("Especialidad: ");
	                String specialty = scanner.nextLine();
	                System.out.print("Comemtarios: ");
	                String comments = scanner.nextLine();
	                bookSystem.addBook(title, author, sales, rating, specialty, comments);
	                break;
	            case 2:
	                System.out.print("Titulo: ");
	                title = scanner.nextLine();
	                System.out.print("Autor: ");
	                author = scanner.nextLine();
	                System.out.print("Venta: ");
	                sales = scanner.nextInt();
	                System.out.print("Rating: ");
	                rating = scanner.nextInt();
	                scanner.nextLine();
	                System.out.print("Especialidad: ");
	                specialty = scanner.nextLine();
	                System.out.print("Comentarioss: ");
	                comments = scanner.nextLine();
	                bookSystem.modifyBook(title, author, sales, rating, specialty, comments);
	                break;
	            case 3:
	                System.out.print("Autor: ");
	                author = scanner.nextLine();
	                Book bestBook = bookSystem.getBestBookByAuthor(author);
	                if (bestBook != null) {
	                    System.out.println("Compra Segura: " + bestBook.getTitle());
	                } else {
	                    System.out.println("No existe ningun libro de ese Autor.");
	                }
	                break;
	            case 4:
	                System.out.print("Especialidad: ");
	                specialty = scanner.nextLine();
	                List<Book> booksBySpecialty = bookSystem.getBooksBySpecialty(specialty);
	                if (!booksBySpecialty.isEmpty()) {
	                    System.out.println("Libros referidos a esa especialidad " + specialty);
	                    for (Book book : booksBySpecialty) {
	                        System.out.println(book.getTitle());
	                    }
	                } else {
	                    System.out.println("No se han encontrado libros para esa especialidad.");
	                }
	                break;
	            case 0:
	                System.out.println("Saliendo...");
	                break;
	            default:
	                System.out.println("Elección inválida. Eliga otra opcion");
	        }
	    }
	
	    scanner.close();
	}
}
