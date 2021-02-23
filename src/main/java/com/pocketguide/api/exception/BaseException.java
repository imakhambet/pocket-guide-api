package com.pocketguide.api.exception;

/**
 * @author imakhambet
 */
public abstract class BaseException extends RuntimeException {
    public BaseException() {}

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }
}