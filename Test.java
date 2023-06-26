package Hash;
//@Angie Alvareza Code 
import Hash.HashC;

public class Test {
    public static void main(String[] args) {
        HashC<String> hashTable = new HashC<>();
        hashTable.Hash(11); // Crear tabla hash de tamaño 11

        hashTable.insert(34, " RegistrosPrueba1");
        hashTable.insert(3, " Registro2");
        hashTable.insert(7, "R egistro3");
        hashTable.insert(30, " Registro4");
        hashTable.insert(11, " Registro5");
        hashTable.insert(8, " Registro6");
        hashTable.insert(7, " Registro7");
        hashTable.insert(23, " Registro8");
        hashTable.insert(41, " Registro9");
        hashTable.insert(16, " Registro10");
        hashTable.insert(34, " Registro11");
        

        System.out.println(hashTable.toString());
        System.out.println("-------------------------------------------------");
        
        hashTable.search(23);
        System.out.println("Buscamos el elemento 23");
        System.out.println(hashTable.search(23));
    }
}
