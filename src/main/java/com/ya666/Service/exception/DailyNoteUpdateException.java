package com.ya666.Service.exception;

public class DailyNoteUpdateException extends ServiceException{
    public DailyNoteUpdateException() {
        super();
    }

    public DailyNoteUpdateException(String message) {
        super(message);
    }

    public DailyNoteUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DailyNoteUpdateException(Throwable cause) {
        super(cause);
    }

    protected DailyNoteUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
