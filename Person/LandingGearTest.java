

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class LandingGearTest.
 *
 * @Paula Díaz Álvarez
 * @8/11/2022
 */
public class LandingGearTest
{
    /**
     * Default constructor for test class LandingGearTest
     */
    public LandingGearTest()
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
    
    //Constructor
    /**
     * Test for the constructor: LandingGear()
     */
    @Test
    public void Constructor1Basic(){
        LandingGear lg= new LandingGear();
        assertEquals(lg.getLever(),LandingGear.LEVER_DOWN);
        //Checking the nose strut
        assertEquals(lg.getNose().getID(),'N');
        for (int i=0 ; i<2 ; i++){
            assertEquals(lg.getNose().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getNose().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getNose().isDeployed(),true);
        //Checking the left strut
        assertEquals(lg.getLeft().getID(),'L');
        for (int i=0 ; i<3 ; i++){
            assertEquals(lg.getLeft().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getLeft().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getLeft().isDeployed(),true);
        //Checking the right strut
        assertEquals(lg.getRight().getID(),'R');
        for (int i=0 ; i<4 ; i++){
            assertEquals(lg.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getRight().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getRight().isDeployed(),true);
    }
    
    /**
     * Test for the constructor: LandingGear(double size)
     */
    @Test
    public void Constructor2Basic(){
        LandingGear lg= new LandingGear(Wheel.METRIC_WHEEL_SIZE);
        assertEquals(lg.getLever(),LandingGear.LEVER_DOWN);
        //Checking the nose strut
        assertEquals(lg.getNose().getID(),'N');
        for (int i=0 ; i<2 ; i++){
            assertEquals(lg.getNose().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getNose().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getNose().isDeployed(),true);
        //Checking the left strut
        assertEquals(lg.getLeft().getID(),'L');
        for (int i=0 ; i<3 ; i++){
            assertEquals(lg.getLeft().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getLeft().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getLeft().isDeployed(),true);
        //Checking the right strut
        assertEquals(lg.getRight().getID(),'R');
        for (int i=0 ; i<4 ; i++){
            assertEquals(lg.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getRight().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getRight().isDeployed(),true);
        
        lg= new LandingGear(Wheel.B737_WHEEL_SIZE);
        assertEquals(lg.getLever(),LandingGear.LEVER_DOWN);
        //Checking the nose strut
        assertEquals(lg.getNose().getID(),'N');
        for (int i=0 ; i<2 ; i++){
            assertEquals(lg.getNose().getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(lg.getNose().getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getNose().isDeployed(),true);
        //Checking the left strut
        assertEquals(lg.getLeft().getID(),'L');
        for (int i=0 ; i<3 ; i++){
            assertEquals(lg.getLeft().getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(lg.getLeft().getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getLeft().isDeployed(),true);
        //Checking the right strut
        assertEquals(lg.getRight().getID(),'R');
        for (int i=0 ; i<4 ; i++){
            assertEquals(lg.getRight().getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(lg.getRight().getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getRight().isDeployed(),true);
    }

    /**
     * Test for the constructor: LandingGear(int numberOfWheels,double size)
     */
    @Test
    public void Constructor22Basic(){
        LandingGear lg= new LandingGear(2,Wheel.METRIC_WHEEL_SIZE);
        assertEquals(lg.getLever(),LandingGear.LEVER_DOWN);
        //Checking the nose strut
        assertEquals(lg.getNose().toString(),"ID: N - Deployed: true - Op: true [0: true] [1: true]");
        for (int i=0 ; i<2 ; i++){
            assertEquals(lg.getNose().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getNose().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        //Checking the left strut
        assertEquals(lg.getLeft().toString(),"ID: L - Deployed: true - Op: true [0: true] [1: true]");
        for (int i=0 ; i<2 ; i++){
            assertEquals(lg.getLeft().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getLeft().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        //Checking the right strut
        assertEquals(lg.getRight().toString(),"ID: R - Deployed: true - Op: true [0: true] [1: true]");
        for (int i=0 ; i<2 ; i++){
            assertEquals(lg.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getRight().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        
        lg= new LandingGear(1,Wheel.B737_WHEEL_SIZE);
        assertEquals(lg.getLever(),LandingGear.LEVER_DOWN);
        //Checking the nose strut
        assertEquals(lg.getNose().toString(),"ID: N - Deployed: true - Op: true [0: true]");
        for (int i=0 ; i<1 ; i++){
            assertEquals(lg.getNose().getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(lg.getNose().getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
        }
        //Checking the left strut
        assertEquals(lg.getLeft().toString(),"ID: L - Deployed: true - Op: true [0: true]");
        for (int i=0 ; i<1 ; i++){
            assertEquals(lg.getLeft().getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(lg.getLeft().getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
        }
        //Checking the right strut
        assertEquals(lg.getRight().toString(),"ID: R - Deployed: true - Op: true [0: true]");
        for (int i=0 ; i<1 ; i++){
            assertEquals(lg.getRight().getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(lg.getRight().getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
        }
    }
    
    
    /**
     * Test for the constructor: LandingGear(double size, boolean lever)
     */
    @Test
    public void Constructor3Basic(){
        LandingGear lg= new LandingGear(Wheel.METRIC_WHEEL_SIZE,LandingGear.LEVER_UP);
        assertEquals(lg.getLever(),LandingGear.LEVER_UP);
        //Checking the nose strut
        assertEquals(lg.getNose().getID(),'N');
        for (int i=0 ; i<2 ; i++){
            assertEquals(lg.getNose().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getNose().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getNose().isDeployed(),false);
        //Checking the left strut
        assertEquals(lg.getLeft().getID(),'L');
         for (int i=0 ; i<3 ; i++){
            assertEquals(lg.getLeft().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getLeft().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getLeft().isDeployed(),false);
        //Checking the right strut
        assertEquals(lg.getRight().getID(),'R');
        for (int i=0 ; i<4 ; i++){
            assertEquals(lg.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getRight().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getRight().isDeployed(),false);
        
        lg= new LandingGear(Wheel.B737_WHEEL_SIZE,LandingGear.LEVER_DOWN);
        assertEquals(lg.getLever(),LandingGear.LEVER_DOWN);
        //Checking the nose strut
        assertEquals(lg.getNose().getID(),'N');
        for (int i=0 ; i<2 ; i++){
            assertEquals(lg.getNose().getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(lg.getNose().getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getNose().isDeployed(),true);
        //Checking the left strut
        assertEquals(lg.getLeft().getID(),'L');
        for (int i=0 ; i<3 ; i++){
            assertEquals(lg.getLeft().getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(lg.getLeft().getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getLeft().isDeployed(),true);
        //Checking the right strut
        assertEquals(lg.getRight().getID(),'R');
        for (int i=0 ; i<4 ; i++){
            assertEquals(lg.getRight().getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(lg.getRight().getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
        }
        assertEquals(lg.getRight().isDeployed(),true);
    }
    
    /**
     * Test for the constructor: LandingGear(int numberOfWheels,double size, boolean lever)
     */
    @Test
    public void Constructor33Basic(){
        LandingGear lg= new LandingGear(2,Wheel.METRIC_WHEEL_SIZE,LandingGear.LEVER_UP);
        assertEquals(lg.getLever(),LandingGear.LEVER_UP);
        //Checking the nose strut
        assertEquals(lg.getNose().toString(),"ID: N - Deployed: false - Op: true [0: true] [1: true]");
        for (int i=0 ; i<2 ; i++){
            assertEquals(lg.getNose().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getNose().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        //Checking the left strut
        assertEquals(lg.getLeft().toString(),"ID: L - Deployed: false - Op: true [0: true] [1: true]");
         for (int i=0 ; i<2 ; i++){
            assertEquals(lg.getLeft().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getLeft().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        //Checking the right strut
        assertEquals(lg.getRight().toString(),"ID: R - Deployed: false - Op: true [0: true] [1: true]");
        for (int i=0 ; i<2 ; i++){
            assertEquals(lg.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            assertEquals(lg.getRight().getWheel(i).getSize(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        
        lg= new LandingGear(1,Wheel.B737_WHEEL_SIZE,LandingGear.LEVER_DOWN);
        assertEquals(lg.getLever(),LandingGear.LEVER_DOWN);
        //Checking the nose strut
        assertEquals(lg.getNose().toString(),"ID: N - Deployed: true - Op: true [0: true]");
        for (int i=0 ; i<1 ; i++){
            assertEquals(lg.getNose().getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(lg.getNose().getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
        }
        //Checking the left strut
        assertEquals(lg.getLeft().toString(),"ID: L - Deployed: true - Op: true [0: true]");
        for (int i=0 ; i<1 ; i++){
            assertEquals(lg.getLeft().getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(lg.getLeft().getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
        }
        //Checking the right strut
        assertEquals(lg.getRight().toString(),"ID: R - Deployed: true - Op: true [0: true]");
        for (int i=0 ; i<1 ; i++){
            assertEquals(lg.getRight().getWheel(i).getPressure(),Wheel.B737_WHEEL_SIZE,0.01);
            assertEquals(lg.getRight().getWheel(i).getSize(),Wheel.B737_WHEEL_SIZE,0.01);
        }
    }
    //Setters and getters
    
    /**
     * Test for the method: reviewPressure(double basePressure)
     */
    @Test
    public void reviewPressureBasic(){ //check results
        LandingGear dummy=new LandingGear(3*Wheel.METRIC_WHEEL_SIZE); //size and pressure of every strut=200
        //Setting the pressure to 100 to not explode the wheel in when the pressure is 200 bars
        for (int i=0 ; i<2 ; i++){
            dummy.getNose().getWheel(i).setPressure(Wheel.METRIC_WHEEL_SIZE);
        }
        for (int i=0 ; i<3 ; i++){
            dummy.getLeft().getWheel(i).setPressure(Wheel.METRIC_WHEEL_SIZE);
        }
        for (int i=0 ; i<4 ; i++){
            dummy.getRight().getWheel(i).setPressure(Wheel.METRIC_WHEEL_SIZE);
        }
        //basePressure=100
        assertEquals(dummy.getNose().reviewPressure(Wheel.METRIC_WHEEL_SIZE+15),2*Wheel.METRIC_WHEEL_SIZE,0.01);//[90,140]--Correct pressure (pressure=100)
        assertEquals(dummy.getLeft().reviewPressure(Wheel.METRIC_WHEEL_SIZE),3*Wheel.METRIC_WHEEL_SIZE,0.01);//[75,125]--Correct pressure (pressure=100)
        assertEquals(dummy.getRight().reviewPressure(Wheel.METRIC_WHEEL_SIZE),4*Wheel.METRIC_WHEEL_SIZE,0.01);//[75,125]--Correct pressure (pressure=100)
        
        assertEquals(dummy.reviewPressure(Wheel.METRIC_WHEEL_SIZE),(2+3+4)*Wheel.METRIC_WHEEL_SIZE,0.01); //(sum=700)
        
        //basePressure=200
        assertEquals(dummy.getNose().reviewPressure(Wheel.METRIC_WHEEL_SIZE*2+15),2*(Wheel.METRIC_WHEEL_SIZE*2+15),0.01);// [190,240]--Not correct pressure
        assertEquals(dummy.getLeft().reviewPressure(Wheel.METRIC_WHEEL_SIZE*2),3*(Wheel.METRIC_WHEEL_SIZE*2),0.01);//[175,225]--Not correct pressure
        assertEquals(dummy.getRight().reviewPressure(Wheel.METRIC_WHEEL_SIZE*2),4*(Wheel.METRIC_WHEEL_SIZE*2),0.01);//[175,225]--Not correct pressure
               
        assertEquals(dummy.reviewPressure(Wheel.METRIC_WHEEL_SIZE*2),2*(Wheel.METRIC_WHEEL_SIZE*2+15)+(3+4)*(2*Wheel.METRIC_WHEEL_SIZE),0.01);
        
        //basePressure=0, now checking that only the nose is incorrect
        for (int i=0 ; i<2 ; i++){
            dummy.getNose().getWheel(i).setPressure(80);
        }
        for (int i=0 ; i<3 ; i++){
            dummy.getLeft().getWheel(i).setPressure(80);
        }
        for (int i=0 ; i<4 ; i++){
            dummy.getRight().getWheel(i).setPressure(80);
        }
        assertEquals(dummy.getNose().reviewPressure(Wheel.METRIC_WHEEL_SIZE+15),2*(Wheel.METRIC_WHEEL_SIZE+15),0.01);//[90,140]--Incorrect pressure (pressure=100)
        assertEquals(dummy.getLeft().reviewPressure(Wheel.METRIC_WHEEL_SIZE),3*80,0.01);//[75,125]--Correct pressure (pressure=100)
        assertEquals(dummy.getRight().reviewPressure(Wheel.METRIC_WHEEL_SIZE),4*80,0.01);//[75,125]--Correct pressure (pressure=100)
        
        assertEquals(dummy.reviewPressure(Wheel.METRIC_WHEEL_SIZE),2*(Wheel.METRIC_WHEEL_SIZE+15)+7*80);
        
        //Negative tests
        for (int i=0 ; i<2 ; i++){
            dummy.getNose().getWheel(i).setPressure(Wheel.METRIC_WHEEL_SIZE);
        }
        for (int i=0 ; i<3 ; i++){
            dummy.getLeft().getWheel(i).setPressure(Wheel.METRIC_WHEEL_SIZE);
        }
        for (int i=0 ; i<4 ; i++){
            dummy.getRight().getWheel(i).setPressure(Wheel.METRIC_WHEEL_SIZE);
        }
        try { 
            dummy.reviewPressure(-1); //basicPressure=-1
            fail();
        }
        catch (Exception e){
            for (int i=0 ; i<2 ; i++){
            assertEquals(dummy.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            }    
            for (int i=0 ; i<3 ; i++){
            assertEquals(dummy.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            }    
            for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            }             
            assertEquals(e.getMessage(),"NEGATIVE BASE PRESSURE");
        }
        
        try { 
            dummy.reviewPressure(-1*Wheel.METRIC_WHEEL_SIZE); //basicPressure=-100
            fail();
        }
        catch (Exception e){
            for (int i=0 ; i<2 ; i++){
            assertEquals(dummy.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            }    
            for (int i=0 ; i<3 ; i++){
            assertEquals(dummy.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            }    
            for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
            } 
            assertEquals(e.getMessage(),"NEGATIVE BASE PRESSURE");
        }
    }
    
    /**
     * Test for the method: setLever(boolean lever)
     */
    @Test
    public void LeverBasic(){
        LandingGear lg= new LandingGear();
        
        lg.setLever(LandingGear.LEVER_UP);
        assertEquals(lg.getLever(),LandingGear.LEVER_UP);
        assertEquals(lg.getNose().isDeployed(),false);
        assertEquals(lg.getLeft().isDeployed(),false);
        assertEquals(lg.getRight().isDeployed(),false);
        
        lg.setLever(LandingGear.LEVER_DOWN);
        assertEquals(lg.getLever(),LandingGear.LEVER_DOWN);
        assertEquals(lg.getNose().isDeployed(),true);
        assertEquals(lg.getLeft().isDeployed(),true);
        assertEquals(lg.getRight().isDeployed(),true);
    }
    
    /**
     * Test for the method: isConsistent()
     */
    @Test
    public void isConsistentBasic(){
        LandingGear lg= new LandingGear(Wheel.METRIC_WHEEL_SIZE); //the lever is down
        //Everything OK
        assertEquals(lg.isConsistent(),true);
        lg.setLever(LandingGear.LEVER_UP);
        assertEquals(lg.isConsistent(),true);
        //Some struts fail with the level UP
        lg.getNose().setDeployed(true);
        lg.getLeft().setDeployed(true);
        lg.getRight().setDeployed(true);
        assertEquals(lg.isConsistent(),false); //all wrong
        
        lg.getNose().setDeployed(false);
        assertEquals(lg.isConsistent(),false); //only nose OK
        
        lg.getLeft().setDeployed(true);      
        assertEquals(lg.isConsistent(),false); //nose and left OK
        
        //Some struts fail with the level DOWN
        lg.setLever(LandingGear.LEVER_DOWN);
        lg.getNose().setDeployed(false);
        lg.getLeft().setDeployed(false);
        lg.getRight().setDeployed(false);
        assertEquals(lg.isConsistent(),false); //all wrong
        
        lg.getNose().setDeployed(true);
        assertEquals(lg.isConsistent(),false); //only nose OK
        
        lg.getLeft().setDeployed(true);      
        assertEquals(lg.isConsistent(),false); //nose and left OK
    }
    
    /**
     * Test for the method: isOperational()
     */
    @Test
    public void isOperationalBasic(){
        LandingGear lg= new LandingGear(Wheel.METRIC_WHEEL_SIZE); //the lever is down
        //Everything OK
        assertEquals(lg.isOperational(),true);
        lg.setLever(LandingGear.LEVER_UP); 
        assertEquals(lg.isOperational(),true);
        //Some struts fail with the level UP
        lg.getNose().getWheel(0).setPressure(Wheel.MIN_SIZE);
        lg.getLeft().getWheel(0).setPressure(Wheel.MIN_SIZE);
        lg.getRight().getWheel(0).setPressure(Wheel.MIN_SIZE);
        assertEquals(lg.isOperational(),false); //all wrong
        
        lg.getNose().getWheel(0).setPressure(Wheel.METRIC_WHEEL_SIZE);
        assertEquals(lg.isOperational(),false); //only nose OK
        
        lg.getLeft().getWheel(0).setPressure(Wheel.METRIC_WHEEL_SIZE);   
        assertEquals(lg.isOperational(),false); //nose and left OK
        
        //Some struts fail with the level DOWN
        lg.setLever(LandingGear.LEVER_DOWN);
        lg.getNose().getWheel(0).setPressure(Wheel.MIN_SIZE);
        lg.getLeft().getWheel(0).setPressure(Wheel.MIN_SIZE);
        lg.getRight().getWheel(0).setPressure(Wheel.MIN_SIZE);
        assertEquals(lg.isOperational(),false); //all wrong
        
        lg.getNose().getWheel(0).setPressure(Wheel.METRIC_WHEEL_SIZE);
        assertEquals(lg.isOperational(),false); //only nose OK
        
        lg.getLeft().getWheel(0).setPressure(Wheel.METRIC_WHEEL_SIZE);     
        assertEquals(lg.isOperational(),false); //nose and left OK
    }
    
    /**
     * Test for the method: activeHardLandingConfiguration()
     */
    @Test
    public void activeHardLandingConfigurationBasic(){
        LandingGear dummy=new LandingGear (Wheel.METRIC_WHEEL_SIZE);
        assertEquals(dummy.getNose().isDeployed(),true);
        assertEquals(dummy.getLeft().isDeployed(),true);
        assertEquals(dummy.getRight().isDeployed(),true);
        //the pressure don't change because the airplane isn't flying
        dummy.activeHardLandingConfiguration();
        for (int i=0 ; i<2 ; i++){
            assertEquals(dummy.getNose().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(dummy.getNose().isDeployed(),true);
        
        for (int i=0 ; i<3 ; i++){
            assertEquals(dummy.getLeft().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(dummy.getLeft().isDeployed(),true);
        
        for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE,0.01);
        }
        assertEquals(dummy.getRight().isDeployed(),true);
        
        //the pressure change because the airplane is flying now
        dummy.setLever(LandingGear.LEVER_UP);
        assertEquals(dummy.getNose().isDeployed(),false);
        assertEquals(dummy.getLeft().isDeployed(),false);
        assertEquals(dummy.getRight().isDeployed(),false);
        
        dummy.activeHardLandingConfiguration();
        for (int i=0 ; i<2 ; i++){
            assertEquals(dummy.getNose().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE*0.75,0.01);
        }
        assertEquals(dummy.getNose().isDeployed(),true);
        
        for (int i=0 ; i<3 ; i++){
            assertEquals(dummy.getLeft().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE*0.75,0.01);
        }
        assertEquals(dummy.getLeft().isDeployed(),true);
        
        for (int i=0 ; i<4 ; i++){
            assertEquals(dummy.getRight().getWheel(i).getPressure(),Wheel.METRIC_WHEEL_SIZE*0.75,0.01);
        }
        assertEquals(dummy.getRight().isDeployed(),true);
    }
    
    //Printing
    /**
     * Test for the method: toString()
     */
    @Test
    public void toStringBasic(){
        LandingGear lg= new LandingGear(Wheel.METRIC_WHEEL_SIZE);
        //Everithing OK-------------------------------------------------------------------------------
        //Aircarft parked at the gates
        assertEquals(LandingGear.LEVER_DOWN,lg.getLever());
        assertEquals("Lever: DOWN Status: ON      Nose: ON    Left: ON    Right: ON   ",lg.toString());
        
        //Take off, positive altitude, retract lg
        lg.setLever(LandingGear.LEVER_UP);
        assertEquals(LandingGear.LEVER_UP,lg.getLever());
        assertEquals("Lever: UP   Status: ON      Nose: OFF   Left: OFF   Right: OFF  ",lg.toString());
        
        //UP FAILURE,one strut is deployed------------------------------------------------------------
        lg.getNose().setDeployed(true); //hack nose strut, is retracted
        assertEquals("Lever: UP   Status: FAILURE Nose: ON    Left: OFF   Right: OFF  ",lg.toString());
        
        lg.getNose().setDeployed(false); //recover
        lg.getLeft().setDeployed(true); //hack left strut, is retracted
        assertEquals("Lever: UP   Status: FAILURE Nose: OFF   Left: ON    Right: OFF  ",lg.toString());
        
        lg.getLeft().setDeployed(false); //recover
        lg.getRight().setDeployed(true); //hack right strut, is retracted
        assertEquals("Lever: UP   Status: FAILURE Nose: OFF   Left: OFF   Right: ON   ",lg.toString());
        
        //DOWN FAILURE,one strut is not deployed-------------------------------------------------------
        lg.setLever(LandingGear.LEVER_DOWN); //reset the system to land
        lg.getNose().setDeployed(false); //hack nose strut, is not retracted
        assertEquals("Lever: DOWN Status: FAILURE Nose: OFF   Left: ON    Right: ON   ",lg.toString());
        
        lg.getNose().setDeployed(true); //recover
        lg.getLeft().setDeployed(false); //hack left strut, is not retracted
        assertEquals("Lever: DOWN Status: FAILURE Nose: ON    Left: OFF   Right: ON   ",lg.toString());
        
        lg.getLeft().setDeployed(true); //recover
        lg.getRight().setDeployed(false); //hack right strut, is not retracted
        assertEquals("Lever: DOWN Status: FAILURE Nose: ON    Left: ON    Right: OFF  ",lg.toString());
        
        //UP FAILURE,one wheel of one strut doesn't have enough pressure-------------------------------
        lg.setLever(LandingGear.LEVER_UP); //reset the system to fly
        lg.getNose().getWheel(0).setPressure(Wheel.MIN_SIZE); //hack nose strut, the first wheel doesn't have enough pressure
        assertEquals("Lever: UP   Status: FAILURE Nose: PRESS Left: OFF   Right: OFF  ",lg.toString());
        
        lg.getNose().getWheel(0).setPressure(Wheel.METRIC_WHEEL_SIZE); //recover
        lg.getLeft().getWheel(0).setPressure(Wheel.MIN_SIZE); //hack left strut, the first wheel doesn't have enough pressure
        assertEquals("Lever: UP   Status: FAILURE Nose: OFF   Left: PRESS Right: OFF  ",lg.toString());
        
        lg.getLeft().getWheel(0).setPressure(Wheel.METRIC_WHEEL_SIZE); //recover
        lg.getRight().getWheel(0).setPressure(Wheel.MIN_SIZE); //hack right strut, the first wheel doesn't have enough pressure
        assertEquals("Lever: UP   Status: FAILURE Nose: OFF   Left: OFF   Right: PRESS",lg.toString());
        lg.getRight().getWheel(0).setPressure(Wheel.METRIC_WHEEL_SIZE); //recover
        
        //DOWN FAILURE,one wheel of one strut doesn't have enough pressure-------------------------------
        lg.setLever(LandingGear.LEVER_DOWN); //reset the system to fly
        lg.getNose().getWheel(0).setPressure(Wheel.MIN_SIZE); //hack nose strut, the first wheel doesn't have enough pressure
        assertEquals("Lever: DOWN Status: FAILURE Nose: PRESS Left: ON    Right: ON   ",lg.toString());
        
        lg.getNose().getWheel(0).setPressure(Wheel.METRIC_WHEEL_SIZE); //recover
        lg.getLeft().getWheel(0).setPressure(Wheel.MIN_SIZE); //hack left strut, the first wheel doesn't have enough pressure
        assertEquals("Lever: DOWN Status: FAILURE Nose: ON    Left: PRESS Right: ON   ",lg.toString());
        
        lg.getLeft().getWheel(0).setPressure(Wheel.METRIC_WHEEL_SIZE); //recover
        lg.getRight().getWheel(0).setPressure(Wheel.MIN_SIZE); //hack right strut, the first wheel doesn't have enough pressure
        assertEquals("Lever: DOWN Status: FAILURE Nose: ON    Left: ON    Right: PRESS",lg.toString());
    }
}
