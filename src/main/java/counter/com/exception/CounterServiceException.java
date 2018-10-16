package counter.com.exception;

import org.springframework.http.HttpStatus;

public class CounterServiceException extends  RuntimeException {
    private HttpStatus httpStatus;
    private String message;

    public CounterServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }



    public String getMessage() {
        return message;
    }
}
