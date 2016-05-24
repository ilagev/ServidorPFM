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
    
    public SmartphoneWrapper create(SmartphoneWrapper smartphoneWrapper) {
        return this.getSmartphoneWrapper(smartphoneDao.save(this.getSmartphoneEntity(smartphoneWrapper)));
        
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

    public SmartphoneWrapper updateSmartphone(SmartphoneWrapper smartphoneWrapper, int id) {
        Smartphone smartphoneEntity = this.smartphoneDao.findById(id);
        smartphoneEntity.setModelName(smartphoneWrapper.getModelName());
        smartphoneEntity.setBrandName(smartphoneWrapper.getBrandName());
        smartphoneEntity.setReleaseDate(smartphoneWrapper.getReleaseDate());
        smartphoneEntity.setScreenSize(smartphoneWrapper.getScreenSize());
        smartphoneEntity.setResolutionX(smartphoneWrapper.getResolutionX());
        smartphoneEntity.setResolutionY(smartphoneWrapper.getResolutionY());
        smartphoneEntity.setRam(smartphoneWrapper.getRam());
        smartphoneEntity.setRom(smartphoneWrapper.getRom());
        smartphoneEntity.setBattery(smartphoneWrapper.getBattery());
        smartphoneEntity.setWeight(smartphoneWrapper.getWeight());
        smartphoneEntity.setHeight(smartphoneWrapper.getHeight());
        smartphoneEntity.setWidth(smartphoneWrapper.getWidth());
        smartphoneEntity.setThickness(smartphoneWrapper.getThickness());
        smartphoneEntity.setGps(smartphoneWrapper.isGps());
        smartphoneEntity.setNfc(smartphoneWrapper.isNfc());
        smartphoneEntity.setBluetooth(smartphoneWrapper.isBluetooth());
        
        this.smartphoneDao.save(smartphoneEntity);
        return this.getSmartphoneWrapper(smartphoneEntity);
    }

    public void removeSmartphone(int id) {
        this.smartphoneDao.delete(smartphoneDao.findById(id));
    }

}
