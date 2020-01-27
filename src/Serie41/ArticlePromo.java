package Serie41;

// Article Promo en plus de tous les caracteristiques d'article on va rajouter d'autres caracteristiques

public class ArticlePromo extends Article41<Integer> {

	private int quantiteMini;
	private float reduction;
	
	//comment on appelle tout ce qui est de la super classe, il faut mettre super, pour le constructeur il nous faut 5 parametres, les 3 de la super classe Article41 + les deux de Article Promo
	
	public ArticlePromo(Integer code, String designation, float pu, int quantiteMini, float reduction)
	{
		super(code,designation,pu);
		this.quantiteMini=quantiteMini;
		this.reduction=reduction;
	}
	
	//constructeur sans parametres
	public ArticlePromo(){}
	
	//toString est une methode polymorphe, elle est un peu partout
	
	public String toString()
	{
		return super.toString() + " Quantite Mini : " + quantiteMini + " Reduction : " + reduction;
	}
	
	public String facturer(int quantite)
	{
		String text= "\t"+ getCode() + "\t" + getDesignation() + "\t\t" + quantite + "\t" 
				+ getPu() + "\t" + ((int) (prixFacturer(quantite)*100))/100.0F + "Quantite Mini :" + quantiteMini + "reduction : " + reduction + " *****\n";	
		
		return text;
	}
	
	public float prixFacturer(int quantite)
	{
		if (quantite < quantiteMini) return super.prixFacturer(quantite);
		else return(super.prixFacturer(quantite)*(1-reduction/100.0F));
	}
	
	//nous manque le getter et le setter
	public int getQuantiteMini()
	{
		return quantiteMini;
	}
	
	public float getReduction()
	{
		return reduction;
	}
	
	public void setQuantiteMini(int quantiteMini)
	{
		this.quantiteMini = quantiteMini;
	}
	
	public void setReduction(float reduction)
	{
		this.reduction = reduction;
	}
}
