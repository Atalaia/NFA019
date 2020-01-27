package Serie22;

import java.util.*;
import Utils.DateUser;

// maintenant on va pouvoir gestionner la table des articles, creer des articles, etc. et gestion des commands, plusieurs à la place d'une seule
import Utils.ClientUtils;

public class ClientS22 {
	
	static 	Scanner sc= new Scanner(System.in);
	
	public static void main(String[] s)
	{
		TableDesArticles tabArt= new TableDesArticles();
		TableDesCommandes tabCde = new TableDesCommandes();
		
		int choix;
				
	do{
		choix=menuChoixGeneral();
		switch (choix)
		{
			case 1: gestionTabArticles(tabArt, tabCde); break;
			case 2: gestionDesCommandes(tabArt,tabCde); break;
			case 0: break;
		}
	} while(choix !=0);	
	
	System.out.print("\n ** AU REVOIR A BIENTOT SUR SUPERETTE ** \n");		
	}
	
	public static void gestionDesCommandes(TableDesArticles tabArt, TableDesCommandes tabCde)
	{
		int choix;
		
		do
		{
			TableDesLignesDeCommande cde= new TableDesLignesDeCommande();
			choix = menuGestionDesCommandes();
			switch(choix)
			{
			case 1: gestionUneCommande(tabArt,cde); 
					if(cde.taille() != 0) 
					{int numero = premierNumeroDispo(tabCde);
					cde.setDateCommande(new Utils.DateUser());
					cde.setNumCde(numero);
					
						tabCde.ajouter(cde);
					}
					break;//on crée une commande, si ce n'est pas vide nous ajoutons dans la table des commandes
	//		case 2: supprimerUneCommande(tabCde); break;
	//		case 3: afficherUneCommande(tabCde); break;
	//		case 4: afficherToutesLesCommandes(tabCde); break;
			case 5: facturer1Commande(tabArt,tabCde); break;
			case 0: break;
			}
		} while (choix != 0);
	}
	
	public static void facturer1Commande(TableDesArticles tabArt, TableDesCommandes tabCde)
	{
		System.out.print(" \n** LISTE DES NUMEROS DE COMMANDES : \n" + tabCde.toString());
		int numero= Utils.ClientUtils.lireEnt("", 0, 999);
		
		if(tabCde.retourner(numero) != null) 
			System.out.print(" \n " + tabCde.retourner(numero).facturer(tabArt));
	}
	
	public static int premierNumeroDispo(TableDesCommandes tabCde)
	{
	 int numero=1;
	 while(tabCde.retourner(numero) != null) numero++;
	 return numero;
	}
	
	public static int menuGestionDesCommandes()
	{
		String mes= "\n *** MENU GESTION DES COMMANDES ***\n" +
				" CREER UNE COMMANDE________________1\n" +
				" SUPPRIMER UNE COMMANDE____________2\n" +
				" AFFICHER UNE COMMANDE_____________3\n" +
				" AFFICHER TOUTES LES COMMANDES_____4\n" +
				" FACTURER UNE COMMANDE_____________5\n" +
				" FIN_______________________________0\n" +
				"VOTRE CHOIX_________________________";
		
		return ClientUtils.lireEnt(mes, 0, 5);
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
		if (ldc != null) cde.ajouter(ldc); //si la ligne de commande n'est pas vide je rajoute dans la commande
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
		String mes= "\n ***** BIENVENUE A LA SUPERETTE **\n"+
					"\n____________________________________\n"+
					"\n GESTION DES ARTICLES---------------1\n"+
					"\n GESTION D'UNE COMMANDE-------------2\n"+
					"\n FIN--------------------------------0\n"+
					"\n VOTRE CHOIX..............";
		return ClientUtils.lireEnt(mes, 0, 2);
	}
	
	public static void gestionTabArticles(TableDesArticles tabArt, TableDesCommandes tabCde)
	{
		
		//ajouter un menu avec creer un article, supprimer, ...
		int choix;
		
		do{
			choix = menuChoixGestionTabArticles();
			switch(choix)
			{
			case 1: ajouterArticle(tabArt); break;
			case 2: supprimerArticle(tabArt, tabCde); break; 
			case 3: afficherTabArticles(tabArt); break;
			case 0: break;
			}
		}while (choix != 0);
	}
	
	public static int menuChoixGestionTabArticles()
	{
		String mes = "\n ***** GESTION DES ARTICLES **\n"+
				"\n____________________________________\n"+
				"\n AJOUTER UN ARTICLE-------------------1\n"+
				"\n SUPPRIMER UN ARTICLE-----------------2\n"+
				"\n AFFICHER LA TABLE DES ARTICLES-------3\n"+
				"\n FIN----------------------------------0\n"+
				"\n VOTRE CHOIX..........................";
		
		return ClientUtils.lireEnt(mes, 0, 3);
	}
	
	public static void ajouterArticle(TableDesArticles tabArt)
	{
		Article<Integer> art = saisieArticle(tabArt);
		if(art != null) tabArt.ajouter(art);
	}
	
	public static void supprimerArticle(TableDesArticles tabArt, TableDesCommandes tabCde)
	{
		if (tabArt.taille() == 0) System.out.print("\n *** STOCK VIDE !!! PAS DE SUPPRESSION POSSIBLE ***\n");
		else {
			int code= Utils.ClientUtils.lireEnt(" Lequel code voulez-vous supprimer ? ", 1, Integer.MAX_VALUE);
			tabArt.supprimer(code,tabCde);
		}
		//il faut aller dans la structure et supprimer, j'ajoute tabCde pour supprimer en cascade
	}
	
	public static void afficherTabArticles(TableDesArticles tabArt)
	{
		if (tabArt.taille() == 0) System.out.append("\n *** STOCK VIDE ! ***\n");
		else System.out.print(tabArt.toString());
	}
	
	public static Article<Integer> saisieArticle(TableDesArticles tabArt)
	{
		int code;
		
		code= ClientUtils.lireEnt(" QUEL CODE ?", 1, Integer.MAX_VALUE);
				
		if (tabArt.retourner(code)==null)
		{
			System.out.print(" Quelle designation ? ");
			String designation= sc.nextLine();
			System.out.print(" Quel prix unitaire ? ");
			float pu= sc.nextFloat();
			return new Article<Integer>(code, designation, pu);
		}
		else {
				System.out.print(" *** Cet article existe déjà ! ");
				return null;
		}
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