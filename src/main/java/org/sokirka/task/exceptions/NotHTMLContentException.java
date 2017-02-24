package org.sokirka.task.exceptions;

/**
 * @author Eugine Sokirka
 */
public class NotHTMLContentException extends Exception {

    public NotHTMLContentException(String message) {
        super(message);
    }

    public NotHTMLContentException(String message, Throwable cause) {
        super(message, cause);
    }
}
