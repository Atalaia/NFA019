package Serie21;

import java.util.*;


public class TableDesLignesDeCommande {

	private Vector<LigneDeCommande> cde;
	
	public TableDesLignesDeCommande(){cde = new Vector<LigneDeCommande>();}
	
	
	public String toString()
	{
		String st=" \n ***** Votre Commande *****\n ";
		
		for(int i=0; i<taille(); i++)
			st= st + cde.get(i).toString() + "\n";
		
		return st;
	}
	
	public int taille(){ return cde.size();}
	
	public void ajouter(LigneDeCommande ldc)
	{
		cde.addElement(ldc);
	}
	
	public void supprimer(int i)
	{
		if (i>=0 && i < taille()){
		cde.remove(i);
		}
	}
	
	public String facturer(TableDesArticles tabArt)
	{
		String entete="", details="", pied="";
		float totalHT=0;
		float totalTVA=0;
		float totalTTC=0;
		
		entete="\n ***** FACTURE Nº 1 *****\n "+
				"\n\t CODE ** \t DESIGNATION \t\t QUANTITE \t P.U. \t P.T. (HT) ******\n ";
		
		for(int i=0; i<taille();i++)
		{
			details= details + cde.get(i).facturer(tabArt)+"\n";
			totalHT = totalHT+ cde.get(i).prixTotal(tabArt);
		}
		
		totalTVA = totalHT * 0.196F;
		totalTTC = totalHT + totalTVA;
		
		pied = "\n ******* TOTAL HT :" + totalHT + " *******\n"
				+ "\n ******* TOTAL TVA (19,6%) :" + totalTVA + " *******\n"
				+ "\n ******* TOTAL TTC :" + totalTTC + " *******\n";
		
		return entete + details + pied;
	}
		
	public LigneDeCommande retourner(int indice)
	{
		for(int i=0; i< taille(); i++)
		{
			LigneDeCommande ldc = cde.get(i);
			if (i == indice) return ldc;
		}
		return null;
	}
	
	//getter,setter
	
}
