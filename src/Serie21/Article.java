package Serie21;

public class Article {
	
	private int code;
	private String designation;
	private float pu;
	
	public Article(int code,String designation,float pu)
	{
		this.code=code; this.designation=designation;this.pu=pu;
	}
	
	public Article(){}
	
	public String toString()
	{
		return "Code : " + code + " ** Designation : " + designation + " *** Prix " + pu + "\n";
	}
	
	public int getCode()
	{
		return code;
	}
	
	public String getDesignation(){return designation;}
	
	public float getPu(){return pu;}
		
	public void setCode(int code){this.code=code;}
	
	public void setDesignation(String dd){designation=dd;}
	
	public void setPu(float pu){this.pu=pu;}

}
