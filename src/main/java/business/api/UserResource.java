package business.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import business.api.exceptions.AlreadyExistsUserException;
import business.controllers.UserController;
import business.wrappers.UserWrapper;

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
    
    @RequestMapping(method = RequestMethod.GET)
    public boolean existsUser(@RequestParam(value = "nick", required = false) String nick, @RequestParam(value = "mail", required = false) String mail) {
        return userController.existsUser(nick, mail);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public UserWrapper createUser(@RequestBody UserWrapper userWrapper) throws AlreadyExistsUserException {
        if (!userController.existsUser(userWrapper.getNick(), userWrapper.getMail())) {
            return userController.create(userWrapper);
        } else {
            throw new AlreadyExistsUserException("Ya existe el user " + userWrapper.getNick());
        }
    }
    
}
