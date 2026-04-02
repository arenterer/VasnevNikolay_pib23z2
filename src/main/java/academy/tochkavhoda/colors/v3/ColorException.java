package academy.tochkavhoda.colors.v3;

public class ColorException extends Exception {
    private final ColorErrorCode errorCode;

    public ColorException(ColorErrorCode errorCode) {
        super(errorCode == null ? null : errorCode.getErrorString());
        this.errorCode = errorCode;
    }

    public ColorErrorCode getErrorCode() {
        return errorCode;
    }
}

