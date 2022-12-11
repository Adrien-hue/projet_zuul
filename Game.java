/**
 * Classe Game - le moteur du jeu d'aventure Zuul.
 *
 * @author HOUEE Adrien
 */
public class Game
{
    /**
     * Une interface utilisateur à portée privée
     */
    private UserInterface aGui;
    
    /**
     * Un moteur de jeu à portée privée
     */
    private GameEngine aEngine;

    /**
     * Create the game and initialise its internal map. Create the inerface and link to it.
     */
    public Game() 
    {
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface( this.aEngine );
        this.aEngine.setGUI( this.aGui );
    }
} // Game
