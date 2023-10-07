import java.util.*;

/**
 * FSim is a class that draws the map of the airplanes flying in the air and it also animates them.
 *
 * @author Paula Díaz Álvarez
 * @version 29/11/2022
 */
public class FSim
{
    /**
     * It's the symbol for the land
     */
    public final static char TERRAIN_SYMBOL='~';
    /**
     * It's the symbol for the diagonal of the radar that goes up-down (left-right)
     */
    public final static char RADAR_LEFT_DIAGONAL_SYMBOL='\\';
    /**
     * It's the symbol for the diagonal of the radar that goes down-up (left-right)
     */
    public final static char RADAR_RIGHT_DIAGONAL_SYMBOL='/';
    /**
     * It's the symbol for the vertical of the radar
     */
    public final static char RADAR_VERTICAL_SYMBOL='|';
    /**
     * It's the symbol for the horizontal of the radar
     */
    public final static char RADAR_HORIZONTAL_SYMBOL='-';
    // Attributes
    private ArrayList<Airplane> planes;
    private char[][] map;
    /**
     * Constructor that sets the limits of the map acording to the Y_SOUTH_BORDER, Y_NORTH_BORDER, X_EAST_BORDER and X_WEST_BORDER
     * defined on the Airplane class
     */
    public FSim() {
        planes=new ArrayList<Airplane> ();
        map= new char[Airplane.Y_SOUTH_BORDER-Airplane.Y_NORTH_BORDER +1][Airplane.X_EAST_BORDER-Airplane.X_WEST_BORDER +1]; //11 x 11
    }
    
    /**
     * Adds a givne airplane to the map
     * @param plane It's the airplane that is going to be added
     */
    public void add(Airplane plane){
        planes.add(plane);
    }
    
    /**
     * It sets the background of the map (the land and the radar)
     */
    private void paintBackground() {
        for (int i=0 ; i<map.length ; i++) {
            for (int j=0 ; j<map[0].length ; j++) {
                if (j==Airplane.X_EAST_BORDER-i){
                    map[i][j]=RADAR_RIGHT_DIAGONAL_SYMBOL;                
                }
                else if (i==Airplane.Y_SOUTH_BORDER/2){
                    map[i][j]=RADAR_HORIZONTAL_SYMBOL;
                }
                else if(j==Airplane.X_EAST_BORDER/2){
                    map[i][j]=RADAR_VERTICAL_SYMBOL;
                }
                else if (i==j){
                    map[i][j]=RADAR_LEFT_DIAGONAL_SYMBOL;
                }
                else {
                    map[i][j]=TERRAIN_SYMBOL;
                }
            }
        }
    }
    
    /**
     * It sets the airplanes on the map according to their positions
     */
    private void paintForegroung(){
        for (Airplane plane:planes){
            map[plane.getYPos()][plane.getXPos()]=plane.getID();
        }
    }
    
    /**
     * It prints the map with the background and the airplanes
     */
    private void paint(){
        paintBackground();
        paintForegroung();
        //print the image
        for (int i=0 ; i<map.length ; i++) {
            for (int j=0 ; j<map[0].length ; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    
    /**
     * It prints the map with the background and the airplanes a given number of times while their airplanes are moving in each
     * frame
     * @param frames It's the number of times thath the map will be painted and the number of times the airplanes will fly
     */
    public void animate (int frames){
        for (int i=0; i<frames; i++){
            System.out.println("*** - FRAME: "+i+" ***");
            paint();
            System.out.println();
            for (Airplane plane:planes){
                plane.fly();
            }
        }
    }
}
