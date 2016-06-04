package business.wrappers;

public class PasswordWrapper {
    
    private String newp;
    
    public PasswordWrapper() {
        
    }
    
    public PasswordWrapper(String newp) {
        this.newp = newp;
    }
    
    public String getNewp() {
        return newp;
    }
    public void setNewp(String newp) {
        this.newp = newp;
    }

    @Override
    public String toString() {
        return "PasswordWrapper [newp=" + newp + "]";
    }
    
}
