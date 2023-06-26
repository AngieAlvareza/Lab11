package Ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class HashingExample {
    private static final double LOAD_FACTOR = 0.4; // Factor de carga
    private static final int QUADRATIC_CONSTANT = 1; // Constante de búsqueda cuadrática

    private int tableSize; // Tamaño de la tabla hash
    private int elementCount; // Cantidad de elementos en el archivo
    private Employee[] hashTable; // Tabla hash

    public HashingExample() {
        tableSize = 0;
        elementCount = 0;
        hashTable = null;
    }

    public static void readEmployeeFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            // Leer la cantidad de elementos (valor "m")
            int m = Integer.parseInt(scanner.nextLine());
            System.out.println("Cantidad de elementos: " + m);

            // Resto del código para leer los empleados

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encuentra: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al leer la cantidad de elementos: " + e.getMessage());
        }
    }
//    public void readEmployeeFile(String fileName) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader(fileName));
//
//        // Leer la cantidad de elementos en el archivo
//        String line = reader.readLine();
//        elementCount = Integer.parseInt(line);
//
//        // Determinar el tamaño de la tabla hash
//        tableSize = (int) (elementCount / LOAD_FACTOR);
//        tableSize += (int) (tableSize * 0.4); // Agregar el 40% adicional
//
//        // Crear la tabla hash
//        hashTable = new Employee[tableSize];
//
//        // Leer los empleados del archivo y agregarlos a la tabla hash
//        for (int i = 0; i < elementCount; i++) {
//            line = reader.readLine();
//            String[] parts = line.split(",");
//            int code = Integer.parseInt(parts[0]);
//            String name = parts[1];
//            String address = parts[2];
//            Employee employee = new Employee(code, name, address);
//            addEmployee(employee);
//        }
//
//        reader.close();
//    }

    public void addEmployee(Employee employee) {
        int hash = getHash(employee.getCode());
        int index = hash;

        // Resolver colisiones mediante búsqueda cuadrática
        int i = 1;
        while (hashTable[index] != null) {
            index = (hash + QUADRATIC_CONSTANT * i * i) % tableSize;
            i++;
        }

        // Agregar el empleado a la tabla hash
        hashTable[index] = employee;
    }

//    public void displayHashTable() {
//        for (int i = 0; i < tableSize; i++) {
//            Employee employee = hashTable[i];
//            int hash = getHash(i);
//            String realAddress = employee != null ? Integer.toString(i) : "empty";
//            int searchLength = getSearchLength(i, hash);
//            System.out.println(i + " -->\t" + hash + "\t" + realAddress + "\tSearch Length: " + searchLength);
//        }
//    }
    
    public void displayHashTable() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("Lista en el índice " + i + ":");
            if (hashTable[i] != null) {
                System.out.println(hashTable[i].toString());
            } else {
                System.out.println("Lista vacía");
            }
            System.out.println();
        }
    }

    private int getHash(int code) {
        return code % tableSize;
    }

    private int getSearchLength(int index, int hash) {
        int searchLength = 0;
        int i = 1;
        int currentIndex = hash;

        while (hashTable[currentIndex] != null && currentIndex != index) {
            currentIndex = (hash + QUADRATIC_CONSTANT * i * i) % tableSize;
            searchLength++;
            i++;
        }

        return searchLength;
    }
}
