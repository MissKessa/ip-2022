import java.util.*;

/**
 * This class models the SeatManager of the Airplane where you can set the size of it; sit passengers; fill the airplane;
 * print the seats...
 *
 * @Paula Díaz Álvarez
 * @15/11/2022
 */
public class SeatManager
{
    /**
     * They are the letters of the columns of the seats
     */
    public final static char SEAT_LABELS[]= {'A','B','C','D','E','F'};
    /**
     * It's the symbol for the empty seats
     */
    public final static char EMPTY_SYMBOL='?';
    /**
     * It's the symbol for the seats where an adult is sit
     */
    public final static char ADULT_SYMBOL='X';
    /**
     * It's the symbol for the seats where a child is sit
     */
    public final static char CHILDREN_SYMBOL='C';
    /**
     * It's the width of the seats (the number of columns)
     */
    public final static int WIDTH=6;//columns
    //Error messages
    /**
     * It's the error message thrown when the number of first Class Rows is negative
     */
    public final static String ERROR_NEGATIVE_FIRST_CLASS="The firstClassRows must be positive";
    /**
     * It's the error message thrown when the number of standard Class Rows is negative
     */
    public final static String ERROR_NEGATIVE_STANDARD_CLASS="The standardClassRows must be positive";
    /**
     * It's the error message thrown when you want to access a row that is negative
     */
    public final static String ERROR_NEGATIVE_ROW="The row number can not be negative";
    /**
     * It's the error message thrown when you want to access a row that is greater than the number of rows in the seatManager
     */
    public final static String ERROR_HIGHER_ROW="The row number can not be higher than the length of the aircraft";
    /**
     * It's the error message thrown when you want to access a column that is negative
     */
    public final static String ERROR_NEGATIVE_COLUMN="The column number can not be negative";
    /**
     * It's the error message thrown when you want to access a column that is greater than the number of columns in the seatManage
     */
    public final static String ERROR_HIGHER_COLUMN="The column number can not be higher than the width of the aircraft";
    /**
     * It's the error message thrown when you want to sit a Person that is null
     */
    public final static String ERROR_NULL_PASSENGER="The value for the person can not be null";
    /**
     * It's the error message thrown when you want to reserved a seat that is not empty
     */
    public final static String ERROR_NO_EMPTY_SEAT="The seat is not empty";
    /**
     * It's the error message thrown when you want to access an area that doesn't exist
     */
    public final static String ERROR_INCORRECT_AREA="The area must be FIRST_CLASS,STANDARD_CLASS or ALL_CLASSES";
    /**
     * It's the error message thrown when you want to access a section that doesn't exist
     */
    public final static String ERROR_INCORRECT_SECTION=
    "The section must be STARBOARD_WINDOW, BOARD_WINDOW, BOTH_WINDOWS, LEFT_AISLE, RIGHT_AISLE, BOTH_AISLES or EVERYWHERE";
    /**
     * It's the error message thrown when you want to sit a negative number of passengers
     */
    public final static String ERROR_NEGATIVE_PASSENGERS="The number of passengers must be greater than 0";
    /**
     * It's the error message thrown when you want to sit a number of passengers that is greater than the number of seats available
     */
    public final static String ERROR_HIGHER_PASSENGERS="There aren't enough seats";
    
    //Areas and sections
    /**
     * It's the value assigned to the first class area
     */
    public final static byte FIRST_CLASS=0;
    /**
     * It's the value assigned to the standard class area
     */
    public final static byte STANDARD_CLASS=1;
    /**
     * It's the value assigned to the area of all the classes
     */
    public final static byte ALL_CLASSES=2;
    /**
     * It's the value assigned to the starboard window section
     */
    public final static byte STARBOARD_WINDOW= 0;
    /**
     * It's the value assigned to the board window section
     */
    public final static byte BOARD_WINDOW= 1; 
    /**
     * It's the value assigned to the section of boath windows
     */
    public final static byte BOTH_WINDOWS= 2;
    /**
     * It's the value assigned to the left aisle section
     */
    public final static byte LEFT_AISLE= 3;
    /**
     * It's the value assigned to the right aisle section
     */
    public final static byte RIGHT_AISLE= 4;
    /**
     * It's the value assigned to the section of both aisles
     */
    public final static byte BOTH_AISLES= 5;
    /**
     * It's the value assigned to all the sections
     */
    public final static byte EVERYWHERE= 6;
    //Attributes
    private Person[][] seats;
    private int firstClassRows;
    
    /**
     * Constructor that creates a SeatManger with a given number of first class rows and a given number of standard class rows.
     * If this numbers are negative, an error will appear
     * @param firstClassRows It's the number of first class rows that will have the SeatManager
     * @param standardClassRows It's the number of standard class rows that will have the SeatManager
     */
    public SeatManager(int firstClassRows, int standardClassRows) {
        checkParam(firstClassRows>=0,ERROR_NEGATIVE_FIRST_CLASS);
        checkParam(standardClassRows>=0,ERROR_NEGATIVE_STANDARD_CLASS);
        
        seats = new Person [firstClassRows+standardClassRows][WIDTH];
        this.firstClassRows = firstClassRows;
    }
    
    //EXCEPTIONS
    /**
     * Throws a given error message if the given condition is not true
     * @param condition It's the condition that is going to be checked
     * @param message It's the error message that will be thrown if the condition is not true
     */
    private void checkParam (boolean condition, String message) {
        if (!condition)
            throw new RuntimeException (message);
    }
    
    /**
     * Throws an error message if the coordinates are wrong.
     * @param row It's the number of the row that is going to be checked
     * @param col It's the number of the column that is going to be checked
     * @return True if all the tests pass
     */
    private boolean verifyCoordinates (int row,int col){
        verifyCol(col);
        verifyRow(row);
        return true;
    }
    
    /**
     * Throws an error message if the coordinates of the column are wrong
     * @param col It's the number of the column that is going to be checked
     * @return True if all the tests pass
     */
    private boolean verifyCol (int col){
        checkParam(col>=0,ERROR_NEGATIVE_COLUMN);
        checkParam(col<WIDTH,ERROR_HIGHER_COLUMN);
        return true;
    }
    
    /**
     * Throws an error message if the coordinates are wrong.
     * @param row It's the number of the row that is going to be checke
     * @return True if all the tests pass
     */
    private boolean verifyRow (int row){
        checkParam(row>=0,ERROR_NEGATIVE_ROW);
        checkParam(row<seats.length,ERROR_HIGHER_ROW);
        return true;
    }
    
    //getters and setters
    /**
     * Returns the number of rows that are in the airplane
     * @return The number of rows that are in the airplane
     */
    public int getRows(){
        return seats.length;
    }
    /**
     * Returns the number of first class rows that are in the airplane
     * @return The number of first class rows that are in the airplane
     */
    public int getRowsFirstClass(){
        return firstClassRows;
    }
    /**
     * Returns the number of standard class rows that are in the airplane
     * @return The number of standard class rows that are in the airplane
     */
    public int getRowsStandardClass(){
        return (seats.length-firstClassRows);
    }
    
    /**
     * Returns the number of seats that are in the airplane
     * @return The number of seats that are in the airplane
     */
    public int getSize(){ 
        return seats.length*WIDTH;
        //return seats.length*seats[0].length;
    }
    /**
     * Returns the number of first class seats that are in the airplane
     * @return The number of first class seats that are in the airplane
     */
    public int getSizeFirstClass(){
        return firstClassRows*WIDTH;
    }
    /**
     * Returns the number of standard class seats that are in the airplane
     * @return The number of standard class seats that are in the airplane
     */
    public int getSizeStandardClass(){
        //return getSize()-getSizeFirstClass();
        return (seats.length-firstClassRows)*WIDTH;
    }
    
    /**
     * Assigns a given seat to a given person when the seat exists and the seat is not already reserved. If not a error message
     * will appear.
     * @param person It's the person that books that seat
     * @param row It's the number of the row of the seat
     * @param col It's the number of the column of the seat
     */
    public void bookSeat (Person person, int row, int col){
        verifyCoordinates(row,col);
        checkParam(person!=null,ERROR_NULL_PASSENGER);
        checkParam(seats[row][col]==null, ERROR_NO_EMPTY_SEAT);
        
        seats[row][col]=person;
    }
    /**
     * Checks if a given seat is reserved or not.
     * @param row It's the number of the row of the seat
     * @param col It's the number of the column of the seat
     * @return True if the seat is not empty (not reserved)
     */
    public boolean isReserved (int row, int col){
        verifyCoordinates(row,col);
        return seats[row][col] !=null;
    }
    /**
     * Returns the Person that has booked the seat
     * @param row It's the number of the row of the seat
     * @param col It's the number of the column of the seat
     * @return The person that has booked the seat
     */
    public Person getReservation (int row, int col){
        verifyCoordinates(row,col);
        return seats[row][col];
    }
    /**
     * Releases a given seat (cancels the reservation)
     * @param row It's the number of the row of the seat
     * @param col It's the number of the column of the seat
     */
    public void releaseSeat (int row, int col){
        verifyCoordinates(row,col);
        seats[row][col]=null;
    }
    /**
     * Returns the number of passengers of all the Airplane
     * @return The number of passengers
     */
    public int getNumPax(){
        int counter=0;
        for (int i=0 ; i<seats.length ; i++) {
            for (int j=0 ; j <WIDTH ; j++){
                if (seats[i][j]!=null){
                    counter+=1;
                }
            }
        } 
        return counter;
    }
    /**
     * Returns the number of passengers of a given area that can be: FIRST_CLASS, STANDARD_CLASS or ALL_CLASSES
     * @param area It's the area where do you want to count the passengers
     * @return The number of passengers of that area
     */
    public int getNumPax(byte area){
        int counter=0;
        checkParam(area==FIRST_CLASS || area==STANDARD_CLASS ||area==ALL_CLASSES, ERROR_INCORRECT_AREA);
        for (int i=0 ; i<seats.length ; i++) {
            if (area==FIRST_CLASS && i>=firstClassRows){
                break;
            }
            else if (area==STANDARD_CLASS && i<firstClassRows){
                continue;
            }
            for (int j=0 ; j <WIDTH ; j++){
                if (seats[i][j]!=null){
                    counter+=1;
                }
            }
        }
        return counter;
    }
    
    /**
     * Returns the number of passengers of a given area that can be: FIRST_CLASS, STANDARD_CLASS or ALL_CLASSES
     * and a given section that can be: STARBOARD_WINDOW (right), BOARD_WINDOW (left), BOTH_WINDOWS, LEFT_AISLE, RIGHT_AISLE, 
     * BOTH_AISLES or EVERYWHERE
     * @param area It's the area where do you want to count the passengers
     * @param section It's the section where do you want to count the passengers
     * @return The number of passengers of that area and that section
     */
    public int getNumPax(byte area,byte section){
        int counter=0;
        checkParam(area==FIRST_CLASS || area==STANDARD_CLASS ||area==ALL_CLASSES,ERROR_INCORRECT_AREA);
        checkParam(section==STARBOARD_WINDOW || section==BOARD_WINDOW ||section==BOTH_WINDOWS || section==LEFT_AISLE ||
        section==RIGHT_AISLE || section==BOTH_AISLES || section==EVERYWHERE,ERROR_INCORRECT_SECTION);
        for (int i=0 ; i<seats.length ; i++) {
            //checking area
            if (area==FIRST_CLASS && i>=firstClassRows){
                break;
            }
            else if (area==STANDARD_CLASS && i<firstClassRows){
                continue;
            }
            //checking section
            if (section==STARBOARD_WINDOW && seats[i][WIDTH-1]!=null) {
                counter+=1;
            }
            else if (section==BOARD_WINDOW && seats[i][0]!=null) {
                counter+=1;
            }
            else if (section==BOTH_WINDOWS) {
                if (seats[i][0]!=null){
                    counter+=1;
                }
                if (seats[i][WIDTH-1]!=null){
                    counter+=1;
                }
            }
            else if (section==LEFT_AISLE && seats[i][WIDTH/2 -1]!=null) {
                counter+=1;
            }
            else if (section==RIGHT_AISLE && seats[i][WIDTH/2]!=null) {
                counter+=1;
            }
            else if (section==BOTH_AISLES) {
                if (seats[i][WIDTH/2 -1]!=null){
                    counter+=1;
                }
                if (seats[i][WIDTH/2]!=null){
                    counter+=1;
                }
            }
            else{
                for (int j=0 ; j <WIDTH ; j++){
                    if (seats[i][j]!=null){
                        counter+=1;
                    }
                }
            }
        }
        return counter;
    }
    
    /**
     * Fills in order the airplane with a given number of virtual passengers
     * @param paxNumber It's the number of passengers that you want to sit
     */
    public void loadPaxNotDistributed(int paxNumber){
        checkParam(paxNumber>0, ERROR_NEGATIVE_PASSENGERS);
        //checkParam(paxNumber<=getSize(), "The number of passengers must be less than or equal to the number of seats");
        checkParam(getNumPax()+paxNumber<=getSize(), ERROR_HIGHER_PASSENGERS);
        for (int i=0 ; i<seats.length && paxNumber>0; i++) {
            for (int j=0 ; j <WIDTH && paxNumber>0; j++){
                if (seats[i][j]==null){ //faster than using !isReserved()
                    seats[i][j]=new Person();
                    paxNumber--;
                }
            }
        }
    }
    
    /**
     * Fills distributed(randomly) the airplane with a given number of virtual passenger
     * @param paxNumber It's the number of passengers that you want to sit
     */
    public void loadPax(int paxNumber){
        checkParam(paxNumber>0, ERROR_NEGATIVE_PASSENGERS);
        //checkParam(paxNumber<=getSize(), "The number of passengers must be less than or equal to the number of seats");
        checkParam(getNumPax()+paxNumber<=getSize(), ERROR_HIGHER_PASSENGERS);
        Random coin=new Random();
        while (paxNumber>0){
            int row=coin.nextInt(seats.length);
            int col=coin.nextInt(WIDTH);
            if (seats[row][col]==null){ //faster than using !isReserved()
                seats[row][col]=new Person();
                paxNumber--;
            }
        }
    }
    
    /**
     * Prints the manifest of the airplane. It's divided by class and it shows the seat, name, surname  and age of every passenger
     */
    public void printManifest(){
        System.out.println("MANIFEST");
        System.out.println();
        System.out.println("FIRST CLASS");
        for (int i=0 ; i<seats.length ; i++) {
            if (i==firstClassRows){
                System.out.println();
                System.out.println("STANDARD CLASS");
            }
            for (int j=0 ; j <WIDTH ; j++){
                if (seats[i][j]!=null){
                    System.out.print("ROW: "+i);
                    System.out.print(" SEAT: "+SEAT_LABELS[j]);
                    System.out.print(" - "+seats[i][j].getName().toUpperCase());
                    System.out.print(" "+seats[i][j].getSurname().toUpperCase());
                    System.out.println(" - AGE: "+seats[i][j].getAge());
                }
            }
        }
    }
    
    /**
     * Prints a drawing of the seats of the airplane indicating the empty seats, adults and children
     */
    public void print(){
        //HEADER
        System.out.print("  ");
        for (int i=0; i<SEAT_LABELS.length ; i++){
            if (i==SEAT_LABELS.length/2){
                System.out.print("  ");
            }
            System.out.print(SEAT_LABELS[i]+" ");
        }
        System.out.println();
        //BODY
        for (int i=0 ; i<seats.length ; i++){
            if (i==firstClassRows){
                for (int k=0 ; k<WIDTH+2 ; k++){
                    System.out.print("--");
                }
                System.out.println();
            }
            System.out.print(i+" ");
            for (int j=0 ; j <WIDTH ; j++){ //j< seats[0].length
                if (j==WIDTH/2){
                    System.out.print("  ");
                }
                if (seats[i][j]==null){
                    System.out.print(EMPTY_SYMBOL+" ");
                }
                else if (seats[i][j].getAge()>=Person.ADULTHOOD_AGE) {
                    System.out.print(ADULT_SYMBOL+" ");
                }
                else{
                    System.out.print(CHILDREN_SYMBOL+" ");
                }
            }
            System.out.println();
        }
    }
    
    /**
     * Returns the youngest age on board
     * @return The youngest age. Returns -1 if there's nobody on board
     */
    public int getYoungestAgeOnBoard(){
        int youngestAge=Person.MAX_AGE_VALUE+1;
        for (int i=0 ; i<seats.length; i++) {
            for (int j=0 ; j <WIDTH; j++){
                if (seats[i][j]!=null){
                    if (seats[i][j].getAge()<youngestAge) {
                        youngestAge=seats[i][j].getAge();
                    }
                }
            }
        }
        if (youngestAge==Person.MAX_AGE_VALUE+1){
            return -1;
        }
        return youngestAge;
    }
    
    /**
     * Returns a list containing the youngest people on board
     * @return A list containing the youngest people on board
     */
    public ArrayList<Person> getYoungestPeopleOnBoard(){
        int youngestAge=getYoungestAgeOnBoard();
        ArrayList<Person> youngestPeople=new ArrayList<Person>();
        for (int i=0 ; i<seats.length; i++) {
            for (int j=0 ; j <WIDTH; j++){
                if (seats[i][j]!=null){
                    if (seats[i][j].getAge()==youngestAge) {
                        youngestPeople.add(seats[i][j]);
                    }
                }
            }
        }
        return youngestPeople;
        /*
        ArrayList<Person> youngestPeople=new ArrayList<Person>();
        for (int i=0 ; i<seats.length; i++) {
            for (int j=0 ; j <WIDTH; j++){
                if (seats[i][j]!=null){
                    if (seats[i][j].getAge()<youngestAge) {
                        youngestAge=seats[i][j].getAge();
                        youngestPeople=new ArrayList<Person>();
                        
                    if (seats[i][j].getAge()==youngestAge) {
                        youngestPeople.add(seats[i][j]);
                    }
                }
            }
        }
        return youngestPeople;
         */
    }
    
    /**
     * Counts the number of passengers in the first class (by gender) whose age is over 65
     * @param gender It's the gender of the passengers that you are going to check if the are over 65
     * @return The number of passengers in the first class (by gender) whose age is over 65
     */
    public int countFirstClassElderlyPax(boolean gender){
        int counter=0;
        for (int i=0 ; i<seats.length; i++) {
            for (int j=0 ; j <WIDTH; j++){
                if (seats[i][j]!=null){
                    if (seats[i][j].getAge()>65 && seats[i][j].getGender()==gender) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
    
    /**
     * Returns the given row as a list of passengers
     * @param row It's the given row
     * @return It's the list of passengers in the row
     */
    protected Person[] getRow(int row){
        return seats[row];
    }
    
    /**
     * Returns the given column as a list of passengers
     * @param col It's the given col
     * @return It's the list of passengers in the col
     */
    protected Person[] getCol(int col){
        Person[] passengers = new Person[seats.length];
        for (int i=0 ; i<seats.length; i++){
            passengers[i]=seats[i][col];
        }
        return passengers;
    }
    
    /**
     * Interchanges the seats of the passengers in A and B
     * @param colA It's one of the given columns
     * @param colB It's the other given column
     */
    public void interchangeSeats(int colA, int colB){
        verifyCol(colA);
        verifyCol(colB);
        /*
        Person[] columnA= new Person[seats.length];
        Person[] columnB= new Person[seats.length];
        */
        for (int i=0 ; i<seats.length; i++) {
            Person aux=seats[i][colA];
            seats[i][colA]=seats[i][colB];
            seats[i][colB]=aux;
            /*
            columnA[i]=seats[i][colA];
            columnB[i]=seats[i][colB];
            for (int j=0 ; j <WIDTH; j++){
                if (j==colA){
                    seats[i][j]=columnB[i];
                }
                else if (j==colB){
                    seats[i][j]=columnA[i];
                }
            }
            */
        }
    }
}
