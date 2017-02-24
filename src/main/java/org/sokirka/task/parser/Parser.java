package org.sokirka.task.parser;

import org.sokirka.task.exceptions.NotValidURLPageException;

/**
 * @author Eugine Sokirka
 */
public interface Parser {
    /**
     * Parses text from any sources
     * @param source source for parsing
     * @return result in form String
     */
    String parse(String source) throws NotValidURLPageException;
}
