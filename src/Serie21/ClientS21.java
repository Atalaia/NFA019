package Serie21;

import java.util.*;
import Utils.ClientUtils;

public class ClientS21 {
	
	static 	Scanner sc= new Scanner(System.in);
	
	public static void main(String[] s)
	{
		TableDesArticles tabArt= new TableDesArticles();
		TableDesLignesDeCommande cde= new TableDesLignesDeCommande();
		
		int choix;
				
	do{
		choix=menuChoixGeneral();
		switch (choix)
		{
			case 1: gestionTabArticles(tabArt); break;
			case 2: gestionUneCommande(tabArt,cde); break;
			case 0: break;
		}
	} while(choix !=0);	
	
	System.out.print("\n ** AU REVOIR A BIENTOT SUR SUPERRETTE ** \n");		
	}
	
	public static void gestionUneCommande(TableDesArticles tabArt, TableDesLignesDeCommande cde)
	{
		int choix;
		
		do{
			choix = menuChoixGestion1Commande();
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
	
	public static void ajouter(TableDesArticles tabArt, TableDesLignesDeCommande cde)
	{
		LigneDeCommande ldc = new LigneDeCommande(); //ligne de commande vide et apres on va appeller une methode saisie, si la ligne de commande n'est pas nulle je vais l'ajouter dans la commande
		ldc= saisieLdc(tabArt);
		if (ldc != null) cde.ajouter(ldc);
	}
	
	public static void supprimer(TableDesLignesDeCommande cde)
	{
		int numeroLigne;
		afficher(cde);
		numeroLigne= ClientUtils.lireEnt("\n ** Quelle ligne de commande voulez-vous supprimer ? **\n", 1, cde.taille());
		cde.supprimer(numeroLigne-1);
	}
	
	public static void afficher(TableDesLignesDeCommande cde)
	{;
		if(cde.taille() ==0) System.out.print("\n ***** COMMANDE VIDE!! **\n");
		else System.out.print(cde.toString());
	}
	
	public static void facturer (TableDesArticles tabArt, TableDesLignesDeCommande cde)
	{
		if (cde.taille() == 0) System.out.print("\n ***** COMMANDE VIDE!! **\n");
		else System.out.print(cde.facturer(tabArt));
	}
	
	public static int menuChoixGestion1Commande()
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
	
	public static int menuChoixGeneral()
	{
		String mes= "\n ***** BIENVENUE A LA SUPERRETTE **\n"+
					"\n____________________________________\n"+
					"\n GESTION DES ARTICLES---------------1\n"+
					"\n GESTION D'UNE COMMANDE-------------2\n"+
					"\n FIN--------------------------------0\n"+
					"\n VOTRE CHOIX..............";
		return ClientUtils.lireEnt(mes, 0, 2);
	}
	
	public static void gestionTabArticles(TableDesArticles tabArt)
	{
		System.out.print(tabArt.toString());
		
		//ajouter un menu avec creer un article, supprimer, ...
		
	}
	
	
	public static LigneDeCommande saisieLdc(TableDesArticles tabArt)
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