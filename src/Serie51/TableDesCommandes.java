package Serie51;
import java.util.*;
import java.io.*;

public class TableDesCommandes implements MesInterfaces.InterfaceStructure<TableDesLignesDeCommande, String>, 
Serializable {

	private TreeMap<String,TableDesLignesDeCommande> tabCde;
	
	public TableDesCommandes(){ tabCde= new TreeMap<String, TableDesLignesDeCommande>();}
	
	
	public void ajouter(TableDesLignesDeCommande cde)
	{
		if (retourner(cde.getNumCde()) == null) tabCde.put(cde.getNumCde(),cde);
	}
	
	public void purge(int code) 
	{
		for(TableDesLignesDeCommande cde: tabCde.values())
		{
			cde.purge(code);
			if (cde.taille() != 0) ajouter(cde);
			else supprimer(cde.getNumCde()); 
		}
	}
	
	public void supprimer(String numero) 
	{
		if (retourner(numero) != null) tabCde.remove(numero);
	}
	
	// changement de integer a string
	public TableDesLignesDeCommande retourner(String numCde)
	{
		return tabCde.get(numCde);
	}
	
	public String cle()
	{
		String st = "\n ** LISTE DES CLES DE LA TABLE DES COMMANDES ** \n";
		
		for(String code : tabCde.keySet())
			st = st + code + " ** ";
		return st;
	}
	
	public String toString()
	{
		String st = " \n*** LISTE DES COMMANDES PASSEES *** \n";
		
		for ( TableDesLignesDeCommande cde : tabCde.values())
		{
			st = st + cde.toString() + "*** \n";
		}
		return st;
	}
	
	public int taille() { return tabCde.size();}
	
}
