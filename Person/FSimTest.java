

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class FSimTest.
 *
 * @author Paula Díaz Álvarez
 * @version 29/11/2022
 */
public class FSimTest
{
    /**
     * Default constructor for test class FSimTest
     */
    public FSimTest() {
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
    
    /**
     * Test for the method: animate (int frames)
     */
    @Test
    public void drawingMapBasic(){
        FSim fsim= new FSim();
        fsim.add(new Airplane ('A', 15.0,7.0, Airplane.X_WEST_BORDER,Airplane.Y_NORTH_BORDER,1,1));
        fsim.add(new Airplane ('B', 15.0,7.0, Airplane.X_EAST_BORDER,Airplane.Y_NORTH_BORDER,-1,1));
        fsim.add(new Airplane ('C', 15.0,7.0, Airplane.X_WEST_BORDER,Airplane.Y_SOUTH_BORDER,1,-1));
        fsim.add(new Airplane ('D', 15.0,7.0, Airplane.X_EAST_BORDER,Airplane.Y_SOUTH_BORDER,-1,-1));
        
        fsim.animate(9);
    }
}
