package Ejercicio3;

public class Employee {
    private int code;
    private String name;
    private String address;

    public Employee(int code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
