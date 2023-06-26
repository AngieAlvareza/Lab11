package Ejercicio3;

import java.io.IOException;

public class EmployeeMain {
    public static void main(String[] args) {
        HashingExample hashingExample = new HashingExample();

        //hashingExample.readEmployeeFile("D:UCSM//V//EMPLEADO.TXT");
        hashingExample.readEmployeeFile("D:UCSM\\V\\EMPLEADO.TXT");
		hashingExample.displayHashTable();
		//System.out.println("hi");
    }
}
