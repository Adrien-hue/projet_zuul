import java.util.HashMap;
import java.util.Set;

/**
 * Décrivez votre classe ItemList ici.
 *
 * @author HOUEE Adrien
 * @version 2023-1-4
 */
public class ItemList
{
    /**
     * Un tableau associatif (String -> Item) à portée privée
     */
    private HashMap<String, Item> aItemList;
    
    /**
     * Constructeur naturel
     */
    public ItemList(){
        this.aItemList = new HashMap<String, Item>();
    }
    
    /**
     * Ajoute l'item pItem à aItemList
     * 
     * @param pItem Item à ajouter
     */
    public void addItem(final Item pItem){
        this.aItemList.put(pItem.getNom(), pItem);
    }
    
    /**
     * Retourne l'Item qui a pour clé pItemName
     * 
     * @param pItemName Nom de l'objet voulu
     * @return l'Item recherché
     */
    public Item getItem(final String pItemName){
        return this.aItemList.get(pItemName);
    }
    
    public String getItemListString(){
        StringBuilder vIventoryString = new StringBuilder("Inventaire :");
        
        if(this.aItemList.size() > 0){
            Set<String> vKeys = this.aItemList.keySet();
        
            for(String item : vKeys){
                vIventoryString.append(" " + item);
            }
        } else {
            vIventoryString.append(" vide");
        }
        
        return vIventoryString.toString();
    }
    
    /**
     * Supprime l'item pItem de aItemList
     * 
     * @param pItem Item à supprimer
     */
    public void deleteItem(final Item pItem){
        this.aItemList.remove(pItem.getNom());
    }
    
    /**
     * Retourne la taille de l'ItemList
     * 
     * @return Taille de l'ItemList
     */
    public int size(){
        return this.aItemList.size();
    }
    
    /**
     * Retourne le poid total de l'ItemList
     * 
     * @return Poid de l'ItemList
     */
    public double getWeight(){
        int vWeight = 0;
        
        for(Item vItem: this.aItemList.values()){
            vWeight += vItem.getPoid();
        }
        
        return vWeight;
    }
}
