package Serie52;

public class ArticlePromo extends ArticleAbstrait<Integer> {

	private int quantiteMini;
	private float reduction;
	
	
	public ArticlePromo(Integer code, String designation, float pu, int quantiteMini, float reduction)
	{
		super(code,designation,pu);
		this.quantiteMini=quantiteMini;
		this.reduction=reduction;
	}
	
	public ArticlePromo(){}
	
	public String toString()
	{
		return "Code : " + getCode() + " ** Designation : " + getDesignation() + " *** Prix " + getPu() + " Quantite Mini : " + quantiteMini + " Reduction : " + reduction;
	}
	
	public String facturer(int quantite)
	{
		String text= "\t"+ getCode() + "\t" + getDesignation() + "\t\t" + quantite + "\t" 
				+ getPu() + "\t" + ((int) (prixFacturer(quantite)*100))/100.0F + "Quantite Mini :" + quantiteMini + "reduction : " + reduction + " *****\n";	
		
		return text;
	}
	
	public float prixFacturer(int quantite)
	{
		if (quantite < quantiteMini) return quantite*getPu();
		else return(quantite*getPu())*(1-reduction/100.0F);
	}
	
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
