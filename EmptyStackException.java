/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-10-05
 */

public class EmptyStackException extends  Exception{
    /**
     * Thrown when the current stack is empty
     * @param message Extends Exception class, returns a string output.
     */
    public EmptyStackException(String message){
        super(message);
    }
}
