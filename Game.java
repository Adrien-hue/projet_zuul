/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author HOUEE Adrien
 */
public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
    
    /**
     * Create new Game instance
     */
    public Game()
    {
        this.aParser= new Parser();
        
        this.createRooms();
    } // Game

    /**
     * Init all rooms we need to play the game
     */
    private void createRooms()
    {
        // Declare all the rooms
        Room vComptoir = new Room("au comptoir de le boutique.");
        Room vCaisse = new Room("à la caisse de la boutique.");
        Room vMiroir = new Room("face au miroir.");
        Room vEscalierRdC = new Room("dans les escaliers au rez-de-chaussé.");
        Room vEscalierSousSol = new Room("dans les escaliers au sous sol.");
        Room vEscalierEtage = new Room("dans les escaliers à l'étage.");
        
        Room vRayonPlanche = new Room("dans le rayon des plateaux de skateboard.");
        Room vRayonRoulement = new Room("dans le rayon des roulements.");
        Room vRayonRoue = new Room("dans le rayon des roues.");
        
        Room vRayonCruiser = new Room("dans le rayon des cruisers.");
        Room vRayonHoodie = new Room("dans le rayon des hoodies.");
        Room vRayonChaussure = new Room("dans le rayon des chaussures.");
        Room vRayonSac = new Room("dans le rayon des sacs.");

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
        
        // Init starting room
        this.aCurrentRoom = vRayonCruiser;
    } // createRooms
    
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
        if(!pCommand.hasSecondWord()){
            System.err.println("Go where ?!");
            return;
        }
        
        // Navigate in specified direction
        vNextRoom = this.aCurrentRoom.getExit(vDirection.toLowerCase());
        
        // Check if room exists in specified direction
        if(vNextRoom == null){
            System.err.println("There is no door !");
            return;
        }
        
        this.aCurrentRoom = vNextRoom;
        
        this.printLocationInfo();
    } // goRoom
    
    /**
     * Print welcome message for the player
     */
    private void printWelcome()
    {
        String vWelcome = "Welcome to the World of Zuul!\r\nWorld of Zuul is a new, incredibly boring adventure game.\r\nType 'help' if you need help.\r\n\r\n";
        
        System.out.println(vWelcome);
        
        this.printLocationInfo();
    } // printWelcome
    
    /**
     * Print help message for the player
     */
    private void printHelp()
    {
        String vHelp = "You are lost. You are alone.\r\nYou wander around at the university.\r\n\r\nYour command words are:\r\n\tgo quit help";
        
        System.out.println(vHelp);
    } // printHelp
    
    /**
     * Print location informations for the player
     */
    private void printLocationInfo(){
        String vString = this.aCurrentRoom.getLongDescription();
        
        System.out.println(vString);
    }
    
    /**
     * Quit the game
     * @param Command
     */
    private boolean quit(final Command pCommand)
    {
        return !pCommand.hasSecondWord();
    } // quit
    
    /**
     * Analyse and call function corresponding to the command
     * @param Command
     */
    private boolean processCommand(final Command pCommand)
    {
        if(pCommand.isUnknown()){
            System.out.println("I don't know what you mean...");
            return false;
        } else if(pCommand.getCommandWord().equalsIgnoreCase("quit")){
            return this.quit(pCommand);
        } else {
            if(pCommand.getCommandWord().equalsIgnoreCase("go")){
                this.goRoom(pCommand);
            } else if(pCommand.getCommandWord().equalsIgnoreCase("help")){
                this.printHelp();
            }
            return false;
        }
    } // processCommand
    
    /**
     * Play a game
     */
    public void play()
    {
        boolean vFinished = false;
        Command vInputCommand;
        
        this.printWelcome();
        
        while(!vFinished){
            vInputCommand = aParser.getCommand();
            
            vFinished = this.processCommand(vInputCommand);
        }
        
        System.out.println("Thak you for playing. Good Bye");
    } // play
} // Game
