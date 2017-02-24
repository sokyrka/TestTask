package org.sokirka.task.parser.impl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.sokirka.task.exceptions.NotHTMLContentException;
import org.sokirka.task.exceptions.NotValidURLPageException;
import org.sokirka.task.parser.Parser;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Eugine Sokirka
 */
@Component
public class HTMLParser implements Parser {

    @Override
    public String parse(String input) throws NotValidURLPageException {
        Document document;
        String elements;
        try {
            document = Jsoup.connect(input).get();
            if (!document.hasText())
                throw new NotHTMLContentException("This URL address - " + input + " does not has HTML content.");
            elements = document.text();
        } catch (IOException | NotHTMLContentException e) {
            throw new NotValidURLPageException("Page not valid. Cause: " + e.getMessage(), e);
        }
        return elements;
    }
}
