package Serie23;
import java.util.Scanner;

import Utils.ClientUtils;
import Serie22.*;

public class GestionUneCommande {
	
	static 	Scanner sc= new Scanner(System.in);
	
	public void menuGeneral(TableDesArticles tabArt, TableDesLignesDeCommande cde)
	{
		int choix;
		
		do{
			choix = menuChoix();
			switch(choix)
			{
			case 1: ajouter(tabArt,cde); break;
			case 2: supprimer(cde); break; 
			case 3: afficher(cde); break;
			case 4: facturer(tabArt,cde); break;
			case 0: break;
			}
		}while (choix != 0);
	}
	
	public void ajouter(TableDesArticles tabArt, TableDesLignesDeCommande cde)
	{
		LigneDeCommande ldc = new LigneDeCommande(); //ligne de commande vide et apres on va appeller une methode saisie, si la ligne de commande n'est pas nulle je vais l'ajouter dans la commande
		ldc= saisie(tabArt);
		if (ldc != null) cde.ajouter(ldc); //si la ligne de commande n'est pas vide je rajoute dans la commande
	}
	
	public void supprimer(TableDesLignesDeCommande cde)
	{
		int numeroLigne;
		afficher(cde);
		numeroLigne= ClientUtils.lireEnt("\n ** Quelle ligne de commande voulez-vous supprimer ? **\n", 1, cde.taille());
		cde.supprimer(numeroLigne-1);
	}
	
	public void afficher(TableDesLignesDeCommande cde)
	{;
		if(cde.taille() ==0) System.out.print("\n ***** COMMANDE VIDE!! **\n");
		else System.out.print(cde.toString());
	}
	
	public void facturer (TableDesArticles tabArt, TableDesLignesDeCommande cde)
	{
		if (cde.taille() == 0) System.out.print("\n ***** COMMANDE VIDE!! **\n");
		else System.out.print(cde.facturer(tabArt));
	}
	
	public int menuChoix()
	{
		String mes = "\n ***** GESTION UNE COMMANDE **\n"+
				"\n____________________________________\n"+
				"\n AJOUTER UNE LIGNE DE COMMANDE---------------1\n"+
				"\n SUPPRIMER UNE LIGNE DE COMMANDE-------------2\n"+
				"\n AFFICHER LA COMMANDE-------------3\n"+
				"\n FACTURER LA COMMANDE-------------4\n"+
				"\n FIN--------------------------------0\n"+
				"\n VOTRE CHOIX..............";
		return ClientUtils.lireEnt(mes, 0, 4);
	}
	
	
	
	public LigneDeCommande saisie(TableDesArticles tabArt)
	{
		int code;
		
		code= ClientUtils.lireEnt(" QUEL CODE ?", 1, Integer.MAX_VALUE);
				
		if (tabArt.retourner(code)!=null)
		{
			System.out.print(" Quelle quantite ? ");
			int quantite= sc.nextInt();
			return new LigneDeCommande(code, quantite);
		}
		else {
				System.out.print(" *** Ce code n'existe pas ! ");
				return null;
		}
	}
}
