package implementaciones;

/**
 * Archivo: Node.java
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 * Proposito: Clase que representa un nodo en una lista enlazada
 *
 * Esta clase encapsula los datos y la referencia al siguiente nodo
 * en una estructura de lista enlazada. Es una clase de apoyo para
 * la implementacion de LinkedList.
 */
public class Node<T> {

    // Dato almacenado en el nodo
    private T data;

    // Referencia al siguiente nodo en la lista
    private Node<T> next;

    /**
     * Constructor que crea un nuevo nodo con el dato especificado
     * @param data El dato a almacenar en el nodo
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Constructor que crea un nuevo nodo con dato y referencia al siguiente nodo
     * @param data El dato a almacenar en el nodo
     * @param next La referencia al siguiente nodo
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Obtiene el dato almacenado en el nodo
     * @return El dato del nodo
     */
    public T getData() {
        return data;
    }

    /**
     * Establece el dato del nodo
     * @param data El nuevo dato a almacenar
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Obtiene la referencia al siguiente nodo
     * @return El siguiente nodo en la lista
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Establece la referencia al siguiente nodo
     * @param next El nuevo siguiente nodo
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Representacion en cadena del nodo
     * @return Una representacion en cadena del dato del nodo
     */
    @Override
    public String toString() {
        return data != null ? data.toString() : "null";
    }
}
