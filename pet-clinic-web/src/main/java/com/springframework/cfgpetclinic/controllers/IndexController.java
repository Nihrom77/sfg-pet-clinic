package com.springframework.cfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //Если запрос заканчивается на любое из этих имен, он будет обработан этим контроллером
    @RequestMapping({"", "/", "index", "index.html"})
    public String getIndex() {
        return "index";
    }
}
