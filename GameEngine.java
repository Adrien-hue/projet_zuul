
/**
 * Décrivez votre classe GameEngine ici.
 *
 * @author HOUEE Adrien
 * @version 22-11-21
 */
public class GameEngine
{
    private Parser        aParser;
    private Room          aCurrentRoom;
    private UserInterface aGui;
    
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.createRooms();
    }

    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    }
    
    /**
     * Init all rooms we need to play the game
     */
    private void createRooms()
    {
        // Declare all the rooms
        Room vComptoir = new Room("au comptoir de le boutique.", "images/room_comptoir.jpg");
        Room vCaisse = new Room("à la caisse de la boutique.", "");
        Room vMiroir = new Room("face au miroir.", "");
        Room vEscalierRdC = new Room("dans les escaliers au rez-de-chaussé.", "");
        Room vEscalierSousSol = new Room("dans les escaliers au sous sol.", "");
        Room vEscalierEtage = new Room("dans les escaliers à l'étage.", "");
        
        Room vRayonPlanche = new Room("dans le rayon des plateaux de skateboard.", "images/room_planches.jpg");
        Room vRayonRoulement = new Room("dans le rayon des roulements.", "images/room_roulements.jpg");
        Room vRayonRoue = new Room("dans le rayon des roues.", "images/room_roues.jpg");
        
        Room vRayonCruiser = new Room("dans le rayon des cruisers.", "images/room_cruiser.jpg");
        Room vRayonHoodie = new Room("dans le rayon des hoodies.", "images/room_hoodies.jpg");
        Room vRayonChaussure = new Room("dans le rayon des chaussures.", "images/room_chaussures.jpg");
        Room vRayonSac = new Room("dans le rayon des sacs.", "images/room_sacs.jpg");
        
        Room vMiniRampe = new Room("dans la mini-rampe.", "");
        Room vPartieStreet = new Room("dans la partie street.", "");
        
        Room vReserver = new Room("dans la réserve.", "");
        Room vToilettes= new Room("dans les toilettes.", "");

        // Init exists for each rooms
        vComptoir.setExit("south", vCaisse);
        vComptoir.setExit("west", vRayonPlanche);
        
        vCaisse.setExit("north", vComptoir);
        vCaisse.setExit("east", vRayonCruiser);
        
        vMiroir.setExit("south", vRayonHoodie);
        vMiroir.setExit("east", vEscalierRdC);
        vMiroir.setExit("west", vRayonChaussure);
        
        vEscalierRdC.setExit("south", vRayonRoue);
        vEscalierRdC.setExit("west", vMiroir);
        vEscalierRdC.setExit("up", vEscalierEtage);
        vEscalierRdC.setExit("down", vEscalierSousSol);
        
        vRayonPlanche.setExit("east", vComptoir);
        
        vRayonRoulement.setExit("north", vRayonRoue);
        vRayonRoulement.setExit("west", vRayonCruiser);
        
        vRayonRoue.setExit("north", vEscalierRdC);
        vRayonRoue.setExit("south", vRayonRoulement);

        vRayonCruiser.setExit("north", vRayonHoodie);
        vRayonCruiser.setExit("east", vRayonRoulement);
        vRayonCruiser.setExit("west", vCaisse);
        
        vRayonHoodie.setExit("north", vMiroir);
        vRayonHoodie.setExit("south", vRayonCruiser);
        
        vRayonChaussure.setExit("east", vMiroir);
        vRayonChaussure.setExit("west", vRayonSac);
        
        vRayonSac.setExit("east", vRayonChaussure);
        
        // Init Items positions
        Item vItemPlanche = new Item("Planche - Plan B", "Planche de skateboard, taille 8.25", 1.2, 65);
        vRayonPlanche.setItem(vItemPlanche);
        
        Item vItemRoulement = new Item("Roulement classique", "Roulement en acier ABEC5", 0.1, 20);
        vRayonRoulement.setItem(vItemRoulement);
        
        Item vItemRoue = new Item("Roues classiques", "Roues SpitFire", 0.3, 35);
        vRayonRoue.setItem(vItemRoue);
        
        // Init starting room
        this.aCurrentRoom = vRayonCruiser;
    } // createRooms
    
    /**
     * Print location informations for the player
     */
    private void printLocationInfo(){
        this.aGui.println(this.aCurrentRoom.getLongDescription());
        
        if ( this.aCurrentRoom.getImageName() != null ){
            this.aGui.showImage( this.aCurrentRoom.getImageName() );
        }
    }
    
    /**
     * Print welcome message for the player
     */
    private void printWelcome()
    {
        this.aGui.print( "\n" );
        this.aGui.println( "Welcome to the World of Zuul!" );
        this.aGui.println( "World of Zuul is a new, incredibly boring adventure game." );
        this.aGui.println( "Type 'help' if you need help." );
        this.aGui.print( "\n" );
        this.aGui.println( this.aCurrentRoom.getLongDescription() );
        if ( this.aCurrentRoom.getImageName() != null ){
            this.aGui.showImage( this.aCurrentRoom.getImageName() );
        }
    } // printWelcome
    
    /**
     * Print help message for the player
     */
    private void printHelp()
    {
        this.aGui.println( "You are lost. You are alone. You wander" );
        this.aGui.println( "around at Monash Uni, Peninsula Campus.\n" );
        this.aGui.println( "Your command words are: " + this.aParser.getCommandString() );
    } // printHelp
    
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }
    
    /**
     * Navigate into a room
     * 
     * @param Command Command to navigate
     */
    private void goRoom(final Command pCommand)
    {
        Room vNextRoom = null;
        String vDirection = pCommand.getSecondWord();
        
        // Check if user input direction
        if ( ! pCommand.hasSecondWord() ) {
            this.aGui.println( "Go where?" );
            return;
        }
        
        // Navigate in specified direction
        vNextRoom = this.aCurrentRoom.getExit(vDirection.toLowerCase());
        
        if ( vNextRoom == null )
            this.aGui.println( "There is no door!" );
        else {
            this.aCurrentRoom = vNextRoom;
            this.aGui.println( this.aCurrentRoom.getLongDescription() );
            if ( this.aCurrentRoom.getImageName() != null )
                this.aGui.showImage( this.aCurrentRoom.getImageName() );
        }
    } // goRoom
    
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );

        if ( vCommand.isUnknown() ) {
            this.aGui.println( "I don't know what you mean..." );
            return;
        }

        String vCommandWord = vCommand.getCommandWord();
        if ( vCommandWord.equals( "help" ) )
            this.printHelp();
        else if ( vCommandWord.equals( "go" ) )
            this.goRoom( vCommand );
        else if ( vCommandWord.equals( "quit" ) ) {
            if ( vCommand.hasSecondWord() )
                this.aGui.println( "Quit what?" );
            else
                this.endGame();
        } else if ( vCommandWord.equals( "look" ) ) {
            Item vRoomItem = this.aCurrentRoom.getItem();
            
            if(vCommand.hasSecondWord() && vCommand.getSecondWord().equals(vRoomItem.getNom())){
                this.aGui.println( vRoomItem.getLongDescription() );
            }
        }
    }
}
