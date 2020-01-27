package Serie22;
import java.util.*;

//structure dont le metier est une commande. Le metier de cette structure est une commande. Contient tables de lignes de commande, donc commandes.

public class TableDesCommandes {

	private TreeMap<Integer,TableDesLignesDeCommande> tabCde;
	
	public TableDesCommandes(){ tabCde= new TreeMap<Integer, TableDesLignesDeCommande>();}
	
	//constructeur avec parametre manque
	
	
	//On ajoute toujours un metier
	public void ajouter(TableDesLignesDeCommande cde)
	{
		if (retourner(cde.getNumCde()) == null) tabCde.put(cde.getNumCde(),cde);
	}
	
	public void purge(int code) //méthode qui va purger toutes les Lignes de commande du code passé en parametre, on retrouve toutes les commandes avec ce code, et puis on supprime les lignes qui ont ce code
	{
		for(TableDesLignesDeCommande cde: tabCde.values())
		{
			cde.purge(code);
			if (cde.taille() != 0) ajouter(cde);
			else supprimer(cde.getNumCde()); //on supprime une commande par son numèro si la commande est vide
		}
	}
	
	public void supprimer(int numero) //numero de commande
	{
		if (retourner(numero) != null) tabCde.remove(numero);
	}
	
	public TableDesLignesDeCommande retourner(int numCde)
	{
		return tabCde.get(numCde);
	}
	
	public String cle()
	{
		String st = "\n ** LISTE DES CLES DE LA TABLE DES COMMANDES ** \n";
		
		for(Integer code : tabCde.keySet())
			st = st + code + " ** ";
		return st;
	}
	
	public String toString()
	{
		String st = " \n*** LISTE DES COMMANDES PASSESS *** \n";
		
		for ( TableDesLignesDeCommande cde : tabCde.values())
		{
			st = st + cde.toString() + "*** \n";
		}
		return st;
	}
	
	public int taille() { return tabCde.size();}
	
	//facturer manque, on facture toutes les commandes, il faut faire un for each comme pour le toString
}
