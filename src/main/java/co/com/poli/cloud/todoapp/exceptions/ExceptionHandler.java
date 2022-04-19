package co.com.poli.cloud.todoapp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value
            = { IllegalArgumentException.class, IllegalStateException.class })
    protected ResponseEntity<Object> handleConflict(
            TodoExceptions ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(),
                new HttpHeaders(), ex.getHttpStatus(), request);
    }
}