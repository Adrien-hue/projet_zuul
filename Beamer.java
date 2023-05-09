
/**
 * Décrivez votre classe Beamer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Beamer extends Item
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Room aDestination;

    /**
     * Constructeur d'objets de classe Beamer
     * 
     * @param pNom Nom du Beamer
     * @param pDescription Description du Beamer
     * @param pPoid Poids du Beamer
     * @param pPrix Prix du Beamer
     */
    public Beamer(final String pNom, final String pDescription, final double pPoid, final double pPrix)
    {
        super(pNom, pDescription, pPoid, pPrix);
        
        this.aDestination = null;
    }
    
    /**
     * Vérifie si le Beamer a bien été initialisé
     * 
     * @return true si le Beamer est initialisé, false sinon
     */
    public boolean isInit(){
        return this.getDestination() != null;
    }
    
    /**
     * Met à jour la destination du Beamer
     * 
     * @param pDestination Room de destination
     */
    public void setDestination(final Room pDestination){
        this.aDestination = pDestination;
    }
    
    /**
     * Retourne la Room destination de Beamer
     * 
     * @return Room de destination
     */
    public Room getDestination(){
        return this.aDestination;
    }
}
