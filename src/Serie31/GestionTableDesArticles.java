package Serie31;

import java.util.Scanner;

import Utils.ClientUtils;
import IConsole.ES;
import Serie22.*;
import MesExceptions.*;

public class GestionTableDesArticles {
	
	static 	Scanner sc= new Scanner(System.in);
	
	public void menuGeneral(TableDesArticles tabArt, TableDesCommandes tabCde) throws Abandon
	{
		
		//ajouter un menu avec creer un article, supprimer, ...
		int choix;
		
		do{
			try{
				choix = menuChoix();
				switch(choix)
				{
				case 1: ajouter(tabArt); break;
				case 2: supprimer(tabArt, tabCde); break; 
				case 3: afficher(tabArt); break;
				case 0: break;
				}
			}catch (Abandon ab){choix = 0;}
		}while (choix != 0);
	}
	
	public int menuChoix() throws Abandon
	{
		String mes = "\n ***** GESTION DES ARTICLES **\n"+
				"\n____________________________________\n"+
				"\n AJOUTER UN ARTICLE-------------------1\n"+
				"\n SUPPRIMER UN ARTICLE-----------------2\n"+
				"\n AFFICHER LA TABLE DES ARTICLES-------3\n"+
				"\n FIN----------------------------------0\n"+
				"\n VOTRE CHOIX..........................";
		
		return ES.saisie(mes, 0, 3);
	}
	
	public void ajouter(TableDesArticles tabArt) throws Abandon
	{
		Article<Integer> art = saisie(tabArt);
		if(art != null) tabArt.ajouter(art);
	}
	
	public void supprimer(TableDesArticles tabArt, TableDesCommandes tabCde) throws Abandon
	{
		if (tabArt.taille() == 0) ES.affiche("\n *** STOCK VIDE !!! PAS DE SUPPRESSION POSSIBLE ***\n");
		else {
			int code= ES.saisie(" Quel code voulez-vous supprimer ? ", 1, Integer.MAX_VALUE);
			tabArt.supprimer(code,tabCde);
		}
		//il faut aller dans la structure et supprimer, j'ajoute tabCde pour supprimer en cascade
	}
	
	public void afficher(TableDesArticles tabArt)
	{
		if (tabArt.taille() == 0) ES.affiche("\n *** STOCK VIDE ! ***\n");
		else ES.affiche(tabArt.toString());
	}
	
	public Article<Integer> saisie(TableDesArticles tabArt) throws Abandon
	{
		int code;
		
		code= ES.saisie(" QUEL CODE ?", 1, Integer.MAX_VALUE);
				
		if (tabArt.retourner(code)==null)
		{
			ES.affiche(" Quelle designation ? ");
			String designation= sc.nextLine();
			ES.affiche(" Quel prix unitaire ? ");
			float pu= sc.nextFloat();
			return new Article<Integer>(code, designation, pu);
		}
		else {
				ES.affiche(" *** Cet article existe déjà ! ");
				return null;
		}
	}
}
