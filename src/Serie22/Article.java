package Serie22;

//On va faire l'article générique, la classe article va être générique dans le code du type de l'article, comme ça je pourrai l'utiliser pour un autre code sans avoir à changer le type.
// Classe générique
//Quand on instancie un objet de la classe article il faut préciser le type Article<Integer> art1 / Article<String> art2; et tous les TypeCode seront des Integers ou Strings.

public class Article<TypeCode> {
	
	private TypeCode code;
	private String designation;
	private float pu;
	
	public Article(TypeCode code,String designation,float pu)
	{
		this.code=code; this.designation=designation;this.pu=pu;
	}
	
	public Article(){}
	
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

}
