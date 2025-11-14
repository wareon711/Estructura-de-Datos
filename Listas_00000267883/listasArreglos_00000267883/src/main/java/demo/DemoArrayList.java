package demo;

import implementaciones.ArrayList;
import excepciones.ListException;

/**
 * Archivo: DemoArrayList.java
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 * Proposito: Clase de demostracion para mostrar el funcionamiento de ArrayList
 *
 * Esta clase demuestra el uso completo de la implementacion ArrayList
 * cumpliendo con todos los criterios de corrida especificados en la rubrica.
 */
public class DemoArrayList {

    /**
     * Metodo principal que ejecuta la demostracion
     * @param args Argumentos de linea de comandos
     */
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACION DE ARRAYLIST ===\n");

        // Demostracion con Integer
        demostracionInteger();

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Demostracion con String
        demostracionString();

        System.out.println("\n=== FIN DE LA DEMOSTRACION ===");
    }

    /**
     * Demuestra el uso de ArrayList con tipo Integer
     * Cumple con los criterios a, b, c, d de la rubrica de corrida
     */
    private static void demostracionInteger() {
        try {
            System.out.println("DEMOSTRACION CON TIPO INTEGER:");
            System.out.println("------------------------------");

            // a) Se crea instancia de la clase ArrayList de tamano 5 de tipo Integer, vacia
            ArrayList<Integer> listaEnteros = new ArrayList<>(5);
            System.out.println("a) ArrayList<Integer> creada con capacidad 5");
            System.out.println("   Lista vacia: " + listaEnteros.isEmpty());
            System.out.println("   Tamano: " + listaEnteros.size());
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

            // Demostrar otros metodos
            System.out.println("\n   METODOS ADICIONALES:");
            listaEnteros.set(100, 0); // Reemplazar primer elemento
            System.out.println("   Despues de set(100, 0): " + listaEnteros);

            System.out.println("   Elemento en posicion 1: " + listaEnteros.get(1));

        } catch (ListException e) {
            System.err.println("Error en demostracion Integer: " + e.getMessage());
        }
    }

    /**
     * Demuestra el uso de ArrayList con tipo String
     * Cumple con los criterios e, f, g, h de la rubrica de corrida
     */
    private static void demostracionString() {
        try {
            System.out.println("DEMOSTRACION CON TIPO STRING:");
            System.out.println("-----------------------------");

            // e) Se crea instancia de la clase ArrayList de tamano 5 de tipo String, vacia
            ArrayList<String> listaCadenas = new ArrayList<>(5);
            System.out.println("e) ArrayList<String> creada con capacidad 5");
            System.out.println("   Lista vacia: " + listaCadenas.isEmpty());
            System.out.println("   Tamano: " + listaCadenas.size());
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

            // Demostrar otros metodos
            System.out.println("\n   METODOS ADICIONALES:");
            listaCadenas.set("Kotlin", 0); // Reemplazar primer elemento
            System.out.println("   Despues de set(\"Kotlin\", 0): " + listaCadenas);

            System.out.println("   Elemento en posicion 1: \"" + listaCadenas.get(1) + "\"");

            // Demostrar clear()
            listaCadenas.clear();
            System.out.println("   Despues de clear(): " + listaCadenas);
            System.out.println("   Lista vacia: " + listaCadenas.isEmpty());

        } catch (ListException e) {
            System.err.println("Error en demostracion String: " + e.getMessage());
        }
    }
}
