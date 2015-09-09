public class Heap<E extends Comparable<E>> {

    private Object conjunto[];
    private int last;
    private int capacity;
    String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789.,!?"
    int[] frecuencias = new int[66];
    private BinaryTree<int> raiz, nodoActual;

    public Heap(int cap) {
        conjunto = new Object[cap + 1];
        last = 0;
        capacity = cap;
        raiz=new BinaryTree<int>();
        nodoActual=raiz; 
    }

    public int size() {
        return last;
    }

    public void contarCaracteres(String frase){
        for (int j=0; i<caracteres.length(); j++){
            int cont=0;
            caracteres.charAt(j)=character;
            for(int i=0; i<frase.length(); i++) {
               if(frase.charAt(i).equals(character)) {
                  cont++;
               }
            }
            cont = frecuencias[j];
        }
    }

    public void ordenarTree(){
        for (int j=0; i<frecuencias.length(); j++){         //recorre todas las frecuencias
            int cantRepeticiones = frecuencias[j];
            boolean nodoColocado= false;
            while (cantRepeticiones=!0)&& (!nodoColocado){                       //si la frecuencia no es cero
                int tamanoActual = nodoActual.value();
                while (cantRepeticiones>tamanoActual){         
                    //while (nodoActual.right()=!null){       //mientras no 
                        nodoActual=nodoActual.right();
                        if (nodoActual==null){
                            BinaryTree<int> nuevoNodo = new BinaryTree<int>(cantRepeticiones);
                            nodoActual.setRight(nuevoNodo);
                            nodoColocado=true;
                        }
                        tamanoActual = nodoActual.value();
                    //}
                }
                while (cantRepeticiones>tamanoActual){
                        nodoActual=nodoActual.right();
                        if (nodoActual==null){
                            BinaryTree<int> nuevoNodo = new BinaryTree<int>(cantRepeticiones);
                            nodoActual.setRight(nuevoNodo);
                            break;
                        }
                        tamanoActual = nodoActual.value();
                    //}
                }
                else{}
            
            }
        }

    } 



    //
    // returns the number of elements in the heap
    //

    public boolean isEmpty() {
        return size() == 0;
    }

    //
    // is the heap empty?
    //

    public E min() throws HeapException {
        if (isEmpty())
            throw new HeapException("The heap is empty.");
        else
            return (E) conjunto[1];
    }

    //
    // returns element with smallest key, without removal
    //

    private int compare(Object x, Object y) {
        return ((E) x).compareTo((E) y);
    }

    public void insert(E e) throws HeapException {
        if (size() == capacity)
            throw new HeapException("Heap overflow.");
        else{
            last++;
            conjunto[last] = e;
            upHeapBubble();
        }       
    }

    // inserts e into the heap
    // throws exception if heap overflow
    //

    public E removeMin() throws HeapException {
        if (isEmpty())
            throw new HeapException("Heap is empty.");
        else {
            E min = min();
            conjunto[1] = conjunto[last];
            last--;
            downHeapBubble();
            return min;
        }
    }

    //
    // removes and returns smallest element of the heap
    // throws exception is heap is empty
    //

    /**
     * downHeapBubble() method is used after the removeMin() method to reorder the elements
     * in order to preserve the Heap properties
     */
    private void downHeapBubble(){
        int index = 1;
        while (true){
            int child = index*2;
            if (child > size())
                break;
            if (child + 1 <= size()){
                //if there are two children -> take the smalles or
                //if they are equal take the left one
                child = findMin(child, child + 1);
            }
            if (compare(S[index],S[child]) <= 0 )
                break;
            swap(index,child);
            index = child;
        }
    }

    /**
     * upHeapBubble() method is used after the insert(E e) method to reorder the elements
     * in order to preserve the Heap properties 
     */
    private void upHeapBubble(){
        int index = size();
        while (index > 1){
            int parent = index / 2;
            if (compare(S[index], S[parent]) >= 0)
                //break if the parent is greater or equal to the current element
                break;
            swap(index,parent);
            index = parent;
        }       
    }

    /**
     * Swaps two integers i and j
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        Object temp = conjunto[i];
        conjunto[i] = conjunto[j];
        conjunto[j] = temp;
    }

    /**
     * the method is used in the downHeapBubble() method
     * @param leftChild
     * @param rightChild
     * @return min of left and right child, if they are equal return the left
     */
    private int findMin(int leftChild, int rightChild) {
        if (compare(S[leftChild], S[rightChild]) <= 0)
            return leftChild;
        else
            return rightChild;
    }

    public String toString() {
        String s = "[";
        for (int i = 1; i <= size(); i++) {
            s += S[i];
            if (i != last)
                s += ",";
        }
        return s + "]";
    }
    //
    // outputs the entries in S in the order S[1] to S[last]
    // in same style as used in ArrayQueue
    //

}
