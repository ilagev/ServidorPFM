package data.entities;

public enum Role {
    USER, MODERATOR, ADMIN;

    public String roleName() {
        return "ROLE_" + this.toString();
    }

}