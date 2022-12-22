package com.artemis.exceptions;

public class KeeperException extends RuntimeException {
    public KeeperException(String exception)
    { super(exception); }
}
