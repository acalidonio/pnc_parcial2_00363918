package acalidonio.pnc_parcial2_00363918.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_CONTENT)
public class BusinessLogicException extends RuntimeException {
    public BusinessLogicException(String message) {
        super(message);
    }
}
