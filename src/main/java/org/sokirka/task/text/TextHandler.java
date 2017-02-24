package org.sokirka.task.text;

import java.util.Map;

/**
 * @author Eugine Sokirka
 */
public interface TextHandler {
    Map<String, Integer> getPerformedText(String words);
}
