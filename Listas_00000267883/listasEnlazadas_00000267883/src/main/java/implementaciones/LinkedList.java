package implementaciones;

import interfaces.IList;
import excepciones.ListException;

/**
 * Archivo: LinkedList.java
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 * Proposito: Implementacion de una lista generica utilizando una lista enlazada como estructura de datos
 *
 * Esta clase implementa la interfaz IList utilizando una estructura de lista enlazada
 * para almacenar los elementos. Cada elemento se almacena en un nodo que contiene
 * el dato y una referencia al siguiente nodo.
 */
public class LinkedList<T> implements IList<T> {

    // Referencia al primer nodo de la lista
    private Node<T> head;

    // Numero actual de elementos en la lista
    private int size;

    // Capacidad maxima de la lista (para mantener compatibilidad con los requisitos)
    private int capacity;

    /**
     * Constructor que crea una nueva LinkedList con la capacidad especificada
     * @param capacity La capacidad maxima de la lista
     */
    public LinkedList(int capacity) {
        this.capacity = capacity;
        this.head = null;
        this.size = 0;
    }

    /**
     * Constructor que crea una LinkedList sin limite de capacidad
     */
    public LinkedList() {
        this.capacity = Integer.MAX_VALUE;
        this.head = null;
        this.size = 0;
    }

    /**
     * Agrega un elemento al final de la lista
     * @param o El elemento a agregar
     * @throws ListException si la lista esta llena
     */
    @Override
    public void add(T o) throws ListException {
        // Verificar si la lista esta llena
        if (size >= capacity) {
            throw new ListException("La lista esta llena");
        }

        // Crear nuevo nodo
        Node<T> newNode = new Node<>(o);

        // Si la lista esta vacia, el nuevo nodo sera el head
        if (head == null) {
            head = newNode;
        } else {
            // Buscar el ultimo nodo
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            // Enlazar el nuevo nodo al final
            current.setNext(newNode);
        }

        size++;
    }

    /**
     * Agrega un elemento en la posicion especificada
     * @param o El elemento a agregar
     * @param i La posicion donde insertar el elemento
     * @throws ListException si el indice esta fuera de rango o la lista esta llena
     */
    @Override
    public void add(T o, int i) throws ListException {
        // Verificar si la lista esta llena
        if (size >= capacity) {
            throw new ListException("La lista esta llena");
        }

        // Verificar que el indice sea valido
        if (i < 0 || i > size) {
            throw new ListException("Indice fuera de rango: " + i);
        }

        // Crear nuevo nodo
        Node<T> newNode = new Node<>(o);

        // Caso especial: insertar en la primera posicion
        if (i == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            // Buscar la posicion anterior a la insercion
            Node<T> current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.getNext();
            }

            // Insertar el nuevo nodo
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }

        size++;
    }

    /**
     * Obtiene el elemento en la posicion especificada
     * @param i La posicion del elemento
     * @return El elemento en la posicion i
     * @throws ListException si el indice esta fuera de rango o la lista esta vacia
     */
    @Override
    public T get(int i) throws ListException {
        // Verificar si la lista esta vacia
        if (isEmpty()) {
            throw new ListException("La lista esta vacia");
        }

        // Verificar que el indice sea valido
        if (i < 0 || i >= size) {
            throw new ListException("Indice fuera de rango: " + i);
        }

        // Recorrer hasta encontrar el nodo en la posicion i
        Node<T> current = head;
        for (int j = 0; j < i; j++) {
            current = current.getNext();
        }

        return current.getData();
    }

    /**
     * Remueve el elemento en la posicion especificada
     * @param i La posicion del elemento a remover
     * @return El elemento removido
     * @throws ListException si el indice esta fuera de rango o la lista esta vacia
     */
    @Override
    public T remove(int i) throws ListException {
        // Verificar si la lista esta vacia
        if (isEmpty()) {
            throw new ListException("La lista esta vacia");
        }

        // Verificar que el indice sea valido
        if (i < 0 || i >= size) {
            throw new ListException("Indice fuera de rango: " + i);
        }

        T removedData;

        // Caso especial: remover el primer elemento
        if (i == 0) {
            removedData = head.getData();
            head = head.getNext();
        } else {
            // Buscar el nodo anterior al que se va a eliminar
            Node<T> current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.getNext();
            }

            // Guardar el dato del nodo a eliminar
            Node<T> nodeToRemove = current.getNext();
            removedData = nodeToRemove.getData();

            // Saltar el nodo a eliminar
            current.setNext(nodeToRemove.getNext());
        }

        size--;
        return removedData;
    }

    /**
     * Verifica si la lista esta vacia
     * @return true si la lista esta vacia, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return head == null || size == 0;
    }

    /**
     * Obtiene el numero de elementos en la lista
     * @return El tamano actual de la lista
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Reemplaza el elemento en la posicion especificada
     * @param o El nuevo elemento
     * @param i La posicion del elemento a reemplazar
     * @throws ListException si la lista esta vacia o el indice esta fuera de rango
     */
    @Override
    public void set(T o, int i) throws ListException {
        // Verificar si la lista esta vacia
        if (isEmpty()) {
            throw new ListException("La lista esta vacia");
        }

        // Verificar que el indice sea valido
        if (i < 0 || i >= size) {
            throw new ListException("Indice fuera de rango: " + i);
        }

        // Recorrer hasta encontrar el nodo en la posicion i
        Node<T> current = head;
        for (int j = 0; j < i; j++) {
            current = current.getNext();
        }

        // Reemplazar el dato del nodo
        current.setData(o);
    }

    /**
     * Elimina la primera ocurrencia del elemento especificado
     * @param o El elemento a eliminar
     * @return true si el elemento fue encontrado y eliminado, false en caso contrario
     * @throws ListException si la lista esta vacia
     */
    @Override
    public boolean remove(T o) throws ListException {
        // Verificar si la lista esta vacia
        if (isEmpty()) {
            throw new ListException("La lista esta vacia");
        }

        // Caso especial: el elemento esta en el primer nodo
        if (head.getData() != null && head.getData().equals(o)) {
            head = head.getNext();
            size--;
            return true;
        } else if (head.getData() == null && o == null) {
            head = head.getNext();
            size--;
            return true;
        }

        // Buscar el elemento en el resto de la lista
        Node<T> current = head;
        while (current.getNext() != null) {
            Node<T> nextNode = current.getNext();

            // Comparar datos considerando valores nulos
            boolean dataEquals = false;
            if (nextNode.getData() == null && o == null) {
                dataEquals = true;
            } else if (nextNode.getData() != null && nextNode.getData().equals(o)) {
                dataEquals = true;
            }

            if (dataEquals) {
                // Saltar el nodo a eliminar
                current.setNext(nextNode.getNext());
                size--;
                return true;
            }

            current = current.getNext();
        }

        // No se encontro el elemento
        return false;
    }

    /**
     * Obtiene el indice de la primera ocurrencia del elemento especificado
     * @param o El elemento a buscar
     * @return El indice del elemento o -1 si no se encuentra
     */
    @Override
    public int indexOf(T o) {
        Node<T> current = head;
        int index = 0;

        // Recorrer la lista buscando el elemento
        while (current != null) {
            // Manejar elementos nulos
            if (current.getData() == null && o == null) {
                return index;
            } else if (current.getData() != null && current.getData().equals(o)) {
                return index;
            }

            current = current.getNext();
            index++;
        }

        // No se encontro el elemento
        return -1;
    }

    /**
     * Elimina todos los elementos de la lista
     */
    @Override
    public void clear() {
        // Eliminar todas las referencias
        head = null;
        size = 0;

        // La recoleccion de basura se encargara de liberar la memoria
    }

    /**
     * Representacion en cadena de la lista
     * @return Una representacion en cadena de los elementos de la lista
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node<T> current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(", ");
            }
            current = current.getNext();
        }

        sb.append("]");
        return sb.toString();
    }

    /**
     * Obtiene la capacidad maxima de la lista
     * @return La capacidad maxima
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Establece la capacidad maxima de la lista
     * @param capacity La nueva capacidad maxima
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
