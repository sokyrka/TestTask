package org.sokirka.task.expr.impl;

import org.sokirka.task.expr.ExpressionChecker;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eugine Sokirka
 */
@Component
public class URLChecker implements ExpressionChecker {

    private final static String regex = "http?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,4}\\b([-a-zA-Z0-9@:%_\\+.~#?&//=]*)";

    @Override
    public boolean isValid(String url) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
