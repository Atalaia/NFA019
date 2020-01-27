package Serie41;

// ici on ajoute seulement <Integer> à Article

public class LigneDeCommande {
	
	private int code;
	private int quantite;
	
	public LigneDeCommande(int code, int quantite)
	{
		this.code=code; this.quantite=quantite;
	}
	
	public LigneDeCommande(){}

	public String toString(){
		return "Code article commande : " + code + " quantite : " + quantite + "\n"; 
	}
	
	public String facturer(TableDesArticles41 tabArt)
	{
		Article41<Integer> art= tabArt.retourner(code);
		
		// si c'est un article normal, on appele facturer de Article41, si article promo, on appelle facturer d'ArticlePromo
		return art.facturer(quantite);	
	}
	
	//le prix total est le prix de la ligne
	// si c'est un article normal, on appele prixfacturer de Article41, si article promo, on appelle prixfacturer d'ArticlePromo

	public float prixTotal(TableDesArticles41 tabArt)
	{
		Article41<Integer> art = tabArt.retourner(code);
		return art.prixFacturer(quantite);
	}
	
	
	public int getCode(){return code;}
	
	public int getQuantite(){return quantite;}
	
	public void setCode(int code){this.code=code;}
	
	public void setQuantite(int quantite){this.quantite=quantite;}
}
