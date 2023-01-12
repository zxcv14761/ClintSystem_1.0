package com.ya666.Service.exception;

public class ClintDuplicateException extends ServiceException{
    public ClintDuplicateException() {
        super();
    }

    public ClintDuplicateException(String message) {
        super(message);
    }

    public ClintDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClintDuplicateException(Throwable cause) {
        super(cause);
    }

    protected ClintDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
