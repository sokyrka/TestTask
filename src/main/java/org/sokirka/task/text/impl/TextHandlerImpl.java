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
    public Map<String, Integer> getPerformedText(String words) {
        StringTokenizer tokenizer = new StringTokenizer(words, " .,;-\r");
        Map<String, Integer> map = new TreeMap<>();

        String word;
        Integer count;

        System.out.println("Count: " + tokenizer.countTokens());

        while (tokenizer.hasMoreTokens()) {
            word = tokenizer.nextToken();

            count = map.get(word);
            count = (count == null) ? 1 : count + 1;
            map.put(word, count);
        }

        System.out.println(map.toString());

        return map;
    }
}
