package Serie42;

import java.util.*;

import Utils.DateUser;


public class TableDesLignesDeCommande implements MesInterfaces.InterfaceStructure<LigneDeCommande, Integer>{

	private Vector<LigneDeCommande> cde;
	DateUser dateCommande;
	int numeroCommande;
	
	public TableDesLignesDeCommande(){cde = new Vector<LigneDeCommande>();}
	
	public TableDesLignesDeCommande(Vector<LigneDeCommande> cde, DateUser dateCde, int numCde)
	{
		this.cde=cde;
		this.dateCommande= dateCde;
		this.numeroCommande=numCde;
	}
	
	public void setNumCde(int num) { numeroCommande = num;}
	public void setDateCommande(DateUser dateC) {dateCommande=dateC;}
	
	public void purge(int code)
	{
		for(int i=0; i<taille(); i++)
		{
			if (cde.get(i).getCode() == code) supprimer(i);
		}
	}
	
	public String toString()
	{
		String st=" \n ***** Votre Commande Numero " + numeroCommande + " du "+ dateCommande
				+ " *** \n";
		
		for(int i=0; i<taille(); i++)
			st= st + cde.get(i).toString() + "\n";
		
		return st;
	}
	
	public int taille(){ return cde.size();}
	
	public void ajouter(LigneDeCommande ldc)
	{
		cde.addElement(ldc);
	}
	
	public void supprimer(Integer i)
	{
		if (i>=0 && i < taille()){
		cde.remove(i);
		}
	}
	
	//changer TableDesArticles41 par TablesDesArticles42
	public String facturer(TableDesArticles42 tabArt)
	{
		String entete="", details="", pied="";
		float totalHT=0;
		float totalTVA=0;
		float totalTTC=0;
		
		//Ajouter numero et date ici aussi
		entete="\n ***** FACTURE Nº 1 *****\n "+
				"\n\t CODE ** \t DESIGNATION \t\t QUANTITE \t P.U. \t P.T. (HT) ******\n ";
		
		for(int i=0; i<taille();i++)
		{
			details= details + cde.get(i).facturer(tabArt)+"\n";
			totalHT = totalHT+ cde.get(i).prixTotal(tabArt);
		}
		
		totalTVA = totalHT * 0.196F;
		totalTTC = totalHT + totalTVA;
		
		pied = "\n ******* TOTAL HT : " + totalHT + " *******\n"
				+ "\n ******* TOTAL TVA (19,6%) : " + totalTVA + " *******\n"
				+ "\n ******* TOTAL TTC : " + totalTTC + " *******\n";
		
		return entete + details + pied;
	}
	
	public int getNumCde(){ return numeroCommande;}
		
	public LigneDeCommande retourner(Integer indice)
	{
		for(int i=0; i< taille(); i++)
		{
			LigneDeCommande ldc = cde.get(i);
			if (i == indice) return ldc;
		}
		return null;
	}
	
//quand on implemente l'interface les int sont remplacer par des Integer dans les classes retourner et supprimer	
}
