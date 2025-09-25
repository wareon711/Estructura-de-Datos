package implementaciones;

import interfaces.IList;
import excepciones.ListException;

/**
 * Archivo: ArrayList.java
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 * Proposito: Implementacion de una lista generica utilizando un arreglo como estructura de datos
 *
 * Esta clase implementa la interfaz IList utilizando un arreglo interno para
 * almacenar los elementos. Proporciona todas las operaciones basicas de una lista
 * con control de limites y manejo de excepciones.
 */
public class ArrayList<T> implements IList<T> {

    // Arreglo para almacenar los elementos de la lista
    private T[] arreglo;

    // Numero actual de elementos en la lista
    private int tamano;

    // Capacidad maxima de la lista
    private int capacidad;

    /**
     * Constructor que crea una nueva ArrayList con la capacidad especificada
     * @param capacidad La capacidad maxima de la lista
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int capacidad) {
        this.capacidad = capacidad;
        this.arreglo = (T[]) new Object[capacidad];
        this.tamano = 0;
    }

    /**
     * Agrega un elemento al final de la lista
     * @param o El elemento a agregar
     * @throws ListException si la lista esta llena
     */
    @Override
    public void add(T o) throws ListException {
        // Verificar si la lista esta llena
        if (tamano >= capacidad) {
            throw new ListException("La lista esta llena");
        }

        // Agregar el elemento al final
        arreglo[tamano] = o;
        tamano++;
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
        if (tamano >= capacidad) {
            throw new ListException("La lista esta llena");
        }

        // Verificar que el indice sea valido
        if (i < 0 || i > tamano) {
            throw new ListException("Indice fuera de rango: " + i);
        }

        // Desplazar elementos hacia la derecha
        for (int j = tamano; j > i; j--) {
            arreglo[j] = arreglo[j - 1];
        }

        // Insertar el nuevo elemento
        arreglo[i] = o;
        tamano++;
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
        if (i < 0 || i >= tamano) {
            throw new ListException("Indice fuera de rango: " + i);
        }

        return arreglo[i];
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
        if (i < 0 || i >= tamano) {
            throw new ListException("Indice fuera de rango: " + i);
        }

        // Guardar el elemento a remover
        T removedElement = arreglo[i];

        // Desplazar elementos hacia la izquierda
        for (int j = i; j < tamano - 1; j++) {
            arreglo[j] = arreglo[j + 1];
        }

        // Limpiar la ultima posicion y decrementar el tamano
        arreglo[tamano - 1] = null;
        tamano--;

        return removedElement;
    }

    /**
     * Verifica si la lista esta vacia
     * @return true si la lista esta vacia, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return tamano == 0;
    }

    /**
     * Obtiene el numero de elementos en la lista
     * @return El tamano actual de la lista
     */
    @Override
    public int size() {
        return tamano;
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
        if (i < 0 || i >= tamano) {
            throw new ListException("Indice fuera de rango: " + i);
        }

        // Reemplazar el elemento
        arreglo[i] = o;
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

        // Buscar el elemento
        int index = indexOf(o);

        // Si se encuentra, eliminarlo
        if (index != -1) {
            remove(index);
            return true;
        }

        return false;
    }

    /**
     * Obtiene el indice de la primera ocurrencia del elemento especificado
     * @param o El elemento a buscar
     * @return El indice del elemento o -1 si no se encuentra
     */
    @Override
    public int indexOf(T o) {
        // Buscar el elemento en la lista
        for (int i = 0; i < tamano; i++) {
            // Manejar elementos nulos
            if (o == null) {
                if (arreglo[i] == null) {
                    return i;
                }
            } else {
                if (o.equals(arreglo[i])) {
                    return i;
                }
            }
        }

        // No se encontro el elemento
        return -1;
    }

    /**
     * Elimina todos los elementos de la lista
     */
    @Override
    public void clear() {
        // Limpiar todas las referencias
        for (int i = 0; i < tamano; i++) {
            arreglo[i] = null;
        }

        // Reiniciar el tamano
        tamano = 0;
    }

    /**
     * Representacion en cadena de la lista
     * @return Una representacion en cadena de los elementos de la lista
     */
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < tamano; i++) {
            sb.append(arreglo[i]);
            if (i < tamano - 1) {
                sb.append(", ");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
