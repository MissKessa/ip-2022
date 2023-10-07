import java.util.Random;

/**
 * This class models an airplane with an ID, fuel, altitude, position and speed, and it can fly.
 *
 * @author Paula Díaz Álvarez
 * @version 09/10/2022
 */
public class Airplane
{
    //Fuel and altitude
    /**
     * It's the minimun value for the fuel
     */
    public final static double MIN_FUEL=0.0;      //Minimun fuel to be able to fly
    /**
     * It's the minimun value for the altitude
     */
    public final static double MIN_ALTITUDE=0.0; //Minimun altitude to be able to fly
    //Limits of the map
    /**
     * It's the value of west border of the map
     */
    public final static int X_WEST_BORDER=0;
    /**
     * It's the value of east border of the map
     */
    public final static int X_EAST_BORDER=10;
    /**
     * It's the value of north border of the map
     */
    public final static int Y_NORTH_BORDER=0;
    /**
     * It's the value of south border of the map
     */
    public final static int Y_SOUTH_BORDER=10;
    //Speed
    /**
     * It's the maximum value for the x-speed
     */
    public final static int MAX_X_SPEED=1;
    /**
     * It's the minimum value for the x-speed
     */
    public final static int MIN_X_SPEED=-1;
    /**
     * It's the maximum value for the y-speed
     */
    public final static int MAX_Y_SPEED= 1;
    /**
     * It's the minimum value for the y-speed
     */
    public final static int MIN_Y_SPEED=-1;
    //Error messages
    /**
     * It's the error message thrown when the fuel is less than the MIN_FUEL
     */
    public final static String ERROR_LOWER_FUEL="The fuel must be greater than or equal to "+MIN_FUEL;
    /**
     * It's the error message thrown when the altitude is less than the MIN_ALTITUDE
     */
    public final static String ERROR_LOWER_ALTITUDE="The altitude must be greater than or equal to "+MIN_ALTITUDE;
    /**
     * It's the error message thrown when the x-pos is less than the X_WEST_BORDER
     */
    public final static String ERROR_OUT_WEST_BORDER="The x-position must be greater than or equal to "+X_WEST_BORDER;
    /**
     * It's the error message thrown when the x-pos is greater than the X_EAST_BORDER
     */
    public final static String ERROR_OUT_EAST_BORDER="The x-position must be less than or equal to "+X_EAST_BORDER;
    /**
     * It's the error message thrown when the y-pos is less than the Y_NORTH_BORDER
     */
    public final static String ERROR_OUT_NORTH_BORDER="The y-position must be greater than or equal to "+Y_NORTH_BORDER;
    /**
     * It's the error message thrown when the y-pos is greater than than the Y_SOUTH_BORDER
     */
    public final static String ERROR_OUT_SOUTH_BORDER="The y-position must be less than or equal to "+Y_SOUTH_BORDER;
    /**
     * It's the error message thrown when the x-speed is greater than the MAX_X_SPEED
     */
    public final static String ERROR_HIGHER_X_SPEED="The x-speed must be less than or equal to "+MAX_X_SPEED;
    /**
     * It's the error message thrown when the x-speed is less than the MIN_X_SPEED
     */
    public final static String ERROR_LOWER_X_SPEED="The x-speed must be greater than or equal to "+MIN_X_SPEED;
    /**
     * It's the error message thrown when the y-speed is greater than the MAX_Y_SPEED
     */
    public final static String ERROR_HIGHER_Y_SPEED="The y-speed must be less than or equal to "+ MAX_Y_SPEED;
    /**
     * It's the error message thrown when the y-speed is less than the MIN_Y_SPEED
     */
    public final static String ERROR_LOWER_Y_SPEED="The y-speed must be greater than or equal to "+ MIN_Y_SPEED;
    /**
     * It's the error message thrown when the desired column is less than the X_WEST_BORDER
     */
    public final static String ERROR_DESIRED_COLUMN_OUT_WEST_BORDER="The desired column must be greater than or equal to "+X_WEST_BORDER;
    /**
     * It's the error message thrown when the desired column is greater than the X_EAST_BORDER
     */
    public final static String ERROR_DESIRED_COLUMN_OUT_EAST_BORDER="The desired column must be less than or equal to "+X_EAST_BORDER;
    /**
     * It's the error message thrown when the user wants to go a desired column and the x-speed is 0, so the airplane can't move
     */
    public final static String ERROR_CANNOT_MOVE="It's imposible to reach the desired column because the x-speed is 0";
    /**
     * It's the error message thrown when the user wants to go a desired column and the x-speed is in the other direction
    */
    public final static String ERROR_DIFFERENT_DIRECTIONS="It's imposible to reach the desired column because the x-speed is in the other direction";
    
    //Attributes
    private char ID;         //Identificator for the airplane
    private double fuel;     //Current amount of fuel in tons
    private double altitude; //Current altitude in kilometers
    private int xPos;        //x-coordinate for the latitude [X_WEST_BORDER,X_EAST_BORDER]
    private int yPos;        //y-coordinate for the longitude [Y_NORTH_BORDER,Y_SOUTH_BORDER]
    private int xSpeed;      //x-speed for the plane [MIN_X_SPEED,MAX_X_SPEED]
    private int ySpeed;      //y-speed for the plane [MIN_Y_SPEED,MAX_Y_SPEED]
    
    //CONSTRUCTORS
    /**
     * Default constructor for an airplane with the random values as default values, except the ID that is 'X'
     * It assigns a random fuel between [MIN_FUEL,1000), a random altitude between [MIN_ALTITUDE,1000), a random x-pos between
     * [X_WEST_BORDER,X_EAST_BORDER], a random y-pos between [Y_NORTH_BORDER,Y_SOUTH_BORDER], a random x-speed between
     * [MIN_X_SPEED,MAX_X_SPEED], and a random y-pos between [MIN_Y_SPEED,MAX_Y_SPEED]
     */
    public Airplane()  {
        System.out.println ("Random constructor of Airplane invoked");
        Random coin= new Random(); 
        setID ('X');
        setFuel (coin.nextInt(1000)+MIN_FUEL+coin.nextDouble()); 
        setAltitude (coin.nextInt(1000)+MIN_ALTITUDE+coin.nextDouble());;
        setXPos(coin.nextInt(X_EAST_BORDER+1 - X_WEST_BORDER) + X_WEST_BORDER);
        setYPos(coin.nextInt(Y_SOUTH_BORDER+1 - Y_NORTH_BORDER) + Y_NORTH_BORDER);
        setXSpeed(coin.nextInt(MAX_X_SPEED+1 - MIN_X_SPEED) + MIN_X_SPEED);
        setYSpeed(coin.nextInt(MAX_Y_SPEED+1 - MIN_Y_SPEED) + MIN_Y_SPEED);
    }//For example 1000 because the fuel and the altitude doesn't have an upper limit
    
    /**
     * Constructor for an airplane that has a given ID as ID and the rest of the fields are random as the default constructor
     * @param ID It's the given value for the ID
     */
    public Airplane(char ID) {
        this();
        System.out.println ("Constructor 2 of Airplane invoked");
        setID (ID);
    }
    
    /**
     * Constructor for an airplane that allows set some given values for the ID, fuel, altitude, xPos, yPos, xSpeed and ySpeed
     * @param ID It's the given value for the ID
     * @param fuel It's the given value of the fuel
     * @param altitude It's the given value of the altitude
     * @param xPos It's the given value of the xPos
     * @param yPos It's the given value of the yPos
     * @param xSpeed It's the given value of the xSpeed
     * @param ySpeed It's the given value of the ySpeed
     */
    public Airplane(char ID,double fuel, double altitude, int xPos, int yPos,int xSpeed,int ySpeed) {
        System.out.println ("Constructor 3 of Airplane invoked");
        setID(ID);
        setFuel(fuel);
        setAltitude(altitude);
        setXPos(xPos);
        setYPos(yPos);
        setXSpeed(xSpeed);
        setYSpeed(ySpeed);
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
    
    //SETTERS AND GETTERS
    /**
     * Changes the value of the ID
     * @param ID It's the given value for the ID
     */
    public void setID(char ID) {
        this.ID=ID;    
    }
    
    /**
     * Returns the value of the ID
     * @return The value of the ID
     */
    public char getID() {
        return ID;    
    }
    
    /**
     * Changes the value of the fuel. If the new value of the fuel is less than the MIN_FUEL, an exception will appear.
     * @param fuel It's the given value of the fuel
     */
    public void setFuel(double fuel) {
        checkParam(fuel>=MIN_FUEL,ERROR_LOWER_FUEL);
        this.fuel=fuel;    
    }
    /**
     * Returns the value of the fuel
     * @return The value of the fuel
     */
    public double getFuel() {
        return fuel;    
    }
    
    /**
     * Changes the value of the altitude. If the new value of the altitude is less than the MIN_ALTITUDE, an exception will appear.
     * @param altitude It's the new value of the altitude
     */
    public void setAltitude (double altitude)  {
        checkParam(altitude>=MIN_FUEL,ERROR_LOWER_ALTITUDE);
        this.altitude=altitude;    
    }
    /**
     * Returns the value of the altitude
     * @return The value of the altitude field
     */
    public double getAltitude() {
        return altitude;    
    }

    /**
     * Changes the value of the xPos. If the new value of the xPos is less than X_WEST_BORDER or greater than X_EAST_BORDER, an
     * exception will appear depending on the error
     * @param xPos It's the new value of the xPos
     */
    public void setXPos (int xPos) {
        checkParam(xPos>=X_WEST_BORDER,ERROR_OUT_WEST_BORDER);
        checkParam(xPos<=X_EAST_BORDER,ERROR_OUT_EAST_BORDER);
        this.xPos=xPos;    
    }
    /**
     * Returns the value of the xPos
     * @return The value of the xPos
     */
    public int getXPos() {
        return xPos;    
    }
    
    /**
     * Changes the value of the yPos field. If the new value of the yPos is less than Y_NORTH_BORDER or greater than
     * Y_SOUTH_BORDER, an exception will appear depending on the error.
     * @param yPos It's the new value of the yPos
     */
    public void setYPos (int yPos)  {
        checkParam(yPos>=Y_NORTH_BORDER,ERROR_OUT_NORTH_BORDER);
        checkParam(yPos<=Y_SOUTH_BORDER,ERROR_OUT_SOUTH_BORDER);
        this.yPos=yPos;    
    }
    /**
     * Returns the value of the yPos
     * @return The value of the yPos
     */
    public int getYPos() {
        return yPos;    
    }
    
    /**
     * Changes the value of the xSpeed. If the new value of the xSpeed is greater than MAX_X_SPEED or less than 
     * MIN_X_SPEED, an exception will appear depending on the error.
     * @param xSpeed It's the new value of the xSpeed
     */
    public void setXSpeed (int xSpeed) {
        checkParam(xSpeed<=MAX_X_SPEED,ERROR_HIGHER_X_SPEED);
        checkParam(xSpeed>=MIN_X_SPEED,ERROR_LOWER_X_SPEED);
        this.xSpeed=xSpeed;    
    }
    /**
     * Returns the value of the xSpeed
     * @return The value of the xSpeed
     */
    public int getXSpeed() {
        return xSpeed;    
    }
    
    /**
     * Returns the number of turns required to move the Airplane to a desired column from its current xPos and xSpeed.
     * Trows an error message when it is imposible to go to the desired column.
     * @param desiredColumn It's the desired column that the user wants to reach. Throws an error message if the desiredCloumn is not valid
     * @return The number of turns the airplane has to do. Returns 0 if xPos==desiredColumn
     */
    public int turnsRequiredToReachColumn (int desiredColumn){
        checkParam(desiredColumn>=X_WEST_BORDER,ERROR_DESIRED_COLUMN_OUT_WEST_BORDER);
        checkParam(desiredColumn<=X_EAST_BORDER,ERROR_DESIRED_COLUMN_OUT_EAST_BORDER);
        checkParam(xSpeed!=0,ERROR_CANNOT_MOVE);
        
        int turns=(desiredColumn-xPos)/xSpeed;
        
        checkParam(turns>=0, ERROR_DIFFERENT_DIRECTIONS);
        //checkParam((desiredColumn-xPos)%xSpeed==0,"It's imposible to reach the desired column because the turns are not an integer value");
        return turns;
    }
    
    /**
     * Changes the value of the ySpeed. If the new value of the ySpeed is greater than MAX_Y_SPEED or less than MIN_Y_SPEED, an
     * error message will appear depending on the error.
     * @param ySpeed It's the new value of the ySpeed
     */
    public void setYSpeed (int ySpeed) {
        checkParam(ySpeed<=MAX_Y_SPEED,ERROR_HIGHER_Y_SPEED);
        checkParam(ySpeed>=MIN_Y_SPEED,ERROR_LOWER_Y_SPEED);
        this.ySpeed=ySpeed;    
    }
    /**
     * Returns the value of the ySpeed
     * @return The value of the ySpeed 
     */
    public int getYSpeed() {
        return ySpeed;    
    }
    
    //PRINTING DATA
    /**
     * Prints all the values of the airplane into the computer's console: ID, fuel, altitude, position and speed
     */
    public void print() {
        System.out.println("ID: "+ ID);
        System.out.println("Fuel: "+ fuel);
        System.out.println("Altitude: "+ altitude);
        System.out.println("X-position: "+ xPos);
        System.out.println("Y-position: "+ yPos);
        System.out.println("X-speed: "+ xSpeed);
        System.out.println("Y-speed: "+ ySpeed);
    }
    
    /**
     * Returns a text containing all the values of the airplane: ID, fuel, altitude, position and speed.
     * @return A text corresponding to all the values of the airplane
     */
    public String toString() {
        String result="";
        result+="ID: "+ ID;
        result+=" - Fuel: "+ fuel;
        result+=" - Altitude: "+ altitude;
        result+=" - Pos["+ xPos +","+ yPos + "]";
        result+=" - Speed["+ xSpeed +","+ ySpeed + "]";
        return result;
    }
    
    /**
     * Creates a text looking like a code, containing all the values of the airplane: ID, fuel, altitude, position and speed.
     * @return A text with a code representing the values of the airplane
     */
    public String getHashCode() {
        String result="";
        result+= ID;
        result+=" - "+ fuel;
        result+=" - "+ altitude;
        result+=" - "+ "["+ xPos +","+ yPos + "]";
        result+=" - "+ "["+ xSpeed +","+ ySpeed + "]";
        return result;
    }
    
    /**
     * The airplane flies to a new x-coordinate and new y-coordinate depending on the the x-speed and the y-speed
     * -If either the x or y coordinate is in the border of the gameboard, the coordinate will not updated
     * @return True if there is enough fuel and the position is updated, it reduces its amount in 1.0 unit.
     */
    public boolean fly() {
        if (fuel>=1){
            if (!(xSpeed<0 &&(xPos+xSpeed<X_WEST_BORDER) || xSpeed>0 &&(xPos+xSpeed>X_EAST_BORDER))){
                setXPos(xPos+xSpeed);
            }
            if (!(ySpeed<0 &&(yPos+ySpeed<Y_NORTH_BORDER) || ySpeed>0 &&(yPos+ySpeed>Y_SOUTH_BORDER))){
                setYPos(yPos+ySpeed);
            }
            setFuel(fuel-1.0);
            return true;            
        }
        return false;
    }
    /*
     * if fuel>=1
     *  try
     *      setFuel(
     *      setXpos
     *      setyPos
     *  catch (exception e) //Ignoring the exception
     *  ;
     */
}
