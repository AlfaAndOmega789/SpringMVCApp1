package ru.kovalia.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPag(@RequestParam(value = "name", required = false)String name,
                           @RequestParam(value = "surname", required = false)String surname,
                           Model model){
//        System.out.println("Hello " + name + ", " + surname);
        model.addAttribute("message", "Hello " + name + ", " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String mathOperation(@RequestParam(value = "a", required = false)Integer a,
                                @RequestParam(value = "b", required = false)Integer b,
                                @RequestParam(value = "action", required = false)String action,
                                Model model){
        String str = null;

        if(action.equals("multiplication")){
            str = String.valueOf(a * b );
        }
        if(action.equals("addition")){
            str = String.valueOf(a + b );
        }
        if(action.equals("subtraction")){
            str = String.valueOf(a - b );
        }
        if(action.equals("division")){
            str = String.valueOf( (double) a / (double) b);
        }
        model.addAttribute("message", "Result operation: " + str);

        return "first/calculator";
    }

}
