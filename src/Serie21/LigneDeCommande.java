package Serie21;

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
	
	public String facturer(TableDesArticles tabArt)
	{
		Article art= tabArt.retourner(code);
		
		String text= "\t"+ code + "\t" + art.getDesignation() + "\t\t" + quantite + "\t" 
		+ art.getPu() + "\t" + ((int) (art.getPu()*quantite*100))/100.0F + "\n";
		
		return text;	
	}
	
	public float prixTotal(TableDesArticles tabArt)
	{
		Article art = tabArt.retourner(code);
		return art.getPu()*quantite;
	}
	
	
	public int getCode(){return code;}
	
	public int getQuantite(){return quantite;}
	
	public void setCode(int code){this.code=code;}
	
	public void setQuantite(int quantite){this.quantite=quantite;}
}
