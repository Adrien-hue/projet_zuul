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
        return "You are " + this.getDescription() + "\r\n" + this.getExitString();
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
} // Room
