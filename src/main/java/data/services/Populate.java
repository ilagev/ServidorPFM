package data.services;

import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import config.ResourceNames;
import data.daos.ReviewDao;
import data.daos.SmartphoneDao;
import data.daos.UserDao;
import data.entities.Review;
import data.entities.Role;
import data.entities.Smartphone;
import data.entities.User;

@Service
@Transactional
@PropertySource(ResourceNames.PROPERTIES)
public class Populate {
    
    @Autowired
    private SmartphoneDao smartphoneDao;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private ReviewDao reviewDao;
    
    @PostConstruct
    public void populate() {
        User user = new User("pedro", "pedro", "pedro@pedro.com");
        user.setKarma(95);
        user.setLevel(9);
        user = this.userDao.save(user);
        
        User mod = new User("mod", "mod", "mod@mod.com");
        mod.setRole(Role.MODERATOR);
        mod.setKarma(95);
        mod.setLevel(49);
        mod = this.userDao.save(mod);
        
        User admin = new User("admin", "admin", "admin@admin.com");
        admin.setRole(Role.ADMIN);
        admin = this.userDao.save(admin);
        
        Calendar c = Calendar.getInstance();
        c.set(2016, 3, 1);
        Smartphone sgs7 = new Smartphone("Galaxy S7", "Samsung", c.getTime(), 5.1, 1440, 1920, 4, 128, 3000,
                                         152, 142.4, 72.8, 6.7, true, true, true);
        sgs7.setCreator(user);
        smartphoneDao.save(sgs7);
        
        c = Calendar.getInstance();
        c.set(2016, 3, 1);
        Smartphone sgs6 = new Smartphone("Galaxy S6", "Samsung", c.getTime(), 4.9, 1080, 1560, 3, 64, 2800,
                                         158, 142.6, 72.9, 6.8, true, false, true);
        sgs6.setCreator(user);
        smartphoneDao.save(sgs6);
        
        c = Calendar.getInstance();
        c.set(2016, 2, 1);
        Smartphone htc9 = new Smartphone("M9", "HTC", c.getTime(), 4.7, 1280, 1560, 3, 64, 2860,
                                         105, 142.6, 72.9, 6.8, true, false, false);
        htc9.setCreator(mod);
        smartphoneDao.save(htc9);
        
        c = Calendar.getInstance();
        c.set(2014, 2, 10);
        Smartphone htc10 = new Smartphone("M10", "HTC", c.getTime(), 5.5, 1080, 2000, 3, 16, 3100,
                                         120, 162.6, 75.9, 7.0, false, true, false);
        htc10.setCreator(mod);
        smartphoneDao.save(htc10);
        
        c = Calendar.getInstance();
        c.set(2015, 6, 17);
        Smartphone z1 = new Smartphone("Zuk Z1", "Lenovo", c.getTime(), 5.5, 1780, 1200, 3, 128, 3500,
                                         130, 142.6, 75.4, 7.0, false, true, false);
        z1.setCreator(mod);
        smartphoneDao.save(z1);
        
        c = Calendar.getInstance();
        c.set(2016, 2, 18);
        Smartphone hp9 = new Smartphone("Lite P9", "Huawei", c.getTime(), 5.5, 1480, 1260, 2, 32, 2500,
                                         134, 122.6, 75.4, 9.0, false, true, false);
        hp9.setCreator(admin);
        smartphoneDao.save(hp9);
        
        Review rhp9 = new Review("Gran smarphone, buena pantalla, mejor bateria, pero poca memoria RAM :(", 7, hp9, mod);
        reviewDao.save(rhp9);
        
        Review rhtc9 = new Review("Asco de movil, esteticamente pesimo, HTC en sus ultimas... un desastre!!", 1, htc9, user);
        reviewDao.save(rhtc9);
        
        Review rhtc9_2 = new Review("No entiendo tanta critica, este es un movil en MAYUSCULAS, procesador, memoria, sonido... Perfecto hoyga", 10, htc9, mod);
        reviewDao.save(rhtc9_2);
        
        Review rhtc10 = new Review("ASI SI HTC, gran acabado, gran bateria, potencia a raudales... enhorabuena!!!", 9, htc10, admin);
        reviewDao.save(rhtc10);
        
    }

}
