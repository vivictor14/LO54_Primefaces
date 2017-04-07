package fr.utbm.lo54.primeProject.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexConfig {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:index.xhtml";
    }
}
