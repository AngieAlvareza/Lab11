package Ejercicio3;

import ejercicio4.Node;

class Employee2 {
    private int code;
    private String name;
    private String address;

//    public Employee(int code, String name, String address) {
//        this.code = code;
//        this.name = name;
//        this.address = address;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    @Override
//    public String toString() {
//        return "Employee [code=" + code + ", name=" + name + ", address=" + address + "]";
//    }
//}

// Clase para representar un nodo de la lista enlazada
class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

// Clase para representar una lista enlazada
class LinkedList<T> {
    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void add(T element) {
        Node<T> newNode = new Node<T>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public void displayList() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.getData().toString());
            current = current.getNext();
        }
    }

    public int getSize() {
        return size;
    }
}}