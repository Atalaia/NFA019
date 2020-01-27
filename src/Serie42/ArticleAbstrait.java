package Serie42;

//classe abstraite générique au niveau du nom, on va mettre tout ce qui est commun a tous les articles + un minimum de comportement commun
public abstract class ArticleAbstrait<TypeCode> {
	
	//les variables d'instance d'article je les garde
	private TypeCode code;
	private String designation;
	private float pu;
	
	public ArticleAbstrait(TypeCode code,String designation,float pu)
	{
		this.code=code; this.designation=designation;this.pu=pu;
	}
	
	public ArticleAbstrait(){}
	
	// 3 methodes abstraites toString, facturer et prixFacturer, je vire le code
	public abstract String toString();
	
	public TypeCode getCode()
	{
		return code;
	}
	
	public String getDesignation(){return designation;}
	
	public float getPu(){return pu;}
		
	public void setCode(TypeCode code){this.code=code;}
	
	public void setDesignation(String dd){designation=dd;}
	
	public void setPu(float pu){this.pu=pu;}
	
	// comme ces classes deviennent abstraites je dois virer le code
	public abstract String facturer(int quantite);
	
	public abstract float prixFacturer(int quantite);

}
