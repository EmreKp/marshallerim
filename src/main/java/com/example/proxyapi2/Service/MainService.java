package com.example.proxyapi2.Service;

import com.example.proxyapi2.Model.Request;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

@Service
public class MainService {
    public Request convertToObject(String json) throws JAXBException {
        System.setProperty("javax.xml.bind.context.factory","org.eclipse.persistence.jaxb.JAXBContextFactory");
        JAXBContext jaxbContext=JAXBContext.newInstance(Request.class);
        Unmarshaller unmarshaller=jaxbContext.createUnmarshaller();
        unmarshaller.setProperty("eclipselink.media-type", "application/json");
        StreamSource source=new StreamSource(new StringReader(json));
        JAXBElement<Request> javaObj=unmarshaller.unmarshal(source,Request.class);
        return javaObj.getValue();
    }

    public String deneme(){
        //invokea null denince method statik olacak ya da başka bişey en kolayı bu
        return "deneme";
    }

    public int intAl(){
        return 3;
    }

    public int intBak(){
        return 5;
    }
}
