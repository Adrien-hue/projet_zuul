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
    // private HashMap<String, Item> aInventory;
    
    /**
     * Une liste d'Item
     */
    private ItemList aInventory;
    
    /**
     * Instanciate new default player
     */
    public Player(){
        this.aMaxWeight = 1;
        this.aRoomHistory = new Stack<Room>();
        this.aInventory = new ItemList();
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
        this.aCurrentRoom.deleteItem(pItem);
        
        this.aInventory.addItem(pItem);
    }
    
    /**
     * Drop an Item in a Room
     * 
     * @param pItem Item to drop
     */
    public void drop(final Item pItem){
        this.aInventory.deleteItem(pItem);
        
        this.aCurrentRoom.addItem(pItem);
    }
    
    /**
     * Eat and Item
     * 
     * @param pItem Item to eat
     */
    public void eat(final Item pItem){
        if(pItem.getNom().equals("Space_cookie")){
            this.aMaxWeight *= 2;
        }
        
        this.aCurrentRoom.deleteItem(pItem);
    }
    
    /**
     * Return the inventory string
     * 
     * @return Inventory
     */
    public String getInventoryString(){
        return "Inventaire : (" + this.getCurrentWeight() + "/" + this.getMaxWeight() + ")\r\n" + this.aInventory.getItemListString();
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
     * Retourne l'inventaire aInventory
     * 
     * @return L'inventaire aIventory
     */
    public ItemList getInventory(){
        return this.aInventory;
    }
    
    /**
     * Return the item in the current room
     * 
     * @param pItemName Item wanted
     * @return The item in the current room
     */
    public Item getItem(final String pItemName){
        return this.aInventory.getItem(pItemName);
    }
    
    /**
     * Retourne le poid de l'inventaire aInventory du Player
     * 
     * @return Poid de aInventory
     */
    public double getCurrentWeight(){
        return this.aInventory.getWeight();
    }
}
