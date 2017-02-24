package org.sokirka.task.controllers;

import org.sokirka.task.exceptions.NotValidURLPageException;
import org.sokirka.task.service.ApplicationService;
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

    @Autowired
    private ApplicationService service;

    @ResponseBody
    @RequestMapping(value = "/")
    public String inputRequestParam(@RequestParam(value = "url", required = true) String url) throws NotValidURLPageException {
        if (!service.isValidUrl(url))
            throw new NotValidURLPageException("Page not valid");
        return service.getModifiedTextForUrl(url);
    }
}
