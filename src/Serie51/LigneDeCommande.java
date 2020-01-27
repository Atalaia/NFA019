package Serie51;
import java.io.Serializable;

public class LigneDeCommande implements Serializable {
	
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
	
	public String facturer(TableDesArticles51 tabArt)
	{
		ArticleAbstrait<Integer> art= tabArt.retourner(code);
		
		return art.facturer(quantite);	
	}
	
	
	public float prixTotal(TableDesArticles51 tabArt)
	{
		ArticleAbstrait<Integer> art = tabArt.retourner(code);
		return art.prixFacturer(quantite);
	}
	
	
	public int getCode(){return code;}
	
	public int getQuantite(){return quantite;}
	
	public void setCode(int code){this.code=code;}
	
	public void setQuantite(int quantite){this.quantite=quantite;}
}
