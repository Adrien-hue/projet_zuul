import java.util.HashMap;
import java.util.Set;
 
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author HOUEE Adrien
 */
public class Room
{
    /**
     * Un String à portée privée
     */
    private String aDescription;
    
    /**
     * Un tableau associatif (String -> Room) à portée privée
     */
    private HashMap<String, Room> aExits;
    
    /**
     * Un String à portée privée
     */
    private String aImageName;
    
    /**
     * Un tableau associatif (String -> Item) à portée privée
     */
    private ItemList aItems;
    
    /**
     * Create new Room instance with description and no exit
     * 
     * @param pDescription Description
     * @param pImage Image path
     */
    public Room(final String pDescription, final String pImage)
    {
        this.aDescription = pDescription;
        this.aExits = new HashMap<String, Room>();
        this.aImageName = pImage;
        this.aItems = new ItemList();
    } // Room
    
    /**
     * Return Room description
     * 
     * @return String
     */
    public String getDescription()
    {
        return this.aDescription;   
    } // getDescription
    
    /**
     * Return the room description and availables exits
     * 
     * @return Room description and availables exits
     */
    public String getLongDescription(){
        StringBuilder vLongDescription = new StringBuilder("");
        
        vLongDescription.append("Vous êtes " + this.getDescription());
        vLongDescription.append("\r\n" + this.getExitString());
        if(this.aItems.size() > 0){
            vLongDescription.append("\r\n" + this.getItemString());
        }
        
        return vLongDescription.toString();
    }
    
    /**
     * Return the room in the specified direction pDirection
     * 
     * @param pDirection Direction wanted
     * @return The room in specified direction
     */
    public Room getExit(final String pDirection){
        return this.aExits.get(pDirection);
    }
    
    /**
     * Return the item in the current room
     * 
     * @param pItemName Item wanted
     * @return The item in the current room
     */
    public Item getItem(final String pItemName){
        return this.aItems.getItem(pItemName);
    }
    
    /**
     * Return available exits
     * 
     * @return String with available exits
     */
    public String getExitString(){
        StringBuilder vExitString = new StringBuilder("Sortie(s) :");
        
        Set<String> vKeys = this.aExits.keySet();
        
        for(String direction : vKeys){
            vExitString.append("\r\n*\t" + direction);
        }
        
        return vExitString.toString();
    }
    
    /**
     * Return item in the current room
     * 
     * @return String with item in the current room
     */
    public String getItemString(){
        return "Objet(s) :" + this.aItems.getItemListString();
    }
    
    /**
     * Return a string describing the room's image name
     * 
     * @return Image name
     */
    public String getImageName()
    {
        return this.aImageName;
    }
    
    /**
     * Define the exit pRoom in the specified direction pDirection
     * 
     * @param pDirection Direction
     * @param pRoom Room
     */
    public void setExit(final String pDirection, final Room pRoom){
        this.aExits.put(pDirection, pRoom);
    }
    
    /**
     * Set the room's item
     * 
     * @param pItem item to set
     */
    public void addItem(final Item pItem){
        this.aItems.addItem(pItem);
    }
    
    /**
     * delete a room item
     * 
     * @param pItem item to delete
     */
    public void deleteItem(final Item pItem){
        this.aItems.deleteItem(pItem);
    }
    
    /**
     * Check if the current Room contains pRoom 
     * 
     * @param pRoom Room to check
     * @return true if the current Room's exits contains pRoom, else false
     */
    public boolean isExit(final Room pRoom){
        return this.aExits.containsValue(pRoom);
    }
} // Room
