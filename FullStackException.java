/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-10-05
 */

public class FullStackException extends Exception{
    /**
     * Thrown when the current stack is at capacity
     * @param message Extends Exception class, returns a string output.
     */
    public FullStackException(String message){
        super(message);
    }
}
