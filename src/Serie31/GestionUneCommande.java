package Serie31;
import java.util.Scanner;

import Utils.ClientUtils;
import IConsole.ES;
import Serie22.*;
import MesExceptions.Abandon;

public class GestionUneCommande {
	
	static 	Scanner sc= new Scanner(System.in);
	
	public void menuGeneral(TableDesArticles tabArt, TableDesLignesDeCommande cde) throws Abandon
	{
		int choix;
		
		do{
			try {
				choix = menuChoix();
				switch(choix)
				{
				case 1: ajouter(tabArt,cde); break;
				case 2: supprimer(cde); break; 
				case 3: afficher(cde); break;
				case 4: facturer(tabArt,cde); break;
				case 0: break;
				}
			}catch (Abandon ab){choix = 0;}
		}while (choix != 0);
	}
	
	public void ajouter(TableDesArticles tabArt, TableDesLignesDeCommande cde) throws Abandon
	{
		LigneDeCommande ldc = new LigneDeCommande(); //ligne de commande vide et apres on va appeller une methode saisie, si la ligne de commande n'est pas nulle je vais l'ajouter dans la commande
		ldc= saisie(tabArt);
		if (ldc != null) cde.ajouter(ldc); //si la ligne de commande n'est pas vide je rajoute dans la commande
	}
	
	public void supprimer(TableDesLignesDeCommande cde) throws Abandon
	{
		int numeroLigne;
		afficher(cde);
		numeroLigne= ES.saisie("\n ** Quelle ligne de commande voulez-vous supprimer ? **\n", 1, cde.taille());
		cde.supprimer(numeroLigne-1);
	}
	
	public void afficher(TableDesLignesDeCommande cde)
	{;
		if(cde.taille() ==0) ES.affiche("\n ***** COMMANDE VIDE!! **\n");
		else ES.affiche(cde.toString());
	}
	
	public void facturer (TableDesArticles tabArt, TableDesLignesDeCommande cde)
	{
		if (cde.taille() == 0) ES.affiche("\n ***** COMMANDE VIDE!! **\n");
		else ES.affiche(cde.facturer(tabArt));
	}
	
	public int menuChoix() throws Abandon
	{
		String mes = "\n ***** GESTION UNE COMMANDE **\n"+
				"\n____________________________________\n"+
				"\n AJOUTER UNE LIGNE DE COMMANDE---------------1\n"+
				"\n SUPPRIMER UNE LIGNE DE COMMANDE-------------2\n"+
				"\n AFFICHER LA COMMANDE-------------3\n"+
				"\n FACTURER LA COMMANDE-------------4\n"+
				"\n FIN--------------------------------0\n"+
				"\n VOTRE CHOIX..............";
		return ES.saisie(mes, 0, 4);
	}
	
	
	
	public LigneDeCommande saisie(TableDesArticles tabArt) throws Abandon
	{
		int code;
		
		code= ES.saisie(" QUEL CODE ?", 1, Integer.MAX_VALUE);
				
		if (tabArt.retourner(code)!=null)
		{
			int quantite= ES.saisie("Quelle quantite ? ", 1, Integer.MAX_VALUE);
			return new LigneDeCommande(code, quantite);
		}
		else {
				ES.affiche(" *** Ce code n'existe pas ! ");
				return null;
		}
	}
}
