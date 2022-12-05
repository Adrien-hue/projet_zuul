import java.util.HashMap;
import java.util.Set;
 
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author HOUEE Adrien
 */
public class Room
{
    private String aDescription;
    private HashMap<String, Room> aExits;
    private String aImageName;
    private Item aItem;
    
    /**
     * Create new Room instance with description and no exit
     * 
     * @param String Description
     */
    public Room(final String pDescription, final String pImage)
    {
        this.aDescription = pDescription;
        this.aExits = new HashMap<String, Room>();
        this.aImageName = pImage;
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
        
        vLongDescription.append("You are " + this.getDescription());
        vLongDescription.append("\r\n" + this.getExitString());
        if(this.getItem() != null){
            vLongDescription.append("\r\n" + this.getItemString());
        }
        
        return vLongDescription.toString();
    }
    
    /**
     * Return the room in the specified direction pDirection
     * 
     * @param String Direction wanted
     * @return The room in specified direction
     */
    public Room getExit(final String pDirection){
        return this.aExits.get(pDirection);
    }
    
    /**
     * Return the item in the current room
     * 
     * @return The item in the current room
     */
    public Item getItem(){
        return this.aItem;
    }
    
    /**
     * Return available exits
     * 
     * @return String with available exits
     */
    public String getExitString(){
        StringBuilder vExitString = new StringBuilder("Exits :");
        
        Set<String> vKeys = this.aExits.keySet();
        
        for(String direction : vKeys){
            vExitString.append(" " + direction);
        }
        
        return vExitString.toString();
    }
    
    /**
     * Return item in the current room
     * 
     * @return String with item in the current room
     */
    public String getItemString(){
        StringBuilder vExitString = new StringBuilder("Items :");
        
        vExitString.append(" " + this.aItem.getNom());
        
        return vExitString.toString();
    }
    
    /**
     * Return a string describing the room's image name
     */
    public String getImageName()
    {
        return this.aImageName;
    }
    
    /**
     * Define the exit pRoom in the specified direction pDirection
     * 
     * @param String Direction
     * @param String Room
     */
    public void setExit(final String pDirection, final Room pRoom){
        this.aExits.put(pDirection, pRoom);
    }
    
    /**
     * Set the room's item
     * 
     * @params Item item to set
     */
    public void setItem(final Item pItem){
        this.aItem = pItem;
    }
} // Room
