package Serie52;

import Utils.*;
import java.io.Serializable;

public class Facture {
	
	private DateUser dateFacture;
	private String numFacture;
	private String facture;
	
	public Facture(DateUser dateFacture, String numFacture, String facture)
	{
		this.dateFacture = dateFacture;
		this.numFacture = numFacture;
		this.facture = facture;
	}
	
	public Facture(){}
	
	public String toString()
	{
		return "Date de la facture : " + getDateFacture() + 
				" ** Numéro de la facture : " + getNumFacture() + " " + 
				"*** Facture " + getFacture() + "\n";
	}
	
	public DateUser getDateFacture(){return dateFacture;}
	
	public String getNumFacture(){return numFacture;}
	
	public String getFacture(){return facture;}
	
	public void setDateFacture(DateUser dateFacture){this.dateFacture=dateFacture;}
	
	public void setNumFacture(String numFacture){this.numFacture=numFacture;}
	
	public void setFacture(String facture){this.facture=facture;}
}