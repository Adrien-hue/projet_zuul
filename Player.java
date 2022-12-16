import java.util.HashMap;
import java.util.Stack;

/**
 * Décrivez votre classe Player ici.
 *
 * @author HOUEE Adrien
 * @version 22-12-14
 */
public class Player
{
    /**
     * Une room à portée privée
     */
    private Room          aCurrentRoom;

    /**
     * Un double à portée privée
     */
    private double        aMaxWeight;
    
    /**
     * Une pile de direction à portée privée
     */
    private Stack<Room> aRoomHistory;
    
    /**
     * Un tableau associatif (String -> Item) à portée privée
     */
    private HashMap<String, Item> aInventory;
    
    /**
     * Instanciate new default player
     */
    public Player(){
        this.aMaxWeight = 50;
        this.aRoomHistory = new Stack<Room>();
    }
    
    public void changeRoom(final Room pRoom, final boolean pToSave){
        this.setCurrentRoom(pRoom);
        
        if(pToSave){
            this.aRoomHistory.push(pRoom);
        }
    }
    
    /**
     * Retourne la Room dans laquelle le Player était précédement
     * 
     * @return Room précédente
     */
    public Room getPreviousRoom(){
        return this.aRoomHistory.peek();
    }
    
    /**
     * Replace le joueur dans la Room précédente
     */
    public void back(){
        Room vPreviousRoom = this.getPreviousRoom();
        
        this.changeRoom(vPreviousRoom, false);
        
        this.aRoomHistory.pop();
    }
    
    /**
     * Set the current player room
     * 
     * @param pRoom Room
     */
    public void setCurrentRoom(final Room pRoom){
        this.aCurrentRoom = pRoom;
    }
    
    /**
     * Set the current player max weight
     * 
     * @param pMaxWeight Max weight
     */
    public void setMaxWeight(final double pMaxWeight){
        this.aMaxWeight = pMaxWeight;
    }
    
    /**
     * Return the current room of the player
     * 
     * @return Current room
     */
    public Room getCurrentRoom(){
        return this.aCurrentRoom;
    }
    
    /**
     * Return the max weight of the player
     * 
     * @return Max weight
     */
    public double getMaxWeight(){
        return this.aMaxWeight;
    }
}
