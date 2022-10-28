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
    
    /**
     * Create new Room instance with description and no exit
     * 
     * @param String Description
     */
    public Room(final String pDescription)
    {
        this.aDescription = pDescription;
        this.aExits = new HashMap<String, Room>();
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
     * Return the room in the specified direction pDirection
     * 
     * @param String Direction wanted
     * @return The room in specified direction
     */
    public Room getExit(final String pDirection){
        return this.aExits.get(pDirection);
    }
    
    /**
     * Return available exits
     * 
     * @return String with available exits
     */
    public String getExitString(){
        String vString = "You are " + this.getDescription() + "\r\nExits :";
        
        Set<String> vKeys = this.aExits.keySet();
        
        for(String direction : vKeys){
            vString += " " + direction;
        }
        
        return vString;
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
} // Room
