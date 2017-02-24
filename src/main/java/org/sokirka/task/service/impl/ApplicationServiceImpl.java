package org.sokirka.task.service.impl;

import org.apache.commons.lang3.text.StrBuilder;
import org.sokirka.task.exceptions.NotValidURLPageException;
import org.sokirka.task.expr.ExpressionChecker;
import org.sokirka.task.parser.Parser;
import org.sokirka.task.service.ApplicationService;
import org.sokirka.task.text.TextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Eugine Sokirka
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    private Parser parser;
    private TextHandler textHandler;
    private ExpressionChecker checker;

    @Autowired
    public ApplicationServiceImpl(Parser parser, TextHandler textHandler, ExpressionChecker checker) {
        this.parser = parser;
        this.textHandler = textHandler;
        this.checker = checker;
    }

    @Override
    public String getModifiedTextForUrl(String url) throws NotValidURLPageException {
        String parsedResult = parser.parse(url);
        Map<String, Integer> modifiedResult = textHandler.getModifiedText(parsedResult);
        return makeTextPretty(modifiedResult);
    }

    @Override
    public boolean isValidUrl(String url) {
        return checker.isValid(url);
    }

    private String makeTextPretty(Map<String, Integer> map) {
        StrBuilder finalResult = new StrBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            finalResult.append("<p>")
                    .append(entry.getKey())
                    .append(" - ")
                    .append(entry.getValue())
                    .append("</p>")
                    .appendNewLine();
        }
        return finalResult.toString();
    }
}
