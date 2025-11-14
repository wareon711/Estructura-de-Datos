package demo;

import implementaciones.LinkedList;
import excepciones.ListException;

/**
 * Archivo: DemoLinkedList.java
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 * Proposito: Clase de demostracion para mostrar el funcionamiento de LinkedList
 *
 * Esta clase demuestra el uso completo de la implementacion LinkedList
 * cumpliendo con todos los criterios de corrida especificados en la rubrica.
 */
public class DemoLinkedList {

    /**
     * Metodo principal que ejecuta la demostracion
     * @param args Argumentos de linea de comandos
     */
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACION DE LINKEDLIST ===\n");

        // Demostracion con Integer
        demostracionInteger();

        System.out.println("\n" + "==================================================\n");

        // Demostracion con String
        demostracionString();

        System.out.println("\n" + "==================================================\n");

        // Demostracion de ventajas de la lista enlazada
        demostracionVentajasListaEnlazada();

        System.out.println("\n=== FIN DE LA DEMOSTRACION ===");
    }

    /**
     * Demuestra el uso de LinkedList con tipo Integer
     * Cumple con los criterios a, b, c, d de la rubrica de corrida
     */
    private static void demostracionInteger() {
        try {
            System.out.println("DEMOSTRACION CON TIPO INTEGER:");
            System.out.println("------------------------------");

            // a) Se crea instancia de la clase LinkedList de tamano 5 de tipo Integer, vacia
            LinkedList<Integer> listaEnteros = new LinkedList<>(5);
            System.out.println("a) LinkedList<Integer> creada con capacidad 5");
            System.out.println("   Lista vacia: " + listaEnteros.isEmpty());
            System.out.println("   Tamano: " + listaEnteros.size());
            System.out.println("   Capacidad: " + listaEnteros.getCapacity());
            System.out.println("   Contenido: " + listaEnteros);

            // b) Agrega un entero a la lista
            Integer entero = 42;
            listaEnteros.add(entero);
            System.out.println("\nb) Entero agregado: " + entero);
            System.out.println("   Lista vacia: " + listaEnteros.isEmpty());
            System.out.println("   Tamano: " + listaEnteros.size());
            System.out.println("   Contenido: " + listaEnteros);

            // Agregar mas elementos para hacer mas interesante la demostracion
            listaEnteros.add(15);
            listaEnteros.add(73);
            listaEnteros.add(42); // Elemento duplicado
            System.out.println("   Agregando mas elementos: 15, 73, 42");
            System.out.println("   Contenido: " + listaEnteros);

            // c) Obtiene el indice de la primera ocurrencia de un entero
            int indice = listaEnteros.indexOf(entero);
            System.out.println("\nc) Indice de la primera ocurrencia de " + entero + ": " + indice);

            int indiceNoExistente = listaEnteros.indexOf(999);
            System.out.println("   Indice de elemento no existente (999): " + indiceNoExistente);

            // d) Elimina la primera ocurrencia de un entero
            boolean eliminado = listaEnteros.remove(entero);
            System.out.println("\nd) Eliminando primera ocurrencia de " + entero + ": " + eliminado);
            System.out.println("   Tamano despues de eliminar: " + listaEnteros.size());
            System.out.println("   Contenido: " + listaEnteros);

            // Verificar que el elemento duplicado sigue en la lista
            int nuevoIndice = listaEnteros.indexOf(42);
            System.out.println("   Nueva posicion de " + entero + ": " + nuevoIndice);

            // Demostrar otros metodos especificos de lista enlazada
            System.out.println("\n   METODOS ADICIONALES:");
            listaEnteros.set(100, 0); // Reemplazar primer elemento
            System.out.println("   Despues de set(100, 0): " + listaEnteros);

            System.out.println("   Elemento en posicion 1: " + listaEnteros.get(1));

            // Agregar elemento en posicion especifica
            listaEnteros.add(25, 1);
            System.out.println("   Despues de add(25, 1): " + listaEnteros);

        } catch (ListException e) {
            System.err.println("Error en demostracion Integer: " + e.getMessage());
        }
    }

    /**
     * Demuestra el uso de LinkedList con tipo String
     * Cumple con los criterios e, f, g, h de la rubrica de corrida
     */
    private static void demostracionString() {
        try {
            System.out.println("DEMOSTRACION CON TIPO STRING:");
            System.out.println("-----------------------------");

            // e) Se crea instancia de la clase LinkedList de tamano 5 de tipo String, vacia
            LinkedList<String> listaCadenas = new LinkedList<>(5);
            System.out.println("e) LinkedList<String> creada con capacidad 5");
            System.out.println("   Lista vacia: " + listaCadenas.isEmpty());
            System.out.println("   Tamano: " + listaCadenas.size());
            System.out.println("   Capacidad: " + listaCadenas.getCapacity());
            System.out.println("   Contenido: " + listaCadenas);

            // f) Agrega una cadena a la lista
            String cadena = "Java";
            listaCadenas.add(cadena);
            System.out.println("\nf) Cadena agregada: \"" + cadena + "\"");
            System.out.println("   Lista vacia: " + listaCadenas.isEmpty());
            System.out.println("   Tamano: " + listaCadenas.size());
            System.out.println("   Contenido: " + listaCadenas);

            // Agregar mas elementos para hacer mas interesante la demostracion
            listaCadenas.add("Python");
            listaCadenas.add("C++");
            listaCadenas.add("Java"); // Elemento duplicado
            System.out.println("   Agregando mas elementos: \"Python\", \"C++\", \"Java\"");
            System.out.println("   Contenido: " + listaCadenas);

            // g) Obtiene el indice de la primera ocurrencia de una cadena
            int indice = listaCadenas.indexOf(cadena);
            System.out.println("\ng) Indice de la primera ocurrencia de \"" + cadena + "\": " + indice);

            int indiceNoExistente = listaCadenas.indexOf("JavaScript");
            System.out.println("   Indice de elemento no existente (\"JavaScript\"): " + indiceNoExistente);

            // h) Elimina la primera ocurrencia de una cadena
            boolean eliminado = listaCadenas.remove(cadena);
            System.out.println("\nh) Eliminando primera ocurrencia de \"" + cadena + "\": " + eliminado);
            System.out.println("   Tamano despues de eliminar: " + listaCadenas.size());
            System.out.println("   Contenido: " + listaCadenas);

            // Verificar que el elemento duplicado sigue en la lista
            int nuevoIndice = listaCadenas.indexOf("Java");
            System.out.println("   Nueva posicion de \"Java\": " + nuevoIndice);

            // Demostrar otros metodos especificos de lista enlazada
            System.out.println("\n   METODOS ADICIONALES:");
            listaCadenas.set("Kotlin", 0); // Reemplazar primer elemento
            System.out.println("   Despues de set(\"Kotlin\", 0): " + listaCadenas);

            System.out.println("   Elemento en posicion 1: \"" + listaCadenas.get(1) + "\"");

            // Agregar elemento en posicion especifica
            listaCadenas.add("Ruby", 1);
            System.out.println("   Despues de add(\"Ruby\", 1): " + listaCadenas);

            // Demostrar clear()
            System.out.println("\n   LIMPIANDO LA LISTA:");
            listaCadenas.clear();
            System.out.println("   Despues de clear(): " + listaCadenas);
            System.out.println("   Lista vacia: " + listaCadenas.isEmpty());
            System.out.println("   Tamano: " + listaCadenas.size());

        } catch (ListException e) {
            System.err.println("Error en demostracion String: " + e.getMessage());
        }
    }

    /**
     * Metodo adicional para demostrar las ventajas de la lista enlazada
     */
    private static void demostracionVentajasListaEnlazada() {
        try {
            System.out.println("\n=== VENTAJAS DE LA LISTA ENLAZADA ===");

            LinkedList<String> lista = new LinkedList<>(10);

            // Agregar elementos
            lista.add("Primero");
            lista.add("Segundo");
            lista.add("Tercero");
            lista.add("Cuarto");

            System.out.println("Lista inicial: " + lista);

            // Insertar en el medio es eficiente
            lista.add("Nuevo", 2);
            System.out.println("Despues de insertar 'Nuevo' en posicion 2: " + lista);

            // Remover del inicio es muy eficiente
            String removido = lista.remove(0);
            System.out.println("Despues de remover primer elemento ('" + removido + "'): " + lista);

            // La lista se adapta dinamicamente
            System.out.println("Tamano actual: " + lista.size());
            System.out.println("Capacidad restante: " + (lista.getCapacity() - lista.size()));

        } catch (ListException e) {
            System.err.println("Error en demostracion de ventajas: " + e.getMessage());
        }
    }
}
