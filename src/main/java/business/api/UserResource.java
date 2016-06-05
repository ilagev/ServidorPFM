package business.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.AlreadyExistsUserException;
import business.api.exceptions.UserNotFoundException;
import business.controllers.UserController;
import business.wrappers.PasswordWrapper;
import business.wrappers.UserWrapper;
import business.wrappers.SmartphoneWrapper;;

@RestController
@RequestMapping(Uris.SERVLET_MAP + Uris.USERS)
public class UserResource {
    
    private UserController userController;

    @Autowired
    public void setUserController(UserController userController) {
        this.userController = userController;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = Uris.LOGGED_IN)
    public UserWrapper getUser(@AuthenticationPrincipal User activeUser) {
        return userController.getUser(activeUser.getUsername());
    }
    
    @RequestMapping(method = RequestMethod.GET, value = Uris.ID)
    public UserWrapper getUser(@PathVariable int id) {
        return userController.getUser(id);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = Uris.ID + Uris.SMARTPHONES)
    public List<SmartphoneWrapper> getUserSmartphones(@PathVariable int id) {
        return userController.getUserSmartphones(id);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public UserWrapper findUser(@RequestParam(value = "nick", required = false) String nick, @RequestParam(value = "mail", required = false) String mail) throws UserNotFoundException {
        if (userController.existsUser(nick, mail)) {
            return userController.findUser(nick, mail);
        } else {
            throw new UserNotFoundException("No existe el user " + nick + " con mail " + mail);
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public UserWrapper createUser(@RequestBody UserWrapper userWrapper) throws AlreadyExistsUserException {
        if (!userController.existsUser(userWrapper.getNick(), userWrapper.getMail())) {
            return userController.create(userWrapper);
        } else {
            throw new AlreadyExistsUserException("Ya existe el user " + userWrapper.getNick());
        }
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = Uris.LOGGED_IN + Uris.PASSWORD)
    public UserWrapper updatePassword(@RequestBody PasswordWrapper password, @AuthenticationPrincipal User activeUser) {
        return userController.updatePassword(activeUser.getUsername(), password.getNewp());
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = Uris.LOGGED_IN + Uris.SMARTPHONE)
    public UserWrapper updatePassword(@RequestBody SmartphoneWrapper smartphone, @AuthenticationPrincipal User activeUser) {
        return userController.updateSmartphoneOwned(smartphone.getId(), activeUser.getUsername());
    }
    
}
