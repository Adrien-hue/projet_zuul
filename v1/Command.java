package v1;

/**
 * Classe Command - une commande du jeu d'aventure Zuul.
 *
 * @author votre nom
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    } // Command
    
    /**
     * Return aCommandWord
     */
    public String getCommandWord()
    {
        return this.aCommandWord;
    } // getCommandWord
    
    /**
     * Return aSecondWord
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    } // getSecondWord
    
    /**
     * Check if command has second word
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    } // hasSecondWord
    
    /**
     * Check if command word is known
     */
    public boolean isUnknown()
    {
        return this.aCommandWord == null;
    } // isUnknown
} // Command
