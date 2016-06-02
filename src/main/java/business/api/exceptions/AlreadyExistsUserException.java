package business.api.exceptions;

public class AlreadyExistsUserException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "Usuario ya existente en la BD";

    public static final int CODE = 1;

    public AlreadyExistsUserException() {
        this("");
    }

    public AlreadyExistsUserException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }
    
}
