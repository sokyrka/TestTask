package org.sokirka.task.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Eugine Sokirka
 */
@Controller
public class MainController {

    @ResponseBody
    @RequestMapping(path = "/")
    public String sayHello() {
        return "Hello Spring World";
    }

}
