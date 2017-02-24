package org.sokirka.task.expr;

/**
 * @author Eugine Sokirka
 */
public interface ExpressionChecker {
    /**
     * Checks whether the URL address corresponds to specified requirements
     * @param url URL address in string form
     * @return boolean value true or false
     */
    boolean isValid(String url);
}
