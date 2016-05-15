package business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

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
    public SmartphoneWrapper createSmartphone(@RequestBody SmartphoneWrapper smartphoneWrapper) {
        System.out.println(smartphoneWrapper.toString());
        return smartphoneController.create(smartphoneWrapper);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = Uris.ID)
    public SmartphoneWrapper getSmartphone(@PathVariable int id) {
        return smartphoneController.getSmartphone(id);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<SmartphoneWrapper> searchSmartphones(@RequestParam("query") String modelOrBrand) {
        return smartphoneController.findSmartphones(modelOrBrand);
    }

}
