package org.sokirka.task.service;

import org.sokirka.task.exceptions.NotValidURLPageException;

import java.util.Map;

/**
 * @author Eugine Sokirka
 */
public interface ApplicationService {
    /**
     * Returns modified pretty text from text handler
     * @param url set of words for modification
     * @return sorted set of words with their amounts
     */
    String getModifiedTextForUrl(String url) throws NotValidURLPageException;

    /**
     * Service checks whether the URL address corresponds to specified requirements
     * @param url URL address in string form
     * @return boolean value true or false
     */
    boolean isValidUrl(String url);
}
