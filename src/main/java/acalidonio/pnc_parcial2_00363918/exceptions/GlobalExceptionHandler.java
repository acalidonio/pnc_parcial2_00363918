package acalidonio.pnc_parcial2_00363918.exceptions;

import acalidonio.pnc_parcial2_00363918.domain.dto.response.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404 Error
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage(), request.getRequestURI());
    }

    // 400 Error
    @ExceptionHandler(FieldValidationException.class)
    public ResponseEntity<ApiErrorResponse> handleFieldValidation(FieldValidationException e, HttpServletRequest request) {
        return buildResponse(HttpStatus.BAD_REQUEST, e.getMessage(), request.getRequestURI());
    }

    // 409 Error
    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ApiErrorResponse> handleConflict(ConflictException e, HttpServletRequest request) {
        return buildResponse(HttpStatus.CONFLICT, e.getMessage(), request.getRequestURI());
    }

    // 422 Error
    @ExceptionHandler(BusinessLogicException.class)
    public ResponseEntity<ApiErrorResponse> handleBusinessLogic(BusinessLogicException e, HttpServletRequest request) {
        return buildResponse(HttpStatus.UNPROCESSABLE_CONTENT, e.getMessage(), request.getRequestURI());
    }

    private ResponseEntity<ApiErrorResponse> buildResponse(HttpStatus status, Object message, String uri) {
        return ResponseEntity
                .status(status)
                .body(ApiErrorResponse.builder()
                        .status(status.value())
                        .message(message)
                        .time(LocalDateTime.now())
                        .uri(uri)
                        .build()
        );
    }
}