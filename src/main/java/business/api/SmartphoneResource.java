package business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import business.controllers.SmartphoneController;
import business.wrappers.SmartphoneWrapper;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.SMARTPHONES)
public class SmartphoneResource {
    
    private SmartphoneController smartphoneController;
    
    @Autowired
    public void setSmartphoneController(SmartphoneController smartphoneController) {
        this.smartphoneController = smartphoneController;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void createSmartphone(@RequestBody SmartphoneWrapper smartphoneWrapper) {
        System.out.println(smartphoneWrapper.toString());
        smartphoneController.create(smartphoneWrapper);
    }

}
