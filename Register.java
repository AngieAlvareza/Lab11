package Hash;

public class Register<E> implements Comparable<Register<E>> {
    protected int key;
    private E data;

    public Register(int key, E data) {
        this.key = key;
        this.data = data;
    }

//    public E getKey() {
//        return key;
//    }
//
//    public E getData() {
//        return data;
//    }
    @Override
    public int compareTo(Register<E> other) {
        // Implementa la lógica de comparación aquí
        // Retorna un número negativo si this es menor que other
        // Retorna cero si this es igual a other
        // Retorna un número positivo si this es mayor que other
        // Puedes modificar esta implementación según tus necesidades
        	return this.key-other.key;
        
    }
    public boolean equals (Object o ) {
    	if (o instanceof Register) {
    		Register<E> other = (Register<E>)o;
    		return other.key == this.key;
    		
    	}
    	return false;
    	
    }
    public int getKey() {
    	return this.key;}
    public E getData() {
        return this.data;
    }
    
    public String toString() {
    	return this.key+":"+this.data.toString();
    }
}
