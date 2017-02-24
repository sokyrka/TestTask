package org.sokirka.task.text;

import java.util.Map;

/**
 * @author Eugine Sokirka
 */
public interface TextHandler {
    /**
     * Cleans punctuation marks and calculates doubles
     * @param words set of words for modification
     * @return sorted set of words with their amounts
     */
    Map<String, Integer> getModifiedText(String words);
}
