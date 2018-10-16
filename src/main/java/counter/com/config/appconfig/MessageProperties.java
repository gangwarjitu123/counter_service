package counter.com.config.appconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:message.properties")
public class MessageProperties {
    @Value("canNotBlank")
    private String canNotBlank;
    @Value("${canNotNull}")
    private String canNotNull;
    @Value("${invalidValue}")
    private String invalidValue;
    @Value("${methodNotAllowed}")
    private String methodNotAllowed;
    @Value("${missingPathVariable}")
    private String missingPathVariable;

    @Value("${missingPayload}")
    private String missingPayload;

    @Value("${teamNameOrTeamVenuAlreadyReported}")
    private String alreadyReported;
    @Value("${recordNotFound}")
    private String recordNotFound;

    public String getCanNotBlank() {
        return canNotBlank;
    }

    public String getCanNotNull() {
        return canNotNull;
    }

    public String getInvalidValue() {
        return invalidValue;
    }

    public String getMethodNotAllowed() {
        return methodNotAllowed;
    }

    public String getMissingPathVariable() {
        return missingPathVariable;
    }

    public String getMissingPayload() {
        return missingPayload;
    }

    public void setMissingPayload(String missingPayload) {
        this.missingPayload = missingPayload;
    }

    public String getAlreadyReported() {
        return alreadyReported;
    }

    public String getRecordNotFound() {
        return recordNotFound;
    }
}
