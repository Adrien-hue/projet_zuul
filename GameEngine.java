import java.util.Stack;
import java.io.FileReader; 
import java.io.BufferedReader; 
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Décrivez votre classe GameEngine ici.
 *
 * @author HOUEE Adrien
 * @version 22-11-21
 */
public class GameEngine
{
    /**
     * Un parser à portée privée
     */
    private Parser        aParser;
    
    /**
     * Un player à portée
     */
    private Player        aPlayer;
    
    /**
     * Une interface utilisateur à portée privée
     */
    private UserInterface aGui;
    
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        this.aParser = new Parser();
        this.aPlayer = new Player();
        this.createRooms();
    }

    /**
     * Set up grahic user interface
     * 
     * @param pUserInterface User interface
     */
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
        
        Room vReserve = new Room("dans la réserve.", "");
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
        
        vToilettes.setExit("north", vEscalierEtage);
        
        vReserve.setExit("east", vEscalierEtage);
        
        vEscalierEtage.setExit("down", vEscalierRdC);
        vEscalierEtage.setExit("south", vToilettes);
        vEscalierEtage.setExit("west", vReserve);
        
        vPartieStreet.setExit("north", vEscalierSousSol);
        
        vMiniRampe.setExit("east", vEscalierSousSol);
        
        vEscalierSousSol.setExit("up", vEscalierRdC);
        vEscalierSousSol.setExit("south", vPartieStreet);
        vEscalierSousSol.setExit("west", vMiniRampe);
        
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
        Item vItemPlanche_PlanB = new Item("Planche-Plan_B", "Planche de skateboard, taille 8.25", 1.2, 65);
        Item vItemPlanche_Girl = new Item("Planche-Girl", "Planche de skateboard, taille 8.25", 1.2, 55);
        vRayonPlanche.addItem(vItemPlanche_PlanB);
        vRayonPlanche.addItem(vItemPlanche_Girl);
        
        Item vItemRoulement = new Item("Roulement_classique", "Roulement en acier ABEC5", 0.1, 20);
        vRayonRoulement.addItem(vItemRoulement);
        
        Item vItemRoue = new Item("Roues_classiques", "Roues SpitFire", 0.3, 35);
        vRayonRoue.addItem(vItemRoue);
        
        // Init starting room
        this.aPlayer.setCurrentRoom(vRayonCruiser);
    } // createRooms
    
    /**
     * Print location informations for the player
     */
    private void printLocationInfo(){
        this.aGui.println(this.aPlayer.getCurrentRoom().getLongDescription());
        
        if ( this.aPlayer.getCurrentRoom().getImageName() != null ){
            this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
        }
    }
    
    /**
     * Print welcome message for the player
     */
    private void printWelcome()
    {
        this.aGui.print( "\n" );
        this.aGui.println( "Bienvenue à SnowBeach!" );
        this.aGui.println( "C'est une boutique exceptionnel pour le skateboard." );
        this.aGui.println( "Tapez 'help' si vous avez besoin d'aide." );
        this.aGui.print( "\n" );
        this.aGui.println( this.aPlayer.getCurrentRoom().getLongDescription() );
        if ( this.aPlayer.getCurrentRoom().getImageName() != null ){
            this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
        }
    } // printWelcome
    
    /**
     * Print help message for the player
     */
    private void printHelp()
    {
        this.aGui.println( "Vous êtes perdu ? Vous êtes seul, les vendeurs sont occupés. Vous vous baladez" );
        this.aGui.println( "dans la boutique SnowBeach.\n" );
        this.aGui.println( "Les commandes disponibles sont: " + this.aParser.getCommandString() );
    } // printHelp
    
    
    /**
     * End the game
     */
    private void endGame()
    {
        this.aGui.println( "Merci d'avoir jouer. Au revoir." );
        this.aGui.enable( false );
    }
    
    /**
     * Quit the game
     * 
     * @param pCommand Commande
     */
    private void quit(final Command pCommand){
        if ( pCommand.hasSecondWord() )
            this.aGui.println( "Quit what?" );
        else
            this.endGame();
    }
    
    /**
     * Look at something
     * 
     * @param pCommand Commande
     */
    private void look(final Command pCommand){
        if(pCommand.hasSecondWord()){
            Item vRoomItem = this.aPlayer.getCurrentRoom().getItem(pCommand.getSecondWord());
            
            if(vRoomItem != null){
                this.aGui.println( vRoomItem.getLongDescription() );
            } else {
                this.aGui.println("Je ne trouve pas ce que vous voulez regarder.");
            }
        } else {
            this.aGui.println("Que voulez-vous regarder ?");
        }
    }
    
    /**
     * Navigate into a room
     * 
     * @param pCommand Command to navigate
     * @param pToSave Save or not the navigation
     */
    private void goRoom(final Command pCommand)
    {
        Room vNextRoom = null;
        String vDirection = pCommand.getSecondWord();
        
        // Check if user input direction
        if ( ! pCommand.hasSecondWord() ) {
            this.aGui.println( "Où voulez-vous aller?" );
            return;
        }
        
        // Navigate in specified direction
        vNextRoom = this.aPlayer.getCurrentRoom().getExit(vDirection.toLowerCase());
        
        if ( vNextRoom == null )
            this.aGui.println( "Vous ne pouvez pas aller dans cette direction!" );
        else {
            this.aPlayer.changeRoom(vNextRoom, true);
            
            this.printLocationInfo();
        }
    } // goRoom
    
    /**
     * Back into the previous Room
     * 
     * @param pCommand Commande to back
     */
    private void back(final Command pCommand){
        Command vGoOpposite = null;
            
        if ( pCommand.hasSecondWord() ){
            this.aGui.println( "Back where ?" );
        } else {
            if(this.aPlayer.getPreviousRoom() != null){
                this.aPlayer.back();
                
                this.printLocationInfo();
            } else {
                this.aGui.println( "Vous ne pouvez pas retourner en arrière." );
            }
        }
    }
    
    /**
     * Test the game with file
     * 
     * @param pCommand
     */
    private void test(final Command pCommand){
        if ( !pCommand.hasSecondWord() )
            this.aGui.println( "Please input file to test." );
        else {
            String vFileName = pCommand.getSecondWord();
            
            if(!vFileName.endsWith(".txt")){
                vFileName += ".txt";
            }
            
            try{
                Scanner vSr = new Scanner(new BufferedReader(new FileReader( vFileName )));
                
                String vCommandLine = "";
                
                while ( vSr.hasNextLine() ) {
                    vCommandLine = vSr.nextLine();
                    
                    this.interpretCommand(vCommandLine);
                } // while
            } catch(final FileNotFoundException vFNFE){
                System.err.println("File : " + vFileName + " not found.");
            }
        }
    }
    
    /**
     * Take an Item in a Room
     * 
     * @param pCommand Command to take the Item
     */
    private void takeItem(final Command pCommand){
        if ( !pCommand.hasSecondWord() ){
            this.aGui.println( "Que voulez vous que je prenne ?" );
        } else {
            Item vItem = this.aPlayer.getCurrentRoom().getItem(pCommand.getSecondWord());
            
            if(vItem != null){
                this.aPlayer.take(vItem);
                
                this.aGui.println( "Vous prenez l'objet : " +  vItem.getNom());
            } else {
                this.aGui.println( "Je ne vois pas cet objet." );
            }
        }
    }
    
    /**
     * Drop an Item from the Player inventory
     * 
     * @param pCommand Command to drop the Item
     */
    private void dropItem(final Command pCommand){
        if ( !pCommand.hasSecondWord() ){
            this.aGui.println( "Que voulez vous que je pose ?" );
        } else {
            Item vItem = this.aPlayer.getItem(pCommand.getSecondWord());
            
            if(vItem != null){
                this.aPlayer.drop(vItem);
                
                this.aGui.println( "Vous déposez l'objet : " +  vItem.getNom());
            } else {
                this.aGui.println( "Je n'ai pas cet objet sur moi." );
            }
        }
    }
    
    /**
     * Show inventory
     */
    private void showInventory(){
        this.aGui.println(this.aPlayer.getInventoryString());
    }
    
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     * 
     * @param pCommandLine Command to interpret
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
        else if ( vCommandWord.equals( "back" ) ){
            this.back(vCommand);
        } else if ( vCommandWord.equals( "quit" ) ) {
            this.quit(vCommand);
        } else if ( vCommandWord.equals( "look" ) ) {
            this.look(vCommand);
        } else if ( vCommandWord.equals( "test" ) ) {
            this.test(vCommand);
        } else if ( vCommandWord.equals( "eat" ) ) {
            this.aGui.println( "Miam miam." );
        } else if ( vCommandWord.equals( "take" ) ) {
            this.takeItem(vCommand);
        } else if ( vCommandWord.equals( "drop" ) ) {
            this.dropItem(vCommand);
        } else if ( vCommandWord.equals( "inventory" ) ) {
            this.showInventory();
        }
    }
}
