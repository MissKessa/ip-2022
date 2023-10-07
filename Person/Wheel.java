
/**
 * This class models a Wheel of the Airplane with the required size and pressure. Also checks thta the Wheel is ready to use and 
 *
 * @Paula Díaz Álvarez
 * @25/10/2022
 */
public class Wheel
{
    //Sample wheel size
    /**
     * It's a sample wheel size with a value equal to the size of the wheel for a B737
     */
    public final static double B737_WHEEL_SIZE=20.7;
    /**
     * It's a sample wheel size with a value equal to the metric size
     */
    public final static double METRIC_WHEEL_SIZE=100;
    //Constants
    /**
     * It's the minimum size that a wheel can have
     */
    public final static double MIN_SIZE=0;
    /**
     * It's the minimum safety threshold that a wheel must have to be safe to use
     */
    public final static double SAFETY_THRESHOLD=0.8; //min safety ratio
    /**
     * It's the value around is going to be checked the pressure of the wheel
     */
    public final static double THRESHOLD=25; //in bars
    //Error messages
    /**
     * It's the error message thrown when the size is less than the MIN_SIZE
     */
    public final static String ERROR_LOWER_SIZE="The size must be higher or equal to "+MIN_SIZE;
    /**
     * It's the error message thrown when the pressure is less than the MIN_SIZE
     */
    public final static String ERROR_LOWER_PRESSURE="The pressure must be higher or equal to "+MIN_SIZE;
    /**
     * It's the error message thrown when the pressure is higher than the size
     */
    public final static String ERROR_HIGHER_PRESSURE="The pressure must be less or equal to "; //We add the size in the method
    
    //Attributes
    private double size; //in bars, its the (max) size of the wheel
    private double pressure; //in bars
    
    /**
     * Default constructor to create a wheel with a size equal to the METRIC_WHEEL_SIZE and the wheel
     * is full inflated it
     */
    public Wheel()
    {
        System.out.println ("Default constructor of Wheel invoked");
        size=METRIC_WHEEL_SIZE;
        setPressure(METRIC_WHEEL_SIZE);
    }
    /**
     * Constructor to create a wheel with a given size and it's not inflated it
     * @param size It's the given size that the wheel will have.
     */
    public Wheel(double size)
    {
        System.out.println ("Constructor 2 of Wheel invoked");
        checkParam(size>=MIN_SIZE, ERROR_LOWER_SIZE); 
        this.size=size; //or we can create a private setter
    }
    /**
     * Constructor to create a wheel with a given size and a given pressure
     * @param size It's the given size that the wheel will have.
     * @param pressure It's the given pressure that the wheel will have.
     */
    public Wheel (double size, double pressure)
    {
        this(size);
        System.out.println ("Constructor 3 of Wheel invoked");
        this.pressure=pressure;
    }

    //EXCEPTIONS
    /**
     * Throws a given error message if the given condition is not true
     * @param condition It's the given condition that is going to be checked
     * @param message It's the given error message that will be thrown if the condition is not true
     */
    private void checkParam (boolean condition, String message)
    {
        if (!condition)
            throw new RuntimeException (message);
    }
    
    //SETTERS AND GETTERS
    
    /**
     * Verifies that the pressure of the wheel is within the range [basePressure-Wheel.THRESHOLD; basePressure+Wheel.THRESHOLD].
     * If so, the wheel pressure is correct, and remains unmodified. If don't, the pressure in the wheel will be updated to the basePressure.
     * 
     * If the basePressure is negative, the pressure won't update it and a error message will appear
     * @param basePressure It's the pressure taken to check if the pressure of the wheel is in that range
     * @return The final pressure of the wheel (it is was correct it remains the same, if not it will be the basePressure)
     */
    public double reviewPressure (double basePressure) {
        checkParam (basePressure>=0,"NEGATIVE BASE PRESSURE");
        if (pressure>=(basePressure-THRESHOLD) && pressure<=(basePressure+THRESHOLD)){
            return pressure;
        }
        else {
            setPressure(basePressure);
            return pressure;
        }
    }
    
    
    /**
     * Returns the value of the size of the wheel
     * @return The value of the size of the wheel
     */
    public double getSize(){
        return size;
    }
    
    /**
     * Changes the value of the pressure of the wheel
     * @param pressure It's the pressure that is going to be set to the wheel
     */
    public void setPressure(double pressure){
        checkParam(pressure>=MIN_SIZE,ERROR_LOWER_PRESSURE);
        checkParam(pressure<=size,ERROR_HIGHER_PRESSURE+size);
        this.pressure=pressure;
    }
    /**
     * Returns the value of the pressure of the wheel
     * @return The value of the pressure of the wheel
     */
    public double getPressure(){
        return pressure;
    }
    
    /**
     * Returns the safety ratio of the wheel
     * @return The value of the safety ratio of the wheel.
     */
    private double getSafetyRatio(){
        return pressure/size;
    }
    /**
     * Returns if it is safe to use the wheel (the safety ratio of the wheel is higher or equal than the SAFETY_THRESHOLD)
     * @return True if it's safe.
     */
    public boolean isOperational(){
        return getSafetyRatio()>=SAFETY_THRESHOLD;
    }
    
    /**
     * Activates the Hard Landing Configuration of the wheel, so the pressure is set to 75% of the wheel size
     */
    public void activeHardLandingConfiguration(){
        setPressure(0.75*size);
    }
    
    //PRINTING DATA
    /**
     * Returns a text with all the values of the size, pressure, the safety ratio and if it's operational
     * @return A text containing all the values of the fields of that wheel
     */
    public String toString(){
        String aux="Size: ";
        aux+=String.format("%.2f",size)+ " bars";
        aux+= " - Pressure: " +String.format("%.2f",pressure)+ " bars";
        aux+= " - Ratio: " +String.format("%.2f",getSafetyRatio());
        aux+= " - Op: "+ isOperational(); 
        return aux;
    }
    
    /**
     * Prints a text with all the values of the size, pressure, the safety ratio and if it's operational
     */
    public void print(){
        System.out.println(toString());
    }
    
}
