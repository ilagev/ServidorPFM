package business.wrappers;

import data.entities.Role;

public class UserWrapper {
    
    private int id;
    private String nick;
    private String password;
    private String mail;
    private int level;
    private int karma;
    private String role;
    
    public UserWrapper() {
        
    }
    
    public UserWrapper(int id, String nick, String password, String mail, int level, int karma, Role role) {
        super();
        this.id = id;
        this.nick = nick;
        this.password = password;
        this.mail = mail;
        this.level = level;
        this.karma = karma;
        this.role = role.roleName();
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
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserWrapper [id=" + id + ", nick=" + nick + ", password=" + password + ", mail=" + mail + ", level=" + level + ", karma="
                + karma + ", role=" + role + "]";
    }
    
    

}
