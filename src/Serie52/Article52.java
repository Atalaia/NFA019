package Serie52;

public class Article52 extends ArticleAbstrait<Integer> 
{

	public Article52(int code, String designation, float pu){ super(code,designation,pu);}

	public Article52(){}
	
	public String toString()
	{
		return "Code : " + getCode() + " ** Designation : " + getDesignation() + " *** Prix " + getPu() + "\n";

	}
	
	public String facturer(int quantite)
	{
		String text= "\t"+ getCode() + "\t" + getDesignation() + "\t\t" + quantite + "\t" 
		+ getPu() + "\t" + ((int) (prixFacturer(quantite)*100))/100.0F + "\n";
		
		return text;	
	}
	
	public float prixFacturer(int quantite)
	{
		return getPu()*quantite;
	}	
}
