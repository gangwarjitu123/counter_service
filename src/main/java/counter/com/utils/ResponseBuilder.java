package counter.com.utils;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import counter.com.response.Response;

@Component
public class ResponseBuilder {
    public static Response build(Object data){
        Response response = new Response();
        response.setData(data);
        response.setHttpStatus(HttpStatus.OK.value());
        response.setMessage("request process successfully");
        return response;

    }
}
