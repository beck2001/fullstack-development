package kz.iitu.insurancecrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String homeController(Principal principal) {
        return "Welcome to insurance website, " + principal.getName();
    }
}
