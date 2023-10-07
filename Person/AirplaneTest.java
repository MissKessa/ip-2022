

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class AirplaneTest.
 *
 * @author Paula Díaz Álvarez
 * @version 09/10/2022
 */
public class AirplaneTest
{
    /**
     * Default constructor for test class AirplaneTest
     */
    public AirplaneTest() {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp() {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown() {
    }
    
    //CONSTRUCTORS
    /**
     * Test for the constructor: Airplane()
     */
    @Test
    public void constructor1Basic() {
        Airplane dummy = new Airplane();
        assertEquals(dummy.getID(),'X');
        //assertEquals(dummy.getFuel(),Airplane.MIN_FUEL,0.1);
        //assertEquals(dummy.getAltitude(),Airplane.MIN_ALTITUDE,0.1);
        //assertEquals(dummy.getXPos(),Airplane.X_WEST_BORDER);
        //assertEquals(dummy.getYPos(),Airplane.Y_NORTH_BORDER);
        //assertEquals(dummy.getXSpeed(),(Airplane.MAX_X_SPEED+Airplane.MIN_X_SPEED)/2);
        //assertEquals(dummy.getYSpeed(),(Airplane.MAX_Y_SPEED+Airplane.MIN_Y_SPEED)/2);
    }
    
    /**
     * Test for the constructor: Airplane(char ID)
     */
    @Test
    public void constructor2Basic() {
        Airplane dummy = new Airplane('z');
        assertEquals(dummy.getID(),'z');
        //assertEquals(dummy.getFuel(),Airplane.MIN_FUEL,0.1);
        //assertEquals(dummy.getAltitude(),Airplane.MIN_ALTITUDE,0.1);
        //assertEquals(dummy.getXPos(),Airplane.X_WEST_BORDER);
        //assertEquals(dummy.getYPos(),Airplane.Y_NORTH_BORDER);
        //assertEquals(dummy.getXSpeed(),(Airplane.MAX_X_SPEED+Airplane.MIN_X_SPEED)/2);
        //assertEquals(dummy.getYSpeed(),(Airplane.MAX_Y_SPEED+Airplane.MIN_Y_SPEED)/2);
        Airplane dummy2 = new Airplane('A');
        assertEquals(dummy2.getID(),'A');
    }
    
    /**
     * Test for the constructor: Airplane(char ID, double fuel, double altitude, int xPos, int yPos, int xSpeed, int ySpeed)
     */
    @Test
    public void constructor3Basic() {
        Airplane dummy = new Airplane('a',Airplane.MIN_FUEL,Airplane.MIN_ALTITUDE,Airplane.X_WEST_BORDER,
        Airplane.Y_NORTH_BORDER,Airplane.MIN_X_SPEED,Airplane.MAX_Y_SPEED);
        
        assertEquals(dummy.getID(),'a');
        assertEquals(dummy.getFuel(),Airplane.MIN_FUEL,0.01);
        assertEquals(dummy.getAltitude(),Airplane.MIN_ALTITUDE,0.01);
        assertEquals(dummy.getXPos(),Airplane.X_WEST_BORDER);
        assertEquals(dummy.getYPos(),Airplane.Y_NORTH_BORDER);
        assertEquals(dummy.getXSpeed(),Airplane.MIN_X_SPEED);
        assertEquals(dummy.getYSpeed(),Airplane.MAX_Y_SPEED);
        
        Airplane dummy2 = new Airplane('Z',Airplane.MIN_FUEL+100,Airplane.MIN_ALTITUDE+100,Airplane.X_EAST_BORDER,
        Airplane.Y_SOUTH_BORDER,Airplane.MAX_X_SPEED,Airplane.MIN_Y_SPEED);
        
        assertEquals(dummy2.getID(),'Z');
        assertEquals(dummy2.getFuel(),Airplane.MIN_FUEL+100,0.01);
        assertEquals(dummy2.getAltitude(),Airplane.MIN_ALTITUDE+100,0.01);
        assertEquals(dummy2.getXPos(),Airplane.X_EAST_BORDER);
        assertEquals(dummy2.getYPos(),Airplane.Y_SOUTH_BORDER);
        assertEquals(dummy2.getXSpeed(),Airplane.MAX_X_SPEED);
        assertEquals(dummy2.getYSpeed(),Airplane.MIN_Y_SPEED);
    }
    
    //SETTERS AND GETTERS
    /**
     * Test for the method: setID(char ID)
     */
    @Test
    public void IDBasic() {
        Airplane dummy = new Airplane ();
        dummy.setID('a');
        assertEquals(dummy.getID(),'a');
        
        dummy.setID('b');
        assertEquals(dummy.getID(),'b');
    }
    
    /**
     * Test for the method: setFuel(double fuel)
     */
    @Test
    public void fuelBasic() {
        Airplane dummy = new Airplane ();
        dummy.setFuel(Airplane.MIN_FUEL); //fuel=0.0
        assertEquals (dummy.getFuel(),Airplane.MIN_FUEL,0.1);
        
        dummy.setFuel(Airplane.MIN_FUEL + 50000.65); //fuel=big number
        assertEquals (dummy.getFuel(),Airplane.MIN_FUEL + 50000.65,0.01);
        
        dummy.setFuel(Airplane.MIN_FUEL); //fuel=0.0
        //Negative Tests
        try { //fuel=-1.0
            dummy.setFuel(Airplane.MIN_FUEL - 1);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getFuel(),Airplane.MIN_FUEL,0.1);
            assertEquals (e.getMessage(), Airplane.ERROR_LOWER_FUEL);
        }
        
        try { //fuel=-1*big number
            dummy.setFuel(Airplane.MIN_FUEL- 50000.65);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getFuel(),Airplane.MIN_FUEL,0.1);
            assertEquals (e.getMessage(), Airplane.ERROR_LOWER_FUEL);
        }
    }
    
    /**
     * Test for the method: setAltitude (double altitude)
     */
    @Test
    public void altitudeBasic() {
        Airplane dummy = new Airplane ();
        dummy.setAltitude(Airplane.MIN_ALTITUDE); //altitude=0.0
        assertEquals (dummy.getAltitude(),Airplane.MIN_ALTITUDE,0.1);
        
        dummy.setAltitude(Airplane.MIN_ALTITUDE + 50000.65); //altitude=big number
        assertEquals (dummy.getAltitude(),Airplane.MIN_ALTITUDE + 50000.65,0.01);
        
        dummy.setAltitude(Airplane.MIN_ALTITUDE); //altitude=0.0
        
        //Negative Tests
        try { //altitude=-1.0
            dummy.setAltitude(Airplane.MIN_ALTITUDE - 1);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getAltitude(),Airplane.MIN_ALTITUDE,0.1);
            assertEquals (e.getMessage(), Airplane.ERROR_LOWER_ALTITUDE);
        }
        
        try { //altitude=-1*big number
            dummy.setAltitude(Airplane.MIN_ALTITUDE- 50000.65);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getAltitude(),Airplane.MIN_ALTITUDE,0.1);
            assertEquals (e.getMessage(), Airplane.ERROR_LOWER_ALTITUDE);
        }
    }
    
    /**
     * Test for the method: setXPos (int xPos)
     */
    @Test
    public void xPosBasic() {
        Airplane dummy = new Airplane();
        dummy.setXPos(Airplane.X_WEST_BORDER); //xPos=0
        assertEquals (dummy.getXPos(),Airplane.X_WEST_BORDER);
        
        dummy.setXPos(Airplane.X_EAST_BORDER); //xPos=10
        assertEquals (dummy.getXPos(),Airplane.X_EAST_BORDER);
        
        dummy.setXPos((Airplane.X_EAST_BORDER+Airplane.X_WEST_BORDER)/2); //xPos=Intermediate value: 5
        assertEquals (dummy.getXPos(),(Airplane.X_EAST_BORDER+Airplane.X_WEST_BORDER)/2);
        
        //Negative tests
        dummy.setXPos(Airplane.X_WEST_BORDER); //xPos=0
        try { //xPos=-1
            dummy.setXPos(Airplane.X_WEST_BORDER - 1);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getXPos(),Airplane.X_WEST_BORDER);
            assertEquals (e.getMessage(), Airplane.ERROR_OUT_WEST_BORDER);
        }
        try { //xPos=-10
            dummy.setXPos(-Airplane.X_EAST_BORDER);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getXPos(),Airplane.X_WEST_BORDER);
            assertEquals (e.getMessage(), Airplane.ERROR_OUT_WEST_BORDER);
        }
        try { //xPos=11
            dummy.setXPos(Airplane.X_EAST_BORDER + 1);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getXPos(),Airplane.X_WEST_BORDER);
            assertEquals (e.getMessage(), Airplane.ERROR_OUT_EAST_BORDER);
        }
        try { //xPos=20
            dummy.setXPos(2*Airplane.X_EAST_BORDER); 
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getXPos(),Airplane.X_WEST_BORDER);
            assertEquals (e.getMessage(), Airplane.ERROR_OUT_EAST_BORDER);
        }
    }
    
    /**
     * Test for the method: setYPos (int yPos)
     */
    @Test
    public void yPosBasic() {
        Airplane dummy = new Airplane();
        dummy.setYPos(Airplane.Y_NORTH_BORDER); //yPos=0
        assertEquals (dummy.getYPos(),Airplane.Y_NORTH_BORDER);
        
        dummy.setYPos(Airplane.Y_SOUTH_BORDER); //yPos=10
        assertEquals (dummy.getYPos(),Airplane.Y_SOUTH_BORDER);
        
        dummy.setYPos((Airplane.Y_SOUTH_BORDER + Airplane.Y_NORTH_BORDER)/2); //yPos=Intermediate value: 5
        assertEquals (dummy.getYPos(),(Airplane.Y_SOUTH_BORDER + Airplane.Y_NORTH_BORDER)/2);
        
        //Negative tests
        dummy.setYPos(Airplane.Y_NORTH_BORDER);
        try { //yPos=-1
            dummy.setYPos(Airplane.Y_NORTH_BORDER - 1);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getYPos(),Airplane.Y_NORTH_BORDER);
            assertEquals (e.getMessage(), Airplane.ERROR_OUT_NORTH_BORDER);
        }
        try { //yPos=-10
            dummy.setYPos(-Airplane.Y_SOUTH_BORDER);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getYPos(),Airplane.Y_NORTH_BORDER);
            assertEquals (e.getMessage(), Airplane.ERROR_OUT_NORTH_BORDER);
        }
        try { //yPos=11
            dummy.setYPos(Airplane.Y_SOUTH_BORDER + 1);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getYPos(),Airplane.Y_NORTH_BORDER);
            assertEquals (e.getMessage(), Airplane.ERROR_OUT_SOUTH_BORDER);
        }
        try { //yPos=20
            dummy.setYPos(2*Airplane.Y_SOUTH_BORDER);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getYPos(),Airplane.Y_NORTH_BORDER);
            assertEquals (e.getMessage(), Airplane.ERROR_OUT_SOUTH_BORDER);
        }
    }
    
    /**
     * Test for the method: setXSpeed (int xSpeed)
     */
    @Test
    public void xSpeedBasic() {
        Airplane dummy = new Airplane();
        dummy.setXSpeed(Airplane.MAX_X_SPEED); //xSpeed=1
        assertEquals(dummy.getXSpeed(),Airplane.MAX_X_SPEED);
        
        dummy.setXSpeed(Airplane.MIN_X_SPEED); //xSpeed=-1
        assertEquals(dummy.getXSpeed(),Airplane.MIN_X_SPEED);

        dummy.setXSpeed((Airplane.MIN_X_SPEED+Airplane.MAX_X_SPEED)/2); //xSpeed=0
        assertEquals(dummy.getXSpeed(),(Airplane.MIN_X_SPEED+Airplane.MAX_X_SPEED)/2);

        //Negative test
        dummy.setXSpeed(Airplane.MAX_X_SPEED);
        try { //xSpeed=-2
            dummy.setXSpeed(Airplane.MIN_X_SPEED - 1);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getXSpeed(),Airplane.MAX_X_SPEED);
            assertEquals (e.getMessage(), Airplane.ERROR_LOWER_X_SPEED);
        }
        try { //xSpeed=-10
            dummy.setXSpeed(Airplane.MIN_X_SPEED*10);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getXSpeed(),Airplane.MAX_X_SPEED);
            assertEquals (e.getMessage(), Airplane.ERROR_LOWER_X_SPEED);
        }
        try { //xSpeed=2
            dummy.setXSpeed(Airplane.MAX_X_SPEED +1);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getXSpeed(),Airplane.MAX_X_SPEED);
            assertEquals (e.getMessage(), Airplane.ERROR_HIGHER_X_SPEED);
        }
        try { //xSpeed=10
            dummy.setXSpeed(Airplane.MAX_X_SPEED*10);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getXSpeed(),Airplane.MAX_X_SPEED);
            assertEquals (e.getMessage(), Airplane.ERROR_HIGHER_X_SPEED);
        }
    }
    
    /**
     * Test for the method: turnsRequiredToReachColumn (int desiredColumn)
     */
    @Test
    public void turnsRequiredToReachColumnbasic(){
        Airplane dummy = new Airplane();
        dummy.setXPos(Airplane.X_WEST_BORDER); //I am in 0
        dummy.setXSpeed(Airplane.MAX_X_SPEED/Airplane.MAX_X_SPEED);//xSpeed=1
        assertEquals(dummy.turnsRequiredToReachColumn((Airplane.X_WEST_BORDER+Airplane.X_EAST_BORDER)/2), //move to 5
        (Airplane.X_WEST_BORDER+Airplane.X_EAST_BORDER)/2); //turns=5
        
        dummy.setXPos(Airplane.X_EAST_BORDER); //I am in 10
        dummy.setXSpeed(-(Airplane.MAX_X_SPEED/Airplane.MAX_X_SPEED));//xSpeed=-1
        assertEquals(dummy.turnsRequiredToReachColumn((Airplane.X_WEST_BORDER+Airplane.X_EAST_BORDER)/2),  //move to 5
        (Airplane.X_WEST_BORDER+Airplane.X_EAST_BORDER)/2); //turns=5
        
        dummy.setXPos(Airplane.X_WEST_BORDER); //I am in 0
        //Wrong parameter
        try {
           dummy.turnsRequiredToReachColumn(Airplane.X_WEST_BORDER-1); //move to -1
           fail();
        }
        catch(Exception e){
            assertEquals(dummy.getXPos(), Airplane.X_WEST_BORDER);
            assertEquals(e.getMessage(), Airplane.ERROR_DESIRED_COLUMN_OUT_WEST_BORDER);
        }
        try {
           dummy.turnsRequiredToReachColumn(-Airplane.X_EAST_BORDER); //move to -10
           fail();
        }
        catch(Exception e){
            assertEquals(dummy.getXPos(), Airplane.X_WEST_BORDER);
            assertEquals(e.getMessage(), Airplane.ERROR_DESIRED_COLUMN_OUT_WEST_BORDER);
        }
        try {
           dummy.turnsRequiredToReachColumn(Airplane.X_EAST_BORDER+1); //move to 11
           fail();
        }
        catch(Exception e){
            assertEquals(dummy.getXPos(), Airplane.X_WEST_BORDER);
            assertEquals(e.getMessage(), Airplane.ERROR_DESIRED_COLUMN_OUT_EAST_BORDER);
        }
        try {
           dummy.turnsRequiredToReachColumn(Airplane.X_EAST_BORDER*2); //move to 20
           fail();
        }
        catch(Exception e){
            assertEquals(dummy.getXPos(), Airplane.X_WEST_BORDER);
            assertEquals(e.getMessage(), Airplane.ERROR_DESIRED_COLUMN_OUT_EAST_BORDER);
        }
        
        //Speed=0
        try {
            dummy.setXSpeed(0);
            dummy.turnsRequiredToReachColumn((Airplane.X_WEST_BORDER+Airplane.X_EAST_BORDER)/2); //move to 5
            fail();
        }
        catch(Exception e){
            assertEquals(dummy.getXPos(), Airplane.X_WEST_BORDER);
            assertEquals(e.getMessage(), Airplane.ERROR_CANNOT_MOVE);
        }
        
        //Different directions
        try {
            dummy.setXSpeed(-(Airplane.MAX_X_SPEED/Airplane.MAX_X_SPEED)); //xSpeed=-1
            dummy.turnsRequiredToReachColumn((Airplane.X_WEST_BORDER+Airplane.X_EAST_BORDER)/2); //move to 5
            fail();
        }
        catch(Exception e){
            assertEquals(dummy.getXPos(), Airplane.X_WEST_BORDER);
            assertEquals(e.getMessage(), Airplane.ERROR_DIFFERENT_DIRECTIONS);
        }
        try {
            dummy.setXPos(Airplane.X_EAST_BORDER); //I am in 10
            dummy.setXSpeed(Airplane.MAX_X_SPEED/Airplane.MAX_X_SPEED); //xSpeed=1
            dummy.turnsRequiredToReachColumn((Airplane.X_WEST_BORDER+Airplane.X_EAST_BORDER)/2); //move to 5
            fail();
        }
        catch(Exception e){
            assertEquals(dummy.getXPos(), Airplane.X_EAST_BORDER);
            assertEquals(e.getMessage(), Airplane.ERROR_DIFFERENT_DIRECTIONS);
        }
    }
    
    /**
     * Test for the method: setYSpeed (int ySpeed)
     */
    @Test
    public void ySpeedBasic() {
        Airplane dummy = new Airplane();
        dummy.setYSpeed(Airplane.MAX_Y_SPEED); //ySpeed=1
        assertEquals(dummy.getYSpeed(),Airplane.MAX_Y_SPEED);
        
        dummy.setYSpeed(Airplane.MIN_Y_SPEED); //ySpeed=-1
        assertEquals(dummy.getYSpeed(),Airplane.MIN_Y_SPEED);

        dummy.setYSpeed((Airplane.MIN_Y_SPEED+Airplane.MAX_Y_SPEED)/2); //ySpeed=0
        assertEquals(dummy.getYSpeed(),(Airplane.MIN_Y_SPEED+Airplane.MAX_Y_SPEED)/2);

        //Negative test
        dummy.setYSpeed(Airplane.MAX_Y_SPEED); //ySpeed=1
        try { //ySpeed=-2
            dummy.setYSpeed(Airplane.MIN_Y_SPEED - 1);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getYSpeed(),Airplane.MAX_Y_SPEED);
            assertEquals (e.getMessage(), Airplane.ERROR_LOWER_Y_SPEED);
        }
        try { //ySpeed=-10
            dummy.setYSpeed(Airplane.MIN_Y_SPEED *10);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getYSpeed(),Airplane.MAX_Y_SPEED);
            assertEquals (e.getMessage(), Airplane.ERROR_LOWER_Y_SPEED);
        }
        try { //ySpeed=2
            dummy.setYSpeed(Airplane.MAX_Y_SPEED +1);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getYSpeed(),Airplane.MAX_Y_SPEED);
            assertEquals (e.getMessage(), Airplane.ERROR_HIGHER_Y_SPEED);
        }
        try { //ySpeed=10
            dummy.setYSpeed(Airplane.MAX_Y_SPEED *10);
            fail();
        }
        catch (Exception e) {
            assertEquals (dummy.getYSpeed(),Airplane.MAX_Y_SPEED);
            assertEquals (e.getMessage(), Airplane.ERROR_HIGHER_Y_SPEED);
        }
    }
    
    
    //PRINTING DATA
    /**
     * Test for the method: toString()
     */
    @Test
    public void toStringBasic() {
        Airplane dummy = new Airplane('a',Airplane.MIN_FUEL,Airplane.MIN_ALTITUDE,Airplane.X_EAST_BORDER,
        Airplane.Y_SOUTH_BORDER,Airplane.MIN_X_SPEED,Airplane.MAX_Y_SPEED);
        
        assertEquals(dummy.toString(),"ID: a - Fuel: "+Airplane.MIN_FUEL+" - Altitude: "+Airplane.MIN_ALTITUDE+
        " - Pos["+Airplane.X_EAST_BORDER+","+Airplane.Y_SOUTH_BORDER+"] - Speed["+Airplane.MIN_X_SPEED+","
        +Airplane.MAX_Y_SPEED+"]");
        
        Airplane dummy2 = new Airplane('z',Airplane.MIN_FUEL+12,Airplane.MIN_ALTITUDE+11,Airplane.X_WEST_BORDER,
        Airplane.Y_NORTH_BORDER,Airplane.MAX_X_SPEED,Airplane.MIN_Y_SPEED);
        
        assertEquals(dummy2.toString(),"ID: z - Fuel: "+(Airplane.MIN_FUEL+12)+" - Altitude: "+(Airplane.MIN_ALTITUDE+11)+
        " - Pos["+Airplane.X_WEST_BORDER+","+Airplane.Y_NORTH_BORDER+"] - Speed["+Airplane.MAX_X_SPEED+","
        +Airplane.MIN_Y_SPEED+"]");
    }
    
    /**
     * Test for the method: getHashCode()
     */
    @Test
    public void getHashCodeBasic() {
        Airplane dummy = new Airplane('a',Airplane.MIN_FUEL,Airplane.MIN_ALTITUDE,Airplane.X_EAST_BORDER,
        Airplane.Y_SOUTH_BORDER,Airplane.MIN_X_SPEED,Airplane.MAX_Y_SPEED);
        
        assertEquals(dummy.getHashCode(),"a - "+Airplane.MIN_FUEL+" - "+Airplane.MIN_ALTITUDE+" - ["+Airplane.X_EAST_BORDER+","
        +Airplane.Y_SOUTH_BORDER+"] - ["+Airplane.MIN_X_SPEED+","+Airplane.MAX_Y_SPEED+"]");
        
        Airplane dummy2 = new Airplane('z',Airplane.MIN_FUEL+12,Airplane.MIN_ALTITUDE+11,Airplane.X_WEST_BORDER,
        Airplane.Y_NORTH_BORDER,Airplane.MAX_X_SPEED,Airplane.MIN_Y_SPEED);
        
        assertEquals(dummy2.getHashCode(),"z - "+(Airplane.MIN_FUEL+12)+" - "+(Airplane.MIN_ALTITUDE+11)+" - ["
        +Airplane.X_WEST_BORDER+","+Airplane.Y_NORTH_BORDER+"] - ["+Airplane.MAX_X_SPEED+","+Airplane.MIN_Y_SPEED+"]");
    }
    
    /**
     * Test for the method: fly()
     */
    @Test
    public void flyBasic(){
        Airplane a= new Airplane('z',7.0,7.2, 3, 4,-1,1);
        assertEquals("ID: z - Fuel: 7.0 - Altitude: 7.2 - Pos[3,4] - Speed[-1,1]",a.toString());
        assertEquals(a.fly(),true);
        assertEquals("ID: z - Fuel: 6.0 - Altitude: 7.2 - Pos[2,5] - Speed[-1,1]",a.toString());
        assertEquals(a.fly(),true);
        assertEquals("ID: z - Fuel: 5.0 - Altitude: 7.2 - Pos[1,6] - Speed[-1,1]",a.toString());
        assertEquals(a.fly(),true);
        assertEquals("ID: z - Fuel: 4.0 - Altitude: 7.2 - Pos[0,7] - Speed[-1,1]",a.toString());
        assertEquals(a.fly(),true);
        assertEquals("ID: z - Fuel: 3.0 - Altitude: 7.2 - Pos[0,8] - Speed[-1,1]",a.toString());
        assertEquals(a.fly(),true);
        assertEquals("ID: z - Fuel: 2.0 - Altitude: 7.2 - Pos[0,9] - Speed[-1,1]",a.toString());
        assertEquals(a.fly(),true);
        assertEquals("ID: z - Fuel: 1.0 - Altitude: 7.2 - Pos[0,10] - Speed[-1,1]",a.toString());
        assertEquals(a.fly(),true);
        assertEquals("ID: z - Fuel: 0.0 - Altitude: 7.2 - Pos[0,10] - Speed[-1,1]",a.toString());
        assertEquals(a.fly(),false);
        assertEquals("ID: z - Fuel: 0.0 - Altitude: 7.2 - Pos[0,10] - Speed[-1,1]",a.toString());
    }
}
