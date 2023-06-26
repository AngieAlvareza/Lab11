package ejercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HashingExample {
    private LinkedList<Employee>[] hashTable;
    private int size;

    public void readEmployeeFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        // Leer la cantidad de elementos del archivo
        int elementCount = Integer.parseInt(reader.readLine());

        // Calcular el tamaño de la tabla hash
        size = elementCount;

        // Crear la tabla hash
        hashTable = new LinkedList[size];

        // Leer y almacenar los empleados en la tabla hash
        String line;
        while ((line = reader.readLine()) != null) {
            String[] employeeData = line.split(",");
            int code = Integer.parseInt(employeeData[0]);
            String name = employeeData[1];
            String address = employeeData[2];

            // Calcular el índice de hash
            int hashIndex = hashFunction(code);

            // Crear el nuevo empleado
            Employee employee = new Employee(code, name, address);

            // Verificar si la lista en el índice de hash está vacía
         // Verificar si la lista en el índice de hash está vacía
            if (hashTable[hashIndex] == null) {
                // Crear una nueva lista enlazada y agregar el empleado
                LinkedList<Employee> newList = new LinkedList<>();
                newList.add(employee);
                hashTable[hashIndex] = newList;
            } else {
                // Agregar el empleado a la lista existente
                hashTable[hashIndex].add(employee);
            }

        }

        reader.close();
    }
//
//    public void displayHashTable() {
//        for (int i = 0; i < size; i++) {
//            System.out.println("Lista en el índice " + i + ":");
//            if (hashTable[i] != null) {
//                //hashTable[i].displayList();
//            } else {
//                System.out.println("Lista vacía");
//            }
//            System.out.println();
//        }
//    }
//    public void displayHashTable() {
//        for (int i = 0; i < hashTable.length; i++) {
//            System.out.println("Lista en el índice " + i + ":");
//            System.out.println(hashTable[i].toString());
//        }
//    }
//    
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



    private int hashFunction(int code) {
        return code % size;
    }
}

