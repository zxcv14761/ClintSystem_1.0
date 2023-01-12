package com.ya666.Service.exception;

public class DailyNoteInsertException extends ServiceException{
    public DailyNoteInsertException() {
        super();
    }

    public DailyNoteInsertException(String message) {
        super(message);
    }

    public DailyNoteInsertException(String message, Throwable cause) {
        super(message, cause);
    }

    public DailyNoteInsertException(Throwable cause) {
        super(cause);
    }

    protected DailyNoteInsertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
