package teamshave.com.shavejam2015;

/**
 * Class of static methods for performing calculations
 */
public final class Calculations {

    /**
     * Calculate the tip due on a billAmount for a particular tipPercentage
     * @param billAmount The bill amount
     * @param tipPercentage The percentage tip to add
     * @return The tip due
     */
    public static double CalculateTip(double billAmount, int tipPercentage) {

        return (billAmount / 100) * tipPercentage;

    }

}
