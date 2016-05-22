package data.services;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import config.ResourceNames;
import data.daos.SmartphoneDao;
import data.entities.Smartphone;

@Service
@Transactional
@PropertySource(ResourceNames.PROPERTIES)
public class Populate {
    
    @Autowired
    private SmartphoneDao smartphoneDao;
    
    @PostConstruct
    public void createSmartphones() {
        Calendar c = Calendar.getInstance();
        c.set(2016, 3, 1);
        Smartphone sgs7 = new Smartphone("Galaxy S7", "Samsung", c.getTime(), 5.1, 1440, 1920, 4, 128, 3000,
                                         152, 142.4, 72.8, 6.7, true, true, true);
        smartphoneDao.save(sgs7);
        
        c = Calendar.getInstance();
        c.set(2016, 3, 1);
        Smartphone sgs6 = new Smartphone("Galaxy S6", "Samsung", c.getTime(), 4.9, 1080, 1560, 3, 64, 2800,
                                         158, 142.6, 72.9, 6.8, true, false, true);
        smartphoneDao.save(sgs6);
        
        c = Calendar.getInstance();
        c.set(2016, 2, 1);
        Smartphone htc9 = new Smartphone("M9", "HTC", c.getTime(), 4.7, 1280, 1560, 3, 64, 2860,
                                         105, 142.6, 72.9, 6.8, true, false, false);
        smartphoneDao.save(htc9);
        
        c = Calendar.getInstance();
        c.set(2014, 2, 10);
        Smartphone htc10 = new Smartphone("M10", "HTC", c.getTime(), 5.5, 1080, 2000, 3, 16, 3100,
                                         120, 162.6, 75.9, 7.0, false, true, false);
        smartphoneDao.save(htc10);
        
        c = Calendar.getInstance();
        c.set(2015, 6, 17);
        Smartphone z1 = new Smartphone("Zuk Z1", "Lenovo", c.getTime(), 5.5, 1780, 1200, 3, 128, 3500,
                                         130, 142.6, 75.4, 7.0, false, true, false);
        smartphoneDao.save(z1);
        
        c = Calendar.getInstance();
        c.set(2016, 2, 18);
        Smartphone hp9 = new Smartphone("Lite P9", "Huawei", c.getTime(), 5.5, 1480, 1260, 2, 32, 2500,
                                         134, 122.6, 75.4, 9.0, false, true, false);
        smartphoneDao.save(hp9);
        
        
    }

}
