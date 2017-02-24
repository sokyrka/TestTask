package org.sokirka.task.text.impl;

import org.sokirka.task.text.TextHandler;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * @author Eugine Sokirka
 */
@Component
public class TextHandlerImpl implements TextHandler {

    @Override
    public Map<String, Integer> getModifiedText(String words) {
        StringTokenizer tokenizer = new StringTokenizer(words, " .,;-@\r");
        Map<String, Integer> map = new TreeMap<>();
        map.put(" Total count", tokenizer.countTokens());

        String word;
        Integer count;

        while (tokenizer.hasMoreTokens()) {
            word = tokenizer.nextToken();

            count = map.get(word);
            count = (count == null) ? 1 : count + 1;
            map.put(word, count);
        }

        return map;
    }
}
