package business.api.exceptions;

public class UserNotFoundException extends ApiException {
    
    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "El usuario referenciado no existe";

    public static final int CODE = 1;

    public UserNotFoundException() {
        this("");
    }

    public UserNotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
