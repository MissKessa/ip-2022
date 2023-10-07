

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WheelStrutTest.
 *
 * @Paula Díaz Álvarez
 * @25/10/2022
 */
public class WheelStrutTest
{
    /**
     * Default constructor for test class WheelStrutTest
     */
    public WheelStrutTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    //Constructors
    /**
     * Test for the constructor: WheelStrut​(int numberOfWheels)
     */
    @Test
    public void constructor1Basic(){
        WheelStrut dummy=new WheelStrut(2);
        assertEquals(dummy.getID(),'X');
        //Checking each Wheel
        for (int i=0 ; i<2 ; i++){
            assertEquals(dummy.getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(dummy.isDeployed(),true);
        
        dummy=new WheelStrut(4);
        assertEquals(dummy.getID(),'X');
        //Checking each Wheel
        for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(dummy.isDeployed(),true);
        try{
            dummy=new WheelStrut(-1);
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getID(),'X');
            for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            }
            assertEquals(dummy.isDeployed(),true);
            assertEquals(e.getMessage(),WheelStrut.ERROR_NEGATIVE_WHEELS);
        }
        try{
            dummy=new WheelStrut(-100);
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getID(),'X');
            for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            }
            assertEquals(dummy.isDeployed(),true);
            assertEquals(e.getMessage(),WheelStrut.ERROR_NEGATIVE_WHEELS);
        }
    }
    
    /**
     * Test for the constructor: WheelStrut​(char ID, double size, int numberOfWheels)
     */
    @Test
    public void constructor2Basic(){
        WheelStrut dummy=new WheelStrut ('A',Wheel.METRIC_WHEEL_SIZE,2);
        assertEquals(dummy.getID(),'A');
        for (int i=0 ; i<2 ; i++){
            assertEquals(dummy.getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(dummy.isDeployed(),true);    
        
        dummy=new WheelStrut ('z',Wheel.B737_WHEEL_SIZE,4);
        assertEquals(dummy.getID(),'z');
        for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
        }
        assertEquals(dummy.isDeployed(),true);
        try{
            dummy=new WheelStrut('A',Wheel.METRIC_WHEEL_SIZE,-1);
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getID(),'z');
            for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            }
            assertEquals(dummy.isDeployed(),true);
            assertEquals(e.getMessage(),WheelStrut.ERROR_NEGATIVE_WHEELS);
        }
        try{
            dummy=new WheelStrut('A',Wheel.METRIC_WHEEL_SIZE,-100);
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getID(),'z');
            for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            }
            assertEquals(dummy.isDeployed(),true);
            assertEquals(e.getMessage(),WheelStrut.ERROR_NEGATIVE_WHEELS);
        }
    }
    
    /**
     * Test for the constructor: WheelStrut​(char ID, double size, int numberOfWheels, boolean deployed)
     */
    @Test
    public void constructor3Basic(){
        WheelStrut dummy=new WheelStrut ('A',Wheel.METRIC_WHEEL_SIZE,2,false);
        assertEquals(dummy.getID(),'A');
        assertEquals(dummy.isDeployed(),false);
        for (int i=0 ; i<2 ; i++){
            assertEquals(dummy.getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
            
        dummy=new WheelStrut ('z',Wheel.B737_WHEEL_SIZE,4,true);
        assertEquals(dummy.getID(),'z');
        assertEquals(dummy.isDeployed(),true);
        for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
        }
        try{
            dummy=new WheelStrut('A',Wheel.METRIC_WHEEL_SIZE,-1,false);
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getID(),'z');
            for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            }
            assertEquals(dummy.isDeployed(),true);
            assertEquals(e.getMessage(),WheelStrut.ERROR_NEGATIVE_WHEELS);
        }
        try{
            dummy=new WheelStrut('A',Wheel.METRIC_WHEEL_SIZE,-100,false);
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getID(),'z');
            for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            }
            assertEquals(dummy.isDeployed(),true);
            assertEquals(e.getMessage(),WheelStrut.ERROR_NEGATIVE_WHEELS);
        }
    }
    
    //Setters and getters
    /**
     * Test for the method: reviewPressure​(double basePressure)
     */
    @Test
    public void reviewPressureBasic(){
        WheelStrut dummy=new WheelStrut('X',2*Wheel.METRIC_WHEEL_SIZE,2); //size and pressure=200
        //Setting the pressure to 100 to not explode the wheel when the pressure is set to 200
        for (int i=0 ; i<2 ; i++){
            dummy.getWheel(i).setPressure(Wheel.METRIC_WHEEL_SIZE);
        }
        
        assertEquals(dummy.reviewPressure(Wheel.METRIC_WHEEL_SIZE),Wheel.METRIC_WHEEL_SIZE+Wheel.METRIC_WHEEL_SIZE);//[75,125]--Correct pressure (pressure=100)
        assertEquals(dummy.reviewPressure(Wheel.METRIC_WHEEL_SIZE*2),2*(Wheel.METRIC_WHEEL_SIZE*2)); //[175,225]--Not correct pressure (pressure=200)
        assertEquals(dummy.reviewPressure(0),0); //[-25,25]--Not correct pressure (pressure=0)
        
        //Negative tests
        for (int i=0 ; i<2 ; i++){
            dummy.getWheel(i).setPressure(Wheel.METRIC_WHEEL_SIZE);
        }
        try { 
            dummy.reviewPressure(-1); //basicPressure=-1
            fail();
        }
        catch (Exception e){
            for (int i=0 ; i<2 ; i++){
                assertEquals(dummy.getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE);
            }
            assertEquals(e.getMessage(),"NEGATIVE BASE PRESSURE");
        }
        
        try { 
            dummy.reviewPressure(-1*Wheel.METRIC_WHEEL_SIZE); //basicPressure=-100
            fail();
        }
        catch (Exception e){
            for (int i=0 ; i<2 ; i++){
                assertEquals(dummy.getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE);
            }
            assertEquals(e.getMessage(),"NEGATIVE BASE PRESSURE");
        }
    }
    
    /**
     * Test for the method: setID​(char ID)
     */
    @Test
    public void IDBasic(){
        WheelStrut dummy=new WheelStrut ('A',Wheel.METRIC_WHEEL_SIZE,2);
        assertEquals(dummy.getID(),'A');
        
        dummy.setID('s');
        assertEquals(dummy.getID(),'s');
    }
    
    /**
     * Test for the method: setDeployed​(boolean deployed)
     */
    @Test
    public void deployedBasic(){
        WheelStrut dummy=new WheelStrut ('A', Wheel.METRIC_WHEEL_SIZE,2);
        dummy.setDeployed(false);
        assertEquals(dummy.isDeployed(),false);
        
        dummy.setDeployed(true);
        assertEquals(dummy.isDeployed(),true);
    }
    
    /**
     * Test for the method: isOperational()
     */
    @Test
    public void isOperationalBasic(){
        WheelStrut dummy=new WheelStrut ('N', Wheel.METRIC_WHEEL_SIZE,2);
        //Everything OK
        assertEquals(true, dummy.isOperational());
        
        //Not operational. We must cause a damage to the wheel
        for (int i=0 ; i<2 ; i++){
            dummy.getWheel(i).setPressure(Wheel.MIN_SIZE);
        }
        assertEquals(false, dummy.isOperational());
        
        dummy.getWheel(0).setPressure(Wheel.METRIC_WHEEL_SIZE); //now the first wheel is okay
        assertEquals(false, dummy.isOperational());
    }
    
    /**
     * Test for the method: activeHardLandingConfiguration()
     */
    @Test
    public void activeHardLandingConfigurationBasic(){
        WheelStrut dummy=new WheelStrut ('N', Wheel.METRIC_WHEEL_SIZE,2);
        dummy.setDeployed(false);
        dummy.activeHardLandingConfiguration();
        for (int i=0 ; i<2 ; i++){
            assertEquals(dummy.getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE*0.75,0.01);
        }
        assertEquals(dummy.isDeployed(),true);
    }
    
    //Printing data
    /**
     * Test for the method: toString()
     */
    @Test
    public void toStringBasic(){
        WheelStrut dummy=new WheelStrut ('N', Wheel.METRIC_WHEEL_SIZE,2);
        assertEquals(dummy.toString(),"ID: N - Deployed: true - Op: true [0: true] [1: true]");
        
        //Causing damage to the firs wheel and setting the deployed to false
        dummy.setDeployed(false);
        dummy.getWheel(0).setPressure(Wheel.MIN_SIZE);
        assertEquals(dummy.toString(),"ID: N - Deployed: false - Op: false [0: false] [1: true]");
        
        //Causing damage also to the right wheel
        dummy.getWheel(1).setPressure(Wheel.MIN_SIZE);;
        assertEquals(dummy.toString(),"ID: N - Deployed: false - Op: false [0: false] [1: false]");
    }
}
