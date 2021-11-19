/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-10-05
 */

/**
 * Write a fully-documented class named Package which represents the mail
 * packages that are being delivered and picked up from the mailroom.
 *
 * The arrival date will start at day 0 (see sample IO).
 */
public class Package {
    private String recipient;
    private int arrivalDate = 0;
    private double weight;

    /**
     * Default constructor of the Package class
     * Postconditions: This object has been initialized to a package object
     * with specified recipient, arrival date and weight.
     * @param recipient the name of whom the package is for
     * @param arrivalDate the current day when added
     * @param weight the weight of the object
     */
    public Package(String recipient, int arrivalDate, double weight){
        this.recipient = recipient;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
    }

    /**
     * @return the name of the recipient
     */
    public String getRecipient(){
        return recipient;
    }

    /**
     * @param recipient is the new name of the recipient
     */
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    /**
     * @return the arrival date of the package
     */
    public int getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param arrivalDate sets the new arrival day of the object
     */
    public void setArrivalDate(int arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * @return the weight of the object
     */
    public double getWeight() {
        return weight;
    }

    /**
     * @param weight is the new weight of the object
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * @return the stack that the package should theoretically be at
     */
    public int correctStack(){
        String name = recipient.toUpperCase();
        int out = -1;
        switch (name.charAt(0)) {
            case 'A', 'B', 'C', 'D', 'E', 'F', 'G' -> {
                out = 0;
            }
            case 'H', 'I', 'J' -> {
                out = 1;
            }
            case 'K', 'L', 'M' -> {
                out = 2;
            }
            case 'N', 'O', 'P', 'Q', 'R' -> {
                out = 3;
            }
            case 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' -> {
                out = 4;
            }
        }
        return out;
    }

    /**
     *
     * @return the toString for the package object
     */
    public String toString(){
        return "[" + recipient + " " + arrivalDate + "]";
    }
}
