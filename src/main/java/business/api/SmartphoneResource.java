package business.api;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.wrappers.SmartphoneWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.SMARTPHONES)
public class SmartphoneResource {
    
    @RequestMapping(method = RequestMethod.POST)
    public void createSmartphone(@RequestBody SmartphoneWrapper smartphoneWrapper) {
        // TODO: de momento ver que lo recibimos
        System.out.println(smartphoneWrapper.toString());
    }

}
