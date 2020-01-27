package Serie52;

import java.io.Serializable;
import java.util.TreeMap;

public class TableDesFactures implements MesInterfaces.InterfaceStructure<Facture, String>, 
Serializable {
	
	private TreeMap<String,Facture> tabFac;
	
	public TableDesFactures(){ tabFac= new TreeMap<String, Facture>();}
	
	public void ajouter(Facture fac)
	{
		if (retourner(fac.getNumFacture()) == null) tabFac.put(fac.getNumFacture(),fac);
	}
	
	public void supprimer(String numero) 
	{
		if (retourner(numero) != null) tabFac.remove(numero);
	}
	
	public Facture retourner(String numCde)
	{
		return tabFac.get(numCde);
	}
	
	public String cle()
	{
		String st = "\n ** LISTE DES CLES DE LA TABLE DES FACTURES ** \n";
		
		for(String code : tabFac.keySet())
			st = st + code + " ** ";
		return st;
	}
	
	public String toString()
	{
		String st = " \n*** LISTE DES FACTURES *** \n";
		
		for (Facture fac : tabFac.values())
		{
			st = st + fac.toString() + "*** \n";
		}
		return st;
	}
	
	public int taille() {return tabFac.size();}
	
}

/*

classe structure : table des factures : treemap de factures, les cles tries

Treemap<string numero de facture, la facture> et implement l’interface structure : retourner, ajouter, supprimer, taille… afficher

*/