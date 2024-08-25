package movie.com.example.movie.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorMessage handleResourceNotFound(
            final ResourceNotFoundException exception,
            final HttpServletRequest request){
        return ErrorMessage.builder()
                .errorMessage(exception.getMessage())
                .requestedURI(request.getRequestURI())
                .timestamp(Instant.now())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorMessage handleMethodArgumentNotValid(
            final ConstraintViolationException exception,
            final HttpServletRequest request) {
        return ErrorMessage.builder()
                .errorMessage(exception.getMessage())
                .requestedURI(request.getRequestURI())
                .timestamp(Instant.now())
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ErrorMessage handleException(
            final Exception exception,
            final HttpServletRequest request) {
        return ErrorMessage.builder()
                .errorMessage(exception.getMessage())
                .requestedURI(request.getRequestURI())
                .timestamp(Instant.now())
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }
}
