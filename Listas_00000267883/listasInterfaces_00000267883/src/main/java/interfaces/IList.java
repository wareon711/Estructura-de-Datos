package interfaces;

import excepciones.ListException;

/**
 * Archivo: IList.java
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 * Proposito: Interfaz generica que define las operaciones basicas de una lista
 *
 * Esta interfaz define los metodos que debe implementar cualquier clase
 * que represente una lista de elementos de tipo generico T.
 */
public interface IList<T> {

    /**
     * Agrega un elemento al final de la lista
     * @param o El elemento a agregar
     * @throws ListException si la lista esta llena
     */
    void add(T o) throws ListException;

    /**
     * Agrega un elemento en la posicion especificada
     * @param o El elemento a agregar
     * @param i La posicion donde insertar el elemento
     * @throws ListException si el indice esta fuera de rango o la lista esta llena
     */
    void add(T o, int i) throws ListException;

    /**
     * Obtiene el elemento en la posicion especificada
     * @param i La posicion del elemento
     * @return El elemento en la posicion i
     * @throws ListException si el indice esta fuera de rango o la lista esta vacia
     */
    T get(int i) throws ListException;

    /**
     * Remueve el elemento en la posicion especificada
     * @param i La posicion del elemento a remover
     * @return El elemento removido
     * @throws ListException si el indice esta fuera de rango o la lista esta vacia
     */
    T remove(int i) throws ListException;

    /**
     * Verifica si la lista esta vacia
     * @return true si la lista esta vacia, false en caso contrario
     */
    boolean isEmpty();

    /**
     * Obtiene el numero de elementos en la lista
     * @return El tamano actual de la lista
     */
    int size();

    /**
     * Reemplaza el elemento en la posicion especificada
     * @param o El nuevo elemento
     * @param i La posicion del elemento a reemplazar
     * @throws ListException si la lista esta vacia o el indice esta fuera de rango
     */
    void set(T o, int i) throws ListException;

    /**
     * Elimina la primera ocurrencia del elemento especificado
     * @param o El elemento a eliminar
     * @return true si el elemento fue encontrado y eliminado, false en caso contrario
     * @throws ListException si la lista esta vacia
     */
    boolean remove(T o) throws ListException;

    /**
     * Obtiene el indice de la primera ocurrencia del elemento especificado
     * @param o El elemento a buscar
     * @return El indice del elemento o -1 si no se encuentra
     */
    int indexOf(T o);

    /**
     * Elimina todos los elementos de la lista
     */
    void clear();
}
