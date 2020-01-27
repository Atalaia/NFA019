package Serie41;

public class Article41<TypeCode> {
	
	private TypeCode code;
	private String designation;
	private float pu;
	
	public Article41(TypeCode code,String designation,float pu)
	{
		this.code=code; this.designation=designation;this.pu=pu;
	}
	
	public Article41(){}
	
	public String toString()
	{
		return "Code : " + code + " ** Designation : " + designation + " *** Prix " + pu + "\n";
	}
	
	public TypeCode getCode()
	{
		return code;
	}
	
	public String getDesignation(){return designation;}
	
	public float getPu(){return pu;}
		
	public void setCode(TypeCode code){this.code=code;}
	
	public void setDesignation(String dd){designation=dd;}
	
	public void setPu(float pu){this.pu=pu;}
	
	//on ajoute la methode facturer
	public String facturer(int quantite)
	{
		String text= "\t"+ code + "\t" + designation + "\t\t" + quantite + "\t" 
		+ pu + "\t" + ((int) (prixFacturer(quantite)*100))/100.0F + "\n";
		
		return text;	
	}
	
	public float prixFacturer(int quantite)
	{
		return pu*quantite;
	}

}
