 
/**
 * Classe Room - un lieu du jeu d'aventure Zuul.
 *
 * @author votre nom
 */
public class Room
{
    private String aDescription;
    public Room aNorthExit = null;
    public Room aSouthExit = null;
    public Room aEastExit = null;
    public Room aWestExit = null;
    
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
