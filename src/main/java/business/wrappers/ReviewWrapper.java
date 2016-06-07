package business.wrappers;

import java.util.Date;

public class ReviewWrapper {
    
    private int id;
    private Date date;
    private String text;
    private float mark;
    private int smartphoneId;
    private String user;
    private int userId;
    
    public ReviewWrapper() {
        
    }
    
    public ReviewWrapper(int id, Date date, String text, float mark, String user, int smartphoneId, int userId) {
        super();
        this.id = id;
        this.date = date;
        this.text = text;
        this.mark = mark;
        this.user = user;
        this.smartphoneId = smartphoneId;
        this.userId = userId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public float getMark() {
        return mark;
    }
    public void setMark(float mark) {
        this.mark = mark;
    }
    public int getSmartphoneId() {
        return smartphoneId;
    }
    public void setSmartphoneId(int smartphoneId) {
        this.smartphoneId = smartphoneId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ReviewWrapper [id=" + id + ", date=" + date + ", text=" + text + ", mark=" + mark + ", smartphoneId=" + smartphoneId
                + ", user=" + user + ", userId=" + userId + "]";
    }

}
