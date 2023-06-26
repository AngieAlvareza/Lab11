package Hash;
//Angie Alvareza Code 
import java.util.ArrayList;

public class HashC<E extends Comparable<E>>{
	protected class Element{
		int mark; //indica si esta ocupaod o empty
		Register<E>reg;
		
		public Element (int mark,Register<E> reg) {//constructor
			this.mark = mark;
			this.reg = reg;
			
		}
	}
	protected ArrayList<Element> table;
	protected int m;//tamaño de la tabla hash
	
	public void Hash(int n) {
		this.m = n;
		this.table = new ArrayList<Element>(m);
		for (int i = 0; i <m; i ++) //itero de 0  hasta m -1
			this.table.add(new Element (0, null));
		
	}
	private int functionHash(int Key) {
		int d=0;
		//(Key % m)= d;
		//System.out.println(m-1);
		return Key % (m-1);
		
	}
	
	//CUADRADO ////
//	private int functionHash(int key) {
//        // Método del cuadrado
//        int square = key * key;
//        String squareStr = String.valueOf(square);
//        if (squareStr.length() < 2) {
//            return Integer.parseInt(squareStr);
//        } else {
//            int startIndex = squareStr.length() / 2 - 1;
//            int endIndex = startIndex + 2;
//            String substring = squareStr.substring(startIndex, endIndex);
//            return Integer.parseInt(substring);
//        }
//    }
	 //meetodo suma 
	private int foldingHash(int key) {
        // Método por pliegue aplicando suma
        String keyStr = String.valueOf(key);
        int sum = 0;
        for (int i = 0; i < keyStr.length(); i++) {
            char digit = keyStr.charAt(i);
            sum += Character.getNumericValue(digit);
        }
        return sum % m;
    }
	
	private int linearProbing (int hashedAdress , int key) {
		//metodo que realiza exploraion lineal para resolver las colisiciones 
		 int i = 1; //variable contador en caso de colisiones
	     int hashedAddress = 0;
	     int address = hashedAddress;
	     while (table.get(address).mark == 1 && table.get(address).reg.getKey() != key) {
	    	 address = (hashedAddress + i) % m; //linear
	         i++;
	     }
	     return address;
		
	}

	public int insert(int key, E reg) {
		Register<E> reg1 = new Register<>(key, reg);
        int hashedAddress = functionHash(key);
        int address = linearProbing(hashedAddress, key);
        table.set(address, new Element(1, reg1));
        System.out.println("se ha insertado "+key+" en el espacio  "+functionHash(key));
		return address;
    }
//
	
	public E search (int key) {
		int hashedAddress = functionHash(key);
        int address = linearProbing(hashedAddress, key);
        if (table.get(address).mark == 1 && table.get(address).reg.getKey() == key) {
        	//functionHash(key);
        	//System.out.println("El dato buscado esta en el espacio"+ functionHash(key));
            return table.get(address).reg.getData()  ;
        }
        return null;
	}
//	public String toString() {
//		String s = "d.Real\tD.Hash\tRegister\n";
//        int i = 0;//muestro indice de la direccion
//        for (Element item : table) {
//            s += (i++) + " ---> \t";//agrego el indice de direcion
//            if (item.mark == 1) {
//                int hashedAddress = functionHash(item.reg.getKey());
//                s += hashedAddress + "\t" + item.reg + "\n";
//            } else {
//                s += "empty\n";
//            }
//        }
//        return s;
//	}
	public String toString() {
	    String s = "Posicion.Real\t|Pos.Hash \t|Register       |\n";
	    System.out.println("-------------------------------------------------");
	    int i = 0;
	    for (Element item : table) {
	    	//System.out.println(table);
	        s += (i++) + "      --> \t";
	        if (item.mark == 1) {
	            s += "|" +functionHash(item.reg.getKey()) + "\t\t|" + item.reg + "\n";
	        } else {
	            s += "|empty\n";
	        }
	    }
	    
	    return s;       
	}
}




	
