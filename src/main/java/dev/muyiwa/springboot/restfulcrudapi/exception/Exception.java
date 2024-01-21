package dev.muyiwa.springboot.restfulcrudapi.exception;

public class Exception {
    private String status = "failure";
    private Object error;
    private String message;

    public Exception (String message, Object error) {
        super();
        this.message = message;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getError() {
        return error;
    }
}
