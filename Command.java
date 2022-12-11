/**
 * Classe Command - une commande du jeu d'aventure Zuul.
 *
 * @author HOUEE Adrien
 */
public class Command
{
    /**
     * Un String à portée privée
     */
    private String aCommandWord;
    
    /**
     * Un String à portée privée
     */
    private String aSecondWord;
    
    /**
     * Create new Command instance
     * 
     * @param pCommandWord Principal word
     * @param pSecondWord Second word
     */
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    } // Command
    
    /**
     * Return aCommandWord
     * 
     * @return Command word
     */
    public String getCommandWord()
    {
        return this.aCommandWord;
    } // getCommandWord
    
    /**
     * Return aSecondWord
     * 
     * @return Second word
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    } // getSecondWord
    
    /**
     * Check if command has second word
     * 
     * @return true if there is a second word, else false
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    } // hasSecondWord
    
    /**
     * Check if command word is known
     * 
     * @return true if the command is unkown, else false
     */
    public boolean isUnknown()
    {
        return this.aCommandWord == null;
    } // isUnknown
} // Command
