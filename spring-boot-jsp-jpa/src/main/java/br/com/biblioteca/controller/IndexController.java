package br.com.biblioteca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class IndexController {

//    @RequestMapping("/index")
//    String home() {
//        return "index";
//    }
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String menu(ModelMap model) {

        return "index";
    }
}
