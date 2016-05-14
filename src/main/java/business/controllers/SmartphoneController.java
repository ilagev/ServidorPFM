package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrappers.SmartphoneWrapper;
import data.daos.SmartphoneDao;
import data.entities.Smartphone;

@Controller
public class SmartphoneController {
    
    private SmartphoneDao smartphoneDao;
    
    @Autowired
    public void setSmartphoneDao(SmartphoneDao smartphoneDao) {
        this.smartphoneDao = smartphoneDao;
    }
    
    public void create(SmartphoneWrapper smartphoneWrapper) {
        Smartphone smartphone = new Smartphone(
                smartphoneWrapper.getModelName(),
                smartphoneWrapper.getBrandName(),
                smartphoneWrapper.getReleaseDate(),
                smartphoneWrapper.getScreenSize(),
                smartphoneWrapper.getResolutionX(),
                smartphoneWrapper.getResolutionY(),
                smartphoneWrapper.getRam(),
                smartphoneWrapper.getRom(),
                smartphoneWrapper.getBattery(),
                smartphoneWrapper.getWeight(),
                smartphoneWrapper.getHeight(),
                smartphoneWrapper.getWidth(),
                smartphoneWrapper.getThickness(),
                smartphoneWrapper.isGps(),
                smartphoneWrapper.isNfc(),
                smartphoneWrapper.isBluetooth());
        smartphoneDao.save(smartphone);
    }

}
