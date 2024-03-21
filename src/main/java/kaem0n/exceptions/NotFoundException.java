package kaem0n.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("Error: event id " + id + " not found.");
    }
}
