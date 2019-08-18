package online.zxff.arsenal.retrieval.exception;

/**
 * Created by cloudgo on 2019/8/17 15:53.
 */
public class RetrievalConfigParseException extends RuntimeException {

    public RetrievalConfigParseException() {
        super();
    }

    public RetrievalConfigParseException(String message) {
        super(message);
    }

    public RetrievalConfigParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
