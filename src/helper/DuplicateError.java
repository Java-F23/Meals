package helper;

public class DuplicateError extends Exception{
    public DuplicateError(String item) {
        super(item + " already exists");
    }
}
