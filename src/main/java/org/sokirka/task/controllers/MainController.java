package org.sokirka.task.controllers;

import org.sokirka.task.exceptions.NotValidURLPageException;
import org.sokirka.task.expr.ExpressionChecker;
import org.sokirka.task.parser.Parser;
import org.sokirka.task.text.TextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Eugine Sokirka
 */
@Controller
public class MainController {

    private ExpressionChecker checker;
    private Parser parser;
    private TextHandler textHandler;

    @Autowired
    public MainController(ExpressionChecker checker, Parser parser, TextHandler textHandler) {
        this.checker = checker;
        this.parser = parser;
        this.textHandler = textHandler;
    }

    @ResponseBody
    @RequestMapping(value = "/")
    public String inputRequestParam(@RequestParam(value = "url", required = true) String url) throws NotValidURLPageException {
        if (!checker.isValid(url))
            throw new NotValidURLPageException("Page not valid");
        String parsedText = parser.parse(url);
        return textHandler.getPerformedText(parsedText).toString();
    }
}
