package prueba.arraylist;

import implementaciones.ArrayList;
import excepciones.ListException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Archivo: ArrayListTest.java
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 * Proposito: Clase de pruebas unitarias para la clase ArrayList
 *
 * Esta clase contiene todas las pruebas unitarias necesarias para verificar
 * el correcto funcionamiento de la implementacion ArrayList tanto para
 * tipos Integer como String.
 */
public class ArrayListTest {

    private ArrayList<Integer> listaEnteros;
    private ArrayList<String> listaCadenas;

    /**
     * Configuracion inicial antes de cada prueba
     * Se ejecuta antes de cada metodo de prueba
     */
    @BeforeEach
    public void setUp() {
        // Crear instancias de ArrayList de tamano 5
        listaEnteros = new ArrayList<>(5);
        listaCadenas = new ArrayList<>(5);
    }

    /**
     * Prueba la creacion de una instancia ArrayList de tipo Integer vacia
     */
    @Test
    public void testCrearListaEnterosVacia() {
        assertTrue(listaEnteros.isEmpty(), "La lista de enteros deberia estar vacia");
        assertEquals(0, listaEnteros.size(), "El tamano de la lista de enteros deberia ser 0");
    }

    /**
     * Prueba la creacion de una instancia ArrayList de tipo String vacia
     */
    @Test
    public void testCrearListaCadenasVacia() {
        assertTrue(listaCadenas.isEmpty(), "La lista de cadenas deberia estar vacia");
        assertEquals(0, listaCadenas.size(), "El tamano de la lista de cadenas deberia ser 0");
    }

    /**
     * Prueba agregar un entero a la lista
     */
    @Test
    public void testAgregarEntero() throws ListException {
        Integer valorPrueba = 42;

        listaEnteros.add(valorPrueba);

        assertFalse(listaEnteros.isEmpty(), "La lista no deberia estar vacia despues de agregar un elemento");
        assertEquals(1, listaEnteros.size(), "El tamano deberia ser 1");
        assertEquals(valorPrueba, listaEnteros.get(0), "El elemento agregado deberia ser recuperable");
    }

    /**
     * Prueba agregar una cadena a la lista
     */
    @Test
    public void testAgregarCadena() throws ListException {
        String valorPrueba = "Hola Mundo";

        listaCadenas.add(valorPrueba);

        assertFalse(listaCadenas.isEmpty(), "La lista no deberia estar vacia despues de agregar un elemento");
        assertEquals(1, listaCadenas.size(), "El tamano deberia ser 1");
        assertEquals(valorPrueba, listaCadenas.get(0), "El elemento agregado deberia ser recuperable");
    }

    /**
     * Prueba obtener el indice de la primera ocurrencia de un entero
     */
    @Test
    public void testIndiceDeEntero() throws ListException {
        Integer valorPrueba1 = 10;
        Integer valorPrueba2 = 20;
        Integer valorPrueba3 = 30;
        Integer valorInexistente = 99;

        // Agregar varios elementos
        listaEnteros.add(valorPrueba1);
        listaEnteros.add(valorPrueba2);
        listaEnteros.add(valorPrueba3);
        listaEnteros.add(valorPrueba1); // Elemento duplicado

        // Probar indexOf
        assertEquals(0, listaEnteros.indexOf(valorPrueba1), "El indice de la primera ocurrencia de 10 deberia ser 0");
        assertEquals(1, listaEnteros.indexOf(valorPrueba2), "El indice de 20 deberia ser 1");
        assertEquals(2, listaEnteros.indexOf(valorPrueba3), "El indice de 30 deberia ser 2");
        assertEquals(-1, listaEnteros.indexOf(valorInexistente), "El indice de un elemento no existente deberia ser -1");
    }

    /**
     * Prueba obtener el indice de la primera ocurrencia de una cadena
     */
    @Test
    public void testIndiceDeCadena() throws ListException {
        String valorPrueba1 = "Java";
        String valorPrueba2 = "Python";
        String valorPrueba3 = "C++";
        String valorInexistente = "JavaScript";

        // Agregar varios elementos
        listaCadenas.add(valorPrueba1);
        listaCadenas.add(valorPrueba2);
        listaCadenas.add(valorPrueba3);
        listaCadenas.add(valorPrueba1); // Elemento duplicado

        // Probar indexOf
        assertEquals(0, listaCadenas.indexOf(valorPrueba1), "El indice de la primera ocurrencia de 'Java' deberia ser 0");
        assertEquals(1, listaCadenas.indexOf(valorPrueba2), "El indice de 'Python' deberia ser 1");
        assertEquals(2, listaCadenas.indexOf(valorPrueba3), "El indice de 'C++' deberia ser 2");
        assertEquals(-1, listaCadenas.indexOf(valorInexistente), "El indice de un elemento no existente deberia ser -1");
    }

    /**
     * Prueba eliminar la primera ocurrencia de un entero
     */
    @Test
    public void testRemoverEntero() throws ListException {
        Integer valorPrueba1 = 100;
        Integer valorPrueba2 = 200;
        Integer valorPrueba3 = 300;
        Integer valorInexistente = 999;

        // Agregar elementos
        listaEnteros.add(valorPrueba1);
        listaEnteros.add(valorPrueba2);
        listaEnteros.add(valorPrueba3);
        listaEnteros.add(valorPrueba1); // Elemento duplicado

        int tamanoInicial = listaEnteros.size();

        // Remover elemento existente
        assertTrue(listaEnteros.remove(valorPrueba1), "Deberia poder remover el elemento existente");
        assertEquals(tamanoInicial - 1, listaEnteros.size(), "El tamano deberia decrementar");
        assertEquals(0, listaEnteros.indexOf(valorPrueba2), "El elemento 200 ahora deberia estar en indice 0");

        // Intentar remover elemento no existente
        assertFalse(listaEnteros.remove(valorInexistente), "No deberia poder remover un elemento no existente");
    }

    /**
     * Prueba eliminar la primera ocurrencia de una cadena
     */
    @Test
    public void testRemoverCadena() throws ListException {
        String valorPrueba1 = "Primero";
        String valorPrueba2 = "Segundo";
        String valorPrueba3 = "Tercero";
        String valorInexistente = "NoExiste";

        // Agregar elementos
        listaCadenas.add(valorPrueba1);
        listaCadenas.add(valorPrueba2);
        listaCadenas.add(valorPrueba3);
        listaCadenas.add(valorPrueba1); // Elemento duplicado

        int tamanoInicial = listaCadenas.size();

        // Remover elemento existente
        assertTrue(listaCadenas.remove(valorPrueba1), "Deberia poder remover el elemento existente");
        assertEquals(tamanoInicial - 1, listaCadenas.size(), "El tamano deberia decrementar");
        assertEquals(0, listaCadenas.indexOf(valorPrueba2), "El elemento 'Segundo' ahora deberia estar en indice 0");

        // Intentar remover elemento no existente
        assertFalse(listaCadenas.remove(valorInexistente), "No deberia poder remover un elemento no existente");
    }

    /**
     * Prueba el metodo set() para reemplazar elementos
     */
    @Test
    public void testMetodoSet() throws ListException {
        Integer valorAntiguo = 50;
        Integer valorNuevo = 75;

        // Agregar un elemento
        listaEnteros.add(valorAntiguo);

        // Reemplazar el elemento
        listaEnteros.set(valorNuevo, 0);

        assertEquals(valorNuevo, listaEnteros.get(0), "El elemento deberia haber sido reemplazado");
        assertEquals(1, listaEnteros.size(), "El tamano no deberia cambiar");
    }

    /**
     * Prueba el metodo clear() para limpiar la lista
     */
    @Test
    public void testMetodoClear() throws ListException {
        // Agregar varios elementos
        listaEnteros.add(1);
        listaEnteros.add(2);
        listaEnteros.add(3);

        assertFalse(listaEnteros.isEmpty(), "La lista deberia tener elementos");

        // Limpiar la lista
        listaEnteros.clear();

        assertTrue(listaEnteros.isEmpty(), "La lista deberia estar vacia despues de clear()");
        assertEquals(0, listaEnteros.size(), "El tamano deberia ser 0 despues de clear()");
    }

    /**
     * Prueba excepciones en lista vacia
     */
    @Test
    public void testExcepcionesListaVacia() {
        // Probar get() en lista vacia
        assertThrows(ListException.class, () -> {
            listaEnteros.get(0);
        }, "get() deberia lanzar excepcion en lista vacia");

        // Probar remove(index) en lista vacia
        assertThrows(ListException.class, () -> {
            listaEnteros.remove(0);
        }, "remove(index) deberia lanzar excepcion en lista vacia");

        // Probar set() en lista vacia
        assertThrows(ListException.class, () -> {
            listaEnteros.set(10, 0);
        }, "set() deberia lanzar excepcion en lista vacia");

        // Probar remove(object) en lista vacia
        assertThrows(ListException.class, () -> {
            listaEnteros.remove(Integer.valueOf(10));
        }, "remove(object) deberia lanzar excepcion en lista vacia");
    }

    /**
     * Prueba excepciones por indices fuera de rango
     */
    @Test
    public void testExcepcionesIndicesFueraRango() throws ListException {
        // Agregar un elemento
        listaEnteros.add(10);

        // Probar indices negativos
        assertThrows(ListException.class, () -> {
            listaEnteros.get(-1);
        }, "get() deberia lanzar excepcion con indice negativo");

        // Probar indices fuera del limite superior
        assertThrows(ListException.class, () -> {
            listaEnteros.get(1);
        }, "get() deberia lanzar excepcion con indice fuera de limite");

        // Probar set() con indice invalido
        assertThrows(ListException.class, () -> {
            listaEnteros.set(20, 5);
        }, "set() deberia lanzar excepcion con indice fuera de limite");
    }

    /**
     * Prueba el comportamiento cuando la lista esta llena
     */
    @Test
    public void testExcepcionListaLlena() throws ListException {
        // Llenar la lista hasta su capacidad (5 elementos)
        for (int i = 0; i < 5; i++) {
            listaEnteros.add(i);
        }

        // Intentar agregar un elemento mas deberia lanzar excepcion
        assertThrows(ListException.class, () -> {
            listaEnteros.add(5);
        }, "add() deberia lanzar excepcion cuando la lista esta llena");
    }

    /**
     * Prueba funcional completa que demuestra el uso de la ArrayList
     */
    @Test
    public void testFlujoCompletoEnteros() throws ListException {
        // a) Crear instancia ArrayList de tamano 5 de tipo Integer, vacia
        ArrayList<Integer> lista = new ArrayList<>(5);
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
     * Prueba funcional completa que demuestra el uso de la ArrayList con Strings
     */
    @Test
    public void testFlujoCompletoCadenas() throws ListException {
        // e) Crear instancia ArrayList de tamano 5 de tipo String, vacia
        ArrayList<String> lista = new ArrayList<>(5);
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
}
