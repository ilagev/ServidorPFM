package data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {
    
    @Id
    @GeneratedValue
    private int id;
    
    private String nick;
    private String password;
    private String mail;
    private int level;
    private int karma;
    private Role role;
    
    @OneToOne
    private Smartphone smartphone;
    
    public User() {
        
    }
    
    public User(String nick, String password, String mail) {
        super();
        this.nick = nick;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.mail = mail;
        this.level = 0;
        this.karma = 0;
        this.role = Role.USER;
        this.smartphone = null;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNick() {
        return nick;
    }
    
    public void setNick(String nick) {
        this.nick = nick;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public int getKarma() {
        return karma;
    }
    
    public void setKarma(int karma) {
        this.karma = karma;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    

}
