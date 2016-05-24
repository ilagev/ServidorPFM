package business.api.exceptions;

public class NotFoundSmartphoneException extends ApiException {
    
    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "El smartphone referenciado no existe";

    public static final int CODE = 1;

    public NotFoundSmartphoneException() {
        this("");
    }

    public NotFoundSmartphoneException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }

}
