package Serie51;

//il faut serialiser cette classe en implement java.io.Serializable
public abstract class ArticleAbstrait<TypeCode> implements java.io.Serializable
{
	
	private TypeCode code;
	private String designation;
	private float pu;
	
	public ArticleAbstrait(TypeCode code,String designation,float pu)
	{
		this.code=code; this.designation=designation;this.pu=pu;
	}
	
	public ArticleAbstrait(){}
	
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
	
	public abstract String facturer(int quantite);
	
	public abstract float prixFacturer(int quantite);

}
