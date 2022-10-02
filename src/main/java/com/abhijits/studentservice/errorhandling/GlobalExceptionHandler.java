package com.abhijits.studentservice.errorhandling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.stream.Collectors;

/**
 * Created by   : Abhijit Singh
 * On           : 24 September, 2022
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("${stackTrace.enabled}")
    private boolean printStackTrace;

    @Override
    public ResponseEntity<Object> handleExceptionInternal(
            Exception ex,
            Object body,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        return buildErrorResponse(ex, status);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleAllException(Exception ex) {
        ResponseStatus responseStatus = ex.getClass().getAnnotation(ResponseStatus.class);
        if (responseStatus != null)
            return buildErrorResponse(ex, responseStatus.value());
        return buildErrorResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<Object> buildErrorResponse(Exception exception, HttpStatus httpStatus) {
        ErrorResponse errorResponse = ErrorResponse.createInstance()
                                                   .setStatusCode(httpStatus.value());

        if (exception instanceof MethodArgumentNotValidException) {
            errorResponse.setMessage(((MethodArgumentNotValidException) exception).getBindingResult().getAllErrors().stream().map(
                    MessageSourceResolvable::getDefaultMessage).collect(Collectors.toList()));
        } else {
            errorResponse.addMessage(exception.getMessage());
        }

        if (printStackTrace) {
            errorResponse.setStackTrace(getStackTrace(exception));
        }

        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

    private String getStackTrace(Exception exception) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exception.printStackTrace(printWriter);
        return stringWriter.toString();
    }

}
