package org.sokirka.task.exceptions;

/**
 * @author Eugine Sokirka
 */
public class NotValidURLPageException extends Exception {

    public NotValidURLPageException(String message) {
        super(message);
    }

    public NotValidURLPageException(String message, Throwable cause) {
        super(message, cause);
    }
}
