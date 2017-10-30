package com.example.proxyapi2.Controller;

import com.example.proxyapi2.Model.Request;
import com.example.proxyapi2.Service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.*;

@RestController
public class MainController {
    private MainService mainService;

    @Autowired
    public MainController(MainService mainService){
        this.mainService=mainService;
    }

    @RequestMapping("/requestAl")
    public @ResponseBody String example(@RequestBody String json) throws JAXBException {
        Request requestObj=this.mainService.convertToObject(json);
        return requestObj.getPass();
    }
}
