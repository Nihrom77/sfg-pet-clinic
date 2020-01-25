package com.springframework.cfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners") //Все запросы на owners будут попадать в этот класс
@Controller
public class OwnerController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String listOwners() {
        return "owners/index";
    }
}
