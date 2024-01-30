package cat.itacademy.barcelonactiva.rodriguez.jose.s05.t01.n01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping({"/index","/home","/"})
    public String index(){
        return "index";
    }
}
