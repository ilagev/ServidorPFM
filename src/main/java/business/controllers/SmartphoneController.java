package business.controllers;

import java.util.ArrayList;
import java.util.List;

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
        smartphoneDao.save(this.getSmartphoneEntity(smartphoneWrapper));
    }

    public SmartphoneWrapper getSmartphone(int id) {
        return this.getSmartphoneWrapper(smartphoneDao.findOne(id));
    }

    public List<SmartphoneWrapper> findSmartphones(String modelOrBrand) {
        List<SmartphoneWrapper> swl = new ArrayList<SmartphoneWrapper>();
        List<Smartphone> sl = new ArrayList<Smartphone>();
        String[] keywords = modelOrBrand.split(" ");
        for (String key : keywords) {
            sl.addAll(smartphoneDao.findSmartphoneByModelNameOrBrandName(key));
        }
        for (Smartphone s : sl) {
            swl.add(this.getSmartphoneWrapper(s));
        }
        return swl;
    }
    
    private SmartphoneWrapper getSmartphoneWrapper (Smartphone smartphoneEntity) {
        return new SmartphoneWrapper(
                smartphoneEntity.getId(),
                smartphoneEntity.getModelName(),
                smartphoneEntity.getBrandName(),
                smartphoneEntity.getReleaseDate(),
                smartphoneEntity.getScreenSize(),
                smartphoneEntity.getResolutionX(),
                smartphoneEntity.getResolutionY(),
                smartphoneEntity.getRam(),
                smartphoneEntity.getRom(),
                smartphoneEntity.getBattery(),
                smartphoneEntity.getWeight(),
                smartphoneEntity.getHeight(),
                smartphoneEntity.getWidth(),
                smartphoneEntity.getThickness(),
                smartphoneEntity.isGps(),
                smartphoneEntity.isNfc(),
                smartphoneEntity.isBluetooth());
    }
    
    private Smartphone getSmartphoneEntity (SmartphoneWrapper smartphoneWrapper) {
        return new Smartphone(
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
    }

}
