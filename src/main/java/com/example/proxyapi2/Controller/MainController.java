package com.example.proxyapi2.Controller;

import com.example.proxyapi2.Model.Request;
import com.example.proxyapi2.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.util.Map;

@RestController
public class MainController {
    private MainService mainService;

    @Autowired
    public MainController(MainService mainService){
        this.mainService=mainService;
    }

    @RequestMapping(value = "/",params = {"cm=hdb","action"})
    public @ResponseBody String example(@RequestParam("action") String action){
        return action;
    }
}
