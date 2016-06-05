package business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import business.api.exceptions.AlreadyExistSmartphoneException;
import business.api.exceptions.NotFoundSmartphoneException;
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
    public SmartphoneWrapper createSmartphone(@RequestBody SmartphoneWrapper smartphoneWrapper, @AuthenticationPrincipal User activeUser) throws AlreadyExistSmartphoneException {
        if (!smartphoneController.existsSmartphone(smartphoneWrapper.getBrandName(), smartphoneWrapper.getModelName(), null)) {
            return smartphoneController.create(smartphoneWrapper, activeUser.getUsername());
        } else {
            throw new AlreadyExistSmartphoneException("Ya existe el smartphone " + smartphoneWrapper.getBrandName() + " " + 
                                                                               smartphoneWrapper.getModelName());
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, value = Uris.ID)
    public SmartphoneWrapper getSmartphone(@PathVariable int id) throws NotFoundSmartphoneException {
        if (smartphoneController.existsSmartphone(id)) {
            return smartphoneController.getSmartphone(id);
        } else {
            throw new NotFoundSmartphoneException("No existe el smartphone con id = " + id);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<SmartphoneWrapper> searchSmartphones(@RequestParam("query") String modelOrBrand) {
        return smartphoneController.findSmartphones(modelOrBrand);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = Uris.ID)
    public SmartphoneWrapper updateSmartphone(@RequestBody SmartphoneWrapper smartphoneWrapper, @PathVariable int id) throws AlreadyExistSmartphoneException, NotFoundSmartphoneException {
        if (smartphoneController.existsSmartphone(smartphoneWrapper.getBrandName(), smartphoneWrapper.getModelName(), id)) {
            throw new AlreadyExistSmartphoneException("Ya existe el smartphone " + smartphoneWrapper.getBrandName() + " " + 
                    smartphoneWrapper.getModelName());
        } else if (!smartphoneController.existsSmartphone(id)) {
            throw new NotFoundSmartphoneException("No existe el smartphone con id = " + id);
        } else {
            return smartphoneController.updateSmartphone(smartphoneWrapper, id);
        }
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value = Uris.ID)
    public void removeSmartphone(@PathVariable int id) throws NotFoundSmartphoneException {
        if (smartphoneController.existsSmartphone(id)) {
            smartphoneController.removeSmartphone(id);
        } else {
            throw new NotFoundSmartphoneException("No existe el smartphone con id = " + id);
        }
    }

}
