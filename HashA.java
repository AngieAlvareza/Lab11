package Hash;

//@Angie Alvareza Code 

import java.util.ArrayList;
import java.util.LinkedList;

public class HashA<E extends Comparable<E>> {
    protected class Element {
        int mark;
        Register<E> reg;

        public Element(int mark, Register<E> reg) {
            this.mark = mark;
            this.reg = reg;
        }
    }

    protected ArrayList<LinkedList<Element>> table;
    protected int m;

    public HashA(int size) {
        this.m = size;
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            this.table.add(new LinkedList<>());
        }
    }

    private int functionHash(int key) {
        return key % m;
    }

    public void insert(int key, E data) {
        Register<E> reg = new Register<>(key, data);
        int hashedAddress = functionHash(key);
        LinkedList<Element> chain = table.get(hashedAddress);
        chain.add(new Element(1, reg));
    }

    public E search(int key) {
        int hashedAddress = functionHash(key);
        LinkedList<Element> chain = table.get(hashedAddress);
        for (Element element : chain) {
            if (element.reg.getKey() == key) {
                return element.reg.getData();
            }
        }
        return null;
    }

    public String toString() {
        String s = "d.Real\tD.Hash\tRegister\n";
        int i = 0;
        for (LinkedList<Element> chain : table) {
            for (Element element : chain) {
                s += (i++) + " --> \t";
                s += functionHash(element.reg.getKey()) + "\t" + element.reg + "\n";
            }
        }
        return s;
    }
}
