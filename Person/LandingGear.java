
/**
 * This class models the Wheel Structure of the Airplane with 3 WheelSTruts (nose, left and right) with some wheels. Also, you can
 * check that everything is safe to use
 *
 * @Paula Díaz Álvarez
 * @8/11/2022
 */
public class LandingGear
{
    /**
     * It's the value representing that the lever is up
     */
    public final static boolean LEVER_UP = false;
    /**
     * It's the value representing that the lever is down
     */
    public final static boolean LEVER_DOWN = true; //all the WheelStrut must be deployed
    
    private WheelStrut nose;
    private WheelStrut left;
    private WheelStrut right;
    private boolean lever;
    
    /**
     * Default constructor to create a LandingGear that assigns the METRIC_WHEEL_SIZE to the size of the wheels of all the
     * struts (nose have 2 wheels, left 3 and right 4). It creates the 3 struts deployed and sets the lever down
     */
    public LandingGear() {
        System.out.println ("Default constructor of LandingGear invoked");
        nose= new WheelStrut('N',Wheel.METRIC_WHEEL_SIZE,2);
        left= new WheelStrut('L',Wheel.METRIC_WHEEL_SIZE,3);
        right= new WheelStrut('R',Wheel.METRIC_WHEEL_SIZE,4);
        setLever(LEVER_DOWN); //Now the nose,left and right have been created, so there won't be a null pointer exception
    }
    
    /**
     * Constructor to create a LandingGear that assigns a given size as the size of the wheels of all the struts (nose have 2
     * wheels, left 3 and right 4). It creates the 3 struts deployed and sets the lever down
     * @param size It's the size for the wheels
     */
    public LandingGear(double size) {
        System.out.println ("Constructor 2 of LandingGear invoked");
        nose= new WheelStrut('N',size,2);
        left= new WheelStrut('L',size,3);
        right= new WheelStrut('R',size,4);
        setLever(LEVER_DOWN);
    }
    
    /**
     * Constructor for objects of class LandingGear that allows to set the size of the wheels of all the struts.
     * It creates the 3 struts deployed and sets the lever down
     * @param numberOfWheels It's the number of wheels that each wheelStrut will have
     * @param size It's the size for the wheels
     */
    public LandingGear(int numberOfWheels, double size) {
        System.out.println ("Constructor 2.2 of LandingGear invoked");
        nose= new WheelStrut('N',size,numberOfWheels);
        left= new WheelStrut('L',size,numberOfWheels);
        right= new WheelStrut('R',size,numberOfWheels);
        setLever(LEVER_DOWN);
    }
    
    /**
     * Constructor for objects of class LandingGear that allows the user to set the size of the wheels of all the struts and
     * if the lever is down or up.
     * It creates the 3 struts.
     * @param size It's the size for the wheels
     * @param lever It's the value for the lever field (up or down)
     */
    public LandingGear(double size, boolean lever) {
        this(size);
        System.out.println ("Constructor 3 of LandingGear invoked");
        setLever(lever); //Now the nose,left and right have been created, so there won't be a null pointer exception
    }
    
    /**
     * Constructor for objects of class LandingGear that allows the user to set the size of the wheels of all the struts and
     * if the lever is down or up.
     * It creates the 3 struts.
     * @param numberOfWheels It's the number of wheels that each wheelStrut will have
     * @param size It's the size for the wheels
     * @param lever It's the value for the lever field (up or down)
     */
    public LandingGear(int numberOfWheels, double size, boolean lever) {
        this(numberOfWheels,size);
        System.out.println ("Constructor 3.2 of LandingGear invoked");
        setLever(lever); //Now the nose,left and right have been created, so there won't be a null pointer exception
    }

    //EXCEPTIONS
    /**
     * Throws a given error message if the given condition is not true
     * @param condition It's the condition that is going to be checked
     * @param message It's the error message that is thrown if the condition is not true
     */
    private void checkParam (boolean condition, String message) {
        if (!condition)
            throw new RuntimeException (message);
    }
    
    //setters and getters
    /**
     * Verifies that the pressure of each wheel of every strut is within the range [basePressure-Wheel.THRESHOLD; basePressure+Wheel.THRESHOLD].
     * Except for the nose strut, that they must be reviewed for basePressure+15
     * If so, the wheel pressure is correct, and remains unmodified. If don't, the pressure in the wheel will be updated to the basePressure.
     * 
     * If the basePressure is negative, the pressure won't update it and a error message will appear
     * @param basePressure It's the pressure taken to check if the pressure of the wheel is in range
     * @return The sum of the pressure of the wheel in the landing gear
     */
    public double reviewPressure(double basePressure) {
        checkParam(basePressure>=0,"NEGATIVE BASE PRESSURE");
        return nose.reviewPressure(basePressure+15) + left.reviewPressure(basePressure)+right.reviewPressure(basePressure);
    }
    
    /**
     * Sets a new given value for the lever field. If the lever is set to down, all the struts will be deployed. If it's set
     * to up, all the struts will be retracted
     * @param lever It's the new given value of the lever field
     */
    public void setLever(boolean lever){
        this.lever=lever;
        if (lever==LEVER_DOWN){
            nose.setDeployed(true);
            right.setDeployed(true);
            left.setDeployed(true);
        }
        else {
            nose.setDeployed(false);
            right.setDeployed(false);
            left.setDeployed(false);
        }
    }
    
    /**
     * Returns the value of the lever
     * @return The value of the lever
     */
    public boolean getLever(){
        return lever;
    }
    
    /**
     * Checks if the struts are deployed when the lever is down, and retracted if the lever is up.
     * @return True if the landing gear is consistent and safe (the struts have the correct position)
     */
    public boolean isConsistent(){
        if (lever ==LEVER_DOWN){
            return nose.isDeployed() && left.isDeployed() && right.isDeployed();
        }
        else {
            return !nose.isDeployed() && !left.isDeployed() && !right.isDeployed(); 
        }
    }
    
    /**
     * Checks if all the wheels of the WheelStruts are operational (checks the pressure of them).
     * @return True if all the WheelStruts are operational (the pressure of every wheel is OK)
     */
    public boolean isOperational(){
        return nose.isOperational() && right.isOperational() && left.isOperational();
    }
    
    /**
     * Activates the Hard Landing Configuration of the Airplane only if it's flying, so all strut are deployed and the pressure of the wheels is
     * set to 75% of the wheel size
     */
    public void activeHardLandingConfiguration(){
        if (lever==LEVER_UP && isConsistent()) {
            nose.activeHardLandingConfiguration();
            left.activeHardLandingConfiguration();
            right.activeHardLandingConfiguration();
        }    
    }
    
    //testing auxilary methods
    /**
     * Returns the value of all the fields of the nose strut. It's only use for testing purposes
     * @return All the values of the fields of the nose strut
     */
    protected WheelStrut getNose(){
        return nose;
    }
    /**
     * Returns the value of all the fields of the left strut. It's only use for testing purposes
     * @return All the values of the fields of the left strut
     */
    protected WheelStrut getLeft(){
        return left;
    }
    /**
     * Returns the value of all the fields of the right strut. It's only use for testing purposes
     * @return All the values of the fields of the right strut
     */
    protected WheelStrut getRight(){
        return right;
    }
    
    //Printing data
    /**
     * Returns a text with the state of the lever and if it is safe to use the airplane.
     * -Status: ON (everything is OK) | FAILURE (the landing gear is not consistent or at leastone strut isn't operational)
     * -Strut (Nose,Left,Right): ON (the strut is deployed)|OFF (the strut is retracted) | PRESS (there isn't enough pressure
     *                                                                                            on at least one wheel)
     * @return A text with the state of the airplane and where is the problem
     */    
    public String toString(){
        String result="Lever: ";
        if (lever==LEVER_DOWN)
            result+= "DOWN";
        else
            result+= "UP  ";
            
        result+=" Status: ";
        if (isConsistent() && isOperational())
            result+= "ON     ";
        else
            result+= "FAILURE";
            
        result+= " Nose: ";
        if (!nose.isOperational())
            result+="PRESS";
        else if (!nose.isDeployed())
            result+="OFF  ";
        else
            result+="ON   ";
            
        result+= " Left: ";
        if (!left.isOperational())
            result+="PRESS";
        else if (!left.isDeployed())
            result+="OFF  ";
        else
            result+="ON   ";
            
        result+= " Right: ";
        if (!right.isOperational())
            result+="PRESS";
        else if (!right.isDeployed())
            result+="OFF  ";
        else
            result+="ON   ";
        
        return result;
    }
    
    /**
     * Prints a message with the state of the lever and if it is safe to use the airplane.
     * -Status: ON (everything is OK) | FAILURE (the landing gear is not consistent or at leastone strut isn't operational)
     * -Strut (Nose,Left,Right): ON(the strut is deployed)|OFF(the strut is retracted) | PRESS (there isn't enough pressure
     *                           on at least one wheel)
     */    
    public void print(){
        System.out.println(toString());
    }
}
