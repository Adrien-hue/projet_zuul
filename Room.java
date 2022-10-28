 
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author votre nom
 */
public class Room
{
    private String aDescription;
    private Room aNorthExit = null;
    private Room aSouthExit = null;
    private Room aEastExit = null;
    private Room aWestExit = null;
    
    public Room(final String pDescription)
    {
        this.aDescription = pDescription;
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
        if(pDirection.equals("north")){
            return aNorthExit;
        }
        
        if(pDirection.equals("south")){
            return aSouthExit;
        }
        
        if(pDirection.equals("east")){
            return aEastExit;
        }
        
        if(pDirection.equals("west")){
            return aWestExit;
        }
        
        else{
            return null;
        }
    }
    
    /**
     * Return available exits
     * 
     * @return String with available exit
     */
    public String getExitString(){
        String vString = "You are " + this.getDescription() + "\r\n";
        
        // Display available exits
        vString += "Exits : ";
        if(this.getExit("north") != null){
            vString += "North ";
        } 
        
        if(this.getExit("south") != null){
            vString += "South ";
        }
        
        if(this.getExit("east") != null){
            vString += "East ";
        }
        
        if(this.getExit("west") != null){
            vString  += "West ";
        }
        
        return vString;
    }
    
    /**
     * Init exits
     * 
     * @param Room pNorthExit
     * @param Room pSouthExit
     * @param Room pEastExit
     * @param Room pWestExit
     */
    public void setExits(final Room pNorthExit, final Room pSouthExit, final Room pEastExit, final Room pWestExit)
    {
        this.aNorthExit = pNorthExit;
        this.aSouthExit = pSouthExit;
        this.aEastExit = pEastExit;
        this.aWestExit = pWestExit;
    } // setExists
} // Room
