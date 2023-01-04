import java.util.HashMap;
import java.util.Stack;
import java.util.Set;

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
        this.aInventory = new HashMap<String, Item>();
    }
    
    public void changeRoom(final Room pRoom, final boolean pToSave){
        if(pToSave){
            this.aRoomHistory.push(this.aCurrentRoom);
        }
        
        this.setCurrentRoom(pRoom);
    }
    
    /**
     * Retourne la Room dans laquelle le Player était précédement
     * 
     * @return Room précédente
     */
    public Room getPreviousRoom(){
        if(this.aRoomHistory.empty()){
            return null;
        } else {
            return this.aRoomHistory.peek();
        }
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
     * Take an Item in a Room
     * 
     * @param pItem Item to take
     */
    public void take(final Item pItem){
        this.aCurrentRoom.deleteItem(pItem.getNom());
        
        this.aInventory.put(pItem.getNom(), pItem);
    }
    
    /**
     * Drop an Item in a Room
     * 
     * @param pItem Item to drop
     */
    public void drop(final Item pItem){
        this.aInventory.remove(pItem.getNom());
        
        this.aCurrentRoom.addItem(pItem);
    }
    
    /**
     * Return the inventory string
     * 
     * @return Inventory
     */
    public String getInventoryString(){
        StringBuilder vIventoryString = new StringBuilder("Inventaire :");
        
        if(this.aInventory.size() > 0){
            Set<String> vKeys = this.aInventory.keySet();
        
            for(String item : vKeys){
                vIventoryString.append(" " + item);
            }
        } else {
            vIventoryString.append(" vide");
        }
        
        return vIventoryString.toString();
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
    
    /**
     * Return the item in the current room
     * 
     * @param pItemName Item wanted
     * @return The item in the current room
     */
    public Item getItem(final String pItemName){
        return this.aInventory.get(pItemName);
    }
}