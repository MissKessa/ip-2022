import java.util.*; //or import java.util.ArrayList;
/**
 * This class models the Wheel Structure of the Airplane with a given number of wheels. also, checks if it's safe to use
 *
 * @Paula Díaz Álvarez
 * @25/10/2022
 */
public class WheelStrut
{
    //Error messages
    /**
     * It's the error message thrown when the user tries to introduce a negative number of wheels
     */
    public final static String ERROR_NEGATIVE_WHEELS="The number of wheels can not be negative";
    //Attributes
    private char ID;
    private ArrayList<Wheel> wheels;
    private boolean deployed;
    
    /**
     * Default constructor to create a wheel struct with 'X' as ID, a given number of full inflated wheels with a size equal 
     * to METRIC_WHEEL_SIZE and the strut is deployed.
     * If the number of wheel is negative, an error message is thrown.
     * @param numberOfWheels It's the number of wheels that will be created
     */
    public WheelStrut(int numberOfWheels){
        System.out.println ("Default constructor of WheelStrut invoked");
        setID('X');
        setDeployed(true);
        checkParam(numberOfWheels>=0,ERROR_NEGATIVE_WHEELS);
        wheels = new ArrayList<Wheel>(numberOfWheels);
        for (int i=0 ; i<numberOfWheels ; i++){
            wheels.add(new Wheel(Wheel.METRIC_WHEEL_SIZE,Wheel.METRIC_WHEEL_SIZE));
        }
    }
    
    /**
     * Constructor to create a wheel struct with a given ID, a given number of full inflated wheels with a given size and 
     * the strut is deployed.
     * If the number of wheel is negative, an error message is thrown.
     * 
     * @param ID It's the given value of the ID for the WheelStrut
     * @param size It's the given value of the size for the wheels
     * @param numberOfWheels It's the given number of wheels created
     */
    public WheelStrut(char ID, double size,int numberOfWheels){
        System.out.println ("Constructor 2 of WheelStrut invoked");
        setID(ID);
        setDeployed(true);
        //building the collection
        checkParam(numberOfWheels>=0,ERROR_NEGATIVE_WHEELS);
        wheels = new ArrayList<Wheel>(numberOfWheels);
        //fill the collection with wheels
        for (int i=0 ; i<numberOfWheels ; i++){
            wheels.add(new Wheel(size,size));
        }
    }
    
    /**
     * Constructor to create a wheel struct with a given ID,a given number of full inflated wheels with a given size and 
     * set if it's deployed or not.
     * If the number of wheel is negative, an error message is thrown.
     * 
     * @param ID It's the given value of the ID for the WheelStrut
     * @param size It's the given value of the size for the wheels
     * @param numberOfWheels It's the given number of wheels created
     * @param deployed It's sets the struct deployed (given value is true) or not (if the given value is false)
     */
    public WheelStrut(char ID, double size,int numberOfWheels, boolean deployed){
        this(ID,size,numberOfWheels);
        System.out.println ("Constructor 3 of WheelStrut invoked");
        setDeployed(deployed);
    }
    
    //EXCEPTIONS
    /**
     * Throws a given error message if the givencondition is not true
     * @param condition It's the given condition that is going to be checked
     * @param message It's the given error message thath will be thrown if the condition is not true
     */
    private void checkParam (boolean condition, String message)
    {
        if (!condition)
            throw new RuntimeException (message);
    }
    
    //setters and getters
    /**
     * Verifies that the pressure of each wheel of the strut is within the range [basePressure-Wheel.THRESHOLD; basePressure+Wheel.THRESHOLD].
     * If so, the wheel pressure is correct, and remains unmodified. If don't, the pressure in the wheel will be updated to the basePressure.
     * 
     * If the basePressure is negative, the pressure won't update it and a error message will appear
     * @param basePressure It's the pressure taken to check if the pressure of the wheel is in that range
     * @return The sum of the pressures of the wheels in the WheelStrut
     */
    public double reviewPressure(double basePressure) {
        checkParam(basePressure>=0,"NEGATIVE BASE PRESSURE");
        int result=0;       
        for (Wheel item : wheels) {
            result+=item.reviewPressure(basePressure);
        }
        return result;
    }
    
    /**
     * Changes the value of the ID of the struct
     * @param ID It's the new value for the ID
     */
    public void setID(char ID){
        this.ID=ID;
    }
    /**
     * Returns the value of the ID
     * @return The ID of the struct
     */
    public char getID(){
        return ID;
    }
    
    /**
     * Changes if the struc is deployed or not
     * @param deployed It's the new value of the deployed field
     */
    public void setDeployed(boolean deployed){
        this.deployed=deployed;
    }
    /**
     * Returns if the struct is deployed or not
     * @return If the struct is deployed or not
     */
    public boolean isDeployed(){
        return deployed;
    }
    
    /**
     * Returns if it is safe to use the WheelStrut
     * @return True if it's safe (all the wheels are operational)
     */
    public boolean isOperational(){
        for (Wheel item : wheels) {
            if (!item.isOperational()){
                return false; //Stops if it finds a wheel that is not operational
            }
        }
        return true;
    }
    
    /**
     * Activates the Hard Landing Configuration of the strut only if it's flying, so the strut is deployed and the pressure of
     * the wheels is set to 75% of the wheel size.
     */
    public void activeHardLandingConfiguration(){
        setDeployed(true);
        for (int i=0 ; i< wheels.size() ; i++) {
            wheels.get(i).activeHardLandingConfiguration();
        }
    }
    
    //protected method: Only for testing purposes to change call methods for the wheels. The user can't use this methods
    /**
     * Returns the value of all the fields of a wheel. It's only use for testing purposes
     * @param pos It's the position of the wheel we want to checked
     * @return The wheel that we wanted
     */
    protected Wheel getWheel(int pos){ //the first pos is 0
        checkParam(pos>=0, "The position can not be negative");
        checkParam(pos<wheels.size(), "The position can not be higher than "+wheels.size());
        return wheels.get(pos);
    }
    
    //Printing data
    /**
     * Returns a text with all the values of the ID, if it's deployed, if it's operational the strut and if each wheel
     * is operational.
     * @return A text with all the values of the fields of the WheelStrut and if it's safe
     */    
    public String toString(){
        String result="ID: "+ ID;
        result+= " - Deployed: " + isDeployed();
        result+= " - Op: "+ isOperational();
        for (int i=0 ; i< wheels.size() ; i++) {
            result+= " ["+i+": "+ wheels.get(i).isOperational()+"]";
        }
        return result;
    }
    
    /**
     * Prints a text with all the values of the ID, if it's deployed, if it's operational the strut and if each wheel
     * is operational. It also prints all the values of the fields of each wheel
     */  
    public void print(){
        System.out.println(toString());
        for (int i=0 ; i< wheels.size() ; i++) {
            System.out.println(i+": "+ wheels.get(i).toString());
        }
    }
}
