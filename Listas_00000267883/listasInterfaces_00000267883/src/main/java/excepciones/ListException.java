package excepciones;

/**
 * Archivo: ListException.java
 * Creado por: Gibran Alonso Ibarra Palomares, Jose Miguel Rojo Cota, Karely A. Ruiz Córdova
 * Proposito: Excepcion personalizada para operaciones invalidas en listas
 *
 * Esta clase representa una excepcion que se lanza cuando ocurre un error
 * en las operaciones de una lista, como acceder a indices invalidos o
 * realizar operaciones en listas vacias.
 */
public class ListException extends Exception {

    /**
     * Constructor que crea una nueva instancia de ListException con un mensaje especifico
     * @param message El mensaje de error que describe la excepcion
     */
    public ListException(String message) {
        super(message);
    }

    /**
     * Constructor que crea una nueva instancia de ListException con un mensaje y causa
     * @param message El mensaje de error que describe la excepcion
     * @param cause La causa original de la excepcion
     */
    public ListException(String message, Throwable cause) {
        super(message, cause);
    }
}
