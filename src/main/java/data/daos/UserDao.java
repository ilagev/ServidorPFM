package data.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import data.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
    
    @Query("select token.user from Token token where token.value = ?1")
    public User findByTokenValue(String tokenValue);
    
    public User findByNick(String nick);
    
    public User findByMail(String mail);

}
