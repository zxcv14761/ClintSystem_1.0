package com.ya666.Service.exception;

public class UpdateClintException extends ServiceException{
    public UpdateClintException() {
        super();
    }

    public UpdateClintException(String message) {
        super(message);
    }

    public UpdateClintException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateClintException(Throwable cause) {
        super(cause);
    }

    protected UpdateClintException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
