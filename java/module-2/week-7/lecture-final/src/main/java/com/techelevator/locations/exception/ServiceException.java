package com.techelevator.locations.exception;

/*
    1. You can use this exception as general service exception.
    2. You can create multiple specific exceptions as needed, each extending the general service exception.
    3. In your controller you can catch the general service exception and handle
       it in a way that provides meaningful and relevant responses to requesting clients.
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Exception cause) {
        super(message, cause);
    }

}

