
/**
 * Décrivez votre classe Item ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Item
{
    private String aNom;
    private String aDescription;
    private double aPoid;
    private double aPrix;

    public Item(final String pNom, final String pDescription, final double pPoid, final double pPrix){
        this.aNom = pNom;
        this.aDescription = pDescription;
        this.aPoid = pPoid;
        this.aPrix = pPrix;
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
     * @params String item name
     */
    public void setNom(final String pNom){
        this.aNom = pNom;
    }
    
    /**
     * Set current item description
     * 
     * @params String item description
     */
    public void setDescription(final String pDescription){
        this.aDescription = pDescription;
    }
    
    /**
     * Set current item weight
     * 
     * @params double item weight
     */
    public void getPoid(final double pPoid){
        this.aPoid = pPoid;
    }
    
    /**
     * Set current item price
     * 
     * @params double item price
     */
    public void getPrix(final double pPrix){
        this.aPrix = pPrix;
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
}
