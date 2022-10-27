package v1;

/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author votre nom
 */
public class Game
{
    private Room aCurrentRoom;
    private Parser aParser;
    
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
        Room vOutside = new Room("outside the main entrance of the university");
        Room vTheatre = new Room("in a lecture theatre");
        Room vPub = new Room("in the campus pub");
        Room vLab = new Room("in a computing lab");
        Room vOffice = new Room("in the computing admin office");
        
        // Init exists for each rooms
        vOutside.setExits(null, vLab, vTheatre, vPub);
        vTheatre.setExits(null, null, null, vOutside);
        vPub.setExits(null, null, vOutside, null);
        vLab.setExits(vOutside, null, vOffice, null);
        vOffice.setExits(null, null, null, vLab);
        
        // Init starting room
        this.aCurrentRoom = vOutside;
    } // createRooms
    
    /**
     * 
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
        if(vDirection.equalsIgnoreCase("north")){
            vNextRoom = this.aCurrentRoom.aNorthExit;
        } else if(vDirection.equalsIgnoreCase("south")){
            vNextRoom = this.aCurrentRoom.aSouthExit;
        } else if(vDirection.equalsIgnoreCase("east")){
            vNextRoom = this.aCurrentRoom.aEastExit;
        } else if(vDirection.equalsIgnoreCase("west")){
            vNextRoom = this.aCurrentRoom.aWestExit;
        } else {
            System.err.println("Unknown direction !");
        }
        
        // Check if room exists in specified direction
        if(vNextRoom == null){
            System.err.println("There is no door !");
            return;
        }
        
        this.aCurrentRoom = vNextRoom;
        System.out.println("You are currently " + this.aCurrentRoom.getDescription());
        
        // Display available exits
        System.out.print("you can go : ");
        if(this.aCurrentRoom.aNorthExit != null){
            System.out.print("North ");
        } 
        
        if(this.aCurrentRoom.aSouthExit != null){
            System.out.print("South ");
        }
        
        if(this.aCurrentRoom.aEastExit != null){
            System.out.print("East ");
        }
        
        if(this.aCurrentRoom.aWestExit != null){
            System.out.print("West ");
        }
        
        System.out.print("\n");
    } // goRoom
    
    /**
     * Print welcome message for the player
     */
    private void printWelcome()
    {
        String vWelcome = "Welcome to the World of Zuul!\r\nWorld of Zuul is a new, incredibly boring adventure game.\r\nType 'help' if you need help.\r\n\r\n";
        
        vWelcome += "You are " + this.aCurrentRoom.getDescription() + "\r\n";
        
        // Display available exits
        vWelcome += "Exits : ";
        if(this.aCurrentRoom.aNorthExit != null){
            vWelcome += "North ";
        } 
        
        if(this.aCurrentRoom.aSouthExit != null){
            vWelcome += "South ";
        }
        
        if(this.aCurrentRoom.aEastExit != null){
            vWelcome += "East ";
        }
        
        if(this.aCurrentRoom.aWestExit != null){
            vWelcome  += "West ";
        }
        
        System.out.println(vWelcome);
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
     * ??
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
