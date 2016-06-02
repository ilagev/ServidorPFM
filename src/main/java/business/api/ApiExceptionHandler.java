package business.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import business.api.exceptions.AlreadyExistSmartphoneException;
import business.api.exceptions.AlreadyExistsUserException;
import business.api.exceptions.ApiException;
import business.api.exceptions.ErrorMessage;
import business.api.exceptions.NotFoundSmartphoneException;

@ControllerAdvice
public class ApiExceptionHandler {
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({NotFoundSmartphoneException.class})
    @ResponseBody
    public ErrorMessage notFoundRequest(ApiException exception) {
        ErrorMessage apiErrorMessage = new ErrorMessage(exception);
        return apiErrorMessage;
    }
    
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({AlreadyExistSmartphoneException.class, AlreadyExistsUserException.class})
    @ResponseBody
    public ErrorMessage conflictRequest(ApiException exception) {
        ErrorMessage apiErrorMessage = new ErrorMessage(exception);
        return apiErrorMessage;
    }

}
