package prueba;

import implementaciones.LinkedList;
import excepciones.ListException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Archivo: LinkedListTest.java
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 * Proposito: Clase de pruebas unitarias para la clase LinkedList
 *
 * Esta clase contiene todas las pruebas unitarias necesarias para verificar
 * el correcto funcionamiento de la implementacion LinkedList tanto para
 * tipos Integer como String.
 */
public class LinkedListTest {

    private LinkedList<Integer> integerList;
    private LinkedList<String> stringList;

    /**
     * Configuracion inicial antes de cada prueba
     * Se ejecuta antes de cada metodo de prueba
     */
    @BeforeEach
    public void setUp() {
        // Crear instancias de LinkedList de tamano 5
        integerList = new LinkedList<>(5);
        stringList = new LinkedList<>(5);
    }

    /**
     * Prueba la creacion de una instancia LinkedList de tipo Integer vacia
     */
    @Test
    public void testCreateEmptyIntegerLinkedList() {
        assertTrue(integerList.isEmpty(), "La lista Integer deberia estar vacia");
        assertEquals(0, integerList.size(), "El tamano de la lista Integer deberia ser 0");
        assertEquals(5, integerList.getCapacity(), "La capacidad deberia ser 5");
    }

    /**
     * Prueba la creacion de una instancia LinkedList de tipo String vacia
     */
    @Test
    public void testCreateEmptyStringLinkedList() {
        assertTrue(stringList.isEmpty(), "La lista String deberia estar vacia");
        assertEquals(0, stringList.size(), "El tamano de la lista String deberia ser 0");
        assertEquals(5, stringList.getCapacity(), "La capacidad deberia ser 5");
    }

    /**
     * Prueba agregar un entero a la lista
     */
    @Test
    public void testAddInteger() throws ListException {
        Integer testValue = 42;

        integerList.add(testValue);

        assertFalse(integerList.isEmpty(), "La lista no deberia estar vacia despues de agregar un elemento");
        assertEquals(1, integerList.size(), "El tamano deberia ser 1");
        assertEquals(testValue, integerList.get(0), "El elemento agregado deberia ser recuperable");
    }

    /**
     * Prueba agregar una cadena a la lista
     */
    @Test
    public void testAddString() throws ListException {
        String testValue = "Hola Mundo";

        stringList.add(testValue);

        assertFalse(stringList.isEmpty(), "La lista no deberia estar vacia despues de agregar un elemento");
        assertEquals(1, stringList.size(), "El tamano deberia ser 1");
        assertEquals(testValue, stringList.get(0), "El elemento agregado deberia ser recuperable");
    }

    /**
     * Prueba obtener el indice de la primera ocurrencia de un entero
     */
    @Test
    public void testIndexOfInteger() throws ListException {
        Integer testValue1 = 10;
        Integer testValue2 = 20;
        Integer testValue3 = 30;
        Integer nonExistentValue = 99;

        // Agregar varios elementos
        integerList.add(testValue1);
        integerList.add(testValue2);
        integerList.add(testValue3);
        integerList.add(testValue1); // Elemento duplicado

        // Probar indexOf
        assertEquals(0, integerList.indexOf(testValue1), "El indice de la primera ocurrencia de 10 deberia ser 0");
        assertEquals(1, integerList.indexOf(testValue2), "El indice de 20 deberia ser 1");
        assertEquals(2, integerList.indexOf(testValue3), "El indice de 30 deberia ser 2");
        assertEquals(-1, integerList.indexOf(nonExistentValue), "El indice de un elemento no existente deberia ser -1");
    }

    /**
     * Prueba obtener el indice de la primera ocurrencia de una cadena
     */
    @Test
    public void testIndexOfString() throws ListException {
        String testValue1 = "Java";
        String testValue2 = "Python";
        String testValue3 = "C++";
        String nonExistentValue = "JavaScript";

        // Agregar varios elementos
        stringList.add(testValue1);
        stringList.add(testValue2);
        stringList.add(testValue3);
        stringList.add(testValue1); // Elemento duplicado

        // Probar indexOf
        assertEquals(0, stringList.indexOf(testValue1), "El indice de la primera ocurrencia de 'Java' deberia ser 0");
        assertEquals(1, stringList.indexOf(testValue2), "El indice de 'Python' deberia ser 1");
        assertEquals(2, stringList.indexOf(testValue3), "El indice de 'C++' deberia ser 2");
        assertEquals(-1, stringList.indexOf(nonExistentValue), "El indice de un elemento no existente deberia ser -1");
    }

    /**
     * Prueba eliminar la primera ocurrencia de un entero
     */
    @Test
    public void testRemoveInteger() throws ListException {
        Integer testValue1 = 100;
        Integer testValue2 = 200;
        Integer testValue3 = 300;
        Integer nonExistentValue = 999;

        // Agregar elementos
        integerList.add(testValue1);
        integerList.add(testValue2);
        integerList.add(testValue3);
        integerList.add(testValue1); // Elemento duplicado

        int initialSize = integerList.size();

        // Remover elemento existente
        assertTrue(integerList.remove(testValue1), "Deberia poder remover el elemento existente");
        assertEquals(initialSize - 1, integerList.size(), "El tamano deberia decrementar");
        assertEquals(0, integerList.indexOf(testValue2), "El elemento 200 ahora deberia estar en indice 0");

        // Verificar que el elemento duplicado sigue en la lista
        assertEquals(2, integerList.indexOf(testValue1), "El elemento duplicado deberia seguir en la lista");

        // Intentar remover elemento no existente
        assertFalse(integerList.remove(nonExistentValue), "No deberia poder remover un elemento no existente");
    }

    /**
     * Prueba eliminar la primera ocurrencia de una cadena
     */
    @Test
    public void testRemoveString() throws ListException {
        String testValue1 = "Primero";
        String testValue2 = "Segundo";
        String testValue3 = "Tercero";
        String nonExistentValue = "NoExiste";

        // Agregar elementos
        stringList.add(testValue1);
        stringList.add(testValue2);
        stringList.add(testValue3);
        stringList.add(testValue1); // Elemento duplicado

        int initialSize = stringList.size();

        // Remover elemento existente
        assertTrue(stringList.remove(testValue1), "Deberia poder remover el elemento existente");
        assertEquals(initialSize - 1, stringList.size(), "El tamano deberia decrementar");
        assertEquals(0, stringList.indexOf(testValue2), "El elemento 'Segundo' ahora deberia estar en indice 0");

        // Verificar que el elemento duplicado sigue en la lista
        assertEquals(2, stringList.indexOf(testValue1), "El elemento duplicado deberia seguir en la lista");

        // Intentar remover elemento no existente
        assertFalse(stringList.remove(nonExistentValue), "No deberia poder remover un elemento no existente");
    }

    /**
     * Prueba el metodo set() para reemplazar elementos
     */
    @Test
    public void testSetMethod() throws ListException {
        Integer oldValue = 50;
        Integer newValue = 75;

        // Agregar un elemento
        integerList.add(oldValue);

        // Reemplazar el elemento
        integerList.set(newValue, 0);

        assertEquals(newValue, integerList.get(0), "El elemento deberia haber sido reemplazado");
        assertEquals(1, integerList.size(), "El tamano no deberia cambiar");
    }

    /**
     * Prueba el metodo clear() para limpiar la lista
     */
    @Test
    public void testClearMethod() throws ListException {
        // Agregar varios elementos
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        assertFalse(integerList.isEmpty(), "La lista deberia tener elementos");

        // Limpiar la lista
        integerList.clear();

        assertTrue(integerList.isEmpty(), "La lista deberia estar vacia despues de clear()");
        assertEquals(0, integerList.size(), "El tamano deberia ser 0 despues de clear()");
    }

    /**
     * Prueba la insercion en posiciones especificas
     */
    @Test
    public void testAddAtPosition() throws ListException {
        // Agregar elementos en diferentes posiciones
        integerList.add(10, 0); // Agregar en posicion 0 (lista vacia)
        assertEquals(10, integerList.get(0));

        integerList.add(30, 1); // Agregar al final
        assertEquals(30, integerList.get(1));

        integerList.add(20, 1); // Agregar en el medio
        assertEquals(10, integerList.get(0));
        assertEquals(20, integerList.get(1));
        assertEquals(30, integerList.get(2));
    }

    /**
     * Prueba la remocion por indice
     */
    @Test
    public void testRemoveByIndex() throws ListException {
        // Agregar elementos
        integerList.add(10);
        integerList.add(20);
        integerList.add(30);

        // Remover elemento en el medio
        Integer removed = integerList.remove(1);

        assertEquals(20, removed, "El elemento removido deberia ser 20");
        assertEquals(2, integerList.size(), "El tamano deberia ser 2");
        assertEquals(10, integerList.get(0), "El primer elemento deberia seguir siendo 10");
        assertEquals(30, integerList.get(1), "El segundo elemento ahora deberia ser 30");
    }

    /**
     * Prueba excepciones en lista vacia
     */
    @Test
    public void testEmptyListExceptions() {
        // Probar get() en lista vacia
        assertThrows(ListException.class, () -> {
            integerList.get(0);
        }, "get() deberia lanzar excepcion en lista vacia");

        // Probar remove(index) en lista vacia
        assertThrows(ListException.class, () -> {
            integerList.remove(0);
        }, "remove(index) deberia lanzar excepcion en lista vacia");

        // Probar set() en lista vacia
        assertThrows(ListException.class, () -> {
            integerList.set(10, 0);
        }, "set() deberia lanzar excepcion en lista vacia");

        // Probar remove(object) en lista vacia
        assertThrows(ListException.class, () -> {
            integerList.remove(Integer.valueOf(10));
        }, "remove(object) deberia lanzar excepcion en lista vacia");
    }

    /**
     * Prueba excepciones por indices fuera de rango
     */
    @Test
    public void testIndexOutOfBoundsExceptions() throws ListException {
        // Agregar un elemento
        integerList.add(10);

        // Probar indices negativos
        assertThrows(ListException.class, () -> {
            integerList.get(-1);
        }, "get() deberia lanzar excepcion con indice negativo");

        // Probar indices fuera del limite superior
        assertThrows(ListException.class, () -> {
            integerList.get(1);
        }, "get() deberia lanzar excepcion con indice fuera de limite");

        // Probar set() con indice invalido
        assertThrows(ListException.class, () -> {
            integerList.set(20, 5);
        }, "set() deberia lanzar excepcion con indice fuera de limite");
    }

    /**
     * Prueba el comportamiento cuando la lista esta llena
     */
    @Test
    public void testFullListException() throws ListException {
        // Llenar la lista hasta su capacidad (5 elementos)
        for (int i = 0; i < 5; i++) {
            integerList.add(i);
        }

        // Intentar agregar un elemento mas deberia lanzar excepcion
        assertThrows(ListException.class, () -> {
            integerList.add(5);
        }, "add() deberia lanzar excepcion cuando la lista esta llena");
    }

    /**
     * Prueba funcional completa que demuestra el uso de la LinkedList con Integer
     */
    @Test
    public void testCompleteIntegerWorkflow() throws ListException {
        // a) Crear instancia LinkedList de tamano 5 de tipo Integer, vacia
        LinkedList<Integer> lista = new LinkedList<>(5);
        assertTrue(lista.isEmpty());

        // b) Agregar un entero a la lista
        lista.add(42);
        assertEquals(1, lista.size());

        // c) Obtener el indice de la primera ocurrencia de un entero
        int indice = lista.indexOf(42);
        assertEquals(0, indice);

        // d) Eliminar la primera ocurrencia de un entero
        boolean eliminado = lista.remove(Integer.valueOf(42));
        assertTrue(eliminado);
        assertTrue(lista.isEmpty());
    }

    /**
     * Prueba funcional completa que demuestra el uso de la LinkedList con String
     */
    @Test
    public void testCompleteStringWorkflow() throws ListException {
        // e) Crear instancia LinkedList de tamano 5 de tipo String, vacia
        LinkedList<String> lista = new LinkedList<>(5);
        assertTrue(lista.isEmpty());

        // f) Agregar una cadena a la lista
        lista.add("Hola");
        assertEquals(1, lista.size());

        // g) Obtener el indice de la primera ocurrencia de una cadena
        int indice = lista.indexOf("Hola");
        assertEquals(0, indice);

        // h) Eliminar la primera ocurrencia de una cadena
        boolean eliminado = lista.remove("Hola");
        assertTrue(eliminado);
        assertTrue(lista.isEmpty());
    }

    /**
     * Prueba el manejo de valores nulos
     */
    @Test
    public void testNullValues() throws ListException {
        // Agregar valor nulo
        integerList.add(null);
        assertEquals(1, integerList.size());
        assertNull(integerList.get(0));

        // Buscar valor nulo
        assertEquals(0, integerList.indexOf(null));

        // Remover valor nulo
        assertTrue(integerList.remove(null));
        assertTrue(integerList.isEmpty());
    }

    /**
     * Prueba el metodo toString() de la lista
     */
    @Test
    public void testToString() throws ListException {
        // Lista vacia
        assertEquals("[]", integerList.toString());

        // Lista con elementos
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        assertEquals("[1, 2, 3]", integerList.toString());
    }

    /**
     * Prueba de rendimiento basico para verificar que la lista enlazada funciona correctamente
     */
    @Test
    public void testPerformance() throws ListException {
        LinkedList<Integer> bigList = new LinkedList<>(1000);

        // Agregar muchos elementos
        for (int i = 0; i < 100; i++) {
            bigList.add(i);
        }

        assertEquals(100, bigList.size());

        // Verificar que todos los elementos estan en orden
        for (int i = 0; i < 100; i++) {
            assertEquals(Integer.valueOf(i), bigList.get(i));
        }

        // Limpiar la lista
        bigList.clear();
        assertTrue(bigList.isEmpty());
    }
}
