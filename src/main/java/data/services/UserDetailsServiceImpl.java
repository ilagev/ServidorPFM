package data.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import data.daos.UserDao;
import data.entities.Role;
import data.entities.User;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(final String usernameOrToken) throws UsernameNotFoundException {
        User user = userDao.findByTokenValue(usernameOrToken);
        if (user != null) {
            return this.userBuilder(user.getNick(),  new BCryptPasswordEncoder().encode(""), user.getRole());
        } else {
            user = userDao.findByNick(usernameOrToken);
            if (user != null) {
                System.out.println(user.getNick());
                return this.userBuilder(user.getNick(), user.getPassword(), user.getRole());
            } else {
                throw new UsernameNotFoundException("Usuario no encontrado");
            }
        }
    }
    
    private org.springframework.security.core.userdetails.User userBuilder(String username, String password, Role role) {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.roleName()));
        return new org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);
    }

}
