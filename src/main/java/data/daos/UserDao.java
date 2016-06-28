package data.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import data.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
    
    @Query("select token.user from Token token where token.value = ?1")
    public User findByTokenValue(String tokenValue);
    
    public User findByNick(String nick);
    
    public User findByMail(String mail);

    public User findById(int id);

    @Query("select user from User user where user.smartphone.id = ?1")
    public List<User> findBySmartphoneOwnedId(int id);

}
