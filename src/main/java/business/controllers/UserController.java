package business.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import business.wrappers.UserWrapper;
import data.daos.UserDao;
import data.entities.User;

@Controller
public class UserController {
    
    private UserDao userDao;
    
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserWrapper getUser(String username) {
        return this.getUserWrapper(userDao.findByNick(username));
    }

    private UserWrapper getUserWrapper(User user) {
        return new UserWrapper(
            user.getId(),
            user.getNick(),
            user.getPassword(),
            user.getMail(),
            user.getLevel(),
            user.getKarma(),
            user.getRole()
        );
    }
    
    private User getUserEntity(UserWrapper userWrapper) {
        return new User(
            userWrapper.getNick(),
            userWrapper.getPassword(),
            userWrapper.getMail()
        );
    }

    public boolean existsUser(String nick, String mail) {
        return (userDao.findByNick(nick) != null) || (userDao.findByMail(mail) != null);
    }

    public UserWrapper create(UserWrapper userWrapper) {
        return this.getUserWrapper(userDao.save(this.getUserEntity(userWrapper)));
    }

}
