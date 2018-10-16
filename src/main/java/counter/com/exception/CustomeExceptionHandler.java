package counter.com.exception;

import counter.com.error.ApiError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import counter.com.config.appconfig.MessageProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class CustomeExceptionHandler extends ResponseEntityExceptionHandler {
    @Autowired
    MessageProperties messageProperties;

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        pageNotFoundLogger.warn(ex.getMessage());

        Set<HttpMethod> supportedMethods = ex.getSupportedHttpMethods();
        StringBuilder stringBuilder= new StringBuilder();
       supportedMethods.forEach(method->{
           stringBuilder.append(method.name()+" ,");

   });

        List<String> list = Arrays.asList(messageProperties.getMethodNotAllowed() +" "+stringBuilder.toString());
        ApiError apiError = new ApiError(HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getLocalizedMessage(),list);

        return new ResponseEntity<Object>(apiError,HttpStatus.METHOD_NOT_ALLOWED);
    }


    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(
            MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> list = Arrays.asList(messageProperties.getCanNotBlank());
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(),messageProperties.getCanNotNull(),list);

        return new ResponseEntity<Object>(apiError,HttpStatus.METHOD_NOT_ALLOWED);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors=ex.getBindingResult().getFieldErrors();
        List<String> list= new ArrayList<String>();
        fieldErrors.forEach(fieldError -> {
            list.add(fieldError.getDefaultMessage());

        });
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(),messageProperties.getMissingPayload(),list);

        return new ResponseEntity<Object>(apiError,HttpStatus.BAD_REQUEST);

    }
   @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(
            MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
       List<String> list=Arrays.asList(ex.getLocalizedMessage());

       ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(),messageProperties.getMissingPathVariable(),list);

       return new ResponseEntity<Object>(apiError,HttpStatus.BAD_REQUEST);
    }

  @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(
            ServletRequestBindingException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

      List<String> list=Arrays.asList(ex.getLocalizedMessage());

      ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(),messageProperties.getMissingPathVariable(),list);

      return new ResponseEntity<Object>(apiError,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CounterServiceException.class)
    protected ResponseEntity<Object> customSchedulerException(
            CounterServiceException ex) {

        List<String> list=Arrays.asList(ex.getMessage());

        ApiError apiError = new ApiError(ex.getHttpStatus().value(),ex.getMessage(),list);

        return new ResponseEntity<Object>(apiError,ex.getHttpStatus());
    }

}
