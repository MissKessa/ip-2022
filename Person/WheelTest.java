

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WheelTest.
 *
 * @Paula Díaz Álvarez
 * @25/10/2022
 */
public class WheelTest
{
    /**
     * Default constructor for test class WheelTest
     */
    public WheelTest()
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
    
    /**
     * Test for the constructor: Wheel()
     */
    @Test
    public void constructor1Basic()
    {
        Wheel dummy=new Wheel();
        assertEquals(dummy.getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        assertEquals(dummy.getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
    }
    
    /**
     * Test for the constructor: Wheel(double size)
     */
    @Test
    public void constructor2Basic()
    {
        Wheel dummy=new Wheel(Wheel.METRIC_WHEEL_SIZE); //size=100.0
        assertEquals(dummy.getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        
        dummy=new Wheel((Wheel.MIN_SIZE+Wheel.METRIC_WHEEL_SIZE)/2); //size=50.0
        assertEquals(dummy.getSize(),(Wheel.MIN_SIZE+Wheel.METRIC_WHEEL_SIZE)/2,0.01);
        
        dummy=new Wheel(Wheel.MIN_SIZE); //size=0.0
        assertEquals(dummy.getSize(),Wheel.MIN_SIZE,0.01);
        //Negative test
        try {
            dummy=new Wheel(Wheel.MIN_SIZE-0.01); //size=-0.01
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getSize(),Wheel.MIN_SIZE,0.01);
            assertEquals(e.getMessage(),Wheel.ERROR_LOWER_SIZE);
        }
        try {
            dummy=new Wheel(Wheel.MIN_SIZE-1000); //size=-1000.0
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getSize(),Wheel.MIN_SIZE,0.01);
            assertEquals(e.getMessage(),Wheel.ERROR_LOWER_SIZE);
        }
    }
    
    /**
     * Test for the constructor: Wheel(double size, double pressure); setPressure​(double pressure)
     */
    @Test 
    public void constructor3Basic() //Also pressure basic
    {
        Wheel dummy=new Wheel(Wheel.METRIC_WHEEL_SIZE,Wheel.MIN_SIZE);
        assertEquals(dummy.getPressure(), Wheel.MIN_SIZE,0.01); //pressure=0
        
        dummy.setPressure(Wheel.METRIC_WHEEL_SIZE); //pressure=100
        assertEquals(dummy.getPressure(), Wheel.METRIC_WHEEL_SIZE,0.01);
        
        dummy.setPressure((Wheel.MIN_SIZE+Wheel.METRIC_WHEEL_SIZE)/2); //pressure=50
        assertEquals(dummy.getPressure(),(Wheel.MIN_SIZE+Wheel.METRIC_WHEEL_SIZE)/2,0.01);
        
        //Negative test
        dummy.setPressure(Wheel.MIN_SIZE); //pressure=0
        try { 
            dummy.setPressure(Wheel.METRIC_WHEEL_SIZE+1); //pressure=100.01
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getPressure(),Wheel.MIN_SIZE,0.01);
            assertEquals(e.getMessage(),Wheel.ERROR_HIGHER_PRESSURE+dummy.getSize());
        }
        try { 
            dummy.setPressure(Wheel.METRIC_WHEEL_SIZE*2); //pressure=200
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getPressure(),Wheel.MIN_SIZE,0.01);
            assertEquals(e.getMessage(),Wheel.ERROR_HIGHER_PRESSURE+dummy.getSize());
        }
        try { 
            dummy.setPressure(Wheel.MIN_SIZE-0.01); //pressure=-0.01
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getPressure(),Wheel.MIN_SIZE,0.01);
            assertEquals(e.getMessage(),Wheel.ERROR_LOWER_PRESSURE);
        }
        try { 
            dummy.setPressure(Wheel.METRIC_WHEEL_SIZE*(-2)); //pressure=-100
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getPressure(),Wheel.MIN_SIZE,0.01);
            assertEquals(e.getMessage(),Wheel.ERROR_LOWER_PRESSURE);
        }
    }
    
    //Setters and getters
    /**
     * Test for the method: reviewPressure​(double basePressure)
     */
    @Test
    public void reviewPressureBasic(){
        Wheel dummy=new Wheel(Wheel.METRIC_WHEEL_SIZE*2,Wheel.METRIC_WHEEL_SIZE); //size 200 and pressure=100.
        //Setting the pressure to 100 to not explode the wheel when the pressure is set to 200
        
        assertEquals(dummy.reviewPressure(Wheel.METRIC_WHEEL_SIZE),Wheel.METRIC_WHEEL_SIZE,0.01);//[75,125]--Correct pressure (pressure=100)
        assertEquals(dummy.reviewPressure(Wheel.METRIC_WHEEL_SIZE*2),Wheel.METRIC_WHEEL_SIZE*2,0.01); //[175,225]--Not correct pressure (pressure=200)
        assertEquals(dummy.reviewPressure(0),0,0.01); //[-25,25]--Not correct pressure (pressure=0)
        
        //Negative tests
        dummy.setPressure(Wheel.METRIC_WHEEL_SIZE);
        try { 
            dummy.reviewPressure(-1); //basicPressure=-1
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(e.getMessage(),"NEGATIVE BASE PRESSURE");
        }
        
        try { 
            dummy.reviewPressure(-1*Wheel.METRIC_WHEEL_SIZE); //basicPressure=-100
            fail();
        }
        catch (Exception e){
            assertEquals(dummy.getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(e.getMessage(),"NEGATIVE BASE PRESSURE");
        }
    }
    
    /**
     * Test for the method: isOperational()
     */
    @Test
    public void isOperationalBasic(){
        Wheel dummy=new Wheel (Wheel.METRIC_WHEEL_SIZE);//size=100
        
        dummy.setPressure(Wheel.METRIC_WHEEL_SIZE); //pressure=100
        assertEquals(dummy.isOperational(), true); //100%
        
        dummy.setPressure(Wheel.SAFETY_THRESHOLD*100); //pressure=80
        assertEquals(dummy.isOperational(),true); //80%
        
        dummy.setPressure((Wheel.SAFETY_THRESHOLD*100+Wheel.METRIC_WHEEL_SIZE)/2); //pressure=90
        assertEquals(dummy.isOperational(),true); //90%
        
        //Not Operational
        dummy.setPressure(Wheel.SAFETY_THRESHOLD*100-0.1); //pressure=79.9
        assertEquals(dummy.isOperational(),false); //79.9%
        
        dummy.setPressure((Wheel.SAFETY_THRESHOLD*100+Wheel.MIN_SIZE)/2); //pressure=40
        assertEquals(dummy.isOperational(),false); //40%
        
        dummy.setPressure(Wheel.MIN_SIZE); //pressure=0
        assertEquals(dummy.isOperational(),false); //0%
    }
    
    /**
     * Test for the method: activeHardLandingConfiguration()
     */
    @Test
    public void activeHardLandingConfigurationBasic(){
        Wheel dummy=new Wheel (Wheel.METRIC_WHEEL_SIZE,Wheel.METRIC_WHEEL_SIZE);
        dummy.activeHardLandingConfiguration();
        assertEquals(dummy.getPressure(),0.75*Wheel.METRIC_WHEEL_SIZE,0.01);
    }
    
    /**
     * Test for the method: toString()
     */
    @Test
    public void toStringBasic(){
        Wheel dummy=new Wheel (Wheel.METRIC_WHEEL_SIZE,Wheel.METRIC_WHEEL_SIZE);
        assertEquals(dummy.toString(),"Size: "+String.format("%.2f",Wheel.METRIC_WHEEL_SIZE)+" bars - Pressure: "
        +String.format("%.2f",Wheel.METRIC_WHEEL_SIZE)+" bars - Ratio: "+String.format("%.2f",Wheel.METRIC_WHEEL_SIZE/Wheel.METRIC_WHEEL_SIZE)+
        " - Op: true");
        
        Wheel dummy2=new Wheel (Wheel.METRIC_WHEEL_SIZE,Wheel.MIN_SIZE);
        assertEquals(dummy2.toString(),"Size: "+String.format("%.2f",Wheel.METRIC_WHEEL_SIZE)+" bars - Pressure: "
        +String.format("%.2f",Wheel.MIN_SIZE)+" bars - Ratio: "+String.format("%.2f",Wheel.MIN_SIZE/Wheel.METRIC_WHEEL_SIZE)+
        " - Op: false");
    }
}
