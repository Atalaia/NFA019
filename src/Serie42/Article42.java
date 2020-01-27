package Serie42;

public class Article42 extends ArticleAbstrait<Integer> 
{

	public Article42(int code, String designation, float pu){ super(code,designation,pu);}
	//constructeur par défaut
	public Article42(){}
	
	//maintenant on écrit les 3 méthodes abstraites
	public String toString()
	{
		return "Code : " + getCode() + " ** Designation : " + getDesignation() + " *** Prix " + getPu() + "\n";

	}
	
	//copier coller les méthodes facturer et prixFacturer de Article41
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
