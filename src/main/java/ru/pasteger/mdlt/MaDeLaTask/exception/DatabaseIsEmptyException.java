package ru.pasteger.mdlt.MaDeLaTask.exception;

public class DatabaseIsEmptyException extends Throwable {
    public DatabaseIsEmptyException(String message) {
        super(message);
    }
}
