package business.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrappers.SmartphoneWrapper;
import business.wrappers.UserWrapper;
import data.daos.SmartphoneDao;
import data.daos.UserDao;
import data.entities.Smartphone;
import data.entities.User;

@Controller
public class UserController {
    
    private UserDao userDao;
    
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
    private SmartphoneController smartphoneController;
    
    @Autowired
    public void setSmartphoneController(SmartphoneController smartphoneController) {
        this.smartphoneController = smartphoneController;
    }
    
    private SmartphoneDao smartphoneDao;
    
    @Autowired
    public void setSmartphoneDao(SmartphoneDao smartphoneDao) {
        this.smartphoneDao = smartphoneDao;
    }

    public UserWrapper getUser(String username) {
        return this.getUserWrapper(userDao.findByNick(username));
    }

    private UserWrapper getUserWrapper(User user) {
        UserWrapper uw = new UserWrapper(
            user.getId(),
            user.getNick(),
            user.getPassword(),
            user.getMail(),
            user.getLevel(),
            user.getKarma(),
            user.getRole()
        );
        if (user.getSmartphone() != null) {
            uw.setSmartphoneId(user.getSmartphone().getId());
            uw.setSmartphoneBrandName(user.getSmartphone().getBrandName());
            uw.setSmartphoneModelName(user.getSmartphone().getModelName());
        }
        return uw;
    }
    
    private User getUserEntity(UserWrapper userWrapper) {
        return new User(
            userWrapper.getNick(),
            userWrapper.getPassword(),
            userWrapper.getMail()
        );
    }

    public UserWrapper findUser(String nick, String mail) {
        if (userDao.findByNick(nick) != null) {
            return this.getUserWrapper(userDao.findByNick(nick));
        } else if (userDao.findByMail(mail) != null) {
            return this.getUserWrapper(userDao.findByMail(mail));
        } else {
            return null;
        }
    }
    
    public boolean existsUser(String nick, String mail) {
        return (userDao.findByNick(nick) != null) || (userDao.findByMail(mail) != null);
    }

    public UserWrapper create(UserWrapper userWrapper) {
        return this.getUserWrapper(userDao.save(this.getUserEntity(userWrapper)));
    }

    public UserWrapper updatePassword(String username, String newPassword) {
        User user = userDao.findByNick(username);
        user.setPassword(newPassword);
        return this.getUserWrapper(userDao.save(user));
    }

    public UserWrapper getUser(int id) {
        return this.getUserWrapper(userDao.findById(id));
    }

    public List<SmartphoneWrapper> getUserSmartphones(int id) {
        List<SmartphoneWrapper> swl = new ArrayList<SmartphoneWrapper>();
        List<Smartphone> smartphoneEntities = smartphoneDao.findByCreatorId(id);
        for (Smartphone s : smartphoneEntities) {
            swl.add(smartphoneController.getSmartphoneWrapper(s));
        }
        return swl;
    }

    public UserWrapper updateSmartphoneOwned(int id, String nick) {
        User user = userDao.findByNick(nick);
        user.setSmartphone(smartphoneDao.findById(id));
        userDao.save(user);
        return this.getUserWrapper(user);
    }

    public SmartphoneWrapper getSmartphoneOwned(String username) {
        Smartphone smartphone = userDao.findByNick(username).getSmartphone();
        if (smartphone == null) {
            return null;
        } else {
            return smartphoneController.getSmartphoneWrapper(smartphone);
        }
    }

}
