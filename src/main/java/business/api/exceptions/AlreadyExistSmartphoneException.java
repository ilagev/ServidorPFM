package business.api.exceptions;

public class AlreadyExistSmartphoneException extends ApiException {

    private static final long serialVersionUID = -1344640670884805385L;

    public static final String DESCRIPTION = "Campo modelo y marca ya existente en la BD";

    public static final int CODE = 1;

    public AlreadyExistSmartphoneException() {
        this("");
    }

    public AlreadyExistSmartphoneException(String detail) {
        super(DESCRIPTION + ". " + detail, CODE);
    }
    
}
