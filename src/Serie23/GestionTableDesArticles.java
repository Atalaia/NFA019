package Serie23;

import java.util.Scanner;

import Utils.ClientUtils;
import Serie22.*;

public class GestionTableDesArticles {
	
	static 	Scanner sc= new Scanner(System.in);
	
	public void menuGeneral(TableDesArticles tabArt, TableDesCommandes tabCde)
	{
		
		//ajouter un menu avec creer un article, supprimer, ...
		int choix;
		
		do{
			choix = menuChoix();
			switch(choix)
			{
			case 1: ajouter(tabArt); break;
			case 2: supprimer(tabArt, tabCde); break; 
			case 3: afficher(tabArt); break;
			case 0: break;
			}
		}while (choix != 0);
	}
	
	public int menuChoix()
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
	
	public void ajouter(TableDesArticles tabArt)
	{
		Article<Integer> art = saisie(tabArt);
		if(art != null) tabArt.ajouter(art);
	}
	
	public void supprimer(TableDesArticles tabArt, TableDesCommandes tabCde)
	{
		if (tabArt.taille() == 0) System.out.print("\n *** STOCK VIDE !!! PAS DE SUPPRESSION POSSIBLE ***\n");
		else {
			int code= Utils.ClientUtils.lireEnt(" Quel code voulez-vous supprimer ? ", 1, Integer.MAX_VALUE);
			tabArt.supprimer(code,tabCde);
		}
		//il faut aller dans la structure et supprimer, j'ajoute tabCde pour supprimer en cascade
	}
	
	public void afficher(TableDesArticles tabArt)
	{
		if (tabArt.taille() == 0) System.out.append("\n *** STOCK VIDE ! ***\n");
		else System.out.print(tabArt.toString());
	}
	
	public Article<Integer> saisie(TableDesArticles tabArt)
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
}
