package com.ahmadkamal.cms.api;

import com.ahmadkamal.cms.exception.ApplicationError;
import com.ahmadkamal.cms.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Value("${app_doc_url}")
    String details;

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError> handlerCustomerNotFoundException(CustomerNotFoundException
                                                                                     customerNotFoundException,
                                                                             WebRequest webRequest){

        ApplicationError applicationError = new ApplicationError();
        applicationError.setCode(101);
        applicationError.setDetails(details);
        applicationError.setMessage(customerNotFoundException.getMessage());
        return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
    }
}
