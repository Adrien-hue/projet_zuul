
/**
 * Décrivez votre classe Item ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Item
{
    /**
     * Un String à portée privée
     */
    private String aNom;
    
    /**
     * Un String à portée privée
     */
    private String aDescription;
    
    /**
     * Un double à portée privée
     */
    private double aPoid;
    
    /**
     * Un double à portée privée
     */
    private double aPrix;
    
    /**
     * Un boulean à portée privée
     */
    private boolean aEatable;

    /**
     * Create new Item instance
     * 
     * @param pNom Nom
     * @param pDescription Description
     * @param pPoid Poids
     * @param pPrix Prix
     */
    public Item(final String pNom, final String pDescription, final double pPoid, final double pPrix){
        this.aNom = pNom;
        this.aDescription = pDescription;
        this.aPoid = pPoid;
        this.aPrix = pPrix;
        this.aEatable = false;
    }
    
    /**
     * Return full description about current item
     * 
     * @return Full description
     */
    public String getLongDescription(){
        return this.getNom() + " : \n\tDescription : " + this.getDescription() + " : \n\tPoids : " + this.getPoid() + " : \n\tPrix : " + this.getPrix();
    }

    /**
     * Set current item name
     * 
     * @param pNom item name
     */
    public void setNom(final String pNom){
        this.aNom = pNom;
    }
    
    /**
     * Set current item description
     * 
     * @param pDescription item description
     */
    public void setDescription(final String pDescription){
        this.aDescription = pDescription;
    }
    
    /**
     * Set current item weight
     * 
     * @param pPoid item weight
     */
    public void setPoid(final double pPoid){
        this.aPoid = pPoid;
    }
    
    /**
     * Set current item price
     * 
     * @param pPrix item price
     */
    public void setPrix(final double pPrix){
        this.aPrix = pPrix;
    }
    
    /**
     * Set current item eatable state
     * 
     * @param pEatable eatable state
     */
    public void setEatable(final boolean pEatable){
        this.aEatable = pEatable;
    }
    
    /**
     * Return current item name
     * 
     * @return current item name
     */
    public String getNom(){
        return this.aNom;
    }
    
    /**
     * Return current item description
     * 
     * @return current item description
     */
    public String getDescription(){
        return this.aDescription;
    }
    
    /**
     * Return current item weight
     * 
     * @return current item weight
     */
    public double getPoid(){
        return this.aPoid;
    }
    
    /**
     * Return current item price
     * 
     * @return current item price
     */
    public double getPrix(){
        return this.aPrix;
    }
    
    /**
     * Return current item eatable state
     * 
     * @return Eatable state
     */
    public boolean getEatable(){
        return this.aEatable;
    }
}
