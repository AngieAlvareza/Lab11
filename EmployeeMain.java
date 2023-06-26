package ejercicio4;

import java.io.IOException;

public class EmployeeMain {
    public static void main(String[] args) {
        HashingExample hashingExample = new HashingExample();

        try {
            hashingExample.readEmployeeFile("D:UCSM\\V\\EMPLEADO.TXT");
            hashingExample.displayHashTable();
            //System.out.println("hi");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo EMPLEADO.TXT: " + e.getMessage());
        }
    }
}
