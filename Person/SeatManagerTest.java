

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class SeatManagerTest.
 *
 * @Paula Díaz Álvarez
 * @15/11/2022
 */
public class SeatManagerTest
{
    /**
     * Default constructor for test class SeatManagerTest
     */
    public SeatManagerTest()
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
     * Test for the methods: SeatManager​(int firstClassRows, int standardClassRows);
     * getSize() ; getRows() ; getSizeFirstClass(); getRowsFirstClass(); getSizeStandardClass() ; getRowsStandardClass();
     */
    @Test
    public void ConstructorBasic(){
        SeatManager sm=new SeatManager(0,0);
        assertEquals (0, sm.getSize());
        assertEquals(sm.getRows(),0);
        assertEquals (0, sm.getSizeFirstClass());
        assertEquals(sm.getRowsFirstClass(),0);
        assertEquals (0, sm.getSizeStandardClass());
        assertEquals(sm.getRowsStandardClass(),0);
        
        sm=new SeatManager(2,6); //2 rows of the first class, and 6 rows standar class
        assertEquals ((2+6)*SeatManager.WIDTH, sm.getSize());
        assertEquals(sm.getRows(),2+6);
        assertEquals (2*SeatManager.WIDTH, sm.getSizeFirstClass());
        assertEquals(sm.getRowsFirstClass(),2);
        assertEquals (6*SeatManager.WIDTH, sm.getSizeStandardClass());
        assertEquals(sm.getRowsStandardClass(),6);
        
        try {
            sm=new SeatManager(-1,6);
            fail();
        }
        catch (Exception e){
            assertEquals ((2+6)*SeatManager.WIDTH, sm.getSize());
            assertEquals (2*SeatManager.WIDTH, sm.getSizeFirstClass());
            assertEquals (6*SeatManager.WIDTH, sm.getSizeStandardClass());
            assertEquals(e.getMessage(),SeatManager.ERROR_NEGATIVE_FIRST_CLASS);
        }
        try {
            sm=new SeatManager(-100,6);
            fail();
        }
        catch (Exception e){
            assertEquals ((2+6)*SeatManager.WIDTH, sm.getSize());
            assertEquals (2*SeatManager.WIDTH, sm.getSizeFirstClass());
            assertEquals (6*SeatManager.WIDTH, sm.getSizeStandardClass());
            assertEquals(e.getMessage(),SeatManager.ERROR_NEGATIVE_FIRST_CLASS);
        }
        try {
            sm=new SeatManager(2,-1);
            fail();
        }
        catch (Exception e){
            assertEquals ((2+6)*SeatManager.WIDTH, sm.getSize());
            assertEquals (2*SeatManager.WIDTH, sm.getSizeFirstClass());
            assertEquals (6*SeatManager.WIDTH, sm.getSizeStandardClass());
            assertEquals(e.getMessage(),SeatManager.ERROR_NEGATIVE_STANDARD_CLASS);
        }
        try {
            sm=new SeatManager(2,-100);
            fail();
        }
        catch (Exception e){
            assertEquals ((2+6)*SeatManager.WIDTH, sm.getSize());
            assertEquals (2*SeatManager.WIDTH, sm.getSizeFirstClass());
            assertEquals (6*SeatManager.WIDTH, sm.getSizeStandardClass());
            assertEquals(e.getMessage(),SeatManager.ERROR_NEGATIVE_STANDARD_CLASS);
        }
    }
    
    /**
     * Test for the methods: getNumPax(); bookSeat(Person person, int row, int col); isReserved​(int row, int col); 
     * getReservation(int row, int col) ; releaseSeat(int row, int col)
     */
    @Test
    public void ReservationBasic(){
        SeatManager sm=new SeatManager(2,2); //4 rows, 6 columns
        Person dummy= new Person("Paula","Díaz",18,true);
        Person dummy2= new Person("Pablo","Escobar",40,false);
        
        assertEquals(sm.getNumPax(),0);
        //0,0
        sm.bookSeat(dummy,0,0);
        assertEquals(sm.isReserved(0,0),true);
        assertEquals(sm.isReserved(1,0),false);
        assertEquals(sm.isReserved(0,1),false);
        //4,5
        sm.bookSeat(dummy2,sm.getRows()-1,SeatManager.WIDTH-1);
        assertEquals(sm.isReserved(sm.getRows()-1,SeatManager.WIDTH-1),true);
        assertEquals(sm.isReserved(sm.getRows()-1,SeatManager.WIDTH-2),false);
        assertEquals(sm.isReserved(sm.getRows()-2,SeatManager.WIDTH-1),false);
        
        assertEquals(sm.getReservation(0,0).HashCode(),"PAU-DÍA-18-true");
        assertEquals(sm.getReservation(sm.getRows()-1,SeatManager.WIDTH-1).HashCode(),"PAB-ESC-40-false");
        ////
        assertEquals(sm.getNumPax(),2);
        sm.releaseSeat(0,0);
        assertEquals(sm.isReserved(0,0),false);
        
        assertEquals(sm.getNumPax(),1);
        sm.releaseSeat(sm.getRows()-1,SeatManager.WIDTH-1);
        assertEquals(sm.isReserved(sm.getRows()-1,SeatManager.WIDTH-1),false);
        
        assertEquals(sm.getNumPax(),0);
                
        ////////
        //0,5
        sm.bookSeat(dummy,0,SeatManager.WIDTH-1);
        assertEquals(sm.isReserved(0,SeatManager.WIDTH-1),true);
        assertEquals(sm.isReserved(1,SeatManager.WIDTH-1),false);
        assertEquals(sm.isReserved(0,SeatManager.WIDTH-2),false);
        //3,0
        sm.bookSeat(dummy2,sm.getRows()-1,0);
        assertEquals(sm.isReserved(sm.getRows()-1,0),true);
        assertEquals(sm.isReserved(sm.getRows()-1,1),false);
        assertEquals(sm.isReserved(sm.getRows()-2,0),false);
        //0,3
        sm.bookSeat(dummy,0,SeatManager.WIDTH/2);
        assertEquals(sm.isReserved(0,SeatManager.WIDTH/2),true);
        assertEquals(sm.isReserved(1,SeatManager.WIDTH/2),false);
        assertEquals(sm.isReserved(0,SeatManager.WIDTH/2-1),false);
        //2,0
        sm.bookSeat(dummy2,sm.getRows()/2,0);
        assertEquals(sm.isReserved(sm.getRows()/2,0),true);
        assertEquals(sm.isReserved(sm.getRows()/2,1),false);
        assertEquals(sm.isReserved(sm.getRows()/2-1,0),false);
        //3,3
        sm.bookSeat(dummy,sm.getRows()-1,SeatManager.WIDTH/2);
        assertEquals(sm.isReserved(sm.getRows()-1,SeatManager.WIDTH/2),true);
        assertEquals(sm.isReserved(sm.getRows()-2,SeatManager.WIDTH/2),false);
        assertEquals(sm.isReserved(sm.getRows()-1,SeatManager.WIDTH/2-1),false);
        //2,5
        sm.bookSeat(dummy2,sm.getRows()/2,SeatManager.WIDTH-1);
        assertEquals(sm.isReserved(sm.getRows()/2,SeatManager.WIDTH-1),true);
        assertEquals(sm.isReserved(sm.getRows()/2,SeatManager.WIDTH-2),false);
        assertEquals(sm.isReserved(sm.getRows()/2+1,SeatManager.WIDTH-1),false);
        //2,3
        sm.bookSeat(dummy,sm.getRows()/2,SeatManager.WIDTH/2);
        assertEquals(sm.isReserved(sm.getRows()/2,SeatManager.WIDTH/2),true);
        assertEquals(sm.isReserved(sm.getRows()/2-1,SeatManager.WIDTH/2),false);
        assertEquals(sm.isReserved(sm.getRows()/2,SeatManager.WIDTH/2-1),false);
        
        //bookSeat negative test
        try {
            Person dummy3= null;
            sm.bookSeat(dummy3,1,1);
            fail();
        }
        catch(Exception e){
            assertEquals(sm.isReserved(1,1),false);
            assertEquals(e.getMessage(),SeatManager.ERROR_NULL_PASSENGER);
        }
        try {
            sm.bookSeat(dummy,3,3);
            sm.bookSeat(dummy2,3,3);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(),SeatManager.ERROR_NO_EMPTY_SEAT);
        }
        //verifyCoordinates negative test
        try {
            sm.bookSeat(dummy,-1,3);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(),SeatManager.ERROR_NEGATIVE_ROW);
        }
        try {
            sm.bookSeat(dummy,-100,3);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(),SeatManager.ERROR_NEGATIVE_ROW);
        }
        
        try {
            sm.bookSeat(dummy,3,-1);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(),SeatManager.ERROR_NEGATIVE_COLUMN);
        }
        try {
            sm.bookSeat(dummy,3,-100);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(),SeatManager.ERROR_NEGATIVE_COLUMN);
        }
              
        try {
            sm.bookSeat(dummy,sm.getSize()+1,3);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(),SeatManager.ERROR_HIGHER_ROW);
        }
        try {
            sm.bookSeat(dummy,sm.getSize()+100,3);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(),SeatManager.ERROR_HIGHER_ROW);
        }
        
        try {
            sm.bookSeat(dummy,3,SeatManager.WIDTH+1);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(),SeatManager.ERROR_HIGHER_COLUMN);
        }
        try {
            sm.bookSeat(dummy,3,SeatManager.WIDTH+100);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(),SeatManager.ERROR_HIGHER_COLUMN);
        }
    }
    
    /**
     * Test for the method: getNumPax​(byte area)
     */
    @Test
    public void getNumPaxAreaBasic(){
        SeatManager a = new SeatManager (2, 4);
        assertEquals(0,a.getNumPax(SeatManager.FIRST_CLASS));
        assertEquals(0,a.getNumPax(SeatManager.STANDARD_CLASS));
        assertEquals(0,a.getNumPax(SeatManager.ALL_CLASSES));
        
        a.loadPaxNotDistributed(2*SeatManager.WIDTH); //Fill the first class rows
        assertEquals(2*SeatManager.WIDTH,a.getNumPax(SeatManager.FIRST_CLASS));
        assertEquals(0,a.getNumPax(SeatManager.STANDARD_CLASS));
        assertEquals(2*SeatManager.WIDTH,a.getNumPax(SeatManager.ALL_CLASSES));
        
        a.loadPaxNotDistributed(4*SeatManager.WIDTH); //Fill the standard class rows
        assertEquals(2*SeatManager.WIDTH,a.getNumPax(SeatManager.FIRST_CLASS));
        assertEquals(4*SeatManager.WIDTH,a.getNumPax(SeatManager.STANDARD_CLASS));
        assertEquals((2+4)*SeatManager.WIDTH,a.getNumPax(SeatManager.ALL_CLASSES));
        
        try{
            byte b= -1;
            a.getNumPax(b);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), SeatManager.ERROR_INCORRECT_AREA);
        }
        try{
            byte b= -100;
            a.getNumPax(b);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), SeatManager.ERROR_INCORRECT_AREA);
        }
        try{
            byte b= 3;
            a.getNumPax(b);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), SeatManager.ERROR_INCORRECT_AREA);
        }
        try{
            byte b= 100;
            a.getNumPax(b);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), SeatManager.ERROR_INCORRECT_AREA);
        }
    }
    
    /**
     * Test for the method: getNumPax​(byte area, byte section)
     */
    @Test
    public void getNumPaxSectionBasic(){
        SeatManager a = new SeatManager (2, 4);
        assertEquals(0,a.getNumPax(SeatManager.FIRST_CLASS));
        assertEquals(0,a.getNumPax(SeatManager.STANDARD_CLASS));
        assertEquals(0,a.getNumPax(SeatManager.ALL_CLASSES));
        
        //Fill the frist class rows        
        a.loadPaxNotDistributed(2*SeatManager.WIDTH);
        //Check the first class windows
        assertEquals(2,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.STARBOARD_WINDOW));
        assertEquals(2,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.BOARD_WINDOW));
        assertEquals(2+2,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.BOTH_WINDOWS));
        //Check the first class aisles
        assertEquals(2,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.LEFT_AISLE));
        assertEquals(2,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.RIGHT_AISLE));
        assertEquals(2+2,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.BOTH_AISLES));
        //Check the first class
        assertEquals(2*SeatManager.WIDTH,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.EVERYWHERE));
        //Check the standard class windows
        assertEquals(0,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.STARBOARD_WINDOW));
        assertEquals(0,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.BOARD_WINDOW));
        assertEquals(0,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.BOTH_WINDOWS));
        //Check the standard class aisles
        assertEquals(0,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.LEFT_AISLE));
        assertEquals(0,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.RIGHT_AISLE));
        assertEquals(0,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.BOTH_AISLES));
        //Check the standard class
        assertEquals(0,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.EVERYWHERE));
        //Check all the  windows
        assertEquals(2,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.STARBOARD_WINDOW));
        assertEquals(2,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.BOARD_WINDOW));
        assertEquals(2+2,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.BOTH_WINDOWS));
        //Check all the aisles
        assertEquals(2,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.LEFT_AISLE));
        assertEquals(2,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.RIGHT_AISLE));
        assertEquals(2+2,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.BOTH_AISLES));
        //Check all the sections
        assertEquals(2*SeatManager.WIDTH,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.EVERYWHERE));
        
        //Filling 3 rows of the standard class
        a.loadPaxNotDistributed(3*SeatManager.WIDTH);
        //Check the first class windows
        assertEquals(2,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.STARBOARD_WINDOW));
        assertEquals(2,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.BOARD_WINDOW));
        assertEquals(2+2,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.BOTH_WINDOWS));
        //Check the first class aisles
        assertEquals(2,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.LEFT_AISLE));
        assertEquals(2,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.RIGHT_AISLE));
        assertEquals(2+2,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.BOTH_AISLES));
        //Check the first class
        assertEquals(2*SeatManager.WIDTH,a.getNumPax(SeatManager.FIRST_CLASS,SeatManager.EVERYWHERE));
        //Check the standard class windows
        assertEquals(3,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.STARBOARD_WINDOW));
        assertEquals(3,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.BOARD_WINDOW));
        assertEquals(3+3,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.BOTH_WINDOWS));
        //Check the standard class aisles
        assertEquals(3,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.LEFT_AISLE));
        assertEquals(3,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.RIGHT_AISLE));
        assertEquals(3+3,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.BOTH_AISLES));
        //Check the standard class
        assertEquals(3*SeatManager.WIDTH,a.getNumPax(SeatManager.STANDARD_CLASS,SeatManager.EVERYWHERE));
        //Check all the  windows
        assertEquals(2+3,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.STARBOARD_WINDOW));
        assertEquals(2+3,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.BOARD_WINDOW));
        assertEquals(4+6,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.BOTH_WINDOWS));
        //Check all the aisles
        assertEquals(2+3,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.LEFT_AISLE));
        assertEquals(2+3,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.RIGHT_AISLE));
        assertEquals(4+6,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.BOTH_AISLES));
        //Check all the sections
        assertEquals((2+3)*SeatManager.WIDTH,a.getNumPax(SeatManager.ALL_CLASSES,SeatManager.EVERYWHERE));
        //negative test for the area
        try{
            byte b= -1;
            a.getNumPax(b,SeatManager.EVERYWHERE);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), SeatManager.ERROR_INCORRECT_AREA);
        }
        try{
            byte b= -100;
            a.getNumPax(b,SeatManager.EVERYWHERE);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), SeatManager.ERROR_INCORRECT_AREA);
        }
        try{
            byte b= 3;
            a.getNumPax(b,SeatManager.EVERYWHERE);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), SeatManager.ERROR_INCORRECT_AREA);
        }
        try{
            byte b= 100;
            a.getNumPax(b,SeatManager.EVERYWHERE);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), SeatManager.ERROR_INCORRECT_AREA);
        }
        //negative test for the section
        try{
            byte b= -1;
            a.getNumPax(SeatManager.FIRST_CLASS,b);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), SeatManager.ERROR_INCORRECT_SECTION);
        }
        try{
            byte b= -100;
            a.getNumPax(SeatManager.FIRST_CLASS,b);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), SeatManager.ERROR_INCORRECT_SECTION);
        }
        try{
            byte b= 7;
            a.getNumPax(SeatManager.FIRST_CLASS,b);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), SeatManager.ERROR_INCORRECT_SECTION);
        }
        try{
            byte b= 100;
            a.getNumPax(SeatManager.FIRST_CLASS,b);
            fail();
        }
        catch(Exception e){
            assertEquals(e.getMessage(), SeatManager.ERROR_INCORRECT_SECTION);
        }
    }
    
    /**
     * Test for the method: loadPaxNotDistributed​(int paxNumber)
     */
     @Test
    public void loadPaxNotDistributedBasic(){
        SeatManager a= new SeatManager(2,8);
        a.loadPaxNotDistributed​(a.getSize());
        assertEquals(a.getNumPax(),a.getSize());
        
        a=new SeatManager(5,5);
        a.bookSeat(new Person(),0,0);
        a.loadPaxNotDistributed(3);
        assertEquals(a.getNumPax(),3+1);
        a=new SeatManager(5,5);
        try{
            a.loadPaxNotDistributed​(-1);
            fail();
        }
        catch(Exception e){
            assertEquals(a.getNumPax(),0);
            assertEquals(e.getMessage(),SeatManager.ERROR_NEGATIVE_PASSENGERS);
        }
        try{
            a.loadPaxNotDistributed(-100);
            fail();
        }
        catch(Exception e){
            assertEquals(a.getNumPax(),0);
            assertEquals(e.getMessage(),SeatManager.ERROR_NEGATIVE_PASSENGERS);
        }
        try{
            a.loadPaxNotDistributed(a.getSize()+1);
            fail();
        }
        catch(Exception e){
            assertEquals(a.getNumPax(),0);
            assertEquals(e.getMessage(),SeatManager.ERROR_HIGHER_PASSENGERS);
        }
        try{
            a.loadPaxNotDistributed(a.getSize()+100);
            fail();
        }
        catch(Exception e){
            assertEquals(a.getNumPax(),0);
            assertEquals(e.getMessage(),SeatManager.ERROR_HIGHER_PASSENGERS);
        }
    }
    
    /**
     * Test for the method: loadPax​(int paxNumber)
     */
    @Test
    public void loadPaxBasic(){
        SeatManager a= new SeatManager(2,8);
        a.loadPax(a.getSize());
        assertEquals(a.getNumPax(),a.getSize());
        
        a=new SeatManager(5,5);
        a.bookSeat(new Person(),0,0);
        a.loadPax(3);
        assertEquals(a.getNumPax(),3+1);
        a=new SeatManager(5,5);
        try{
            a.loadPax(-1);
            fail();
        }
        catch(Exception e){
            assertEquals(a.getNumPax(),0);
            assertEquals(e.getMessage(),SeatManager.ERROR_NEGATIVE_PASSENGERS);
        }
        try{
            a.loadPax(-100);
            fail();
        }
        catch(Exception e){
            assertEquals(a.getNumPax(),0);
            assertEquals(e.getMessage(),SeatManager.ERROR_NEGATIVE_PASSENGERS);
        }
        try{
            a.loadPax(a.getSize()+1);
            fail();
        }
        catch(Exception e){
            assertEquals(a.getNumPax(),0);
            assertEquals(e.getMessage(),SeatManager.ERROR_HIGHER_PASSENGERS);
        }
        try{
            a.loadPax(a.getSize()+100);
            fail();
        }
        catch(Exception e){
            assertEquals(a.getNumPax(),0);
            assertEquals(e.getMessage(),SeatManager.ERROR_HIGHER_PASSENGERS);
        }
    }
    
    /**
     * Test for the method: printManifest()
     */
    @Test
    public void printManifestBasic(){
        SeatManager sm=new SeatManager(2,6);
        sm.loadPax(sm.getSize()); //fill all the airplane
        sm.printManifest();
    }
    
    /**
     * Test for the method: print()
     */
    @Test
    public void printBasic(){
        SeatManager sm=new SeatManager(2,6);
        sm.loadPaxNotDistributed(2*SeatManager.WIDTH); //fill only the first 2 rows
        sm.print();
    }
    
    /**
     * Test for the methods: getYoungestAgeOnBoard(); getYoungestPeopleOnBoard()
     */
    @Test
    public void getYoungestPeopleOnBoardBasic(){
        SeatManager sm= new SeatManager(2,6);
        assertEquals(-1,sm.getYoungestAgeOnBoard());
        assertEquals(0,sm.getYoungestPeopleOnBoard().size());
        Person yuri= new Person("Yuri","Gagarin",44,Person.MALE_VALUE);
        Person buzz= new Person("Buzz","Aldrin",46,Person.MALE_VALUE);
        Person sally= new Person("Sally","Ride",44,Person.FEMALE_VALUE);
        
        sm.bookSeat(buzz,3,1);
        sm.bookSeat(yuri,0,2);
        sm.bookSeat(sally,0,4);
        
        assertEquals(2,sm.getYoungestPeopleOnBoard().size());
        assertEquals(44,sm.getYoungestAgeOnBoard());
        assertEquals(true,sm.getYoungestPeopleOnBoard().contains(yuri));
        assertEquals(false,sm.getYoungestPeopleOnBoard().contains(buzz));
        assertEquals(true,sm.getYoungestPeopleOnBoard().contains(sally));
    }
    
    /**
     * Test for the methods: countFirstClassElderlyPax(boolean gender);
     */
    @Test
    public void countFirstClassElderlyPaxBasic(){
        SeatManager sm= new SeatManager(2,6);
        assertEquals(0,sm.countFirstClassElderlyPax(Person.FEMALE_VALUE));
        assertEquals(0,sm.countFirstClassElderlyPax(Person.MALE_VALUE));
        
        Person yuri= new Person("Yuri","Gagarin",44,Person.MALE_VALUE); //no
        Person buzz= new Person("Buzz","Aldrin",65,Person.MALE_VALUE); //no
        Person paula= new Person("Paula","Gagarin",66,Person.FEMALE_VALUE); //yes
        Person sally= new Person("Sally","Ride",(Person.MAX_AGE_VALUE+66)/2,Person.FEMALE_VALUE); //yes
        Person jose= new Person("Jose","Ride",78,Person.MALE_VALUE); //yes
        Person juan= new Person("Juan","Ride",90,Person.MALE_VALUE);//yes
        Person carmen= new Person("Carmen","Aldrin",Person.MAX_AGE_VALUE,Person.FEMALE_VALUE);//yes
        
        sm.bookSeat(yuri,0,2);
        sm.bookSeat(buzz,3,1);
        sm.bookSeat(paula,0,4);
        sm.bookSeat(sally,3,2);
        sm.bookSeat(jose,1,2);
        sm.bookSeat(juan,0,5);
        sm.bookSeat(carmen,1,5);
        
        assertEquals(3,sm.countFirstClassElderlyPax(Person.FEMALE_VALUE));
        assertEquals(2,sm.countFirstClassElderlyPax(Person.MALE_VALUE));
    }

    /**
     * Test for the methods: interchangeSeats(int colA, int colB);
     */
    @Test
    public void interchangeSeatsBasic(){
        SeatManager sm= new SeatManager(2,2);
        Person yuri= new Person("Yuri","Gagarin",44,Person.MALE_VALUE);
        Person buzz= new Person("Buzz","Aldrin",65,Person.MALE_VALUE);
        Person paula= new Person("Paula","Gagarin",66,Person.FEMALE_VALUE);
        Person sally= new Person("Sally","Ride",70,Person.FEMALE_VALUE);
        Person jose= new Person("Jose","Ride",78,Person.MALE_VALUE);
        Person juan= new Person("Juan","Ride",90,Person.MALE_VALUE);
        
        sm.bookSeat(yuri,0,0);
        sm.bookSeat(buzz,sm.getRows()/2,0);
        sm.bookSeat(paula,sm.getRows()-1,0);
        sm.bookSeat(sally,0,3);
        sm.bookSeat(jose,sm.getRows()/2,3);
        sm.bookSeat(juan,sm.getRows()-1,3);
        
        sm.interchangeSeats(0,3);
        /*
        assertEquals("[Name: Yuri - Surname: Gagarin - Age: 44 - Gender: male]", sm.getReservation(0,3).toString());
        assertEquals("[Name: Buzz - Surname: Aldrin - Age: 65 - Gender: male]", sm.getReservation(sm.getRows()/2,3).toString());
        assertEquals("[Name: Paula - Surname: Gagarin - Age: 66 - Gender: female]", sm.getReservation(sm.getRows()-1,3).toString());
        assertEquals("[Name: Sally - Surname: Ride - Age: 70 - Gender: female]", sm.getReservation(0,0).toString());
        assertEquals("[Name: Jose - Surname: Ride - Age: 78 - Gender: male]", sm.getReservation(sm.getRows()/2,0).toString());
        assertEquals("[Name: Juan - Surname: Ride - Age: 90 - Gender: male]", sm.getReservation(sm.getRows()-1,0).toString());
        */
       assertArrayEquals(sm.getCol(3),new Person[]{yuri, null,buzz,paula});
       assertArrayEquals(sm.getCol(0),new Person[]{sally, null,jose,juan});
    }
    
    //Test Martin////////////////////////////////////////////////////////////////////
    @Test
    public void basicSeatManagerTest()
    {
        SeatManager a = new SeatManager (2, 8);
        a.bookSeat(new Person ("Neal", "Armstrong", 25, Person.MALE_VALUE), 3, 4);
        a.bookSeat(new Person (), 6, 2);

        assertEquals (false, a.isReserved (0, 0));
        assertEquals (true, a.isReserved (3, 4));
        assertEquals (true, a.isReserved (6, 2));

        assertEquals ("[Name: Neal - Surname: Armstrong - Age: 25 - Gender: male]", a.getReservation (3, 4).toString());

        a.releaseSeat(3, 4);
        assertEquals (false, a.isReserved (3, 4));
        assertEquals (1, a.getNumPax());
        
        for (int k=0; k<SeatManager.WIDTH; k++)
            a.bookSeat(new Person(), 7, k);
            
        assertEquals (7, a.getNumPax()); 
    }
}
